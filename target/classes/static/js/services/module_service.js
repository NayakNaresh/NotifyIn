'use strict';

app.factory('moduleService', ['$http', '$q','Constants', function($http, $q, Constants){

	return {
		    
			fetchAllModules: function() {
				return $http.get(Constants.apiUrl+'/moduleDetails/getAll')
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while fetching module Details');
									return $q.reject(errResponse);
								}
						);
		    },
		    
		    addModule: function(module){
				return $http.post(Constants.apiUrl+'/moduleDetails/add', module)
						.then(
								function(response){
									return response;
								}, 
								function(errResponse){
									console.error('Error while adding module');
									return $q.reject(errResponse);
								}
						);
		    }
		    
	};
}]);