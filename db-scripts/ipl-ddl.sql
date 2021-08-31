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
-- Table structure for table `dt_award`
--

DROP TABLE IF EXISTS `dt_award`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dt_award` (
  `awardId` int NOT NULL AUTO_INCREMENT,
  `awardName` varchar(25) DEFAULT NULL,
  `winnerID` int DEFAULT NULL,
  `matchId` int DEFAULT NULL,
  PRIMARY KEY (`awardId`),
  KEY `winnerID` (`winnerID`),
  KEY `matchId` (`matchId`),
  CONSTRAINT `dt_award_ibfk_1` FOREIGN KEY (`winnerID`) REFERENCES `dt_player` (`playerID`) ON DELETE SET NULL,
  CONSTRAINT `dt_award_ibfk_2` FOREIGN KEY (`matchId`) REFERENCES `dt_match` (`matchID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dt_match`
--

DROP TABLE IF EXISTS `dt_match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dt_match` (
  `matchID` int NOT NULL AUTO_INCREMENT,
  `matchNo` int DEFAULT NULL,
  `venue` varchar(20) DEFAULT NULL,
  `mDate` date DEFAULT NULL,
  `total_runs` int DEFAULT NULL,
  `seasonID` int DEFAULT NULL,
  PRIMARY KEY (`matchID`),
  KEY `seasonID` (`seasonID`),
  CONSTRAINT `dt_match_ibfk_1` FOREIGN KEY (`seasonID`) REFERENCES `dt_season` (`seasonID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dt_player`
--

DROP TABLE IF EXISTS `dt_player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dt_player` (
  `playerID` int NOT NULL AUTO_INCREMENT,
  `pName` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `pType` enum('Batsman','Bowler','All-Rounder') DEFAULT NULL,
  PRIMARY KEY (`playerID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dt_season`
--

DROP TABLE IF EXISTS `dt_season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dt_season` (
  `seasonID` int NOT NULL AUTO_INCREMENT,
  `sName` varchar(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `ent_date` date DEFAULT NULL,
  `seasonNo` int DEFAULT NULL,
  PRIMARY KEY (`seasonID`),
  UNIQUE KEY `sName` (`sName`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dt_team`
--

