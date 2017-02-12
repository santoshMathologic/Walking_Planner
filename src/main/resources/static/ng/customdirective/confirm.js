/**
 * 
 */
'use strict';
var app = angular.module("walkinApp").directive('confirm', function(ConfirmService) {
    return {
        restrict: 'A',
        scope: {
            eventHandler: '&ngClick'
        },
        link: function(scope, element, attrs){
          element.unbind("click");
          element.bind("click", function(e) {
            ConfirmService.open(attrs.confirm, scope.eventHandler);
          });
        }
    }
});

app.service('ConfirmService', function($modal) {
  return {
	  open : function (text, onOk) {
		    var modalInstance = $modal.open({
		      templateUrl: 'ng/customdirective/loginalert.html',
		      controller: 'ModalConfirmCtrl',
		      resolve: {
		        text: function () {
		          return text;
		        }
		      }
		    });

		    modalInstance.result.then(function (selectedItem) {
		      onOk();
		    }, function () {
		    });
		  }  
  		} 
})
app.controller('ModalConfirmCtrl', function ($scope, $modalInstance, text) {
  $scope.text = text;
  $scope.ok = function () {
    $modalInstance.close(true);
  };
  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});