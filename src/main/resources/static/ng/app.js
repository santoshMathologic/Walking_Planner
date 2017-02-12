'use strict';


var api ={
		 protocol: 'http',
		 server: 'localhost',
		 port: 6060,
		 baseUrl: '/api/v1',
		 loginUrl: '/login',
		 registrationUrl:'/registration'
}

var $http = angular.injector(['ng']);

var apiUrl = api.protocol + '://' + api.server + ':' + api.port + api.baseUrl;
var apiLoginUrl = api.protocol + '://' + api.server + ':' + api.port +api.baseUrl+api.loginUrl;
var apiRegistrationUrl = api.protocol + '://' + api.server + ':' + api.port + api.registrationUrl;

var app = angular
  .module('walkinApp', [
    'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'ngSanitize',
    'smart-table',
    'toaster',
    'ngAnimate',
    'ngCookies',
    'base64',
    'angucomplete-alt',
    'AxelSoft',
    'flow',
    'ngRoute',
    'toggle-switch',
    'ngProgress',
    'uiSwitch'
    
  ]).factory('TokenInterceptor', function($q, $window,$location) {
	  return {
		    request: function(config) {
		      config.headers = config.headers || {};
		      if ($window.sessionStorage.token) {
		        config.headers['X-Access-Token'] = $window.sessionStorage.token;
		        config.headers['X-Key'] = $window.sessionStorage.user;
		        config.headers['Content-Type'] = config.headers['Content-Type'] || "application/json";
		      }
		      return config || $q.when(config);
		    },
		 
		    response: function(response) {
		    	if(response.status === 401 || response.status === 403) {
	                /* I need to resend the same request with token included here 
	                 * if the token exist in local storage
	                 */
	                $location.path('/login');
	            }
		      return response || $q.when(response);
		    }
		  };
		})
  .config(['$stateProvider','$routeProvider','$urlRouterProvider','$ocLazyLoadProvider','$httpProvider','$locationProvider',
           function ($stateProvider,$routeProvider,$urlRouterProvider,$ocLazyLoadProvider,$httpProvider,$locationProvider) {
	
	 
	  $httpProvider.defaults.headers.common['Access-Control-Allow-Headers'] = '*';
     // $locationProvider.html5Mode(true);
    $ocLazyLoadProvider.config({
      debug:false,
      events:true,
    });
    
    $routeProvider
    .when('/404', {
        templateUrl: 'errorPages/404error.html'
        
    })

   $urlRouterProvider.otherwise('/home/dashboard');
   //$urlRouterProvider.otherwise('/login');
  // $urlRouterProvider.otherwise('/404');
    $stateProvider
      .state('home', {
        url:'/home',
        templateUrl:'ng/directives/home/home.directive.html',
        resolve: {
            loadMyDirectives:function($ocLazyLoad){
                return $ocLazyLoad.load(
                {
                    name:'walkinApp',
                    files:[
                           'ng/directives/home/home.js',
                          
                   
                    ]
                }),
                $ocLazyLoad.load(
                {
                   name:'toggle-switch',
                   files:["bower_components/angular-toggle-switch/angular-toggle-switch.min.js",
                          "bower_components/angular-toggle-switch/angular-toggle-switch.css"
                      ]
                }),
                $ocLazyLoad.load(
                {
                  name:'ngAnimate',
                  files:['bower_components/angular-animate/angular-animate.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngCookies',
                  files:['bower_components/angular-cookies/angular-cookies.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngResource',
                  files:['bower_components/angular-resource/angular-resource.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngSanitize',
                  files:['bower_components/angular-sanitize/angular-sanitize.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngTouch',
                  files:['bower_components/angular-touch/angular-touch.js']
                })
            }
        }
    })
      .state('home.dashboard',{
        url:'/dashboard',
        controller: 'MainCtrl',
        templateUrl:'ng/directives/dashboard/dashboard.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'walkinApp',
              files:[
              'ng/directives/dashboard/dashboard.js',
              'ng/directives/dashboard/header/header.js',
              'ng/directives/dashboard/sidebar/sidebar.js',
              'ng/controllers/main.js',
              'ng/utils/customConverter.js',
              'ng/utils/customUtil.js',
              'ng/utils/serverTableFetch.js',
              'ng/utils/passwordValidator.js',
              'ng/utils/passwordEquals.js'
              
              ]
            })
          }
        }
      })
       .state('home.dashboard.blank',{
        templateUrl:'ng/directives/dashboard/blank/blank.directive.html',
        controller: 'blankCtrl',
        url:'/blank',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/directives/dashboard/blank/blank.js",
                       "ng/controllers/blank.js",
                       'ng/directives/dashboard/stats/stats.js'
                ]
              })
            }
          }
    }) 
    .state('home.dashboard.upload',{
        templateUrl:'ng/directives/dashboard/upload/upload.directive.html',
        controller: 'uploadCtrl',
        url:'/upload',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/directives/dashboard/upload/upload.js",
                       "ng/controllers/upload.js"
                       
                ]
              })
            }
          }
    })
    
    
    .state('home.dashboard.company',{
        templateUrl:'ng/directives/dashboard/company/company.directive.html',
        controller: 'companyCtrl',
        url:'/company',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/directives/dashboard/company/company.js",
                       "ng/controllers/company.js",
                       "ng/utils/serverTableRetrive.js"

                       
                ]
              })
            }
          }
    }).state('home.dashboard.walking',{
        templateUrl:'ng/directives/dashboard/walking/walking.directive.html',
        controller: 'walkingCtrl',
        url:'/walkin',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/directives/dashboard/walking/walking.js",
                       "ng/controllers/walking.js",
                       "ng/utils/serverTableRetrive.js"

                       
                ]
              })
            }
          }
    }).state('home.dashboard.commondashboard',{
        templateUrl:'ng/directives/dashboard/commondashboard/commondashboard.directive.html',
        url:'/commondsbord',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/directives/dashboard/commondashboard/commondashboard.js",
                       'ng/directives/dashboard/stats/stats.js'

                       
                ]
              })
            }
          }
    	})
      .state('login',{
        templateUrl:'ng/login/login.html',
        url:'/login',
        controller:"loginCtrl",
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/login/login.js",
                       'ng/factory/AuthenticationFactory.js',
                       'ng/factory/UserAuthFactory.js',
                       'ng/factory/TokenInterceptor.js',
                       'ng/customdirective/confirm.js'
                 ]
              })
            }
          }
    }).state('registration',{
        templateUrl:'ng/registration/registration.directive.html',
        url:'/registration',
        controller:"registrationCtrl",
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/registration/registration.js",
                       "ng/controllers/registration.js"
                       
                 ]
              })
            }
          }
    })
    .state('home.dashboard.createNewCompany',{
        templateUrl:'ng/directives/dashboard/createNewCompany/createNewCompany.directive.html',
        controller: 'createNewCompanyCtrl',
        url:'/createNewCompany',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/directives/dashboard/createNewCompany/createNewCompany.js",
                       "ng/controllers/createNewCompany.js"
                       
                ]
              })
            }
          }
    }).state('home.dashboard.createUser',{
        templateUrl:'ng/directives/dashboard/createUser/createUser.directive.html',
        controller: 'createUserCtrl',
        url:'/createUser',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/directives/dashboard/createUser/createUser.js",
                       "ng/controllers/createUser.js",
                       'ng/utils/passwordEquals.js'
                       
                ]
              })
            }
          }
    })
    
    .state('home.dashboard.user',{
        templateUrl:'ng/directives/dashboard/user/user.directive.html',
        controller: 'userCtrl',
        url:'/user',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/directives/dashboard/user/user.js",
                       "ng/controllers/user.js"
                       
                ]
              })
            }
          }
    })
    
    .state('home.dashboard.userplan',{
        templateUrl:'ng/directives/dashboard/userplan/userplan.directive.html',
        controller: 'userplanCtrl',
        url:'/userPlan',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkinApp',
                files:[
                       "ng/directives/dashboard/userplan/userplan.js",
                       "ng/controllers/userplan.js"
                       
                ]
              })
            }
          }
    });
   
  }]).run(function($rootScope, $location) {
      $rootScope.$on("$routeChangeStart", function (event, next, current) {
          if (!(next.templateUrl == "login/login.html")) {
              $location.path("/login");
          }
      })
  }).constant('_', window._);
  
  /*.run(function ($rootScope, $state, $log) {
  
  $rootScope.$on('$stateChangeStart', 
   function(event, toState, toParams, fromState, fromParams){ 
      event.preventDefault();
      window.history.forward();
});
});*/
  
  /*.run(function ($rootScope, $state, $log) {
      $rootScope.$on('$stateChangeStart', function (event, toState) {
      console.log(toState.name);
  var user = JSON.parse(localStorage.getItem('user'));
  if (user) {
      $rootScope.authenticated = true;
      $rootScope.currentUser = user;
  }
});
});
*/
app.filter('toArray', function() { return function(obj) {
    if (!(obj instanceof Object)) return obj;
    var result = [];
	for(var i =0; i<Object.keys(obj).length ;i++){
		for(var item in obj){
			if(obj[item] == i){
				result.push(item);
			}
		}
	}
	return result;
}});