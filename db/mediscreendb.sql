-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mediscreendb
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` date NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'6 rue Leon 93600 Aulnay','1970-05-09','Myriam','Bourgeois','0603367825','F'),(2,'21 rue de Madrid 75008 Paris','1990-03-03','Elsa','Pichereau','01-42548054','F'),(3,'17 Rue Bremontier 75017 Paris','1962-03-12','Lissette','Camacho','07-42548054','F'),(4,'11 Rue Bremontier 75017 Paris','1948-10-17','Michel','Courvoisier','06-42548054','M'),(5,'17 Rue du Docteur Fleming 92600 Asnieres sur seine','1970-06-22','Lucas','Ferguson','06-25361724','M'),(6,'31 Rue Dominique 75007 Paris','1952-09-27','Pippa','Rees','06-77326809','F'),(7,'6 rue lamartine 75009 Paris','1952-11-11','Edward','Arnold','0603367020','M'),(8,'31 rue Dominique 75007 Paris','1946-11-26','Anthony','Sharp','0603367001','M'),(9,'31 rue Dominique 75007 Paris','1958-06-29','Wendy','Ince','0603367002','F'),(10,'31 rue Dominique 75007 Paris','1949-12-07','Tracey','Ross','0603367003','F'),(11,'8 rue Saint Simon 75007 Paris','1966-12-31','Claire','Wilson','06-77326810','F'),(12,'6rue du bac 75007 Paris','1945-06-24','Max','Buckland','06-77325510','M'),(13,'6rue du bac 75007 Paris','1964-06-18','Natalie','Clark','06-77325509','F'),(14,'16 Avenue du Gén De Gaulle 60000 Beauvais','1959-06-28','Piers','Bailey','06-77324010','M'),(15,'3 Avenue du gén Leclerc 13000 Marseille','1973-06-07','Raphael','Dechaunac','06-09284545','M'),(16,'17 rue du bac 75007 Paris','1974-04-12','Latifa','Amzian','06-77325517','F'),(17,'17 rue du bac 75007 Paris','1974-04-10','Vincent','Delaunay','06-77325517','F'),(18,'21 Rue de Madrid 75008 Paris','1992-03-05','Remi','Baudrous','0142548081','M'),(19,'9 rue Blanche 75009 Paris','1988-07-14','Alice','Lebresne','0153423510','F'),(20,'30 Avenue de Clichy 75017 Paris','2008-08-28','Rayane','Sabo','04-94885788','M'),(21,'10 rue de londres 75008 Paris','2010-05-19','Leon','De Bruxelles','01-42548054','M'),(22,'a1','1996-12-31','Paul','Bismut','123','F'),(23,'string','2022-06-03','string','string','string','M');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-09  0:57:00
