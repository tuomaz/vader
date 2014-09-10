'use strict';

/* Controllers */

var vaderControllers = angular.module('vaderControllers', []);

vaderControllers.controller('StartController', [ '$scope', '$http', '$timeout',
        function($scope, $http, $timeout) {
            $scope.loadData = function() {
                $http({
                    method : 'GET',
                    url : 'rest/sample/get',
                    cache : false
                }).success(function(data) {
                    $scope.samples = data;
                });
            };

            $scope.intervalFunction = function() {
                $timeout(function() {
                    $scope.loadData();
                    $scope.intervalFunction();
                }, 1000 * 60 * 4)
            };

            $scope.intervalFunction();
            $scope.loadData();
        } ]);

vaderControllers.controller('GraphController', ['$scope',
        function($scope) {
            $scope.config = {
                    title: 'Temperatur',
                    tooltips: true,
                    labels: false,
                    mouseover: function() {},
                    mouseout: function() {},
                    click: function() {},
                    legend: {
                      display: true,
                      position: 'right'
                    }
            };
            $scope.data = {
                    series: ['Sales', 'Income', 'Expense', 'Laptops', 'Keyboards'],
                    data: [{
                      x: "Laptops",
                      y: [100, 500, 0],
                      tooltip: "this is tooltip"
                    }, {
                      x: "Desktops",
                      y: [300, 100, 100]
                    }, {
                      x: "Mobiles",
                      y: [351]
                    }, {
                      x: "Tablets",
                      y: [54, 0, 879]
                    }]
            };
        } ]);
