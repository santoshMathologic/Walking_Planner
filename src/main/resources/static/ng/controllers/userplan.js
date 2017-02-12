'use strict';

angular.module('walkinApp')
  .controller('userplanCtrl', function($scope,$location,$http,$state,toaster) {
	  
	  String.prototype.replaceAll = function(find, replace) {
          var str = this;
          return str.replace(new RegExp(find.replace(/[-\/\\^$*+?.()|[\]{}]/g, '\\$&'), 'g'), replace);
      };
      $scope.string = $state.current.name;
      $scope.title = $scope.string.replaceAll('.', ' > ');
      $scope.headertitle = $scope.title.split('>');
      
      $scope.userPlanList  = [];
      $scope.query = {
              sort: 'planName',
              limit: 10,
              page: 0,
            
          };
      $scope.$watch('query', function(newValue, oldValue) {
          if (newValue !== oldValue) {
        	  $scope.getUserPlan();
          }
      }, true);
      
      
      $scope.getUserPlan = function(){
          $http.get("api/v1/userPlan/getUserPlan",{params:$scope.query}).then(function success(response){
       	   $scope.userPlanList  = response.data.content;
       	   
          },function errorResponse(error){
       	   
       	   
       	   
          });
          
       }
      
      $scope.getUserPlanStatus = function(){
    	  
    	  
    		  $http.get("http://localhost:6060/api/v1/userPlan/getByAllParams?planName=Plan005&limit=10&page=0&owner=santosh").then(function success(response){
    	       	   $scope.userPlans  = response.data.content;
    	       	   
    	          },function errorResponse(error){
    	       	   
    	       	   
    	       	   
    	          });
    		  
    		  
      }
       
      $scope.getUserPlanStatus ();
       $scope.getUserPlan();
       
       $scope.deleteUserPlan = function(userplan){
    	   $scope.userPlanList.splice($scope.userPlanList.indexOf(userplan),1);  // Splice() Method adds/removes items to/from an array
			toaster.pop({type: 'success', title: 'UserPlan Removed', body: 'UserPlan Removed Successfully!!!'}); // Toaster to show the PopUp message after remove
    	   
       }
       
       $scope.selectUserPlan = function(userplan){
          $state.go("home.dashboard.commondashboard");
    	   console.log(userplan);
    	   
       }
       
   	$scope.setInitValues = function() {
		$scope.isSave = true;
		$scope.action = "Create New";
		$scope.userPlan = {};
		$scope.submitted = false;
	}
	$scope.setInitValues();

  
	$scope.saveUserPlan = function(userPlan, type) {
		if ($scope.userPlanList.length > 9) {
			toaster
					.pop({
						type : 'error',
						title : 'Error',
						body : 'You can add more than 10 User Plans . Please delete existing user plan to add new one'
					});
		} else {
			if (userPlan.name){
				if (type == "create"){
					
					
					toaster
					.pop({
						type : 'success',
						title : 'Plan Created Successfully !!!!!!!!',
						body : 'Plan Created Successfully !!!!!!!!'
					});
					
				}
					
			}
			
		}
	 
	};
  
  
  
  });
	
	
	 	  
  
