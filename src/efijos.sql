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
INSERT INTO `empleadofijo` VALUES ('jjjjj',27,'hhhh','10/6/1987','12356.0','00530767L','jjjj','81dc9bdb52d04dc20036dbd8313ed055','jjjj@qqqq.com','src/imagenes/avatarsBURT7.jpg','User','0','2','4/6/2012'),('rrrrrrrr',34,'cccccccccc','4/5/1981','13068.0','01629378N','rrrr','81dc9bdb52d04dc20036dbd8313ed055','tutramite.internet@gmail.com','','User','0','6','11/5/2009'),('ddddddddd',26,'oooooooo','6/5/1989','12890.0','02254525L','dddd','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com','','User','0','5','6/5/2010'),('prueba',29,'prue','6/6/1985','12712.0','10880399L','prueba','81dc9bdb52d04dc20036dbd8313ed055','prueba@prue','src/imagenes/avatarsQCGS9.jpg','admin','0','4','1/6/2011'),('toni',32,'oficinas','24/11/1982','0.0','15949501J','toni','81dc9bdb52d04dc20036dbd8313ed055','tutramite.internet@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','2','14/5/2012'),('eeee',29,'iiiiii','3/6/1985','12000.0','17905835J','eeee','81dc9bdb52d04dc20036dbd8313ed055','eee@iii.com','src/imagenes/avatars/default-avatar.jpg','User','0','0','9/6/2014'),('meritxell',22,'informatica','24/4/1993','12178.0','20416724W','meritxell','81dc9bdb52d04dc20036dbd8313ed055','meritxellordoñez@gmail.com','src/imagenes/avatars/default-avatar.jpg','user','0','1','7/4/2014'),('pppp',31,'oooo','1/6/1984','12356.0','21793636D','ppp','81dc9bdb52d04dc20036dbd8313ed055','pppp@ooo.com','','User','0','2','8/6/2012'),('laura',32,'informatica','2/6/1983','12534.0','39857864Z','laura','81dc9bdb52d04dc20036dbd8313ed055','laura@gmail.com','src/imagenes/avatarsOF1TW.jpg','admin','0','3','1/6/2012'),('lllllllll',34,'mmmmmmmm','1/5/1981','13068.0','46441719G','llll','81dc9bdb52d04dc20036dbd8313ed055','tutramite.internet@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','6','7/5/2009'),('Borja',21,'Oficina','10/2/1994','0.0','48102369l','borja','81dc9bdb52d04dc20036dbd8313ed055','borja@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','11','15/9/2003'),('Miguel',21,'Informatica','15/9/1993','13424.0','48502123a','miguel','81dc9bdb52d04dc20036dbd8313ed055','miguelgandia@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','8','12/10/2006'),('Raul',26,'Mantenimiento','12/3/1989','12712.0','48520147d','raul','81dc9bdb52d04dc20036dbd8313ed055','raulcolomer@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','4','22/8/2010'),('damian',27,'informatica','29/8/1987','13068.0','48600102K','damian','81dc9bdb52d04dc20036dbd8313ed055','tutramite.internet@gmail.com','src/imagenes/avatars0FVG6.jpg','admin','0','6','4/6/2008'),('eeee',35,'tttt','1/5/1980','0.0','58359073T','eeee','81dc9bdb52d04dc20036dbd8313ed055','tutramite.internet@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','1','7/5/2014'),('ddddd',32,'ooooo','2/5/1983','12356.0','65081534K','ddddd','81dc9bdb52d04dc20036dbd8313ed055','rcolomer3@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','2','21/5/2012'),('qqqqqqq',31,'aaaaaaaa','1/6/1984','12712.0','76095171Q','qqqq','81dc9bdb52d04dc20036dbd8313ed055','qqqq@aaaa.com','src/imagenes/avatars/default-avatar.jpg','','0','4','2/6/2010'),('david',25,'informatica','19/5/1989','0.0','77033499J','david','81dc9bdb52d04dc20036dbd8313ed055','davidgonzalez@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','1','5/5/2014'),('adrian',24,'oficinas','16/5/1990','12178.0','87483277V','adrian','81dc9bdb52d04dc20036dbd8313ed055','adrianpuerto@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','1','5/5/2014'),('carlos',29,'oficinas','9/5/1986','12356.0','91401506N','carlos','81dc9bdb52d04dc20036dbd8313ed055','tutramite.internet@gmail.com','src/imagenes/avatars/default-avatar.jpg','User','0','2','21/5/2012');
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
INSERT INTO `historial_creaef` VALUES ('2015-05-16 01:10:22','eeee','58359073T','tttt','tutramite.internet@gmail.com'),('2015-05-16 01:34:13','ppppppp','10581351V','qqqqqqqq','tutramite.internet@gmail.com'),('2015-05-29 02:53:25','lllllllll','46441719G','mmmmmmmm','tutramite.internet@gmail.com'),('2015-05-29 02:57:07','rrrrrrrr','01629378N','cccccccccc','tutramite.internet@gmail.com'),('2015-06-01 09:39:08','qqqqqqq','76095171Q','aaaaaaaa','qqqq@aaaa.com'),('2015-06-01 09:52:08','eeee','17905835J','iiiiii','eee@iii.com'),('2015-06-02 10:59:53','pppp','21793636D','oooo','pppp@ooo.com'),('2015-06-02 11:04:04','www','49257941Z','rrr','www@rrr.com'),('2015-06-02 11:37:44','laura','70096646Y','informatica','laura@infor.com'),('2015-06-03 11:40:58','jjjjj','00530767L','qqqq','jjjj@qqqq.com'),('2015-06-03 11:59:11','damian','48600102K','informatica','tutramite.internet@gmail.com'),('2015-06-03 12:01:43','damian','48600102K','informatica','titramite.internet@gamil.com'),('2015-06-03 12:08:48','damian','48600102K','informatica','tutramite.internet@gmail.com'),('2015-06-03 12:12:38','laura','39857864Z','informatica','laura@gmail.com'),('2015-06-03 12:18:32','prueba','45467019K','pru','prueba@pru.com'),('2015-06-03 12:38:30','prueba','10880399L','prue','prueba@prue');
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
INSERT INTO `historial_eliminaef` VALUES ('2015-06-01 10:19:11','jjjjjjjj','90880699V','aaaaaaaa','tutramite.internet@gmail.com'),('2015-06-02 11:04:54','www','49257941Z','rrr','www@rrr.com'),('2015-06-03 11:53:28','Damian','48600102k','Informatica','damiandonat@gmail.com'),('2015-06-03 11:59:45','damian','48600102K','informatica','tutramite.internet@gmail.com'),('2015-06-03 12:05:01','damian','48600102K','informatica','titramite.internet@gamil.com'),('2015-06-03 12:09:55','laura','70096646Y','infor','laura@infor.com'),('2015-06-03 12:12:53','vicente','13258356Y','programacion','vicentevalles@gmail.com'),('2015-06-03 12:16:06','pppp','10581351V','qqqqqqqq','tutramite.internet@gmail.com'),('2015-06-03 12:19:23','prueba','45467019K','pru','prueba@pru.com');
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
INSERT INTO `historial_modificaef` VALUES ('2015-05-11 12:28:49','toni','toni','15949501J','oficinas','oficinas','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-05-11 12:29:47','Borja','Borjas','48102369l','Oficina','Oficina','borja@gmail.com','borja@gmail.com'),('2015-05-11 12:35:10','toni','toni','15949501J','oficinas','oficinas','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-05-16 01:20:38','eeee','eeee','58359073T','tttt','tttt','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-05-16 01:21:36','eeee','eeee','58359073T','tttt','tttt','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-05-16 01:27:13','david','david','77033499J','informatica','informatica','davidgonzalez@gmail.com','davidgonzalez@gmail.com'),('2015-05-16 01:27:31','david','david','77033499J','informatica','informatica','davidgonzalez@gmail.com','davidgonzalez@gmail.com'),('2015-05-16 02:21:58','ppp','ppppppp','10581351V','qqqqqqqq','qqqqqqqq','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-05-16 02:30:27','ppp','ppp','10581351V','qqqqqqqq','qqqqqqqq','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-05-16 02:30:33','pppp','ppp','10581351V','qqqqqqqq','qqqqqqqq','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-06-01 09:53:41','lllllllll','lllllllll','46441719G','mmmmmmmm','mmmmmmmm','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-06-01 09:53:41','eeee','eeee','58359073T','tttt','tttt','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-06-01 10:26:38','toni','toni','15949501J','oficinas','oficinas','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-06-01 10:26:38','eeee','eeee','17905835J','iiiiii','iiiiii','eee@iii.com','eee@iii.com'),('2015-06-01 10:26:38','meritxell','meritxell','20416724W','informatica','informatica','meritxellordoñez@gmail.com','meritxellordoñez@gmail.com'),('2015-06-01 10:26:38','lllllllll','lllllllll','46441719G','mmmmmmmm','mmmmmmmm','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-06-01 10:26:38','Borja','Borja','48102369l','Oficina','Oficina','borja@gmail.com','borja@gmail.com'),('2015-06-01 10:26:38','Miguel','Miguel','48502123a','Informatica','Informatica','miguelgandia@gmail.com','miguelgandia@gmail.com'),('2015-06-01 10:26:38','Raul','Raul','48520147d','Mantenimiento','Mantenimiento','raulcolomer@gmail.com','raulcolomer@gmail.com'),('2015-06-01 10:26:38','Damian','Damian','48600102k','Informatica','Informatica','damiandonat@gmail.com','damiandonat@gmail.com'),('2015-06-01 10:26:38','eeee','eeee','58359073T','tttt','tttt','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-06-01 10:26:38','ddddd','ddddd','65081534K','ooooo','ooooo','rcolomer3@gmail.com','rcolomer3@gmail.com'),('2015-06-01 10:26:38','qqqqqqq','qqqqqqq','76095171Q','aaaaaaaa','aaaaaaaa','qqqq@aaaa.com','qqqq@aaaa.com'),('2015-06-01 10:26:38','david','david','77033499J','informatica','informatica','davidgonzalez@gmail.com','davidgonzalez@gmail.com'),('2015-06-01 10:26:38','adrian','adrian','87483277V','oficinas','oficinas','adrianpuerto@gmail.com','adrianpuerto@gmail.com'),('2015-06-01 10:26:38','carlos','carlos','91401506N','oficinas','oficinas','tutramite.internet@gmail.com','tutramite.internet@gmail.com'),('2015-06-02 11:58:04','laura','laura','70096646Y','informatica','informatica','laura@infor.com','laura@infor.com'),('2015-06-02 11:59:46','laura','laura','70096646Y','informatica','informatica','laura@infor.com','laura@infor.com'),('2015-06-02 12:10:22','laura','laura','70096646Y','informatica','informatica','laura@infor.com','laura@infor.com'),('2015-06-02 12:10:52','laura','laura','70096646Y','inform','informatica','laura@infor.com','laura@infor.com'),('2015-06-02 12:14:09','laura','laura','70096646Y','informatica','inform','laura@infor.com','laura@infor.com'),('2015-06-02 12:25:39','laura','laura','70096646Y','infor','informatica','laura@infor.com','laura@infor.com'),('2015-06-02 12:26:42','laura','laura','70096646Y','informatica','infor','laura@infor.com','laura@infor.com'),('2015-06-03 11:43:48','jjjjj','jjjjj','00530767L','hhhh','qqqq','jjjj@qqqq.com','jjjj@qqqq.com'),('2015-06-03 11:48:13','laura','laura','70096646Y','infor','informatica','laura@infor.com','laura@infor.com'),('2015-06-03 11:57:46','laura','laura','70096646Y','infor','infor','laura@infor.com','laura@infor.com'),('2015-06-03 13:24:17','jjjjj','jjjjj','00530767L','hhhh','hhhh','jjjj@qqqq.com','jjjj@qqqq.com'),('2015-06-03 13:48:34','jjjjj','jjjjj','00530767L','hhhh','hhhh','jjjj@qqqq.com','jjjj@qqqq.com'),('2015-06-03 14:00:41','jjjjj','jjjjj','00530767L','hhhh','hhhh','jjjj@qqqq.com','jjjj@qqqq.com'),('2015-06-03 14:02:08','jjjjj','jjjjj','00530767L','hhhh','hhhh','jjjj@qqqq.com','jjjj@qqqq.com');
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

-- Dump completed on 2015-06-03 17:51:30
