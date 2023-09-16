-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2023 at 02:52 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `full_name`, `password`, `email`, `phone`, `status`) VALUES
(1, 'nguyen phuong cuong', '123456', 'cuong@gmail.com', '123456', 0),
(5, 'nguyen van a', '123456', 'a@gmail.com', '123456', 1),
(6, 'nguyen van b', '123456', 'b@gmail.com', '123456', 1),
(11, 'nguyen van c', '123456', 'c@gmail.com', '0367201132', 1),
(12, 'nguyen van ccccc', '123456', 'cc@gmail.com', '0367201132', 1);

-- --------------------------------------------------------

--
-- Table structure for table `grant_access`
--

CREATE TABLE `grant_access` (
  `account_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `is_grant` int(11) DEFAULT NULL,
  `note` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `grant_access`
--

INSERT INTO `grant_access` (`account_id`, `role_id`, `is_grant`, `note`) VALUES
(1, 1, 1, 'Manager'),
(5, 2, 1, 'Staff'),
(6, 3, 1, 'Customer'),
(11, 3, 1, ''),
(12, 3, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` int(11) NOT NULL,
  `account_login` int(11) DEFAULT NULL,
  `time_login` timestamp NULL DEFAULT NULL,
  `time_logout` timestamp NULL DEFAULT NULL,
  `node` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `account_login`, `time_login`, `time_logout`, `node`) VALUES
(5, 1, '2023-09-15 09:07:04', '2023-09-15 09:07:07', NULL),
(6, 1, '2023-09-15 09:07:19', '2023-09-15 09:07:22', NULL),
(9, 1, '2023-09-15 09:18:44', '2023-09-15 09:18:46', NULL),
(10, 1, '2023-09-15 09:41:36', '2023-09-15 09:41:53', NULL),
(11, 1, '2023-09-15 09:42:05', '2023-09-15 09:42:14', NULL),
(14, 1, '2023-09-15 14:11:18', '2023-09-15 14:11:21', NULL),
(15, 6, '2023-09-15 14:11:27', '2023-09-15 14:11:30', NULL),
(16, 1, '2023-09-15 14:11:35', '2023-09-15 14:11:40', NULL),
(17, 5, '2023-09-15 14:13:08', NULL, NULL),
(18, 1, '2023-09-15 14:13:27', NULL, NULL),
(19, 1, '2023-09-15 14:18:09', '2023-09-15 14:18:12', NULL),
(20, 5, '2023-09-15 14:18:21', '2023-09-15 14:18:38', NULL),
(21, 5, '2023-09-15 14:26:44', '2023-09-15 14:27:17', NULL),
(22, 1, '2023-09-15 14:33:34', NULL, NULL),
(23, 1, '2023-09-15 14:36:59', NULL, NULL),
(24, 1, '2023-09-15 14:39:08', '2023-09-15 14:39:16', NULL),
(25, 5, '2023-09-15 14:39:21', NULL, NULL),
(26, 5, '2023-09-15 14:50:55', NULL, NULL),
(27, 5, '2023-09-15 14:58:15', NULL, NULL),
(28, 5, '2023-09-15 14:59:57', '2023-09-15 15:00:11', NULL),
(29, 1, '2023-09-15 15:00:16', '2023-09-15 15:00:30', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role_name`, `description`, `status`) VALUES
(1, 'Manager', 'Manager', 1),
(2, 'Staff', NULL, 1),
(3, 'Customer', 'Customer', 1),
(4, 'admin1', NULL, -1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `grant_access`
--
ALTER TABLE `grant_access`
  ADD PRIMARY KEY (`account_id`,`role_id`),
  ADD KEY `FK_grant_access_role` (`role_id`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_log_account` (`account_login`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `grant_access`
--
ALTER TABLE `grant_access`
  ADD CONSTRAINT `FK_grant_access_account` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_grant_access_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `log`
--
ALTER TABLE `log`
  ADD CONSTRAINT `FK_log_account` FOREIGN KEY (`account_login`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