DROP TABLE IF EXISTS `dt_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dt_team` (
  `teamID` int NOT NULL AUTO_INCREMENT,
  `teamName` varchar(20) DEFAULT NULL,
  `ownerName` varchar(20) DEFAULT NULL,
  `team_no` int DEFAULT NULL,
  PRIMARY KEY (`teamID`),
  UNIQUE KEY `teamName` (`teamName`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lt_played_matches`
--

DROP TABLE IF EXISTS `lt_played_matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lt_played_matches` (
  `matchID` int NOT NULL,
  `team1ID` int NOT NULL,
  `team2ID` int NOT NULL,
  `matchStatus` enum('Result','Abondend','Draw') DEFAULT NULL,
  `winnerID` int DEFAULT NULL,
  `team1_score` int DEFAULT NULL,
  `team2_score` int DEFAULT NULL,
  PRIMARY KEY (`matchID`,`team1ID`,`team2ID`),
  UNIQUE KEY `matchID` (`matchID`),
  KEY `team1ID` (`team1ID`),
  KEY `team2ID` (`team2ID`),
  KEY `wonBy` (`winnerID`),
  CONSTRAINT `lt_played_matches_ibfk_1` FOREIGN KEY (`matchID`) REFERENCES `dt_match` (`matchID`) ON DELETE CASCADE,
  CONSTRAINT `lt_played_matches_ibfk_2` FOREIGN KEY (`team1ID`) REFERENCES `dt_team` (`teamID`) ON DELETE CASCADE,
  CONSTRAINT `lt_played_matches_ibfk_3` FOREIGN KEY (`team2ID`) REFERENCES `dt_team` (`teamID`) ON DELETE CASCADE,
  CONSTRAINT `lt_played_matches_ibfk_4` FOREIGN KEY (`winnerID`) REFERENCES `dt_team` (`teamID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lt_player_match`
--

DROP TABLE IF EXISTS `lt_player_match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lt_player_match` (
  `playerID` int NOT NULL,
  `matchID` int NOT NULL,
  `runScored` int DEFAULT NULL,
  `strikeRate` float DEFAULT NULL,
  `wicketsTaken` int DEFAULT NULL,
  `catchesTaken` int DEFAULT NULL,
  `runOuts` int DEFAULT NULL,
  PRIMARY KEY (`playerID`,`matchID`),
  KEY `matchID` (`matchID`),
  CONSTRAINT `lt_player_match_ibfk_1` FOREIGN KEY (`playerID`) REFERENCES `dt_player` (`playerID`) ON DELETE CASCADE,
  CONSTRAINT `lt_player_match_ibfk_2` FOREIGN KEY (`matchID`) REFERENCES `dt_match` (`matchID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lt_player_season`
--

DROP TABLE IF EXISTS `lt_player_season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lt_player_season` (
  `playerID` int NOT NULL,
  `seasonID` int NOT NULL,
  `total_runs` int DEFAULT NULL,
  `total_wickets` int DEFAULT NULL,
  `total_catches` int DEFAULT NULL,
  `strike_rate` float DEFAULT NULL,
  PRIMARY KEY (`playerID`,`seasonID`),
  KEY `seasonID` (`seasonID`),
  CONSTRAINT `lt_player_season_ibfk_1` FOREIGN KEY (`playerID`) REFERENCES `dt_player` (`playerID`) ON DELETE CASCADE,
  CONSTRAINT `lt_player_season_ibfk_2` FOREIGN KEY (`seasonID`) REFERENCES `dt_season` (`seasonID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lt_player_team`
--

DROP TABLE IF EXISTS `lt_player_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lt_player_team` (
  `playerID` int NOT NULL,
  `teamID` int NOT NULL,
  `noOfmatches` int DEFAULT NULL,
  `seasonID` int DEFAULT NULL,
  PRIMARY KEY (`playerID`,`teamID`),
  KEY `teamID` (`teamID`),
  KEY `seasonID` (`seasonID`),
  CONSTRAINT `lt_player_team_ibfk_1` FOREIGN KEY (`playerID`) REFERENCES `dt_player` (`playerID`) ON DELETE CASCADE,
  CONSTRAINT `lt_player_team_ibfk_2` FOREIGN KEY (`teamID`) REFERENCES `dt_team` (`teamID`) ON DELETE CASCADE,
  CONSTRAINT `lt_player_team_ibfk_3` FOREIGN KEY (`seasonID`) REFERENCES `dt_season` (`seasonID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lt_team_Season`
--

DROP TABLE IF EXISTS `lt_team_Season`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lt_team_Season` (
  `teamID` int NOT NULL,
  `seasonID` int NOT NULL,
  `tRank` varchar(20) DEFAULT NULL,
  `highestRunsScorer` int DEFAULT NULL,
  `highestWicketTaker` int DEFAULT NULL,
  `captainID` int DEFAULT NULL,
  PRIMARY KEY (`teamID`,`seasonID`),
  KEY `seasonID` (`seasonID`),
  KEY `captainID` (`captainID`),
  CONSTRAINT `lt_team_Season_ibfk_1` FOREIGN KEY (`teamID`) REFERENCES `dt_team` (`teamID`) ON DELETE CASCADE,
  CONSTRAINT `lt_team_Season_ibfk_2` FOREIGN KEY (`seasonID`) REFERENCES `dt_season` (`seasonID`) ON DELETE CASCADE,
  CONSTRAINT `lt_team_Season_ibfk_3` FOREIGN KEY (`captainID`) REFERENCES `dt_player` (`playerID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lt_team_matches`
--

DROP TABLE IF EXISTS `lt_team_matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lt_team_matches` (
  `team_match_id` int NOT NULL AUTO_INCREMENT,
  `matchID` int DEFAULT NULL,
  `team1ID` int DEFAULT NULL,
  `team2ID` int DEFAULT NULL,
  `match_status` varchar(50) DEFAULT NULL,
  `winner_id` int DEFAULT NULL,
  `team1_score` int DEFAULT NULL,
  `team2_score` int DEFAULT NULL,
  PRIMARY KEY (`team_match_id`),
  KEY `matchID` (`matchID`),
  KEY `team1ID` (`team1ID`),
  KEY `team2ID` (`team2ID`),
  KEY `winner_id` (`winner_id`),
  CONSTRAINT `lt_team_matches_ibfk_1` FOREIGN KEY (`matchID`) REFERENCES `dt_match` (`matchID`) ON DELETE CASCADE,
  CONSTRAINT `lt_team_matches_ibfk_2` FOREIGN KEY (`team1ID`) REFERENCES `dt_team` (`teamID`) ON DELETE CASCADE,
  CONSTRAINT `lt_team_matches_ibfk_3` FOREIGN KEY (`team2ID`) REFERENCES `dt_team` (`teamID`) ON DELETE CASCADE,
  CONSTRAINT `lt_team_matches_ibfk_4` FOREIGN KEY (`winner_id`) REFERENCES `dt_team` (`teamID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-27 18:44:20
