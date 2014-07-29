var vaderApp = angular.module('vaderApp', [ 'ngRoute', 'vaderControllers' ]);

vaderApp.config([ '$routeProvider', function($routeProvider) {
    $routeProvider.when('/', {
        templateUrl : 'resources/partials/start.html',
        controller : 'StartController'
    });
} ]);