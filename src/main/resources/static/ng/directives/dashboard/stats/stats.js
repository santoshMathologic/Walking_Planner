'use strict';

/**
 * @ngdoc directive
 * @name izzyposWebApp.directive:adminPosHeader
 * @description
 * # adminPosHeader
 */
angular.module('walkinApp')
    .directive('stats',function() {
    	return {
  		templateUrl:"ng/directives/dashboard/stats/stats.tmpl.html",
  		restrict:'E',
  		replace:true,
  		scope: {
        'model': '=',
        'comments': '@',
        'number': '@',
        'name': '@',
        'colour': '@',
        'details':'@',
        'type':'@',
        'goto':'@',
        'fasize':'@'
  		}
  		
  	}
  });
