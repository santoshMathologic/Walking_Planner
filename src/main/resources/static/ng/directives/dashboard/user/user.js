angular.module('walkinApp')
    .directive('user', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl:  "ng/directives/dashboard/user/user.tmpl.html",
            controller: function($rootScope, $scope, $modal, $state, $stateParams, $location, $timeout,$interpolate, $http,$window) {
            	
            	$scope.string = $state.current.name;
            	$scope.title = $scope.string.replaceAll('.', ' > ');
            	$scope.headertitle = $scope.title.split('>');
                 
                 $scope.usersList  = [];
                 $scope.roles = [];
                 
                 $scope.query = {
                         sort: 'username',
                         limit: 10,
                         page: 0,
                         
                        
                     };
                 
                 $scope.passwordRegex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
                 $scope.validatePattern = false;
         		 $scope.passReq = false;
         		 $scope.addSomeChar = false;
         		//$scope.barStatus = barStatus;
         		 $scope.progressStatus = 'white';
         		 $scope.passwordStrength = null;
         		 $scope.strongPswd = true;
         		 $scope.commonSequences = false;
         		 $scope.confirmPswdfield = true;
         		 $scope.disablePage = true;
         		 
         		$scope.inputTypenew = 'password';
         		$scope.showpassword = false;
         		  
                
                $scope.getUsers = function(){
                   $http.get("/api/v1/user/getUsers",{params:$scope.query}).then(function success(response){
                	   $scope.usersList = response.data.content;
                	   
                   },function errorResponse(error){
                	   
                	   
                	   
                   });
                   
                }
                
                $scope.getUsers();
                
                $scope.getRoles = function(){
                	$scope.query1 = {
                			  sort: 'name',
                              limit: 10,
                              page: 0,
                			
                	}
                    $http.get("/api/v1/roles/getUserRoles",{params:$scope.query1}).then(function success(response){
                 	   $scope.roles = response.data.content;
                 	   
                    },function errorResponse(error){
                 	   
                 	   
                 	   
                    });
                    
                 }
                 
                 $scope.getRoles();
                   
                   

				$scope.passwordBarStatus = function(form) {
						if (form.password.$viewValue.length >= 1
												&& !$scope.passwordRegex
														.test(form.password.$viewValue)) {
											$scope.progressStatus = 'red';
											$scope.passwordStrength = 'Weak';
											$scope.strongPswd = true;
											$scope.shownewPasswordText = true;
											$scope.hidenewPasswordText = false;
											$scope.validIconStatus = false;

										}
						
						if (form.password.$viewValue.length >= 9
								&& !$scope.passwordRegex
										.test(form.password.$viewValue)) {
								$scope.progressStatus = 'green';
					            $scope.passwordStrength = 'Strong';
								$scope.shownewPasswordText = false;
								$scope.validIconStatus = true;
								$scope.passwordStatus = 'valid';

						}
						if (!$scope.passwordRegex.test(form.password.$viewValue) && form.password.$viewValue.length === 8) {
							 	$scope.progressStatus = 'amber';
					            $scope.passwordStrength = 'Medium';
								$scope.strongPswd = true;
								$scope.shownewPasswordText = true;
								$scope.validIconStatus = false;
				        }
						
						if (form.password.$viewValue.length < 1) {
				            $scope.progressStatus = 'white';
				            $scope.passwordStrength = 'Weak';
							$scope.strongPswd = true;
							$scope.shownewPasswordText = true;
							$scope.validIconStatus = false;
				        } 
		
						
						

					}
                   
                   $scope.inputType = 'password';
                   $scope.hideShowPassword = function(){
                     if ($scope.inputType == 'password')
                       $scope.inputType = 'text';
                     else
                       $scope.inputType = 'password';
                   };
                   
                   
                   $scope.saveUser = function(ngFormValidate,userdetails){
                	   
                	   if(ngFormValidate) {
                		   console.log(userdetails);
                  	   }
                	   
                	   $scope.validateFields(ngFormValidate);
                   }
                   $scope.isUserInvalid = false;
                   $scope.validateFields = function(ngFormValidate){
                	   
                	   if(ngFormValidate.username.$dirty && ngFormValidate.username.$invalid && ngFormValidate.username.$error.required){
                		   $scope.isUserInvalid = true;
                	   }else{
                		   $scope.isUserInvalid = false;
                	   }
                	   
                	   if(ngFormValidate.password.$dirty && ngFormValidate.password.$invalid && ngFormValidate.password.$error.required){
                		   $scope.isUserInvalid = true;
                	   }
                	   else{
                		   
                		   $scope.isUserInvalid = false;
                	   }
                	   
                	   if(ngFormValidate.repassword.$error && ngFormValidate.repassword.$error.unique){
                		   $scope.isUserInvalid = true;
                	   }else{
                		   $scope.isUserInvalid = false;
                	   }
						
                	   
                	   
                   }
                  
              
              
          
            }

        };
    }]);