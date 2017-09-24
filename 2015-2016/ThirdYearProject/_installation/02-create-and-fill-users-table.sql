CREATE TABLE IF NOT EXISTS `majorgroupproject`.`users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'auto incrementing user_id of each user, unique index',
  `name` varchar(20) NOT NULL,
  `user_name` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'user''s name, unique',
  `user_password_hash` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT 'user''s password in salted and hashed format',
  `score` int(11) NOT NULL,
  `QuestionRight` int(11) NOT NULL,
  `QuestionsWrong` int(11) NOT NULL,
  `user_email` varchar(64) COLLATE utf8_unicode_ci NOT NULL COMMENT 'user''s email, unique',
  `Nationality` text NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='user data';



--
-- Truncate table before insert `users`
--

TRUNCATE TABLE `users`;
--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `user_name`, `user_password_hash`, `score`, `QuestionRight`, `QuestionsWrong`, `user_email`, `Nationality`) VALUES
(1, 'Darren', 'Darren', '$2y$10$I1Cenw2BDC0GLZF11hP5Vutj8hIB726YIN0ILf4W8b6aWAuFG448K', 0, 0, 0, 'darren@hotmail.com', 'spanish'),
(2, 'Ryan', 'Ryan', '$2y$10$M6PTVAjoGhEgoFx7QyTNxubAkLBx6FPvjxfaQaLXAEV7jPJDw8fZi', 0, 0, 0, '', 'spanish'),
(3, 'Rachel', 'Rachel', '$2y$10$ipFtDbGRN29phKbePCM0POfSKCVONkKKDmG/GNHxqMTjYVD6O4fXi', 0, 0, 0, 'rachelegan@live.co.uk', ''),
(4, 'Luke', 'luke', '$2y$10$WDOn1VPheBFwK1q0psu6Z.hsoECEyBWUeDJQ2rn/taum/CBjv44i2', 0, 0, 0, 'luke@hotmail.com', ''),
(5, 'Dina', 'dina', '$2y$10$tnwkLkC4GC59PY8qeep/LuBZTH2airquFc9nnW/lGkhGqf.MPqSEu', 0, 0, 0, 'dina@gmail.com', 'spanish'),
(6, 'Cid', 'cid', '$2y$10$IbYWp8qqMTIN9HV.SGSSMehqvsVdPVr/zzplHesK7d8GJJHQ/YQuy', 0, 0, 0, 'alannettto@gmail.com', 'french' );




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
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`questionid`);


--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `questionid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `users`
--