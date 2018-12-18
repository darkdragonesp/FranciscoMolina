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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `analisis`
--

LOCK TABLES `analisis` WRITE;
/*!40000 ALTER TABLE `analisis` DISABLE KEYS */;
INSERT INTO `analisis` VALUES (28,70,'Muy divertido.','2018-12-18 16:08:36',2,4),(29,99,'El mejor juego de plataformas.','2018-12-18 16:10:18',3,4),(30,60,'Algo aburrido.','2018-12-18 16:11:10',3,5),(31,80,'Me encantó.','2018-12-18 16:11:36',3,6),(32,100,'Muy entretenido. Espero la segunda parte.','2018-12-18 16:16:16',3,7);
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (3,'Aventura'),(17,'Carreras'),(14,'Deportes'),(16,'Disparos'),(5,'Estrategia'),(15,'Lucha'),(2,'Plataformas'),(19,'Puzzle'),(18,'Rol'),(1,'Simulación');
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
  `caratula` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idJuego`),
  UNIQUE KEY `titulo_UNIQUE` (`titulo`),
  KEY `FK_juego_idCategoria_idx` (`idCategoria`),
  KEY `FK_juego_idPlataforma_idx` (`idPlataforma`),
  CONSTRAINT `FK_juego_idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idcategoria`),
  CONSTRAINT `FK_juego_idPlataforma` FOREIGN KEY (`idPlataforma`) REFERENCES `plataforma` (`idplataforma`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego`
--

LOCK TABLES `juego` WRITE;
/*!40000 ALTER TABLE `juego` DISABLE KEYS */;
INSERT INTO `juego` VALUES (1,'Super Mario Bros','1987-11-12','Super Mario Bros. o Super Mario Brothers es un videojuego de plataformas, diseñado por Shigeru Miyamoto, lanzado el 13 de septiembre de 1985 y producido por la compañía Nintendo, para la consola Nintendo Entertainment System (NES). El juego describe las aventuras de los hermanos Mario y Luigi, personajes que ya protagonizaron el arcade Mario Bros. de 1983. ',2,8,NULL),(2,'Mario Kart','1992-11-12','Mario Kart es una serie de videojuegos de carreras desarrollados y distribuidos por Nintendo y cuentan con la aparición de los personajes de la serie de Mario, que además tiene varios spin-offs por cada entrega de estos juegos. El primer juego de la serie, Super Mario Kart, fue lanzado en 1992 para la consola Super Nintendo y fue un éxito comercial y crítico.',17,1,NULL),(3,'Sonic the Hedgehog','1991-11-12','Sonic the Hedgehog (En español Sonic el erizo) es un videojuego desarrollado por Sonic Team y distribuido por Sega en 1991 para la videoconsola Sega Mega Drive protagonizado por Sonic. Este videojuego de plataformas fue, durante mucho tiempo, considerado el buque insignia de Sega, el ejemplo a seguir para sus futuros juegos. Incluso llegó a dar nombre a uno de sus equipos de desarrollo: Sonic Team. ',2,2,NULL),(52,'Tetris','1989-12-18','Tetris (en ruso: Те́трис) es un videojuego de puzzle originalmente diseñado y programado por Alekséi Pázhitnov en la Unión Soviética. Fue lanzado el 6 de junio de 1984,​ mientras trabajaba para el Centro de Computación Dorodnitsyn de la Academia de Ciencias de la Unión Soviética en Moscú, RSFS de Rusia. Su nombre deriva del prefijo numérico griego tetra- (todas las piezas del juego, conocidas como Tetrominós que contienen cuatro segmentos) y del tenis, el deporte favorito de Pázhitnov.',19,7,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juego_usuario`
--

LOCK TABLES `juego_usuario` WRITE;
/*!40000 ALTER TABLE `juego_usuario` DISABLE KEYS */;
INSERT INTO `juego_usuario` VALUES (34,4,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plataforma`
--

LOCK TABLES `plataforma` WRITE;
/*!40000 ALTER TABLE `plataforma` DISABLE KEYS */;
INSERT INTO `plataforma` VALUES (6,'Atari 2600'),(7,'Nintendo Gameboy'),(8,'Nintendo NES'),(4,'PC'),(2,'SEGA MegaDrive'),(5,'SNK Neo Geo'),(3,'Sony PlayStation'),(1,'Super Nintendo');
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (4,'admin','admin@admin.com','admin',1,'2018-11-12 16:11:17'),(5,'pepe','pepe@admin.com','pepe',2,'2018-11-12 16:12:46'),(6,'juan','juan@admin.com','juan',2,'2018-11-12 16:13:02'),(7,'fran','fran@admin.com','fran',2,'2018-11-12 16:13:04');
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

-- Dump completed on 2018-12-18 18:13:35
