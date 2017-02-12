'use strict';
angular.module("walkinApp").factory('UserAuthFactory', function($state,$window, $cookies,$base64,$location, $http, AuthenticationFactory) {
  return {
    login: function(username, password) {
    	return $http({
			method : 'POST',
			url : apiLoginUrl + "/" + "doLogin",
			headers : {
				'Authorization':'Basic '+ $base64.encode(username+":"+password)
				
			},
			
		});
    },
    logout: function() {
 
      if (AuthenticationFactory.isLogged) {
 
        AuthenticationFactory.isLogged = false;
        delete AuthenticationFactory.user;
        delete AuthenticationFactory.userRole;
        delete $window.sessionStorage.userPlan; 
        delete $window.sessionStorage.token;
        delete $window.sessionStorage.user;
        delete $window.sessionStorage.userRole;
        
        $cookies = {};
 
        $state.go("home.login");
      }
 
    }
  }
});
 