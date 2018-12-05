CREATE DATABASE  IF NOT EXISTS `proyecto` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `proyecto`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `analisis`
--

DROP TABLE IF EXISTS `analisis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `analisis` (
  `idAnalisis` int(11) NOT NULL AUTO_INCREMENT,
  `nota` int(11) NOT NULL,
  `comentario` text,
  `fechaAlta` datetime NOT NULL,
  `idJuego` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idAnalisis`),
  KEY `FK_analisis_usuario_idx` (`idUsuario`),
  KEY `FK_analisis_juego_idx` (`idJuego`),
  CONSTRAINT `FK_analisis_juego` FOREIGN KEY (`idJuego`) REFERENCES `juego` (`idjuego`),
  CONSTRAINT `FK_analisis_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis`
--

LOCK TABLES `analisis` WRITE;
/*!40000 ALTER TABLE `analisis` DISABLE KEYS */;
INSERT INTO `analisis` VALUES (1,9,'Muy divertido','1999-03-03 00:00:00',1,4);
/*!40000 ALTER TABLE `analisis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (3,'Aventura'),(5,'Estrategia'),(2,'Plataformas'),(1,'Simulador');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juego`
--

DROP TABLE IF EXISTS `juego`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `juego` (
  `idJuego` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `fechaLanzamiento` date DEFAULT NULL,
  `descripcion` text,
  `idCategoria` int(11) NOT NULL,
  `idPlataforma` int(11) NOT NULL,
  PRIMARY KEY (`idJuego`),
  UNIQUE KEY `titulo_UNIQUE` (`titulo`),
  KEY `FK_juego_idCategoria_idx` (`idCategoria`),
  KEY `FK_juego_idPlataforma_idx` (`idPlataforma`),
  CONSTRAINT `FK_juego_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idcategoria`),
  CONSTRAINT `FK_juego_idPlataforma` FOREIGN KEY (`idPlataforma`) REFERENCES `plataforma` (`idplataforma`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego`
--

LOCK TABLES `juego` WRITE;
/*!40000 ALTER TABLE `juego` DISABLE KEYS */;
INSERT INTO `juego` VALUES (1,'Super Mario Bros','2018-11-12',NULL,2,1),(2,'Mario Kart','2018-11-12',NULL,1,1),(3,'Sonic the Hedgehog','2018-11-12',NULL,2,2),(14,'3','2018-12-04','',3,4),(16,'22','2018-12-12','',3,4),(21,'asdas22','2018-12-05','asda',2,4),(22,'11111','2018-12-04','',3,4),(23,'asdasd','2018-12-18','',3,4),(36,'11','2018-12-12','',3,4);
/*!40000 ALTER TABLE `juego` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juego_usuario`
--

DROP TABLE IF EXISTS `juego_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `juego_usuario` (
  `idJuegoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) NOT NULL,
  `idJuego` int(11) NOT NULL,
  PRIMARY KEY (`idJuegoUsuario`),
  KEY `FK_idUsuarioJuego_idx` (`idUsuario`),
  KEY `FK_idJuegoUsuario_idx` (`idJuego`),
  CONSTRAINT `FK_idJuegoUsuario` FOREIGN KEY (`idJuego`) REFERENCES `juego` (`idjuego`),
  CONSTRAINT `FK_idUsuarioJuego` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idusuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego_usuario`
--

LOCK TABLES `juego_usuario` WRITE;
/*!40000 ALTER TABLE `juego_usuario` DISABLE KEYS */;
INSERT INTO `juego_usuario` VALUES (23,4,3);
/*!40000 ALTER TABLE `juego_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plataforma`
--

DROP TABLE IF EXISTS `plataforma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plataforma` (
  `idPlataforma` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`idPlataforma`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataforma`
--

LOCK TABLES `plataforma` WRITE;
/*!40000 ALTER TABLE `plataforma` DISABLE KEYS */;
INSERT INTO `plataforma` VALUES (4,'PC'),(2,'SEGA MegaDrive'),(3,'Sony PlayStation'),(1,'Super Nintendo');
/*!40000 ALTER TABLE `plataforma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo_usuario` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipo`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'admin'),(2,'usuario');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  `fechaAlta` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `apodo_UNIQUE` (`nombreUsuario`),
  KEY `FK_usuario_idTipo_idx` (`tipoUsuario`),
  CONSTRAINT `FK_usuario_idTipo` FOREIGN KEY (`tipoUsuario`) REFERENCES `tipo_usuario` (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (4,'admin','admin@admin.com','admin',1,'2018-11-12 16:11:17'),(5,'Pepe','pepe@admin.com','admin',2,'2018-11-12 16:12:46'),(6,'Juan','juan@admin.com','admin',2,'2018-11-12 16:13:02'),(7,'Fran','fran@admin.com','admin',2,'2018-11-12 16:13:04'),(8,'pepito','pep@pep.com','pepito',2,'2018-12-03 18:37:20'),(9,'pep','pep@pep','pep',2,'2018-12-03 18:38:38'),(10,'1','1@1','1',2,'2018-12-03 18:43:01'),(11,'2','2@2','2',2,'2018-12-03 18:44:29'),(12,'3','2@2','3',2,'2018-12-03 18:45:29'),(13,'4','4@4','4',2,'2018-12-03 18:46:03'),(14,'23','23@2','23',2,'2018-12-03 18:50:15'),(16,'aaa','aaa@aaa','aaa',2,'2018-12-03 18:52:10'),(17,'','asd@asd','22',2,'2018-12-03 19:33:22');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-05 19:00:45
