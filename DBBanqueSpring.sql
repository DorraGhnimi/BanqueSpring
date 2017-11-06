-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 06, 2017 at 03:42 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DBBanqueSpring`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `code_client` bigint(20) NOT NULL,
  `nom_client` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`code_client`, `nom_client`) VALUES
(1, 'client1'),
(2, 'client1'),
(3, 'client2'),
(4, 'client3');

-- --------------------------------------------------------

--
-- Table structure for table `compte`
--

CREATE TABLE `compte` (
  `type_compte` varchar(2) NOT NULL,
  `code_compte` varchar(255) NOT NULL,
  `date_creation` datetime DEFAULT NULL,
  `solde` double NOT NULL,
  `decouvert` double DEFAULT NULL,
  `taux` double DEFAULT NULL,
  `code_client` bigint(20) DEFAULT NULL,
  `code_employe` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compte`
--

INSERT INTO `compte` (`type_compte`, `code_compte`, `date_creation`, `solde`, `decouvert`, `taux`, `code_client`, `code_employe`) VALUES
('CC', 'CC1', '2017-11-04 14:49:34', 100002, 3000, NULL, NULL, NULL),
('CC', 'CC2', '2017-11-04 14:50:42', 20020, 2000, NULL, NULL, NULL),
('CC', 'CC3', '2017-11-04 14:59:09', 20100, 2010, NULL, 1, NULL),
('CC', 'CC4', '2017-11-04 15:03:24', 99100, 9900, NULL, 1, 2),
('CC', 'CE1', '2017-11-06 15:18:19', 987654, 555, NULL, NULL, NULL),
('CE', 'CE2', '2017-11-04 14:52:43', 17634, NULL, 2000, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `code_employe` bigint(20) NOT NULL,
  `nom_employe` varchar(255) DEFAULT NULL,
  `code_employe_sup` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`code_employe`, `nom_employe`, `code_employe_sup`) VALUES
(1, NULL, NULL),
(2, NULL, NULL),
(3, NULL, NULL),
(4, 'E4', NULL),
(5, 'E5', NULL),
(6, 'E6', NULL),
(7, 'E6', NULL),
(8, 'E8', NULL),
(9, 'E9', 1),
(10, 'E10', 6);

-- --------------------------------------------------------

--
-- Table structure for table `employe_groupe`
--

