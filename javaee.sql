-- MySQL dump 10.11
--
-- Host: localhost    Database: javaee
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(3) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `type` varchar(10) default NULL,
  `bal` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'aa','sav',1500),(2,'bb','sav',2500),(3,'2','ed',45);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_accounts`
--

DROP TABLE IF EXISTS `bank_accounts`;
CREATE TABLE `bank_accounts` (
  `ac_no` int(3) NOT NULL auto_increment,
  `id` int(3) default NULL,
  `type` varchar(10) default NULL,
  `bal` double(6,1) default NULL,
  PRIMARY KEY  (`ac_no`),
  KEY `fk_users` (`id`),
  CONSTRAINT `fk_users` FOREIGN KEY (`id`) REFERENCES `bank_users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=793 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_accounts`
--

LOCK TABLES `bank_accounts` WRITE;
/*!40000 ALTER TABLE `bank_accounts` DISABLE KEYS */;
INSERT INTO `bank_accounts` VALUES (101,1,'NRO',1000.0),(102,1,'NRE',2000.0),(103,2,'SAV',3000.0),(123,159,'sb',1500.0),(190,145,'loan',1500.0),(790,980,'bb',1500.0),(791,981,'nfsk',677.0),(792,982,'nfsk',677.0);
/*!40000 ALTER TABLE `bank_accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_users`
--

DROP TABLE IF EXISTS `bank_users`;
CREATE TABLE `bank_users` (
  `id` int(3) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=983 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank_users`
--

