app.controller('smsController',['$scope','clientService','smsService', function($scope,clientService,smsService) {
    $scope.headingTitle = "SMS Configurations";
    $scope.clients=null;
    $scope.modules=null;
    $scope.getAllClients=function(){
    	clientService.fetchAllClients().then(
    			function(d){
    				$scope.clients=d;
    			},
    			function(errResponse){
					console.error('Error while fetching Clients');
				}
    	);
    }
    
    $scope.fetchModules=function(){
    	 $scope.modules=$scope.sms.client.moduleDetails;
    	 var selectedClient={"id":$scope.sms.client.id};
    	 $scope.sms.clientDetail=selectedClient;
    }
    
 $scope.addSms=function(sms){
    	
	 smsService.addSms(sms).then(function() {
        	$scope.sms=null;
        	$scope.getAllClients();
		},
      			function(errResponse){
  					console.error('Error while adding module details');
  				}
      			);
      }
    $scope.getAllClients();

}]);