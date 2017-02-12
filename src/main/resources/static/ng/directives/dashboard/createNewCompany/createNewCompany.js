angular.module('walkinApp')
    .directive('createNewCompany', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl:  "ng/directives/dashboard/createNewCompany/createNewCompany.tmpl.html",
            controller: function($scope, $state, $window, $location) {
            	 String.prototype.replaceAll = function(find, replace) {
                     var str = this;
                     return str.replace(new RegExp(find.replace(/[-\/\\^$*+?.()|[\]{}]/g, '\\$&'), 'g'), replace);
                 };
                 $scope.string = $state.current.name;
                 $scope.title = $scope.string.replaceAll('.', ' > ');
             
              
          
            }

        };
    }]);