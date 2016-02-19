function mainController($scope, $http, $window, $location) {

    $scope.map;

/*
    $scope.usuarios = [
        {dni: '49013',patente: 'HAO129', nombre: 'Emanuel', apellido: 'Prado', empresa: 'Sancor'},
        {dni: '49133',patente: 'HAO130', nombre: 'Gabriel', apellido: 'Zampa', empresa: 'Sancor'},
        {dni: '46441',patente: 'HAO131', nombre: 'Emiliano', apellido: 'Grande', empresa: 'Sancor'},
        {dni: '48659',patente: 'HAO132', nombre: 'Pablo', apellido: 'Bongiovanni', empresa: 'Sancor'}
    ];
*/
    $scope.usuarios = [];
    $scope.historicos = [];
    $scope.gpsPosition = [];
    /*
    $scope.historicos = [
      {dni: 49013, fecha: '2015-10-20 17:55:00', conductor: 'Prado, Emanuel', remito: '1-222222222222', tambo: '2-22234', sisterna: '1', antibiotico: 'Si', litros: 35000.0, temperatura: 4.0},
      {dni: 49013, fecha: '2015-10-24 16:75:00', conductor: 'Prado, Emanuel', remito: '1-222222456722', tambo: '2-22333', sisterna: '2', antibiotico: 'No', litros: 33000.0, temperatura: 4.2},
      {dni: 49013, fecha: '2015-10-30 19:05:00', conductor: 'Prado, Emanuel', remito: '1-222345678222', tambo: '2-22456', sisterna: '3', antibiotico: 'Si', litros: 38000.0, temperatura: 3.5},
      {dni: 49133, fecha: '2015-10-20 17:55:00', conductor: 'Gabriel, Zampa', remito: '1-222222222222', tambo: '2-22234', sisterna: '1', antibiotico: 'No', litros: 33000.0, temperatura: 4.0},
      {dni: 49133, fecha: '2015-10-24 16:75:00', conductor: 'Gabriel, Zampa', remito: '1-222222456722', tambo: '2-22333', sisterna: '2', antibiotico: 'Si', litros: 37000.0, temperatura: 4.2},
      {dni: 49133, fecha: '2015-10-30 19:05:00', conductor: 'Gabriel, Zampa', remito: '1-222345678222', tambo: '2-22456', sisterna: '3', antibiotico: 'No', litros: 39000.0, temperatura: 3.5},
      {dni: 46441, fecha: '2015-09-20 17:55:00', conductor: 'Emiliano, Grande', remito: '1-222222222222', tambo: '2-22234', sisterna: '1', antibiotico: 'No', litros: 33000.0, temperatura: 4.0},
      {dni: 46441, fecha: '2015-09-24 16:75:00', conductor: 'Emiliano, Grande', remito: '1-222222456722', tambo: '2-22333', sisterna: '2', antibiotico: 'Si', litros: 37000.0, temperatura: 4.2},
      {dni: 46441, fecha: '2015-09-30 19:05:00', conductor: 'Emiliano, Grande', remito: '1-222345678222', tambo: '2-22456', sisterna: '3', antibiotico: 'No', litros: 39000.0, temperatura: 3.5},
      {dni: 48659, fecha: '2015-11-20 17:55:00', conductor: 'Pablo, Bongiovanni', remito: '1-222222222222', tambo: '2-22234', sisterna: '1', antibiotico: 'No', litros: 32000.0, temperatura: 3.0},
      {dni: 48659, fecha: '2015-11-24 16:75:00', conductor: 'Pablo, Bongiovanni', remito: '1-222222456722', tambo: '2-22333', sisterna: '2', antibiotico: 'Si', litros: 35000.0, temperatura: 5.2},
      {dni: 48659, fecha: '2015-11-30 19:05:00', conductor: 'Pablo, Bongiovanni', remito: '1-222345678222', tambo: '2-22456', sisterna: '3', antibiotico: 'No', litros: 40000.0, temperatura: 4.5}
    ];

    $scope.gpsPosition = [
      {dni: 32317260, gps: {lat: -31.4219772, lng: -64.1877145 }, marker: undefined},
      {dni: 32317260, gps: {lat: -31.4262126, lng: -64.1860127 }, marker: undefined},
      {dni: 32317260, gps: {lat: -31.4294566, lng: -64.1847146 }, marker: undefined},
      {dni: 31669160, gps: {lat: -31.4300505, lng: -64.1843458 }, marker: undefined},
      {dni: 31669160, gps: {lat: -31.430899, lng: -64.1842425 }, marker: undefined},
      {dni: 31669160, gps: {lat: -31.4316556, lng: -64.1842511 }, marker: undefined},
      {dni: 29843624, gps: {lat: -31.4256883, lng: -64.1877521 }, marker: undefined},
      {dni: 29843624, gps: {lat: -31.425164, lng: -64.1891782 }, marker: undefined},
      {dni: 29843624, gps: {lat: -31.424687, lng: -64.1905491 }, marker: undefined},
      {dni: 31623864, gps: {lat: -31.425091, lng: -64.1905002 }, marker: undefined},
      {dni: 31623864, gps: {lat: -31.427033, lng: -64.1913775 }, marker: undefined},
      {dni: 31623864, gps: {lat: -31.4313334, lng: -64.1933603 }, marker: undefined},
    ];
    */

    $scope.usuario = {};
    $scope.historicoUsuario=[];

    $scope.buscar = function(){
      var setPosition = false;
      $scope.usuario = {};
      $scope.usuarios.forEach(function(current){
        if(current.dni == $scope.dni){
          $scope.usuario = current;
          return;
        }
      });
      $scope.historicoUsuario = [];
      if($scope.usuario != undefined){
        $scope.historicos.forEach(function(current){
          if(current.dni === $scope.usuario.dni){
            $scope.historicoUsuario.push(current);
          }
        });
        $scope.gpsPosition.forEach(function(current){
          if(current.dni == $scope.usuario.dni){
            if(current.marker === undefined){
              current.marker = new google.maps.Marker({
                position: current.gps,
                map: map,
                title: $scope.usuario.patente
              });
            }else{
              current.marker.setMap(map);
            }
            if(setPosition == false){
              map.setCenter(current.gps);
              map.setZoom(14);
              setPosition = true;
            }
          }else{
            if(current.marker != undefined){
              current.marker.setMap(null);
            }
          }
        });
      }
    };

     $scope.serial = function (){
        $http.get("/serial").success(function(data){
                  $scope.historicoUsuario = data;
        });
     }


     $scope.init = function(){
        $http.get("/user").success(function(data){
            $scope.usuarios = data;
        });
        $http.get("/ticket").success(function(data){
             $scope.historicos = data;
        });
        $http.get("/gps").success(function(data){
             $scope.gpsPosition = data;
        });

        setInterval(function(){$scope.serial();},5000);

        $scope.map = map;
     };
     $scope.init();

};
var app = angular.module('mainApp', [])
.controller('MainController',mainController)



