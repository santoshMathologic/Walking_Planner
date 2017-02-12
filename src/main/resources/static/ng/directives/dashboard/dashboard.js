angular.module('walkinApp')
    .directive('dashboard', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl: 'ng/directives/dashboard/dashboard.tmpl.html',
            controller: function($scope, $state, $http, $log, $q, $timeout, $window,ngProgressFactory) {
            	
            	// $scope.states

                $state.go("home.dashboard.userplan");
                
              //  $scope.progressbar = ngProgressFactory.createInstance();
               // $scope.progressbar.start();
                
                
                
            }

        };
    }]);