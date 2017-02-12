angular.module('walkinApp')
    .directive('company', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl:  "ng/directives/dashboard/company/company.tmpl.html",
            controller: function($scope, $state, $window, $location) {
            
            	$scope.string = $state.current.name;
            	$scope.title = $scope.string.replaceAll('.', ' > ');
            	$scope.headertitle = $scope.title.split('>');
    			
              
          
            }

        };
    }]);