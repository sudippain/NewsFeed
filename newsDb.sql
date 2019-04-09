CREATE DATABASE  IF NOT EXISTS `newsproject` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `newsproject`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: newsproject
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `u_id` int(11) NOT NULL,
  `u_role` varchar(255) DEFAULT NULL,
  `u_contact_number` varchar(10) DEFAULT NULL,
  `u_email` varchar(255) DEFAULT NULL,
  `u_name` varchar(20) DEFAULT NULL,
  `u_password` varchar(255) DEFAULT NULL,
  `u_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES (1,'ROLE_USER','7896523611','sobhon@gmail.com','Sudip','$2a$10$PXNfDjcUcv26l5QCB.JnIeCJORZYWaGZdXh8xE355mPRZY3w1kwnm',''),(2,'ROLE_USER','8016969280','sudip@gmail.com','sudip pain','$2a$10$MuZDDVCXMuUV8M8OI94gJOJqI2hdxtczofs0E0M6gyIGWAL.L4Uvi',''),(3,'ROLE_USER','7748965213','vikram@gmail.com','Vikram Das','$2a$10$yc6tm1CHDJX9s4bT3tLWV.F8hr4TZbKVgR.cxdrg.5Zv5AQrugNmC',''),(6,'ROLE_USER','9865741235','dalal@gmail.com','Sourav Ghosh','$2a$10$.IdAKL0dCIRQG5Vm/5Yt5.ajFPQo.q9GUA7gsRTtPtHQ.kKQ0gUSm',''),(7,'ROLE_ADMIN','7852146398','admin@gmail.com','Admin','$2a$10$ICKJ/sQD98CDLO4KqYQxA.d1.ZlXVQ9wnDQh88H4NmqeJ6L13kb8.',''),(12,'ROLE_USER','4126106511','eex@gmail.com','ddd  w e e','$2a$10$DwI/AjhBnpBHcs1ZnwqOy.kbbO8Yq/k1Bs/A7VOFyW0EphCznjaau',''),(13,'ROLE_USER','4578963121','bhanu@gmail.com','bhanu','$2a$10$he6Y4CzMXiwbq8NXRgQ8COQExoSi109ZCvTdCBP42LOI1x84oIYi.',''),(14,'ROLE_USER','7894561230','ankljdfxxyu@gmail.com','saswata','$2a$10$ZVpkUDa.dK2iW/MWxZPWZOzqg4lsBK5kFbj3aCCE/5bW2HaXNEZ2S',''),(15,'ROLE_USER','7894561230','ankljdfu@gmail.com','saswata','$2a$10$rqKdS9wXZ.No.eAt0XHQLOUBsTNge.UKwbXfebChTMPBtWtY9QciO',''),(16,'ROLE_USER','7894561230','anklfu@gmail.com','saswata','$2a$10$tRm2LPgNNbylOZIAqLuTheTd.KWkXZsjTrn3uiiC4BjQQL5frY4IG',''),(17,'ROLE_USER','7894561230','ank27@gmail.com','saswata','$2a$10$LfAiYetKtqhm5xtyXdSUwuTJx3aeA494U3E2GjsFhL1mHZvY0ubgK',''),(18,'ROLE_USER','7894561230','Subscriber24@gmail.com','saswata','$2a$10$sW8KQni7T9Mx9zNoQsgjgeb77QaIAUa8uvjLTBWk2Cjb22.drPBKm',''),(19,'ROLE_USER','7894561230','anik@gmail.com','anik','$2a$10$53ZwTchBJHXB968Vdt3gyO3Wz3gNP5e90QWjRIGYuuv/6zP7TnuiG','');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (20),(20);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_search_history`
--

DROP TABLE IF EXISTS `user_search_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_search_history` (
  `user_search_id` int(11) NOT NULL AUTO_INCREMENT,
  `serach_time` datetime DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_news_search` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_search_id`)
) ENGINE=MyISAM AUTO_INCREMENT=83 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_search_history`
--

LOCK TABLES `user_search_history` WRITE;
/*!40000 ALTER TABLE `user_search_history` DISABLE KEYS */;
INSERT INTO `user_search_history` VALUES (12,'2019-02-18 14:20:30','dalal@gmail.com','chennai'),(80,'2019-02-22 16:08:13','sudip@gmail.com','dalal'),(81,'2019-02-22 16:08:27','sudip@gmail.com','gdghdgdygdgdfvghfdghvdfdgbdgdghdvhvdghvdfvdghdgvghdvghdvgvdghvghdv'),(72,'2019-02-22 13:59:25','anik@gmail.com','Avangers'),(13,'2019-02-18 14:20:35','dalal@gmail.com','kolkata'),(14,'2019-02-18 14:20:39','dalal@gmail.com','delhi'),(15,'2019-02-18 14:20:48','dalal@gmail.com','kashmir'),(79,'2019-02-22 16:05:08','anik@gmail.com','Avangers'),(32,'2019-02-20 11:40:11','anik@gmail.com','canada'),(33,'2019-02-20 11:41:20','anik@gmail.com','canada'),(34,'2019-02-20 11:44:15','anik@gmail.com','canada'),(36,'2019-02-20 11:46:44','anik@gmail.com','canada'),(37,'2019-02-20 11:49:02','anik@gmail.com','porkistan'),(38,'2019-02-20 11:49:46','anik@gmail.com','porkistan'),(69,'2019-02-21 14:52:35','anik@gmail.com','modi'),(40,'2019-02-20 11:51:17','anik@gmail.com','porkistan'),(41,'2019-02-20 11:55:42','anik@gmail.com','porkistan'),(42,'2019-02-20 11:55:48','anik@gmail.com','porkistan'),(43,'2019-02-20 11:55:54','anik@gmail.com','modi'),(44,'2019-02-20 11:58:37','anik@gmail.com','porkistan'),(45,'2019-02-20 11:59:16','anik@gmail.com','porkistan'),(47,'2019-02-20 12:19:03','anik@gmail.com','porkistan'),(48,'2019-02-20 12:20:52','anik@gmail.com','canada'),(50,'2019-02-20 12:23:54','anik@gmail.com','porkistan'),(51,'2019-02-20 12:24:42','anik@gmail.com','Canada'),(52,'2019-02-20 12:24:43','anik@gmail.com','Canada'),(53,'2019-02-20 12:24:46','anik@gmail.com','Canada'),(54,'2019-02-20 12:24:48','anik@gmail.com','Canada'),(71,'2019-02-22 13:58:19','anik@gmail.com','Avangers'),(70,'2019-02-21 14:52:43','anik@gmail.com','vdfdgfvghdd'),(73,'2019-02-22 14:03:45','anik@gmail.com','Avangers'),(74,'2019-02-22 14:41:29','anik@gmail.com','Avangers'),(75,'2019-02-22 14:43:01','anik@gmail.com','Avangers'),(76,'2019-02-22 15:02:11','anik@gmail.com','Avangers'),(77,'2019-02-22 15:12:16','anik@gmail.com','Avangers'),(82,'2019-02-22 16:08:50','sudip@gmail.com','world cup in india 2011 final');
/*!40000 ALTER TABLE `user_search_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-22 18:26:12
