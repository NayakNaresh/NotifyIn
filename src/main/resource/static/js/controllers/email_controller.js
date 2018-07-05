app.controller('emailController',['$scope','clientService','emailService', function($scope,clientService,smsService) {
    $scope.headingTitle = "Email Configurations";
    $scope.clients=null;
    $scope.modules=null;
    $scope.myHtmlPreview="<h>Test</h>";
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
    	 $scope.modules=$scope.email.client.moduleDetails;
    	 var selectedClient={"id":$scope.email.client.id};
    	 $scope.email.clientDetail=selectedClient;
    }
    $scope.previewEmail=function(email){
    	$scope.myHtmlPreview=email.templateText;
        //$scope.email.templateText=$sce.trustAsHtml(email.templateText);
    }
    
    
 $scope.addEmail=function(email){
    	
	 emailService.addEmail(email).then(function() {
        	$scope.email=null;
        	$scope.getAllClients();
		},
      			function(errResponse){
  					console.error('Error while adding module details');
  				}
      			);
      }
    $scope.getAllClients();

}]);