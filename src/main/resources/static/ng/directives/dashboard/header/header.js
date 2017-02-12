angular.module('walkinApp')
    .directive('customHeader', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl:  "ng/directives/dashboard/header/header.tmpl.html",
            controller: function($scope, $state, $window, $location,$http) {
            	
            	
              
            	$scope.logout = function(){
	        		$http.get('/logout').then(function(response){
	        			$window.location.href="/login/login.html";
	        		});
	        	}
              
          
            }

        };
    }]);