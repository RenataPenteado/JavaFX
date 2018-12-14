-- MySQL dump 10.16  Distrib 10.1.32-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: fake_hotel_db
-- ------------------------------------------------------
-- Server version	10.1.32-MariaDB

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
-- Current Database: `fake_hotel_db`
--

/*!40000 DROP DATABASE IF EXISTS `fake_hotel_db`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `fake_hotel_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `fake_hotel_db`;

--
-- Table structure for table `costumer`
--

DROP TABLE IF EXISTS `costumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costumer` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `email` varchar(20) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `phone` int(10) NOT NULL,
  `numOfPeople` varchar(10) COLLATE utf8_bin NOT NULL,
  `paymentType` varchar(10) COLLATE utf8_bin NOT NULL,
  `duration` varchar(10) COLLATE utf8_bin NOT NULL,
  `roomType` varchar(10) COLLATE utf8_bin NOT NULL,
  `roomNumber` varchar(10) COLLATE utf8_bin NOT NULL,
  `startDate` varchar(10) COLLATE utf8_bin NOT NULL,
  `endDate` varchar(10) COLLATE utf8_bin NOT NULL,
  `price` varchar(10) COLLATE utf8_bin NOT NULL,
  `services` varchar(10) COLLATE utf8_bin NOT NULL,
  `total` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costumer`
--

LOCK TABLES `costumer` WRITE;
/*!40000 ALTER TABLE `costumer` DISABLE KEYS */;
INSERT INTO `costumer` VALUES (1,'Samuel Peter','sam@gmail.com','Spain',2293775,'2','5','2','A*','45','01/02/2018','03/02/2018','150','30','180'),(2,'John','john@gmail.com','London',2336655,'2','5','4','A*','23','03/02/2018','07/02/2018','200','20','220');
/*!40000 ALTER TABLE `costumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roomType` varchar(5) COLLATE utf8_bin NOT NULL,
  `roomNumber` varchar(5) COLLATE utf8_bin NOT NULL,
  `numberOfPeople` varchar(5) COLLATE utf8_bin NOT NULL,
  `numberOfFloor` varchar(15) COLLATE utf8_bin NOT NULL,
  `roomPhone` varchar(10) COLLATE utf8_bin NOT NULL,
  `roomPrice` varchar(10) COLLATE utf8_bin NOT NULL,
  `roomStatus` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'A*','23','2','4','02365','120 $','available'),(2,'A','3','2','6','02357','100 $','available'),(3,'B','25','2','12','023697','90 $','busy'),(4,'B*','3','3','9','023876','100 $','available'),(5,'A','2','1','3','023658','130 $','busy');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(15) COLLATE utf8_bin NOT NULL,
  `fullname` varchar(50) COLLATE utf8_bin NOT NULL,
  `address` varchar(50) COLLATE utf8_bin NOT NULL,
  `phone` varchar(15) COLLATE utf8_bin NOT NULL,
  `startDate` varchar(20) COLLATE utf8_bin NOT NULL,
  `salary` varchar(10) COLLATE utf8_bin NOT NULL,
  `userType` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Kit','12345','Kit Harington','spain, Barcelona','02306745','25/01/2017','3000 $','normal'),(2,'samual','12345','samual john','London','02237689','12/03/2016','4000 $','admin'),(3,'james','12345','james john','paris','9374034','24/12/2017','2000 $','normal'),(4,'peter','12345','peter samual ','india','34083645','24/03/2016','3000 $','normal'),(5,'mohamed','12345','mohamed ali','egypt, cairo','0482776498','30/01/2018','3000 $','normal'),(6,'Renata','54321','Renata Penteado','21 Riversdale Upper Dargle Road','0899861725','10/10/2018','2000','admin'),(7,'Mauricio','54321','Mauricio Giacomini','21 Riversdale Upper Dargle Road','0899836473','01/01/2018','5000','normal');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-14 22:23:33
