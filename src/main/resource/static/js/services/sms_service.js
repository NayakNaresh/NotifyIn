'use strict';

app.factory('smsService', ['$http', '$q','Constants', function($http, $q, Constants){

	return {
		addSms: function(sms){
				return $http.post(Constants.apiUrl+'/sms/add', sms)
						.then(
								function(response){
									return response;
								}, 
								function(errResponse){
									console.error('Error while adding sms');
									return $q.reject(errResponse);
								}
						);
		    }
		    
	};
}]);