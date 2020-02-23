# Prueba técnica S4N

```
Aplicacion lunchDrone para corrientazo a domicilio
```

## Estructura de la aplicación

```
└───src
    └───lunchdrone
        ├───application
        │       Initializer.java
        │       LunchDroneApplication.java		#main
        │
        ├───domain	#dominio
        │       Coordinate.java
        │       Drone.java
        │       Position.java
        │
        ├───exception	#manejo de excepciones
        │       DataException.java
        │       DeliveryException.java
        │       FormatException.java
        │
        ├───factory	    #factory para crear drones
        │       DroneFactory.java
        │
        ├───resources	#donde se leen las rutas para cada dron
        │   ├───input
        │   │       init01.txt
        │   │       init02.txt
        │   │       init03.txt
        │   │       ...
        │   │
        │   └───output	#archivos de salida para cuando realiza las entregas
        ├───service
        │       CreateDroneService.java
        │       CreateDroneServiceImp.java
        │       ...
        │
        └───util	#utilidad para el manejo de la información
                ManageInformation.java
```
