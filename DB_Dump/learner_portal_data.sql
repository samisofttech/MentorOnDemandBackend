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

-- Dumping data for table learner_portal.mentor: ~1 rows (approximately)
/*!40000 ALTER TABLE `mentor` DISABLE KEYS */;
INSERT INTO `mentor` (`mentor_id`, `active`, `end_time`, `fee`, `linkedin`, `rating`, `start_time`, `trainings_delivered`, `username`, `years_exp`) VALUES
	(1, b'0', 2019, 250, 'linkedin@test.com', 0, 2010, 0, 'test12323232', 10);
/*!40000 ALTER TABLE `mentor` ENABLE KEYS */;

-- Dumping data for table learner_portal.mentor_cal: ~1 rows (approximately)
/*!40000 ALTER TABLE `mentor_cal` DISABLE KEYS */;
INSERT INTO `mentor_cal` (`id`, `end_date`, `mid`, `start_date`) VALUES
	(1, '2019-06-23 17:57:26', 1, '2019-06-23 17:57:26');
/*!40000 ALTER TABLE `mentor_cal` ENABLE KEYS */;

-- Dumping data for table learner_portal.mentor_skill: ~2 rows (approximately)
/*!40000 ALTER TABLE `mentor_skill` DISABLE KEYS */;
INSERT INTO `mentor_skill` (`id`, `facilities_offered`, `mid`, `self_rating`, `sid`, `trainings_delivered`, `years_of_exp`) VALUES
	(1, 'Nothing', 1, '5 star', 1, 'string', 20),
	(2, 'Nothing', 1, '5 star', 1, '2', 10);
/*!40000 ALTER TABLE `mentor_skill` ENABLE KEYS */;

-- Dumping data for table learner_portal.mentor_skills: 3 rows
/*!40000 ALTER TABLE `mentor_skills` DISABLE KEYS */;
INSERT INTO `mentor_skills` (`mentor_id`, `skill_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3);
/*!40000 ALTER TABLE `mentor_skills` ENABLE KEYS */;

-- Dumping data for table learner_portal.roles: ~3 rows (approximately)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(3, 'ROLE_ADMIN'),
	(2, 'ROLE_MENTOR'),
	(1, 'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Dumping data for table learner_portal.skills: ~4 rows (approximately)
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` (`id`, `duration`, `prerequites`, `price`, `skillname`) VALUES
	(1, NULL, NULL, 0, 'Java'),
	(2, NULL, NULL, 0, 'Spring'),
	(3, NULL, NULL, 0, 'Boot'),
	(4, '6', 'testing', 100, 'Automation_Testing');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;

-- Dumping data for table learner_portal.trainings: 0 rows
/*!40000 ALTER TABLE `trainings` DISABLE KEYS */;
/*!40000 ALTER TABLE `trainings` ENABLE KEYS */;

-- Dumping data for table learner_portal.users: 2 rows
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `active`, `confirm_code`, `email`, `name`, `password`, `username`) VALUES
	(1, b'1', '336MWL', 'linkedin@test.com', 'sami', '$2a$10$Hkd2nOlCszEVi7IDo6w9weTB1iLmyHkIaOh7N5GwjNdH2DcCPXQ3i', 'test12323232'),
	(2, b'1', 'Z80AV6', 'sami_softtech@gmail.com', 'sami', '$2a$10$w6z35utJTcXXQTZ7hqSVkOAKBlzOk1bawACfIN8an.JNwEwBEg/9W', 'sami');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping data for table learner_portal.user_roles: 2 rows
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
	(1, 2),
	(2, 3);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
