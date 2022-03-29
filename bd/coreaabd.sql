CREATE DATABASE  IF NOT EXISTS `coreaa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `coreaa`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: coreaa
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administradores`
--

DROP TABLE IF EXISTS `administradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administradores` (
  `idadministrador` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idadministrador`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administradores`
--

LOCK TABLES `administradores` WRITE;
/*!40000 ALTER TABLE `administradores` DISABLE KEYS */;
INSERT INTO `administradores` VALUES (3,'Julio','64420192351111','JulioAdmin','4321'),(4,'Benito','64444','BenitoAdmin','1234'),(5,'Luis','644446783','LuisAdmin1','pass'),(6,'Luis','644446783','LuisAdmin1','pass'),(9,'Bryan','64420192351111','BryanAdmin','4321'),(10,'123','123','123','123');
/*!40000 ALTER TABLE `administradores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(150) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (33,'Villa ITSON','Benito Ramirez','644123');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `idcompra` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`idcompra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garantias`
--

DROP TABLE IF EXISTS `garantias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garantias` (
  `idgarantia` int NOT NULL AUTO_INCREMENT,
  `fecha_vencimiento` date NOT NULL,
  PRIMARY KEY (`idgarantia`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garantias`
--

LOCK TABLES `garantias` WRITE;
/*!40000 ALTER TABLE `garantias` DISABLE KEYS */;
INSERT INTO `garantias` VALUES (1,'2022-03-08');
/*!40000 ALTER TABLE `garantias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanicos`
--

DROP TABLE IF EXISTS `mecanicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecanicos` (
  `idmecanico` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idmecanico`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanicos`
--

LOCK TABLES `mecanicos` WRITE;
/*!40000 ALTER TABLE `mecanicos` DISABLE KEYS */;
INSERT INTO `mecanicos` VALUES (1,'Alberto','53444','AlbertoMecanico','4321'),(2,'Bob','644112345','BobMecanico','mecanico');
/*!40000 ALTER TABLE `mecanicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piezas`
--

DROP TABLE IF EXISTS `piezas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piezas` (
  `idpieza` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `costo` double NOT NULL,
  `cantidad` int NOT NULL,
  `fecha_garantia` date DEFAULT NULL,
  PRIMARY KEY (`idpieza`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piezas`
--

LOCK TABLES `piezas` WRITE;
/*!40000 ALTER TABLE `piezas` DISABLE KEYS */;
INSERT INTO `piezas` VALUES (12,'bujes',12,15,NULL),(13,'biela',32,10,NULL),(14,'clutch',500,2,NULL),(15,'puerta',1000,0,NULL);
/*!40000 ALTER TABLE `piezas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rel_compra_piezas`
--

DROP TABLE IF EXISTS `rel_compra_piezas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rel_compra_piezas` (
  `idrel_compra_piezas` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `idcompra` int NOT NULL,
  `idpieza` int NOT NULL,
  PRIMARY KEY (`idrel_compra_piezas`),
  KEY `Fk_comprapiezas_idx` (`idcompra`),
  KEY `Fk_piezacompras_idx` (`idpieza`),
  CONSTRAINT `Fk_comprapiezas` FOREIGN KEY (`idcompra`) REFERENCES `compras` (`idcompra`),
  CONSTRAINT `Fk_piezacompras` FOREIGN KEY (`idpieza`) REFERENCES `piezas` (`idpieza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rel_compra_piezas`
--

LOCK TABLES `rel_compra_piezas` WRITE;
/*!40000 ALTER TABLE `rel_compra_piezas` DISABLE KEYS */;
/*!40000 ALTER TABLE `rel_compra_piezas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relclientevehiculo`
--

DROP TABLE IF EXISTS `relclientevehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relclientevehiculo` (
  `idrelclientevehiculo` int NOT NULL AUTO_INCREMENT,
  `idcliente` int NOT NULL,
  `idvehiculo` int NOT NULL,
  PRIMARY KEY (`idrelclientevehiculo`),
  KEY `FK_relclientevehiculo_idcliente` (`idcliente`),
  KEY `FK_relclientevehiculo_idvehiculo` (`idvehiculo`) /*!80000 INVISIBLE */,
  CONSTRAINT `FK_relclientevehiculo_idcliente` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`idcliente`),
  CONSTRAINT `FK_relclientevehiculo_idvehiculo` FOREIGN KEY (`idvehiculo`) REFERENCES `vehiculos` (`idvehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relclientevehiculo`
--

LOCK TABLES `relclientevehiculo` WRITE;
/*!40000 ALTER TABLE `relclientevehiculo` DISABLE KEYS */;
INSERT INTO `relclientevehiculo` VALUES (23,33,25);
/*!40000 ALTER TABLE `relclientevehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relventapieza`
--

DROP TABLE IF EXISTS `relventapieza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relventapieza` (
  `idrelventapieza` int NOT NULL AUTO_INCREMENT,
  `cantidad` varchar(45) NOT NULL,
  `idventa` int NOT NULL,
  `idpieza` int NOT NULL,
  PRIMARY KEY (`idrelventapieza`),
  KEY `FK_relventapieza_idventa` (`idventa`),
  KEY `FK_relventapieza_idpieza` (`idpieza`),
  CONSTRAINT `FK_relventapieza_idpieza` FOREIGN KEY (`idpieza`) REFERENCES `piezas` (`idpieza`),
  CONSTRAINT `FK_relventapieza_idventa` FOREIGN KEY (`idventa`) REFERENCES `ventas` (`idventa`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relventapieza`
--

LOCK TABLES `relventapieza` WRITE;
/*!40000 ALTER TABLE `relventapieza` DISABLE KEYS */;
INSERT INTO `relventapieza` VALUES (10,'8',26,12),(11,'5',27,12),(12,'3',29,12),(25,'10',30,13);
/*!40000 ALTER TABLE `relventapieza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relventaservicio`
--

DROP TABLE IF EXISTS `relventaservicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `relventaservicio` (
  `idrelVentaServicio` int NOT NULL AUTO_INCREMENT,
  `idventa` int NOT NULL,
  `idservicio` int NOT NULL,
  PRIMARY KEY (`idrelVentaServicio`),
  KEY `FK_relventasservicio_idventa` (`idventa`) /*!80000 INVISIBLE */,
  KEY `FK_relventasservicio_idservicio` (`idservicio`) /*!80000 INVISIBLE */,
  CONSTRAINT `FK_relventasservicio_idservicio` FOREIGN KEY (`idservicio`) REFERENCES `servicios` (`idservicio`),
  CONSTRAINT `FK_relventasservicio_idventa` FOREIGN KEY (`idventa`) REFERENCES `ventas` (`idventa`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relventaservicio`
--

LOCK TABLES `relventaservicio` WRITE;
/*!40000 ALTER TABLE `relventaservicio` DISABLE KEYS */;
INSERT INTO `relventaservicio` VALUES (49,26,57),(50,27,58),(53,29,61),(67,30,78),(68,30,79);
/*!40000 ALTER TABLE `relventaservicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicios` (
  `idservicio` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `costo` double NOT NULL,
  `concepto` varchar(150) NOT NULL,
  `proximo_servicio` date DEFAULT NULL,
  PRIMARY KEY (`idservicio`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (57,'2022-03-23',23,'servicio9',NULL),(58,'2022-03-23',23,'se1',NULL),(61,'2022-03-27',100,'cambio de aceite',NULL),(78,'2022-03-29',34,'servicio1',NULL),(79,'2022-03-29',44,'servicio2',NULL);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos` (
  `idvehiculo` int NOT NULL AUTO_INCREMENT,
  `modelo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  PRIMARY KEY (`idvehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (25,'2021','A4','Audi');
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `idventa` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `idcliente` int NOT NULL,
  `total` double NOT NULL,
  `notas` varchar(250) DEFAULT NULL,
  `idvehiculo` int NOT NULL,
  `vendedor` varchar(45) NOT NULL,
  PRIMARY KEY (`idventa`),
  KEY `Fk_ventas_cliente_idx` (`idcliente`) /*!80000 INVISIBLE */,
  KEY `Fk_ventas_vehiculo_idx` (`idvehiculo`),
  CONSTRAINT `Fk_ventas_cliente` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`idcliente`),
  CONSTRAINT `Fk_ventas_vehiculo` FOREIGN KEY (`idvehiculo`) REFERENCES `vehiculos` (`idvehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (26,'2022-03-23',33,23,'',25,'123'),(27,'2022-03-23',33,45,'',25,'123'),(29,'2022-03-27',33,150,'bujes con aceite',25,'123'),(30,'2022-03-27',33,110,'nuea',25,'123');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-29 13:57:29
