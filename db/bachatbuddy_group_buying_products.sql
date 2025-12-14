-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bachatbuddy
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `group_buying_products`
--

DROP TABLE IF EXISTS `group_buying_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_buying_products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `current_joined` int NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `expires_at` datetime(6) DEFAULT NULL,
  `group_price` double NOT NULL,
  `is_active` bit(1) NOT NULL,
  `original_price` double NOT NULL,
  `product_image` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) NOT NULL,
  `total_needed` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_buying_products`
--

LOCK TABLES `group_buying_products` WRITE;
/*!40000 ALTER TABLE `group_buying_products` DISABLE KEYS */;
INSERT INTO `group_buying_products` VALUES (1,'Electronics','2025-11-25 08:59:55.000000',8,'Premium wireless earbuds with noise cancellation',NULL,1000,_binary '',1099,'assets/bluetooth-earbuds.jpg','Bluetooth Earbuds',10),(2,'Groceries','2025-11-25 08:59:55.000000',9,'High quality basmati rice',NULL,225,_binary '',450,'assets/premium-rice.jpg','5kg Premium Rice',10),(3,'Appliances','2025-11-25 08:59:55.000000',7,'Powerful mixer grinder with 3 jars',NULL,1300,_binary '',2399,'assets/mixer-grinder.jpg','500W Mixer Grinder',10),(4,'Groceries','2025-11-25 08:59:55.000000',8,'Healthy cooking oil pack',NULL,160,_binary '',320,'assets/sunflower-oil.jpg','1L Sunflower Oil (Pack of 3)',10),(5,'Fashion','2025-11-25 08:59:55.000000',7,'Comfortable casual sneakers',NULL,500,_binary '',2500,'assets/sneakers.jpg','Casual Sneakers (Men)',10),(6,'Fashion','2025-11-25 08:59:55.000000',7,'Premium cotton t-shirt combo',NULL,400,_binary '',1750,'assets/tshirt.jpg','Cotton T-shirt (Combo of 3)',10),(7,'Electronics','2025-11-25 09:00:16.000000',8,'Fitness tracking smart watch',NULL,2500,_binary '',3999,'assets/smartwatch.jpg','Smart Watch',15),(8,'Groceries','2025-11-25 09:00:16.000000',13,'Fresh wheat flour',NULL,300,_binary '',500,'assets/wheat-flour.jpg','10kg Wheat Flour',20),(9,'Home & Living','2025-11-25 09:00:16.000000',3,'Adjustable LED desk lamp',NULL,700,_binary '',1200,'assets/desk-lamp.jpg','LED Desk Lamp',8),(10,'Sports','2025-11-25 09:00:16.000000',5,'Non-slip yoga mat with carry bag',NULL,450,_binary '',800,'assets/yoga-mat.jpg','Yoga Mat',12);
/*!40000 ALTER TABLE `group_buying_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-14 19:13:17
