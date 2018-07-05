app.controller('moduleController',['$scope','clientService','moduleService', function($scope,clientService,moduleService) {
    $scope.headingTitle = "Client Modules Configurations";
    
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
    
    $scope.getAllModules=function(){
    	moduleService.fetchAllModules().then(
    			function(d){
    				$scope.modules=d;
    			},
    			function(errResponse){
					console.error('Error while fetching Clients');
				}
    	);
    }
    
    $scope.addModule=function(module){
    	
        moduleService.addModule(module).then(function() {
        	$scope.module=null;
        	$scope.getAllClients();
		},
      			function(errResponse){
  					console.error('Error while adding module details');
  				}
      			);
      }
    
    $scope.getAllClients();
    $scope.getAllModules();

}]);