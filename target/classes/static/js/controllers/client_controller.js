'use strict';

app.controller('clientController', [ '$scope', 'clientService',
		function($scope, clientService) {

			$scope.headingTitle = "Client Configurations";

			$scope.clients = null;

			$scope.getAllClients = function() {
				clientService.fetchAllClients().then(function(d) {
					$scope.clients = d;
				}, function(errResponse) {
					console.error('Error while fetching Clients');
				});
			}

			$scope.addClient = function(client) {
				client.clientUser = {
					"id" : 1
				}
				clientService.addClient(client).then(function() {
					$scope.getAllClients();
				}, function(errResponse) {
					console.error('Error while adding Client details');
				});
			}

			$scope.getAllClients();
		} ]);