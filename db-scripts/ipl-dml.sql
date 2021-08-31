-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: IPL
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

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
-- Dumping data for table `dt_award`
--

LOCK TABLES `dt_award` WRITE;
/*!40000 ALTER TABLE `dt_award` DISABLE KEYS */;
INSERT INTO `dt_award` VALUES (1,'Man Of The Match',1,1),(2,'Super Striker',5,1),(3,'Man Of The Match',3,2),(4,'Super Striker',3,2),(5,'Man Of The Match',1,3),(6,'Super Striker',1,3),(7,'Man Of The Match',5,4),(8,'Super Striker',5,4),(9,'HighestWicketTaker',2,1);
/*!40000 ALTER TABLE `dt_award` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dt_match`
--

LOCK TABLES `dt_match` WRITE;
/*!40000 ALTER TABLE `dt_match` DISABLE KEYS */;
INSERT INTO `dt_match` VALUES (1,1,'Mumbai','2012-04-04',333,1),(2,2,'Banglore','2012-05-04',402,1),(3,3,'Chennai','2012-06-04',375,1),(4,4,'Kolkata','2012-07-04',318,1),(5,NULL,'Kolkata','2021-04-16',NULL,1);
/*!40000 ALTER TABLE `dt_match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dt_player`
--

LOCK TABLES `dt_player` WRITE;
/*!40000 ALTER TABLE `dt_player` DISABLE KEYS */;
INSERT INTO `dt_player` VALUES (1,'Dhoni',32,'Batsman'),(2,'Ashwin',28,'Bowler'),(3,'Kohli',27,'Batsman'),(4,'starc',31,'Bowler'),(5,'Rohit',27,'Batsman'),(6,'Bumrah',25,'Bowler'),(7,'Gambhir',33,'Batsman'),(8,'Morkel',33,'Bowler'),(9,'Raina',30,'Batsman');
/*!40000 ALTER TABLE `dt_player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dt_season`
--

LOCK TABLES `dt_season` WRITE;
/*!40000 ALTER TABLE `dt_season` DISABLE KEYS */;
INSERT INTO `dt_season` VALUES (1,'DLF IPL','2012-04-04','2012-05-26',2019),(2,'VIVO IPL','2013-04-15','2013-05-30',2020),(3,'season4',NULL,NULL,2022);
/*!40000 ALTER TABLE `dt_season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dt_team`
--

LOCK TABLES `dt_team` WRITE;
/*!40000 ALTER TABLE `dt_team` DISABLE KEYS */;
INSERT INTO `dt_team` VALUES (1,'CSK','CC',1),(2,'MI','AA',2),(3,'RCB','MM',3),(4,'KKR','JJ',4),(9,'RR','SS',5),(11,'SRH','HH',6);
/*!40000 ALTER TABLE `dt_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lt_played_matches`
--

LOCK TABLES `lt_played_matches` WRITE;
/*!40000 ALTER TABLE `lt_played_matches` DISABLE KEYS */;
INSERT INTO `lt_played_matches` VALUES (1,1,2,'Result',1,166,165),(2,3,4,'Result',3,202,200),(3,1,3,'Result',1,205,170),(4,2,4,'Result',2,160,158);
/*!40000 ALTER TABLE `lt_played_matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lt_player_match`
--

LOCK TABLES `lt_player_match` WRITE;
/*!40000 ALTER TABLE `lt_player_match` DISABLE KEYS */;
INSERT INTO `lt_player_match` VALUES (1,1,53,140,0,2,0),(1,3,56,146.5,0,2,1),(2,1,12,121.8,3,1,1),(2,3,0,0,2,0,0),(3,2,104,145.5,0,1,1),(3,3,43,135,0,0,0),(4,2,0,0,3,0,0),(4,3,0,0,2,0,0),(5,1,45,150,0,0,1),(5,4,62,160.5,0,0,0),(6,1,0,0,2,0,0),(6,4,0,0,3,0,0),(7,2,40,130,0,0,0),(7,4,45,135,0,0,0),(8,2,0,0,1,0,0),(8,4,0,0,2,0,0);
/*!40000 ALTER TABLE `lt_player_match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lt_player_season`
--

LOCK TABLES `lt_player_season` WRITE;
/*!40000 ALTER TABLE `lt_player_season` DISABLE KEYS */;
INSERT INTO `lt_player_season` VALUES (1,1,450,0,11,140.56),(1,2,400,0,12,138.56),(3,1,600,0,6,144.56),(3,2,550,0,10,142.56);
/*!40000 ALTER TABLE `lt_player_season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lt_player_team`
--

LOCK TABLES `lt_player_team` WRITE;
/*!40000 ALTER TABLE `lt_player_team` DISABLE KEYS */;
INSERT INTO `lt_player_team` VALUES (1,1,14,1),(2,1,13,1),(3,3,14,1),(4,3,10,1),(5,2,14,1),(6,2,14,1),(7,4,14,1),(8,4,14,1);
/*!40000 ALTER TABLE `lt_player_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lt_team_Season`
--

LOCK TABLES `lt_team_Season` WRITE;
/*!40000 ALTER TABLE `lt_team_Season` DISABLE KEYS */;
INSERT INTO `lt_team_Season` VALUES (1,1,'Champion',1,2,1),(2,1,'Second',5,6,5),(3,1,'Fourth',3,4,3),(4,1,'Sixth',7,8,7);
/*!40000 ALTER TABLE `lt_team_Season` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `lt_team_matches`
--

LOCK TABLES `lt_team_matches` WRITE;
/*!40000 ALTER TABLE `lt_team_matches` DISABLE KEYS */;
INSERT INTO `lt_team_matches` VALUES (1,1,1,2,'Result',1,166,165),(2,2,3,4,'Result',1,202,200),(3,3,1,3,'Result',1,205,170),(4,4,2,4,'Result',2,160,158);
/*!40000 ALTER TABLE `lt_team_matches` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-26 19:01:20
