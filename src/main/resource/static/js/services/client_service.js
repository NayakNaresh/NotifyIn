'use strict';

app.factory('clientService', ['$http', '$q','Constants', function($http, $q, Constants){

	return {
		    
			fetchAllClients: function() {
				return $http.get(Constants.apiUrl+'/clientDetails/getAll')
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while fetching Client Details');
									return $q.reject(errResponse);
								}
						);
		    },
		    
		    addClient: function(client){
				return $http.post(Constants.apiUrl+'/clientDetails/add', client)
						.then(
								function(response){
									return response;
								}, 
								function(errResponse){
									console.error('Error while adding client');
									return $q.reject(errResponse);
								}
						);
		    }
		    
	};
}]);