-- MySQL dump 10.13  Distrib 5.5.28, for Win64 (x86)
--
-- Host: localhost    Database: salesinformation
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `producttable`
--

DROP TABLE IF EXISTS `producttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producttable` (
  `product_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producttable`
--

LOCK TABLES `producttable` WRITE;
/*!40000 ALTER TABLE `producttable` DISABLE KEYS */;
INSERT INTO `producttable` VALUES (1,'Product1'),(2,'Product2'),(3,'Product3'),(4,'Product4'),(5,'Product5'),(6,'Product6'),(7,'Product7'),(8,'Product8'),(9,'Product9'),(10,'Product10');
/*!40000 ALTER TABLE `producttable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesentry`
--

DROP TABLE IF EXISTS `salesentry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salesentry` (
  `sales_id` int(10) unsigned NOT NULL DEFAULT '0',
  `product_Id` int(10) unsigned NOT NULL DEFAULT '0',
  `date_of_sale` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `totals_sale` double DEFAULT NULL,
  `totals_amount` double DEFAULT NULL,
  PRIMARY KEY (`sales_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesentry`
--

LOCK TABLES `salesentry` WRITE;
/*!40000 ALTER TABLE `salesentry` DISABLE KEYS */;
INSERT INTO `salesentry` VALUES (1,1,'2015-10-31 18:30:01',20,345),(2,1,'2015-11-30 18:30:01',34,700),(3,2,'2015-10-31 18:30:01',12,24),(4,3,'2015-10-31 18:30:01',23,34),(5,3,'2015-11-30 18:30:01',45,87),(6,4,'2015-10-31 18:30:01',12,400),(7,5,'2015-10-31 18:30:01',12,456),(8,6,'2015-10-31 18:30:01',12,333),(9,7,'2015-10-31 18:30:01',12,342),(10,8,'2015-10-31 18:30:01',123,44456),(11,9,'2015-10-31 18:30:01',233,4432),(12,10,'2015-10-31 18:30:01',333,4444);
/*!40000 ALTER TABLE `salesentry` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-02 15:29:50
