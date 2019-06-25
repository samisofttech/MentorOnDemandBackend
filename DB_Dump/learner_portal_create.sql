-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.14-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for learner_portal
CREATE DATABASE IF NOT EXISTS `learner_portal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `learner_portal`;

-- Dumping structure for table learner_portal.mentor
CREATE TABLE IF NOT EXISTS `mentor` (
  `mentor_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `end_time` int(11) NOT NULL,
  `fee` double NOT NULL,
  `linkedin` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL,
  `start_time` int(11) NOT NULL,
  `trainings_delivered` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `years_exp` int(11) NOT NULL,
  PRIMARY KEY (`mentor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table learner_portal.mentor_cal
CREATE TABLE IF NOT EXISTS `mentor_cal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `end_date` datetime DEFAULT NULL,
  `mid` int(11) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table learner_portal.mentor_skill
CREATE TABLE IF NOT EXISTS `mentor_skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facilities_offered` varchar(255) DEFAULT NULL,
  `mid` int(11) NOT NULL,
  `self_rating` varchar(255) DEFAULT NULL,
  `sid` int(11) NOT NULL,
  `trainings_delivered` varchar(255) DEFAULT NULL,
  `years_of_exp` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table learner_portal.mentor_skills
CREATE TABLE IF NOT EXISTS `mentor_skills` (
  `mentor_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`mentor_id`,`skill_id`),
  KEY `FKl5p17tlimfms83r8cqtd94dto` (`skill_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table learner_portal.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nb4h0p6txrmfc0xbrd1kglp9t` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table learner_portal.skills
CREATE TABLE IF NOT EXISTS `skills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `duration` varchar(255) DEFAULT NULL,
  `prerequites` varchar(255) DEFAULT NULL,
  `price` bigint(20) NOT NULL,
  `skillname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table learner_portal.trainings
CREATE TABLE IF NOT EXISTS `trainings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `progress` int(11) NOT NULL,
  `rating` double NOT NULL,
  `status` int(11) DEFAULT NULL,
  `mentor_id` int(11) DEFAULT NULL,
  `skills_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK85bdsm6nrndeyqtghr0sqd8ex` (`mentor_id`),
  KEY `FKa39x6qw1derbe0thmin4r78d7` (`skills_id`),
  KEY `FK32ir33u28fo97252hksjvlubp` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table learner_portal.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `confirm_code` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table learner_portal.user_roles
CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
