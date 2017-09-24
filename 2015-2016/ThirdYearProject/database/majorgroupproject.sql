-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Feb 10, 2016 at 04:38 AM
-- Server version: 10.1.9-MariaDB-log
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `majorgroupproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `questionid` int(10) UNSIGNED NOT NULL,
  `name` varchar(1500) NOT NULL,
  `choice1` varchar(1500) NOT NULL,
  `choice2` varchar(1500) NOT NULL,
  `choice3` varchar(1500) NOT NULL,
  `answer` varchar(1500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `questions`
--

TRUNCATE TABLE `questions`;
--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`questionid`, `name`, `choice1`, `choice2`, `choice3`, `answer`) VALUES
(1, 'A _____ is a device that forwards packets between networks by processing the routing information included in the packet.', 'bridge', 'firewall', 'all of the mentioned', 'router'),
(2, 'Network congestion occurs_____', 'when a system terminates', 'when connection between two nodes terminates', 'none of the mentioned', 'in case of traffic overloading'),
(3, 'Communication channel is shared by all the machines on the network in', 'unicast network', 'multicast network', 'none of the mentioned', 'broadcast network'),
(4, 'What are the layers of the OSI Model?', 'Application, Presentation, Transport, Session, Physical, Network.', 'Presentation, Network, Datalink, Transport, Session.', 'Physical, Network, Link-State, Transport, Session, Presentation, Application.', 'Application, Presentation, Session, Transport, Network, Datalink, Physical'),
(5, 'Which statement is true regarding the user exec and privileged exec mode?', 'They both require the enable password ', 'The ''?'' only works in Privileged exec', 'They are identical', 'User exec is a subset of the privileged exec'),
(6, 'Bluetooth is an example of', 'local area network', 'virtual private network', 'none of the mentioned', 'personal area network'),
(7, 'Two devices are in network if____', 'a process is running on both devices', 'PIDs of the processes running of different devices are same', 'none of the mentioned', 'a process in one device is able to exchange information with a process in another device'),
(8, 'Which one of the following computer network is built on the top of another network?', 'chief network', 'chief network', 'prime network', 'overlay network'),
(9, 'A list of protocols used by a system, one protocol per layer, is called', 'protocol architecture', 'protocol suit', 'none of the mentioned', 'protocol stack'),
(10, 'In computer network nodes are', 'the computer that originates the data', 'the computer that routes the data', 'the computer that terminates the data', 'all of the mentioned');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `score` int(11) NOT NULL,
  `QuestionRight` int(11) NOT NULL,
  `QuestionsWrong` int(11) NOT NULL,
  `email` text NOT NULL,
  `Nationality` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Truncate table before insert `users`
--

TRUNCATE TABLE `users`;
--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `name`, `username`, `password`, `score`, `QuestionRight`, `QuestionsWrong`, `email`, `Nationality`) VALUES
(1, 'Darren', 'Darren', 'darren', 0, 0, 0, 'darren@hotmail.com', 'spanish'),
(2, 'Ryan', 'Ryan', 'ryan', 0, 0, 0, '', 'spanish'),
(3, 'Rachel', 'Rachel', 'rachel', 0, 0, 0, '', ''),
(4, 'luke', 'luke', 'luke', 0, 0, 0, 'luke@hotmail.com', ''),
(5, 'dina', 'dina', 'dina', 0, 0, 0, 'dina@dfjhfdhdfghfds.frtghr', 'spanish');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`questionid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `questionid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