LOCK TABLES `bank_users` WRITE;
/*!40000 ALTER TABLE `bank_users` DISABLE KEYS */;
INSERT INTO `bank_users` VALUES (1,'a','b'),(2,'c','d'),(3,'e','f'),(145,'abc','123'),(159,'ARUNENDRA KUMAR','1234'),(980,'abfc','988'),(981,'ARUNENDRA KUMAR1','123'),(982,'ARUNENDRA KUMAR2','45678');
/*!40000 ALTER TABLE `bank_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billing`
--

DROP TABLE IF EXISTS `billing`;
CREATE TABLE `billing` (
  `mob_no` varchar(20) NOT NULL,
  `name` varchar(10) default NULL,
  `plan` varchar(10) default NULL,
  `call_duration` int(11) default NULL,
  `total_bill` double(6,1) default NULL,
  PRIMARY KEY  (`mob_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` VALUES ('12344','bb','plan-B',150,70.0),('12345','aa','plan-A',100,50.0),('12346','cc','plan-A',80,40.0),('12347','dd','plan-C',180,240.0);
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dac_customers`
--

DROP TABLE IF EXISTS `dac_customers`;
CREATE TABLE `dac_customers` (
  `id` int(11) NOT NULL auto_increment,
  `req_amt` double default NULL,
  `email` varchar(20) default NULL,
  `name` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `reg_date` date default NULL,
  `role` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_22017yy3bta9vrmm28cwxyr53` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dac_customers`
--

LOCK TABLES `dac_customers` WRITE;
/*!40000 ALTER TABLE `dac_customers` DISABLE KEYS */;
INSERT INTO `dac_customers` VALUES (1,12,'name','mail','123','2019-02-02','dev'),(2,12,'name1','mail','123','2019-02-02','dev');
/*!40000 ALTER TABLE `dac_customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmc_books`
--

DROP TABLE IF EXISTS `dmc_books`;
CREATE TABLE `dmc_books` (
  `id` int(5) NOT NULL auto_increment,
  `title` varchar(20) default NULL,
  `author` varchar(20) default NULL,
  `category` varchar(20) default NULL,
  `price` double(6,1) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dmc_books`
--

LOCK TABLES `dmc_books` WRITE;
/*!40000 ALTER TABLE `dmc_books` DISABLE KEYS */;
INSERT INTO `dmc_books` VALUES (1,'bk1','abc','java_se',500.0),(2,'bk2','abc','java_se',300.0),(3,'bk3','abc1','java_ee',600.0),(4,'bk4','abc1','java_ee',450.0),(5,'bk5','abc','angular',550.0),(6,'bk6','abc','angular',650.0);
/*!40000 ALTER TABLE `dmc_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dmc_users`
--

DROP TABLE IF EXISTS `dmc_users`;
CREATE TABLE `dmc_users` (
  `id` int(5) NOT NULL auto_increment,
  `email` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `reg_amt` double(6,1) default NULL,
  `reg_date` date default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dmc_users`
--

LOCK TABLES `dmc_users` WRITE;
/*!40000 ALTER TABLE `dmc_users` DISABLE KEYS */;
INSERT INTO `dmc_users` VALUES (1,'rama@gmail','ram#123',5000.0,'2017-01-01'),(2,'meera@gmail','mer#123',600.0,'2017-09-21');
/*!40000 ALTER TABLE `dmc_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(3) NOT NULL auto_increment,
  `dscr` varchar(30) default NULL,
  `price` double(6,1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'Core Java Books',500.0),(2,'Java EE Books',600.0);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_customers`
--

DROP TABLE IF EXISTS `my_customers`;
CREATE TABLE `my_customers` (
  `id` int(5) NOT NULL auto_increment,
  `deposit_amt` double(6,1) default NULL,
  `email` varchar(20) default NULL,
  `name` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `reg_date` date default NULL,
  `role` varchar(10) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_customers`
--

LOCK TABLES `my_customers` WRITE;
/*!40000 ALTER TABLE `my_customers` DISABLE KEYS */;
INSERT INTO `my_customers` VALUES (1,1500.0,'rama@gmail','rama','1234','2017-01-23','admin'),(2,1200.0,'kir@gmail','Kiran','123','2018-05-29','customer'),(3,1800.0,'shek@gmail','Shekhar','1235','2016-03-04','customer');
/*!40000 ALTER TABLE `my_customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_emp`
--

DROP TABLE IF EXISTS `my_emp`;
CREATE TABLE `my_emp` (
  `empid` int(3) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `addr` varchar(20) default NULL,
  `salary` double(8,2) default NULL,
  `deptid` varchar(10) default NULL,
  `join_date` date default NULL,
  PRIMARY KEY  (`empid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `my_emp`
--

LOCK TABLES `my_emp` WRITE;
/*!40000 ALTER TABLE `my_emp` DISABLE KEYS */;
INSERT INTO `my_emp` VALUES (1,'aa','pune',1500.00,'rnd','2011-11-18'),(2,'ab','chennai',2500.00,'prod','2015-01-20'),(3,'cc','mumbai',3500.00,'rnd','2014-11-18'),(4,'dd','delhi',3000.00,'prod','2017-01-20');
/*!40000 ALTER TABLE `my_emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_info`
--

DROP TABLE IF EXISTS `stock_info`;
CREATE TABLE `stock_info` (
  `id` int(3) NOT NULL,
  `name` varchar(20) default NULL,
  `dscr` varchar(30) default NULL,
  `price` double(6,1) default NULL,
  `quantity` int(5) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_info`
--

LOCK TABLES `stock_info` WRITE;
/*!40000 ALTER TABLE `stock_info` DISABLE KEYS */;
INSERT INTO `stock_info` VALUES (1,'tata','low-risk,medium-gain',100.0,150),(2,'tcs','medium-risk,medium-gain',150.0,250),(3,'reliance','high-risk,high-gain',200.0,300);
/*!40000 ALTER TABLE `stock_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_users`
--

DROP TABLE IF EXISTS `stock_users`;
CREATE TABLE `stock_users` (
  `id` int(3) NOT NULL,
  `pin` int(6) default NULL,
  `name` varchar(20) default NULL,
  `bal` double(6,1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock_users`
--

LOCK TABLES `stock_users` WRITE;
/*!40000 ALTER TABLE `stock_users` DISABLE KEYS */;
INSERT INTO `stock_users` VALUES (101,1234,'aa',1000.0),(102,1235,'ab',2000.0),(103,1236,'ac',3000.0);
/*!40000 ALTER TABLE `stock_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendors`
--

DROP TABLE IF EXISTS `vendors`;
CREATE TABLE `vendors` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `cell_no` varchar(12) default NULL,
  `reg_amount` decimal(8,2) default NULL,
  `reg_date` date default NULL,
  `role` varchar(10) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `cell_no` (`cell_no`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vendors`
--

LOCK TABLES `vendors` WRITE;
/*!40000 ALTER TABLE `vendors` DISABLE KEYS */;
INSERT INTO `vendors` VALUES (1,'Art Venere','rama@gmail','1234','Bridgeport','8566368749','1700.42','2017-05-01','full stack'),(2,'Lenna Paprocki','lpaprocki@hotmail.com','12345','Anchorage','9073854412','1800.19','2019-02-04','mean stack'),(3,'Kris Marrier','kris@gmail.com','12345','Baltimore','4106558723','2398.83','2019-02-10','big data'),(4,'Minna Amigon','minna_amigon@yahoo.com','12345','Kulpsville','2158741229','2498.60','2017-02-08','python'),(5,'Meaghan Garufi','meaghan@hotmail.com','12345','Mc Minnville','9313139635','3097.23','2016-03-05','python'),(6,'Yuki Whobrey','yuki_whobrey@aol.com','12345','Taylor','3132887937','3296.77','2017-02-01','full stack'),(9,'ARUNENDRA KUMAR','ra@gmail','1234','Other City','0983 8180','0.00',NULL,'n n');
/*!40000 ALTER TABLE `vendors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-12 14:47:57
