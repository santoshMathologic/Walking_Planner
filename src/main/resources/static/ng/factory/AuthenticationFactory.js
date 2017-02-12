'use strict';

angular.module('walkinApp').factory('AuthenticationFactory', function($window) {
  var auth = {
    isLogged: false,
    isLoggedIn: function(){
        return this.check();
    },
    check: function() {
      if ($window.sessionStorage.token && $window.sessionStorage.user) {
        this.isLogged = true;
      } else {
        this.isLogged = false;
        delete this.user;
      }
      return (this.isLogged)?this.isLogged:false;
    }
  }
 
  return auth;
});