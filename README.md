# Prueba técnica corrientazo

```
Aplicacion lunchDrone para corrientazo a domicilio
```

## Estructura de la aplicación

```			
└───src
    ├───main
    │   ├───java
    │   │   └───lunchDrone
    │   │       ├───application
    │   │       │       Initializer.java
    │   │       │       LunchDroneApplication.java	#main
    │   │       │
    │   │       ├───domain	#dominio
    │   │       │       Coordinate.java
    │   │       │       Drone.java
    │   │       │       Position.java
    │   │       │
    │   │       ├───exception	#manejo de excepciones
    │   │       │       DataException.java
    │   │       │       DeliveryException.java
    │   │       │       FormatException.java
    │   │       │
    │   │       ├───factory		#factory para crear drones
    │   │       │       DroneFactory.java
    │   │       │
    │   │       ├───service		#servicios
    │   │       │       CreateDroneService.java
    │   │       │       CreateDroneServiceImp.java
    │   │       │       ...
    │   │       │
    │   │       └───util	#utilidad para el manejo de la información
    │   │               ManageInformation.java
    │   │
    │   └───resources	#donde se leen las rutas para cada dron
    │       ├───input
    │       │       init01.txt
    │       │       init02.txt
    │       │       ...
    │       │
    │       └───output #donde se ponen los reportes finales de cada dron
    └───test
        ├───java
        │   └───service
        │           CreateDroneTest.java
        │           DeliveryServiceTest.java
        │           LimitDroneTest.java
        │           ReportTest.java
        │
        └───resources
```


