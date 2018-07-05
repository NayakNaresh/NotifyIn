'use strict';

var app = angular.module('app', ['ui.router','ngSanitize']);

app.constant('Constants', {
   apiUrl: 'http://localhost:8080'
})
app.config(function($stateProvider){
	$stateProvider
	        .state('client',{
        	url:'/client',
            templateUrl: '/views/clientDetails.html',
            controller: 'clientController'
        })
       .state('module',{
    	    url:'/module',
            templateUrl: '/views/clientModules.html',
            controller: 'moduleController'
        })
        .state('sms',{
        	url:'/sms',
            templateUrl: '/views/sms.html',
            controller: 'smsController'
        })
        .state('email',{
        	url:'/email',
            templateUrl: '/views/email.html',
            controller: 'emailController'
        });
});

