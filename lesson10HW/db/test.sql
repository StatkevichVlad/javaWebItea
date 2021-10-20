-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2021 at 07:57 PM
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
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Plan'),
(2, 'Meal'),
(3, 'Online');

-- --------------------------------------------------------

--
-- Table structure for table `product2category`
--

CREATE TABLE `product2category` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product2category`
--

INSERT INTO `product2category` (`id`, `product_id`, `category_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(4, 4, 2),
(5, 5, 2),
(6, 6, 2),
(7, 7, 3),
(8, 8, 3),
(9, 9, 3);

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `price`) VALUES
(1, '1 week training plan.', 'Online training program for 1 week.', 500),
(2, '4 week training plan.', 'Online training program for 4 week.', 1200),
(3, '12 week training plan.', 'Online training program for 12 week.', 3500),
(4, '1 week meal plan', '1 week meal program according to your wishes. Gaining muscle mass. Losing weight.', 600),
(5, '4 week meal plan', '4 week meal program according to your wishes. Gaining muscle mass. Losing weight.', 2000),
(6, '12 week meal plan', '12 week meal program according to your wishes. Gaining muscle mass. Losing weight.', 4800),
(7, '1 online personal workout', 'Personal zoom training. Which will help you achieve your goal. Gaining muscle mass, losing body weight.', 500),
(8, '5 online personal workout', 'Personal zoom training package. Which will help you achieve your goal. Gaining muscle mass, losing body weight.', 2250),
(9, '10 online personal workout', 'Personal zoom training package. Which will help you achieve your goal. Gaining muscle mass, losing body weight.', 4000);

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
(16, 'SERVLET Test2', 'servlet2@gmail.com', 'f7cc395484dd9df22c535c490843d50dc43884f896a82a1b5bc1eb1c71b95ae4', 'M', 'DNR', 'pass Qwerty123$\r\n'),
(17, '    Max', 'asdasd@com.com', 'f7cc395484dd9df22c535c490843d50dc43884f896a82a1b5bc1eb1c71b95ae4', 'M', 'Crimea', 'Qwerty123$'),
(18, '  Roman', 'roman@romsn.com', 'f7cc395484dd9df22c535c490843d50dc43884f896a82a1b5bc1eb1c71b95ae4', 'M', 'Crimea', 'Qwerty123$'),
(19, 'BroswerTest11.10', 'BroswerTest11.10@mail.ru', 'f7cc395484dd9df22c535c490843d50dc43884f896a82a1b5bc1eb1c71b95ae4', 'M', 'DNR', 'Qwerty123$'),
(20, ' 123', '123@qq.com', 'f7cc395484dd9df22c535c490843d50dc43884f896a82a1b5bc1eb1c71b95ae4', 'M', 'DNR', 'Qwerty123$'),
(21, ' Vera vera', 'vera@google.com.ua', 'f7cc395484dd9df22c535c490843d50dc43884f896a82a1b5bc1eb1c71b95ae4', 'F', 'DNR', 'Qwerty123$'),
(22, '   Vitalina', 'vitalina@com.ua', 'b482ac20646aea511c836a040e6089dcd8f7de38460d376bb0c0cb32bc9bad73', 'F', 'Crimea', 'Privet');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product2category`
--
ALTER TABLE `product2category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product2category`
--
ALTER TABLE `product2category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product2category`
--
ALTER TABLE `product2category`
  ADD CONSTRAINT `product2category_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `product2category_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
