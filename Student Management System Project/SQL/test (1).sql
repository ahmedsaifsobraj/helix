-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2020 at 10:14 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('saif', '12345'),
('zahid', '67890'),
('nrc', '4242'),
('java', 'java');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` varchar(20) NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `section` varchar(10) NOT NULL,
  `list_of_courses` varchar(500) NOT NULL,
  `registration_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `student_name`, `section`, `list_of_courses`, `registration_status`) VALUES
('191-15-12739', 'Ahmed Saif Sobraj', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('191-15-12691', 'Nishat Zaman Zahid', 'O-1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('191-15-12616', 'Tariqul Islam Seyam', 'O-1', 'CSE231,CSE232,CSE2333,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('12121221', 'sddfsdfsdf', 'ss', 'safasdasd', 'Complete'),
('515461541', 'jfnsjd', 'sds', 'dggdgdgd', 'Complete'),
('515461455545', 'jfnkgkkg', 'sds', 'dggdgdgd', 'Complete'),
('22525', 'jfnkgkkggghghh', 'sds', 'dggdgdgd', 'Complete'),
('ghhhghhh', 'hhhh', 'sds', 'dggdgdgd', 'Complete'),
('ghhhghhoo', 'hhhhoo', 'sds', 'dggdgdgd', 'Complete'),
('ghhhh', 'hhhhojjjj', 'ggggg', 'dggdgdgd', 'Complete'),
('ghhppppp', 'hhhhojjjjjjjj', 'ggggg', 'dggdgdgd', 'Complete'),
('ghooooo', 'hhhhojjjjjjjjhhhhhhhhh', 'ggggg', 'dggdgdgd', 'Complete'),
('1', 'a', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('2', 'b', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('3', 'c', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('4', 'd', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('5', 'd', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('6', 'd', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('7', 'e', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('8', 'f', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('9', 'g', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('10', 'h', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('11', 'i', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('12', 'j', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('13', 'k', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('14', 'l', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('15', 'm', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('15', 'n', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('15', 'o', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('166', 'q', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('167', 'r', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('168', 's', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('169', 't', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete'),
('170', 'u', 'O1', 'CSE231,CSE232,CSE233,CSE234,CSE235,CSE236,CSE237', 'Complete');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
