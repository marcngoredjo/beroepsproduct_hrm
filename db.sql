CREATE DATABASE  IF NOT EXISTS `beroepsproduct` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `beroepsproduct`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: beroepsproduct
-- ------------------------------------------------------
-- Server version	5.7.24

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
-- Table structure for table `afdeling`
--

DROP TABLE IF EXISTS `afdeling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `afdeling` (
  `afdeling_id` int(11) NOT NULL AUTO_INCREMENT,
  `afdelingnaam` varchar(20) NOT NULL,
  `locatie` varchar(30) NOT NULL,
  PRIMARY KEY (`afdeling_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afdeling`
--

LOCK TABLES `afdeling` WRITE;
/*!40000 ALTER TABLE `afdeling` DISABLE KEYS */;
INSERT INTO `afdeling` VALUES (1,'ICT','Hofstraat 12'),(2,'accounting','office management'),(4,'office management','saramaccastraat 18');
/*!40000 ALTER TABLE `afdeling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `functie`
--

DROP TABLE IF EXISTS `functie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `functie` (
  `functie_id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(40) NOT NULL,
  `salaris` float NOT NULL,
  PRIMARY KEY (`functie_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `functie`
--

LOCK TABLES `functie` WRITE;
/*!40000 ALTER TABLE `functie` DISABLE KEYS */;
INSERT INTO `functie` VALUES (1,'administratieve medewerker',2500),(2,'human resource officer',3000);
/*!40000 ALTER TABLE `functie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `werknemer`
--

DROP TABLE IF EXISTS `werknemer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `werknemer` (
  `werknemer_id` int(11) NOT NULL AUTO_INCREMENT,
  `personeelsnr` int(11) NOT NULL,
  `voornaam` varchar(20) NOT NULL,
  `familienaam` varchar(20) NOT NULL,
  `geboortedatum` date NOT NULL,
  `address` varchar(20) NOT NULL,
  `telefoonnummer` int(11) NOT NULL,
  `geslacht` varchar(10) NOT NULL,
  `startdatum` date NOT NULL,
  `functie_id` int(11) NOT NULL,
  `afdeling_id` int(11) NOT NULL,
  PRIMARY KEY (`werknemer_id`),
  KEY `functie_id` (`functie_id`),
  KEY `afdeling_id` (`afdeling_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `werknemer`
--

LOCK TABLES `werknemer` WRITE;
/*!40000 ALTER TABLE `werknemer` DISABLE KEYS */;
INSERT INTO `werknemer` VALUES (1,14184,'marc','ngoredjo','1997-09-09','nejalweg 28',8894187,'man','2019-06-06',1,1),(4,6,'timothy','pocorni','1996-05-05','awarrastraat 15',8862034,'man','2019-07-02',1,2);
/*!40000 ALTER TABLE `werknemer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-19 14:36:13
