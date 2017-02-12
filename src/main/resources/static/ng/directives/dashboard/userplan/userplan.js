angular.module('walkinApp')
    .directive('userplan', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl:  "ng/directives/dashboard/userplan/userplan.tmpl.html",
            controller: function($scope, $state, $window, $location) {
              
           
            }

        };
    }]);