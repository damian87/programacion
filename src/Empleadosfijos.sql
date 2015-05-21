CREATE DATABASE  IF NOT EXISTS `efbbdd` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `efbbdd`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: efbbdd
-- ------------------------------------------------------
-- Server version	5.6.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empleadofijo`
--

DROP TABLE IF EXISTS `empleadofijo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleadofijo` (
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `departamento` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fechaNacimiento` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `suelo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `dni` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `login` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `avatar` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `estado` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `antiguedad` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fechaContratacion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadofijo`
--

LOCK TABLES `empleadofijo` WRITE;
/*!40000 ALTER TABLE `empleadofijo` DISABLE KEYS */;
INSERT INTO `empleadofijo` VALUES ('ddddddddd',26,'oooooooo','6/5/1989','12890.0','02254525L','dddd','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com','','User','0','5','6/5/2010'),('vicente',34,'programacion','12/5/1980','12534.0','13258356Y','vicente','81dc9bdb52d04dc20036dbd8313ed055','vicentevalles@gmail.com','','User','0','3','23/5/2011'),('toni',32,'oficinas','24/11/1982','0.0','15949501J','toni','81dc9bdb52d04dc20036dbd8313ed055','tutramite.internet@gmail.com','','User','0','2','14/5/2012'),('meritxell',22,'informatica','24/4/1993','12178.0','20416724W','meritxell','81dc9bdb52d04dc20036dbd8313ed055','meritxellordoñez@gmail.com','','user','0','1','7/4/2014'),('Borja',21,'Oficina','10/2/1994','0.0','48102369l','borja','81dc9bdb52d04dc20036dbd8313ed055','borja@gmail.com','','User','0','11','15/9/2003'),('Miguel',21,'Informatica','15/9/1993','13424.0','48502123a','miguel','81dc9bdb52d04dc20036dbd8313ed055','miguelgandia@gmail.com','','User','0','8','12/10/2006'),('Raul',26,'Mantenimiento','12/3/1989','12712.0','48520147d','raul','81dc9bdb52d04dc20036dbd8313ed055','raulcolomer@gmail.com','','User','0','4','22/8/2010'),('Damian',27,'Informatica','29/8/1987','12178.0','48600102k','damian','81dc9bdb52d04dc20036dbd8313ed055','damiandonat@gmail.com','','admin','0','1','25/1/2014'),('ddddd',32,'ooooo','2/5/1983','12356.0','65081534K','ddddd','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com','','User','0','2','21/5/2012'),('david',25,'informatica','19/5/1989','12178.0','77033499J','david','81dc9bdb52d04dc20036dbd8313ed055','davidgonzalez@gmail.com','','User','0','1','5/5/2014'),('adrian',24,'oficinas','16/5/1990','12178.0','87483277V','adrian','81dc9bdb52d04dc20036dbd8313ed055','adrianpuerto@gmail.com','','User','0','1','5/5/2014'),('jjjjjjjj',31,'aaaaaaaa','27/6/1983','12356.0','90880699V','jjjj','81dc9bdb52d04dc20036dbd8313ed055','tutramite.internet@gmail.com','','User','0','2','29/5/2012'),('carlos',29,'oficinas','9/5/1986','12356.0','91401506N','carlos','81dc9bdb52d04dc20036dbd8313ed055','tutramite.internet@gmail.com','','User','0','2','21/5/2012');
/*!40000 ALTER TABLE `empleadofijo` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_historialEFcrea` AFTER INSERT ON `empleadofijo` FOR EACH
ROW BEGIN
insert into historial_creaEF(fecha_creacion, Nombre, Dni, Depeartamento, email )
values( Now(), new.Nombre, new.Dni, new.Departamento, new.email);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_historialEFmodifica` AFTER UPDATE ON `empleadofijo` FOR EACH
ROW BEGIN
insert into historial_modificaEF(fecha_creacion, NombreNuevo, NombreViejo, Dni, DepartamentoNuevo, DepartamentoViejo, emailNuevo, emailViejo)
values( Now(), new.Nombre, old.Nombre, new.Dni, new.Departamento, old.Departamento, new.email, old.email);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_historialEFelimina` AFTER DELETE ON `empleadofijo` FOR EACH
ROW BEGIN
insert into historial_eliminaEF(fecha_creacion, Nombre, Dni, Departamento, email )
values( Now(), old.Nombre, old.Dni, old.Departamento, old.email);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `historial_creaef`
--

DROP TABLE IF EXISTS `historial_creaef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_creaef` (
  `fecha_creacion` datetime NOT NULL,
  `Nombre` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Dni` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Depeartamento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_creaef`
--

LOCK TABLES `historial_creaef` WRITE;
/*!40000 ALTER TABLE `historial_creaef` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_creaef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_eliminaef`
--

DROP TABLE IF EXISTS `historial_eliminaef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_eliminaef` (
  `fecha_creacion` datetime NOT NULL,
  `Nombre` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Dni` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Departamento` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_eliminaef`
--

LOCK TABLES `historial_eliminaef` WRITE;
/*!40000 ALTER TABLE `historial_eliminaef` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_eliminaef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_modificaef`
--

DROP TABLE IF EXISTS `historial_modificaef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_modificaef` (
  `fecha_creacion` datetime NOT NULL,
  `NombreNuevo` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NombreViejo` varchar(40) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Dni` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DepartamentoNuevo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DepartamentoViejo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `emailNuevo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `emailViejo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_modificaef`
--

LOCK TABLES `historial_modificaef` WRITE;
/*!40000 ALTER TABLE `historial_modificaef` DISABLE KEYS */;
INSERT INTO `historial_modificaef` VALUES ('2015-05-11 12:28:49','toni','toni','15949501J','oficinas','oficinas','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-05-11 12:29:47','Borja','Borjas','48102369l','Oficina','Oficina','borja@gmail.com','borja@gmail.com'),('2015-05-11 12:35:10','toni','toni','15949501J','oficinas','oficinas','tutramite.internet@gmail.com','tutramite.internet@gmail.com');
/*!40000 ALTER TABLE `historial_modificaef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'efbbdd'
--

--
-- Dumping routines for database 'efbbdd'
--
/*!50003 DROP PROCEDURE IF EXISTS `mayormenor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mayormenor`(OUT `empleadoEFjoven` INT, OUT `EmpleadoEFmayor` INT)
begin
SELECT MIN(edad),MAX(edad) into empleadoEFjoven, EmpleadoEFmayor FROM empleadofijo ORDER BY edad;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mediaedad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mediaedad`(OUT `edadmedia` DOUBLE)
begin
SELECT ROUND(AVG(edad)) into edadmedia FROM efbbdd.empleadofijo;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-14 15:41:22
