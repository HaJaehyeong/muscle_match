-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: MUSCLE_MATCH
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `AREA`
--

DROP TABLE IF EXISTS `AREA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `AREA` (
  `AREA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AREA_NAME` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`AREA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AREA`
--

LOCK TABLES `AREA` WRITE;
/*!40000 ALTER TABLE `AREA` DISABLE KEYS */;
INSERT INTO `AREA` VALUES (1,'SIBUYA'),(2,'SINZUKU');
/*!40000 ALTER TABLE `AREA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JOIN_TRAINING`
--

DROP TABLE IF EXISTS `JOIN_TRAINING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `JOIN_TRAINING` (
  `TRAINING_ID` int(11) NOT NULL,
  `TRAINEE_ID` int(11) NOT NULL,
  `STATE` enum('join','cancel') COLLATE utf8_bin DEFAULT NULL,
  KEY `TRAINING_ID_JT_FK_idx` (`TRAINING_ID`),
  KEY `TRAINEE_ID_JT_FK_idx` (`TRAINEE_ID`),
  CONSTRAINT `TRAINEE_ID_JT_FK` FOREIGN KEY (`TRAINEE_ID`) REFERENCES `trainee` (`TRAINEE_ID`),
  CONSTRAINT `TRAINING_ID_JT_FK` FOREIGN KEY (`TRAINING_ID`) REFERENCES `training` (`TRAINING_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JOIN_TRAINING`
--

LOCK TABLES `JOIN_TRAINING` WRITE;
/*!40000 ALTER TABLE `JOIN_TRAINING` DISABLE KEYS */;
INSERT INTO `JOIN_TRAINING` VALUES (1,2,'join'),(1,3,NULL),(2,4,'join'),(2,1,'join'),(2,3,'join'),(3,3,'join'),(4,3,'join'),(5,3,'join'),(6,3,'join'),(7,3,'join'),(8,3,'join'),(9,3,'join'),(10,1,'join'),(10,3,'join'),(11,4,'join'),(11,2,'join'),(11,1,'join'),(11,3,'join'),(12,2,'join'),(12,3,'join'),(13,3,'join'),(14,3,'join'),(15,3,'join'),(16,3,'join'),(17,3,'join'),(18,3,'join'),(19,3,'join'),(20,1,'join'),(20,3,'join'),(1,4,'join'),(11,1,'join');
/*!40000 ALTER TABLE `JOIN_TRAINING` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MUSCLE_CATEGORY`
--

DROP TABLE IF EXISTS `MUSCLE_CATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `MUSCLE_CATEGORY` (
  `MUSCLE_CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MUSCLE_CATEGORY_NAME` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`MUSCLE_CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MUSCLE_CATEGORY`
--

LOCK TABLES `MUSCLE_CATEGORY` WRITE;
/*!40000 ALTER TABLE `MUSCLE_CATEGORY` DISABLE KEYS */;
INSERT INTO `MUSCLE_CATEGORY` VALUES (1,'KATA'),(2,'MUNE'),(3,'UDE'),(4,'HUKKIN'),(5,'SENAKA'),(6,'KAHANSIN');
/*!40000 ALTER TABLE `MUSCLE_CATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRAINEE`
--

DROP TABLE IF EXISTS `TRAINEE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `TRAINEE` (
  `TRAINEE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TRAINEE_NAME` varchar(55) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`TRAINEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRAINEE`
--

LOCK TABLES `TRAINEE` WRITE;
/*!40000 ALTER TABLE `TRAINEE` DISABLE KEYS */;
INSERT INTO `TRAINEE` VALUES (1,'HAJAE'),(2,'TICH'),(3,'KINSYO'),(4,'TENMA');
/*!40000 ALTER TABLE `TRAINEE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TRAINING`
--

DROP TABLE IF EXISTS `TRAINING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `TRAINING` (
  `TRAINING_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TRAINING_NAME` varchar(30) COLLATE utf8_bin NOT NULL,
  `TRAINEE_ID` int(11) NOT NULL,
  `MUSCLE_CATEGORY_ID` int(11) NOT NULL,
  `AREA_ID` int(11) NOT NULL,
  `DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `TYPE` enum('active','inactive') COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`TRAINING_ID`),
  KEY `MUSCLE_ID_FK_idx` (`MUSCLE_CATEGORY_ID`),
  KEY `AREA_ID_FK_idx` (`AREA_ID`),
  KEY `TRAINEE_ID_TR_FK_idx` (`TRAINEE_ID`),
  CONSTRAINT `AREA_ID_TR_FK` FOREIGN KEY (`AREA_ID`) REFERENCES `area` (`AREA_ID`),
  CONSTRAINT `MUSCLE_ID_TR_FK` FOREIGN KEY (`MUSCLE_CATEGORY_ID`) REFERENCES `muscle_category` (`MUSCLE_CATEGORY_ID`),
  CONSTRAINT `TRAINEE_ID_TR_FK` FOREIGN KEY (`TRAINEE_ID`) REFERENCES `trainee` (`TRAINEE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TRAINING`
--

LOCK TABLES `TRAINING` WRITE;
/*!40000 ALTER TABLE `TRAINING` DISABLE KEYS */;
INSERT INTO `TRAINING` VALUES (1,'キンジの肩トレーニング',3,1,1,'2018-01-01 19:00:00','2017-12-30 12:34:56','inactive'),(2,'キンジの胸トレーニング',3,2,1,'2018-02-01 19:00:00','2017-12-30 12:34:56','inactive'),(3,'キンジの腕トレーニング',3,3,1,'2018-03-01 19:00:00','2018-01-30 12:34:56','inactive'),(4,'キンジの腹筋トレーニング',3,4,1,'2018-04-01 20:00:00','2018-01-30 12:34:56','inactive'),(5,'キンジの背中トレーニング',3,5,1,'2018-05-01 19:00:00','2018-03-30 12:34:56','inactive'),(6,'キンジの下半身トレーニング',3,6,1,'2018-06-01 19:00:00','2018-04-20 12:34:50','inactive'),(7,'キンジの肩トレーニング',3,1,1,'2018-07-01 19:00:00','2018-04-20 12:34:56','inactive'),(8,'キンジの胸トレーニング',3,2,1,'2018-08-01 19:00:00','2018-05-30 12:34:56','inactive'),(9,'キンジの腕トレーニング',3,3,1,'2018-09-01 19:00:00','2018-08-30 12:34:56','inactive'),(10,'キンジの腹筋トレーニング',3,4,1,'2018-10-01 19:00:00','2018-09-30 12:34:50','inactive'),(11,'キンジの背中トレーニング',3,5,1,'2018-11-01 19:00:00','2018-10-19 12:34:56','inactive'),(12,'キンジの下半身トレーニング',3,6,1,'2018-12-01 19:00:00','2018-11-05 08:34:56','inactive'),(13,'キンジの肩トレーニング',3,1,2,'2019-01-01 19:00:00','2018-12-30 11:22:33','inactive'),(14,'キンジの胸トレーニング',3,2,2,'2019-02-01 19:00:00','2019-01-11 12:34:56','inactive'),(15,'キンジの腕トレーニング',3,3,2,'2019-03-01 19:00:00','2019-02-20 12:34:56','inactive'),(16,'キンジの腹筋トレーニング',3,4,2,'2019-04-01 19:00:00','2019-03-10 12:34:56','inactive'),(17,'キンジの背中トレーニング',3,5,2,'2019-05-01 19:00:00','2019-04-30 12:34:56','inactive'),(18,'キンジの下半身トレーニング',3,6,2,'2019-06-01 19:00:00','2019-05-23 00:00:00','active'),(19,'キンジの肩トレーニング',3,1,2,'2019-07-01 19:00:00','2019-05-23 00:00:00','active'),(20,'キンジの胸トレーニング',3,2,2,'2019-08-01 19:00:00','2019-05-23 00:00:00','active');
/*!40000 ALTER TABLE `TRAINING` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-24 15:26:43

