-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 10, 2016 at 11:00 PM
-- Server version: 5.6.28-0ubuntu0.15.10.1
-- PHP Version: 5.6.11-1ubuntu3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Order`
--

-- --------------------------------------------------------

--
-- Table structure for table `OrderDetails`
--

CREATE TABLE IF NOT EXISTS `OrderDetails` (
  `id` int(11) NOT NULL,
  `cusName` varchar(50) NOT NULL,
  `itemCode` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` float NOT NULL,
  `tp` char(10) NOT NULL,
  `orderDate` date DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `OrderDetails`
--

INSERT INTO `OrderDetails` (`id`, `cusName`, `itemCode`, `quantity`, `amount`, `tp`, `orderDate`) VALUES
(4, 'sanda', 'aa123', 4, 2800, '097543333', '2017-09-08'),
(5, 'ishan', 'bb1101', 2, 250, '0712345678', '2016-04-04'),
(10, 'bimali', 'aaa-123', 2, 20, '0987654321', '2015-09-09'),
(11, 'ish', 'abc-123', 12, 20000, '0987654321', '2016-02-03'),
(12, 'adsdd', 'AQW-122', 4, 800, '0987654321', '2016-02-09'),
(13, 'asb', 'asb-182', 3, 239, '0987654321', '1200-02-02'),
(14, 'asd', 'asd-123', 4, 5, '0987654321', '2030-09-09'),
(15, 'kamal', 'xyz-987', 4, 890, '0987654321', '2016-12-09'),
(16, 'aaa', 'aaa-123', 5, 2300, '0987654321', '2016-01-01');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `OrderDetails`
--
ALTER TABLE `OrderDetails`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `OrderDetails`
--
ALTER TABLE `OrderDetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