CREATE TABLE `employe_groupe` (
  `employes_code_employe` bigint(20) NOT NULL,
  `groupes_code_employe` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `groupes`
--

CREATE TABLE `groupes` (
  `code_groupe` bigint(20) NOT NULL,
  `nom_groupe` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `operation`
--

CREATE TABLE `operation` (
  `dtype` varchar(1) NOT NULL,
  `numero_operation` bigint(20) NOT NULL,
  `date_operation` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `code_compte` varchar(255) DEFAULT NULL,
  `code_employe` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `operation`
--

INSERT INTO `operation` (`dtype`, `numero_operation`, `date_operation`, `montant`, `code_compte`, `code_employe`) VALUES
('V', 1, '2017-11-04 16:00:46', 5000, 'CC1', 1),
('V', 2, '2017-11-04 16:08:57', 300, 'CC1', 1),
('R', 3, '2017-11-04 16:09:22', 330, 'CC1', 1),
('R', 4, '2017-11-04 16:09:31', 330, 'CC1', 1),
('R', 5, '2017-11-04 16:09:42', 30, 'CC1', 1),
('R', 6, '2017-11-04 16:09:52', 30, 'CC1', 1),
('R', 7, '2017-11-04 16:10:21', 30, 'CC1', 1),
('V', 8, '2017-11-06 09:12:09', 0, 'CC1', 1),
('V', 9, '2017-11-06 09:13:00', 0, 'CC1', 1),
('V', 10, '2017-11-06 09:19:03', 450, 'CC1', 1),
('R', 11, '2017-11-06 10:01:49', 5000, 'CC1', 1),
('V', 12, '2017-11-06 11:35:24', 100, 'CE2', 1),
('V', 13, '2017-11-06 11:35:29', 100, 'CE2', 1),
('V', 14, '2017-11-06 11:35:30', 100, 'CE2', 1),
('R', 15, '2017-11-06 11:35:37', 500, 'CE2', 1),
('R', 16, '2017-11-06 11:35:38', 500, 'CE2', 1),
('R', 17, '2017-11-06 11:35:38', 500, 'CE2', 1),
('R', 18, '2017-11-06 11:35:38', 500, 'CE2', 1),
('R', 19, '2017-11-06 11:35:38', 500, 'CE2', 1),
('R', 20, '2017-11-06 11:35:39', 500, 'CE2', 1),
('R', 21, '2017-11-06 11:36:13', 500, 'CC1', 1),
('V', 22, '2017-11-06 11:36:37', 333, 'CE2', 1),
('V', 23, '2017-11-06 12:38:19', 500, 'CC1', 1),
('R', 24, '2017-11-06 12:38:40', 10000, 'CC1', 1),
('R', 49, '2017-11-06 12:57:52', 3, 'CC1', 1),
('V', 50, '2017-11-06 12:57:52', 3, 'CC2', 1),
('R', 51, '2017-11-06 13:00:48', 3, 'CC1', 1),
('V', 52, '2017-11-06 13:00:48', 3, 'CC2', 1),
('R', 53, '2017-11-06 13:04:09', 1, 'CC1', 1),
('V', 54, '2017-11-06 13:04:09', 1, 'CC2', 1),
('R', 55, '2017-11-06 13:06:02', 2, 'CC1', 1),
('V', 56, '2017-11-06 13:06:02', 2, 'CC2', 1),
('R', 57, '2017-11-06 13:06:05', 2, 'CC1', 1),
('V', 58, '2017-11-06 13:06:05', 2, 'CC2', 1),
('R', 59, '2017-11-06 13:09:45', 9, 'CC1', 1),
('V', 60, '2017-11-06 13:09:45', 9, 'CC2', 1),
('R', 63, '2017-11-06 13:15:55', 0, 'CC1', 1),
('V', 64, '2017-11-06 13:15:55', 0, 'CE1', 1),
('R', 65, '2017-11-06 13:17:07', 1, 'CC1', 1),
('V', 66, '2017-11-06 13:17:07', 1, 'CE1', 1),
('V', 67, '2017-11-06 13:17:26', 1, 'CE2', 1),
('V', 68, '2017-11-06 14:10:15', 1e18, 'CC1', 1),
('V', 69, '2017-11-06 14:10:36', 1e18, 'CC1', 1),
('R', 70, '2017-11-06 14:10:42', 1e18, 'CC1', 1),
('R', 71, '2017-11-06 14:10:43', 1e18, 'CC1', 1),
('R', 72, '2017-11-06 14:21:24', 99, 'CC1', 1),
('V', 73, '2017-11-06 14:22:47', 1e21, 'CC1', 1),
('R', 74, '2017-11-06 14:22:53', 1e21, 'CC1', 1),
('V', 75, '2017-11-06 14:37:28', 99999, 'CC1', 1),
('V', 76, '2017-11-06 14:38:02', 1, 'CC1', 1),
('R', 77, '2017-11-06 14:38:24', 9, 'CC1', 1),
('V', 78, '2017-11-06 14:45:22', 11, 'CC1', 1),
('V', 79, '2017-11-06 14:47:01', 11, 'CC1', 1),
('R', 80, '2017-11-06 14:47:03', 11, 'CC1', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`code_client`);

--
-- Indexes for table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`code_compte`),
  ADD KEY `FK4j39u1ymy78ien5aes05ut81e` (`code_client`),
  ADD KEY `FK2pii6ilo5b3fysep6j23u93gg` (`code_employe`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`code_employe`),
  ADD KEY `FKj6kkrd927tas3n8mv75tyl64f` (`code_employe_sup`);

--
-- Indexes for table `employe_groupe`
--
ALTER TABLE `employe_groupe`
  ADD KEY `FKgmvknqcc5kde8oentl23n78f3` (`groupes_code_employe`),
  ADD KEY `FK5bibe9m7qedg9rsmx86fqerv` (`employes_code_employe`);

--
-- Indexes for table `groupes`
--
ALTER TABLE `groupes`
  ADD PRIMARY KEY (`code_groupe`);

--
-- Indexes for table `operation`
--
ALTER TABLE `operation`
  ADD PRIMARY KEY (`numero_operation`),
  ADD KEY `FK6x81chpvk8psd9e86steac7jf` (`code_compte`),
  ADD KEY `FK73fjjb7q67hw2vjfommajpfhu` (`code_employe`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `code_client` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `employe`
--
ALTER TABLE `employe`
  MODIFY `code_employe` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `groupes`
--
ALTER TABLE `groupes`
  MODIFY `code_groupe` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `operation`
--
ALTER TABLE `operation`
  MODIFY `numero_operation` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FK2pii6ilo5b3fysep6j23u93gg` FOREIGN KEY (`code_employe`) REFERENCES `employe` (`code_employe`),
  ADD CONSTRAINT `FK4j39u1ymy78ien5aes05ut81e` FOREIGN KEY (`code_client`) REFERENCES `client` (`code_client`);

--
-- Constraints for table `employe`
--
ALTER TABLE `employe`
  ADD CONSTRAINT `FKj6kkrd927tas3n8mv75tyl64f` FOREIGN KEY (`code_employe_sup`) REFERENCES `employe` (`code_employe`);

--
-- Constraints for table `employe_groupe`
--
ALTER TABLE `employe_groupe`
  ADD CONSTRAINT `FK5bibe9m7qedg9rsmx86fqerv` FOREIGN KEY (`employes_code_employe`) REFERENCES `employe` (`code_employe`),
  ADD CONSTRAINT `FKgmvknqcc5kde8oentl23n78f3` FOREIGN KEY (`groupes_code_employe`) REFERENCES `employe` (`code_employe`);

--
-- Constraints for table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `FK6x81chpvk8psd9e86steac7jf` FOREIGN KEY (`code_compte`) REFERENCES `compte` (`code_compte`),
  ADD CONSTRAINT `FK73fjjb7q67hw2vjfommajpfhu` FOREIGN KEY (`code_employe`) REFERENCES `employe` (`code_employe`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
