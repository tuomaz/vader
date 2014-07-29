'use strict';

/* Controllers */

var vaderControllers = angular.module('vaderControllers', []);

vaderControllers.controller('StartController', [ 
        '$scope',
        '$http',
        '$timeout',
        function($scope, $http, $timeout) {
            $scope.loadData = function () {
                $http({method: 'GET', url: 'rest/sample/get', cache: false}).success(function(data) {
                    $scope.samples = data;
                });
            };

            $scope.intervalFunction = function(){
              $timeout(function() {
                $scope.loadData();
                $scope.intervalFunction();
              }, 1000 * 60 * 4)
            };

            $scope.intervalFunction();
            $scope.loadData();
}]);