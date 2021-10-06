-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 06, 2021 at 02:16 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

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
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `region` varchar(30) NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `login`, `password`, `gender`, `region`, `comment`) VALUES
(5, 'firsttest@mail.ru', 'firsttest@mail.ru', 'Qwerty123$', '', '', ''),
(6, 'adminvlad@gmail.com', 'adminvlad@gmail.com', 'Qwerty123$', '', '', ''),
(7, '  Stat Vladkevich', 'statvladkevich@gmail.com', 'Qwerty123$', 'M', 'DNR', 'Hello'),
(8, 'ivan', 'ivan@gurak.com', 'c2fc6c6adf8ba0f575a35f48df52c0968a3dcd3c577c2769dc2f1035943b975e', 'M', 'DNR', 'bla-bla'),
(9, 'Vasya', 'vasya@google.com', 'c2fc6c6adf8ba0f575a35f48df52c0968a3dcd3c577c2769dc2f1035943b975e', 'M', 'DNR', 'bla-bla'),
(10, '   Ivan Ivanov', 'admin@gmail.com', '227224f75d3b20bc465100d16cb99ce5ce84bd8a481a9f0150635c202d1f6526', 'M', 'Crimea', 'Qwerty12345!'),
(11, 'Vasya', 'vasya@google.com', 'c2fc6c6adf8ba0f575a35f48df52c0968a3dcd3c577c2769dc2f1035943b975e', 'M', 'DNR', 'bla-bla'),
(12, 'Anton', 'toha@google.com', 'c2fc6c6adf8ba0f575a35f48df52c0968a3dcd3c577c2769dc2f1035943b975e', 'M', 'DNR', 'bla-bla'),
(13, 'TestFromBrowser', 'test1@test.com', 'f7cc395484dd9df22c535c490843d50dc43884f896a82a1b5bc1eb1c71b95ae4', 'M', 'DNR', 'please work'),
(14, 'administrator1', 'admin', 'c2fc6c6adf8ba0f575a35f48df52c0968a3dcd3c577c2769dc2f1035943b975e', 'M', 'DNR', 'login admin, password 123'),
(15, '  ServletTest', 'servlet@jsp.com', 'f7cc395484dd9df22c535c490843d50dc43884f896a82a1b5bc1eb1c71b95ae4', 'M', 'DNR', 'password Qwerty123$'),
(16, 'SERVLET Test2', 'servlet2@gmail.com', 'f7cc395484dd9df22c535c490843d50dc43884f896a82a1b5bc1eb1c71b95ae4', 'M', 'DNR', 'pass Qwerty123$\r\n');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
