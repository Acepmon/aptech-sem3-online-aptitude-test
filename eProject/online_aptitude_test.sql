-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 12, 2014 at 01:54 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `online_aptitude_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

CREATE TABLE IF NOT EXISTS `candidate` (
  `C_id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`C_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`C_id`, `Username`, `Password`) VALUES
(1, 'uchral', '1'),
(2, 'tsogtoo', '1'),
(3, 'tuvshuu', '1'),
(4, 'Bold', '98465432');

-- --------------------------------------------------------

--
-- Table structure for table `candidate_education`
--

CREATE TABLE IF NOT EXISTS `candidate_education` (
  `C_id` int(11) NOT NULL,
  `Degree` varchar(100) NOT NULL,
  KEY `FKCandidate_541713` (`C_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `candidate_education`
--

INSERT INTO `candidate_education` (`C_id`, `Degree`) VALUES
(1, 'deed'),
(2, 'deed'),
(3, 'deed'),
(4, 'deed');

-- --------------------------------------------------------

--
-- Table structure for table `candidate_exp`
--

CREATE TABLE IF NOT EXISTS `candidate_exp` (
  `C_id` int(11) NOT NULL,
  `Category` varchar(100) NOT NULL,
  `Years` int(11) NOT NULL,
  KEY `FKCandidate_949757` (`C_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `candidate_exp`
--

INSERT INTO `candidate_exp` (`C_id`, `Category`, `Years`) VALUES
(1, 'developer for java', 2014),
(2, 'developer for java', 2014),
(3, 'developer for java', 2014),
(4, 'web', 2013);

-- --------------------------------------------------------

--
-- Table structure for table `candidate_personal`
--

CREATE TABLE IF NOT EXISTS `candidate_personal` (
  `C_id` int(11) NOT NULL,
  `F_name` varchar(50) NOT NULL,
  `L_name` varchar(50) NOT NULL,
  `Birthdate` date NOT NULL,
  `Age` int(11) NOT NULL,
  `Gender` varchar(8) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Phone` int(13) NOT NULL,
  `Email` varchar(100) NOT NULL,
  KEY `FKCandidate_553689` (`C_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `candidate_personal`
--

INSERT INTO `candidate_personal` (`C_id`, `F_name`, `L_name`, `Birthdate`, `Age`, `Gender`, `Status`, `Address`, `Phone`, `Email`) VALUES
(1, 'Munkh-Uchral', 'Ankhnibayar', '1996-10-03', 18, 'male', 'student', 'Mongolia', 94961003, 'uchral_1003@yahoo.com'),
(2, 'Tsogtbayar', 'Davaadorj', '1997-08-21', 17, 'male', 'student', 'Mongolia', 89776969, 'ilovewowz@yahoo.com'),
(3, 'Tuvshinbayar', 'Dashdavaa', '1999-10-30', 15, 'male', 'student', 'Mongolia', 99715637, 'moskull@yahoo.com'),
(4, 'Bold', 'Bat', '1998-05-12', 16, 'male', 'jobseeker', 'Mongolia', 98465432, 'bat.bold@yahoo.com');

-- --------------------------------------------------------

--
-- Table structure for table `general_result`
--

CREATE TABLE IF NOT EXISTS `general_result` (
  `C_id` int(11) NOT NULL,
  `C_general` int(11) DEFAULT NULL,
  `T_year` varchar(10) DEFAULT NULL,
  KEY `FKGeneral_Re433670` (`C_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `general_result`
--

INSERT INTO `general_result` (`C_id`, `C_general`, `T_year`) VALUES
(1, 40, '2014-5-12'),
(2, NULL, '2014-5-12'),
(3, NULL, '2014-5-12'),
(4, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `general_test`
--

CREATE TABLE IF NOT EXISTS `general_test` (
  `Question_id` int(11) NOT NULL AUTO_INCREMENT,
  `Question` text NOT NULL,
  `CorrectA` varchar(50) NOT NULL,
  `Answer_1` varchar(50) NOT NULL,
  `Answer_2` varchar(50) NOT NULL,
  `Answer_3` varchar(50) NOT NULL,
  `Answer_4` varchar(50) NOT NULL,
  PRIMARY KEY (`Question_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=41 ;

--
-- Dumping data for table `general_test`
--

INSERT INTO `general_test` (`Question_id`, `Question`, `CorrectA`, `Answer_1`, `Answer_2`, `Answer_3`, `Answer_4`) VALUES
(1, 'The moon is a : ', 'Satellite', 'Comet', 'Satellite', 'Star', 'Planet'),
(2, 'Who receives Dronacharya Award?', 'Sports Coaches', 'Scientists', 'Movie actors', 'Sports Coaches', 'Sportsmen'),
(3, 'A hole is made in a brass plate and it is heated. The size of the hole will ', 'first increase and then decrease', 'increase', 'decrease', 'first increase and then decrease', 'remain unchanged'),
(4, 'Which language was patronised by the the rules of Delhi Sultanate?', 'Persian', 'Hindi', 'Arabic', 'Persian', 'Turkish'),
(5, 'Who discovered magnetic field of electric current?', 'Faraday', 'Ampere', 'Faraday', 'Fleming', 'Edison'),
(6, 'Which country leads in the production of rubber? ', 'Malaysia', 'Australia', 'India', 'Malaysia', 'Myanmar'),
(7, 'Headquarters of Amnesty International is at', 'London', 'New York', 'London', 'Washington', 'Berlin'),
(8, 'The Yellow Stone National Park is in', 'U. S. A.', 'U. S. A.', 'France', 'China', 'Maldives'),
(9, 'The equator passes through which of the following continents ? ', 'Africa', 'Africa', 'Australia', 'Europe', 'North America'),
(10, 'Days and Nights are equal throughout the globe when the sun is above ', 'Equator', 'Poles', 'Tropic of cancer', 'Equator', 'Tropic of Capricorn'),
(11, 'Seasonal unemployment refers to', 'Agriculture', 'Banks', 'Agriculture', 'Public Sector', 'Private Sector'),
(12, 'Which of the following gases is used for refrigeration ?', 'Ammonia', 'Chlorine', 'Sulphur dioxide', 'Phosphine', 'Ammonia'),
(13, 'Aspirin is the common name of ', 'acetyl salicylic acid', 'salicylic acid', 'salicylate', 'methyl salicylate', 'acetyl salicylic acid'),
(14, 'The first metal used by the man was', 'Copper', 'Iron', 'Copper', 'Aluminium', 'Gold'),
(15, 'Gobar gas contains mainly ', 'Methane', 'Carbon dioxide', 'Methane', 'Ethylene', 'Carbon monoxide'),
(16, 'The content of water is greater than fats, the plasma is more than proteins, proteins are more than fats and fats less than plasma. Which constitutes the major Part of the human body ? ', 'Water', 'Fats', 'Water', 'Plasma', 'Proteins'),
(17, 'Which of the following is a balanced fertiliser for plants ?', 'Compost', 'Urea', 'Ammonia sulphate', 'Nitrates', 'Compost'),
(18, 'Which one of the following is a fast growing tree ? ', 'Eucalyptus', 'Teak', 'Eucalyptus', 'Banyan', 'Coconut'),
(19, 'Mouth and foot diseases in cattle are caused due to ', 'Virus', 'Bacteria', 'Virus', 'Fungi', 'Penicillium'),
(20, 'The case of dispute in the presidential election is referred to ', 'Supreme Court', 'Chief Election Commissioner', 'Supreme Court', 'Parliament', 'None of the above'),
(21, ' Liberty, Equality and Fraternity, this inspiration was derived from', 'French Revolution', 'American Revolution', 'French Revolution', 'Russian Revolution', 'None of the above'),
(22, 'In the human body, adductors and abductors are types of what?', 'Muscle', 'Nerve', 'Vein', 'Muscle', 'Bone'),
(23, 'After a plague in 1633, in which German town did the villagers vow to present a living representation of Christ''s Passion every tenth year?', 'Oberammergau', 'Bayreuth', 'Munich', 'Wolfsburg', 'Oberammergau'),
(24, 'What is a plectrum used for?', 'Picking a stringed instrument', 'Pickling', 'Plucking eyebrows', 'Picking a stringed instrument', 'Pilchard gutting'),
(25, 'A major Middle Eastern city is...?', 'Beirut', 'Bayreuth', 'Beirut', 'Beira', 'Bayrakh'),
(26, 'What paradise was created by James Hilton in his book "Lost Horizon"?', 'Shangri-La', 'Shangri-La', 'Erewhon', 'El Dorado', 'Utopia'),
(27, 'Forty hours before he committed suicide in 1945 Adolf Hitler married whom?', 'Eva Braun', 'His favourite dog', 'Eva Braun', 'His Chief of Staff', 'A Jewish prisoner'),
(28, 'What note does an orchestra tune to?', 'A above middle C', 'C an octave above middle C', 'B above middle C', 'A above middle C', 'D above middle C'),
(29, 'Which German-born chemist split the uranium atom in 1939 and won the Nobel prize in 1944?', 'Otto Hahn', 'Otto Hahn', 'Ernest Rutherford', 'Pierre Curie', 'Frederick Nietzsche'),
(30, 'What is used in the technique for opening a champagne bottle called "sabrage"?', 'Sword', 'Hammer', 'Sword', 'Axe', 'Screwdriver'),
(31, 'In fairy tales, black cats are associated with what people?', 'Witches', 'Princesses', 'Witches', 'Goblins', 'Dragons'),
(32, 'Which of these has a backbone?', 'Narwhal', 'Worm', 'Narwhal', 'Starfish', 'Jellyfish'),
(33, 'What sea between Israel and Jordan is 1,385 feet (422 metres) below sea level?', 'Dead Sea', 'Dead Sea', 'Caspian Sea', 'Aegean Sea', 'Tyrrhenian Sea'),
(34, 'The term "blue collar" refers to what?', 'Manual workers in industry', 'Sportsmen', 'Unqualified office workers', 'Moth attacks on overalls', 'Manual workers in industry'),
(35, 'Which of these is a type of cheese?', 'Gorgonzola', 'Gorgonzola', 'Caracciola', 'Belladonna', 'Farina'),
(36, 'What name is given to ducks which feed mainly at the surface rather than by diving?', 'Dabbling ducks', 'Dabbling ducks', 'Puddle ducks', 'Webling ducks', 'Mighty ducks'),
(37, 'Who wrote the historical romances "The White Company" and "Brigadier Gerard"?', 'Arthur Conan Doyle', 'Enid Blyton', 'John Dryden', 'Arthur Conan Doyle', 'Georgette Heyer'),
(38, 'What is the principal ore of aluminium?', 'Bauxite', 'Lead', 'Bauxite', 'Chromium', 'Californium'),
(39, 'What has been the longest-running comedy in US TV history?', 'The Simpsons', ' America''s Funniest Home Videos', 'The Love Boat', 'The Red Skelton Show', 'The Simpsons'),
(40, 'What is a name for the abstract study of topics such as quantity, structure, space, and change?', 'Mathematics', 'Architecture', 'Numerology', 'Wargames', 'Mathematics');

-- --------------------------------------------------------

--
-- Table structure for table `inbox`
--

CREATE TABLE IF NOT EXISTS `inbox` (
  `In_id` int(11) NOT NULL AUTO_INCREMENT,
  `F_name` varchar(50) NOT NULL,
  `L_name` varchar(50) NOT NULL,
  `Birthdate` date NOT NULL,
  `Age` int(11) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Phone` int(13) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Status` varchar(50) NOT NULL,
  `Degree` varchar(100) NOT NULL,
  `Years` int(11) NOT NULL,
  `Category` varchar(100) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`In_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `it_result`
--

CREATE TABLE IF NOT EXISTS `it_result` (
  `C_id` int(11) NOT NULL,
  `C_it` int(11) DEFAULT NULL,
  `T_year` varchar(10) DEFAULT NULL,
  KEY `FKIt_Result103688` (`C_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `it_result`
--

INSERT INTO `it_result` (`C_id`, `C_it`, `T_year`) VALUES
(1, NULL, '2014-5-14'),
(2, 0, '2014-5-14'),
(3, NULL, '2014-5-14'),
(4, NULL, '2014-5-14');

-- --------------------------------------------------------

--
-- Table structure for table `it_test`
--

CREATE TABLE IF NOT EXISTS `it_test` (
  `Question_id` int(11) NOT NULL AUTO_INCREMENT,
  `Question` text NOT NULL,
  `CorrectA` varchar(50) NOT NULL,
  `Answer_1` varchar(50) NOT NULL,
  `Answer_2` varchar(50) NOT NULL,
  `Answer_3` varchar(50) NOT NULL,
  `Answer_4` varchar(50) NOT NULL,
  PRIMARY KEY (`Question_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `it_test`
--

INSERT INTO `it_test` (`Question_id`, `Question`, `CorrectA`, `Answer_1`, `Answer_2`, `Answer_3`, `Answer_4`) VALUES
(1, 'Which of the following refers to an entity in which the identifier of one entity includes the identifier of another entity?', 'ID-dependent entity', 'Weak entity', 'Strong entity', 'ID-dependent entity', 'ID-independent entity'),
(2, 'Which of the following situation requires the use of ID-dependent entities?', 'All of the above use ID dependent entities', 'Multivalued attributes only', 'Association relationships only', 'Archetype/instance relationships only', 'All of the above use ID dependent entities'),
(3, 'What standard, protocol or language was generalized to become a standard protocol for sending messages of any type, using any protocol?', 'SOAP', 'SOAP', 'SGML', 'SQL', 'ADO'),
(4, 'A shared database should:', 'All of the above.', 'be accurate and available.', 'provide for backup and recovery.', 'be secure.', 'All of the above.'),
(5, 'Which two statements are equivalent?  3/2 3<2 3*4 3<<2', '3 and 4', '1 and 2', '2 and 3', '3 and 4', '4 and 1'),
(6, 'Which is true about a method-local inner class?', 'It can be marked abstract.', 'It must be marked final.', 'It can be marked abstract.', 'It can be marked public.', 'It can be marked static.'),
(7, 'Which statement is true for the class java.util.ArrayList?', 'The elements in the collection are ordered.', 'The elements in the collection are ordered.', 'The collection is guaranteed to be immutable.', 'The elements in the collection are guaranteed to b', 'The elements in the collection are accessed using '),
(8, 'Which of the following statements is true?', 'If a switch block has no default, adding an assert', 'In an assert statement, the expression after the c', 'If a switch block has no default, adding an assert', 'In an assert statement, if the expression after th', 'It is appropriate to handle assertion failures usi'),
(9, 'The keyword used to transfer control from a function back to the calling function is', 'return', 'switch', 'goto', 'go back', 'return'),
(10, 'Which of the following statements are correct about an array? 1:	The array int num[26]; can store 26 elements. 2:	The expression num[1] designates the very first element in the array. 3:	It is necessary to initialize the array at the time of declarat', '1, 4', '1', '1, 4', '2, 3', '2, 4'),
(11, 'The library function used to find the last occurrence of a character in a string is', 'strrchr()', 'strnstr()', 'laststr()', 'strrchr()', 'strstr()'),
(12, 'Which header file should you include, if you are going to develop a function, which can accept variable number of arguments?', 'stdarg.h', 'varagrg.h', 'stdlib.h', 'stdio.h', 'stdarg.h'),
(13, 'A shared database should:', 'All of the above.', 'be accurate and available.', 'provide for backup and recovery.', 'be secure.', 'All of the above.'),
(14, 'The three-schema components include all, but:', 'programming schema.', 'internal schema.', 'conceptual schema.', 'programming schema.', 'external schema.'),
(15, 'When mapping a supertype/subtype relationship which of the following is true?', 'The supertype primary key is assigned to each subt', 'The supertype primary key is assigned to each subt', 'The subtype primary key is assigned to each supert', 'There is no link between the supertype/subtype ent', 'There is no primary key/foreign key relationship b'),
(16, 'A server-side extension is needed to do what?', 'Allow a request from a client to access the databa', 'Allow a request from a client to access the databa', 'Allow a request from a client to access a HTML-for', 'Allow a request from a client to access Web pages.', 'All of the above.'),
(17, 'Which of the following is true concerning the standard network protocol for connecting a client to a Web or database server via the Internet?', 'Both TCP and IP are needed.', 'Both TCP and IP are needed.', 'TCP is needed but IP is not needed.', 'TCP is not needed but IP is needed.', 'Neither TCP and IP are needed.'),
(18, 'The ODBC core API consists of which of the following functions?', 'Both 1 and 3 above are in the OBDC core API.', 'Commit or rollback transactions only', 'Connect to data sources with driver-specific infor', 'Connect to data sources only', 'Both 1 and 3 above are in the OBDC core API.'),
(19, 'Which of the following class level (nonlocal) variable declarations will not compile?', 'private synchronized int e;', 'protected int a;', 'transient int b = 3;', 'private synchronized int e;', 'volatile int d;'),
(20, 'Which statement is true?', 'Except in case of VM shutdown, if a try block star', 'A try statement must have at least one correspondi', 'Multiple catch statements can catch the same class', 'An Error that might be thrown in a method must be ', 'Except in case of VM shutdown, if a try block star'),
(21, 'How will you free the allocated memory ?', 'free(var-name);', 'remove(var-name);', 'free(var-name);', 'delete(var-name);', 'dalloc(var-name);'),
(22, 'In a file contains the line "I am a boy\\r\\n" then on reading this line into the array str using fgets(). What will str contain?', '"I am a boy\\n\\0"', '"I am a boy\\r\\n\\0"', '"I am a boy\\r\\0"', '"I am a boy\\n\\0"', '"I am a boy"'),
(23, 'You want subclasses in any package to have access to members of a superclass. Which is the most restrictive access that accomplishes this objective?', 'protected', 'public', 'private', 'protected', 'transient'),
(24, 'Which statement is true?', 'catch(X x) can catch subclasses of X where X is a ', 'catch(X x) can catch subclasses of X where X is a ', 'The Error class is a RuntimeException.', 'Any statement that can throw an Error must be encl', 'Any statement that can throw an Exception must be '),
(25, 'Which is valid declaration of a float?', 'float f = 1F;', 'float f = 1F;', 'float f = 1.0;', 'float f = "1";', 'float f = 1.0d;'),
(26, 'Which three guarantee that a thread will leave the running state?  yield() wait() notify() notifyAll() sleep(1000) aLiveThread.join() Thread.killThread()', '2, 5 and 6', '1, 2 and 4', '2, 5 and 6', '2, 4 and 7', '4, 5 and 7'),
(27, 'Which will contain the body of the thread?', 'run();', 'run();', 'start();', 'stop();', 'main();'),
(28, 'How many bytes are occupied by near, far and huge pointers (DOS)?', 'near=2 far=4 huge=4', 'near=2 far=4 huge=4', 'near=4 far=8 huge=8', 'near=2 far=4 huge=8', 'near=4 far=4 huge=8'),
(29, 'What is the most restrictive access modifier that will allow members of one class to have access to members of another class in the same package?', 'default access', 'public', 'protected', 'synchronized', 'default access'),
(30, 'Which is a valid declaration within an interface?', 'public static short stop = 23;', 'public static short stop = 23;', 'protected short stop = 23;', 'transient short stop = 23;', 'final void madness(short stop);');

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE IF NOT EXISTS `manager` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`Username`, `Password`) VALUES
('admin', '1');

-- --------------------------------------------------------

--
-- Table structure for table `math_result`
--

CREATE TABLE IF NOT EXISTS `math_result` (
  `C_id` int(11) NOT NULL,
  `C_math` int(11) DEFAULT NULL,
  `T_year` varchar(10) DEFAULT NULL,
  KEY `FKMath_Resul159063` (`C_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `math_result`
--

INSERT INTO `math_result` (`C_id`, `C_math`, `T_year`) VALUES
(1, NULL, '2014-5-13'),
(2, NULL, '2014-5-13'),
(3, NULL, '2014-5-13'),
(4, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `math_test`
--

CREATE TABLE IF NOT EXISTS `math_test` (
  `Question_id` int(11) NOT NULL AUTO_INCREMENT,
  `Question` text NOT NULL,
  `CorrectA` varchar(50) NOT NULL,
  `Answer_1` varchar(50) NOT NULL,
  `Answer_2` varchar(50) NOT NULL,
  `Answer_3` varchar(50) NOT NULL,
  `Answer_4` varchar(50) NOT NULL,
  PRIMARY KEY (`Question_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `math_test`
--

INSERT INTO `math_test` (`Question_id`, `Question`, `CorrectA`, `Answer_1`, `Answer_2`, `Answer_3`, `Answer_4`) VALUES
(1, 'Ok,If there are 23 boys and 21 boys are in class A,Class B has 21 boys and 22 girls,how many girls and boys are there in Class A and B?', '87', '73', '69', '87', '91'),
(2, 'Your mom is in the market,she buy 22kg of fish and 24kg of chicken,you ate 4kg of chicken and 12kg of fish,how many kg was left of the 2 foods?', '30', '30', '34', '37', '41'),
(3, 'You are the baker,you have 253 loaves of bread and 152 donuts,you are making 13 more loaves of bread and 4 donuts,while a boy bought 7 donuts and 17 loaves of bread,how many do loaves of bread and donuts do you still have?', '398', '265', '398', '402', '372'),
(4, 'You have $30.00,You bout a flower that costs $4.50 and sell it to a lady,she give you $1.20,Then you go to the donut store and bought 3 pieces of donuts that costs $12.45,how many money do you still have?', '$14.25', '$17.7', '$14.25', '$10.00', '$8.75'),
(5, '20 squared x 4 - 16 = ?', '1584', '1582', '1584', '72', '74'),
(6, 'Is it true that 5-1 is 3', 'false', 'true', 'false', 'Paradox', 'None of the above. I live in space'),
(7, 'what is the squere root of 5?', '2.23', '4', '2.23', '1.75', '1.13'),
(8, '3(5X-1)<4(X-6)', 'X< -21/11', 'X< 10/21', 'X > 5', 'X> -11/21', 'X< -21/11'),
(9, 'Find the perpendicular slope of the line 3X-9Y=15', '-3', '3', '-1/3', '-3', '1/3'),
(10, '3(X-5)-4X = 6(X-10) -(X+ 5) ', 'X= 25/3', 'X=10/3', 'X= -25/3', 'X= 25/3', 'X= 0'),
(11, 'Y= -3X + 6. so then X=?', '(2,0)', '(0,6)', '(0,-1/3)', '(2,0)', '(0,2)'),
(12, 'x*x-16x=-55', '5, 11', '-5, 55', '5, 11', '5, -11', '-5, -11'),
(13, 'Which of the following equations passes through point  (-3,-16)', 'Y=2X-10', 'Y=2X-10', 'Y=-X-8', 'Y=3X-16', 'Y=-2X-10'),
(14, 'What is the X? (3X+2)(X-4)=0', '-2/3, 4', '-2/3, 4', '-3/2, -4', '2/3, -4', '3/2, 4'),
(15, 'The length of a rectangular box is 2 units less than its width. If the area of the box is 15 units square. Find the perimeter of the box.', '16', '36', '16', '26', '10'),
(16, 'Solve the following system of equations: 2X-5Y=-4  X+6Y=15', '(3, 2)', '(2, 3)', '(3, 2)', '(1, 3)', '(3, 1)'),
(17, 'Multiply (3X -5)(2X+ 5) ', '6x*x+5x-25', '6x*x-5x-25', '6x*x+5x-25', '6x*x+5x+25', '6x*x-10x+25'),
(18, 'Translate the following sentence into an algebraic expression: " The product of a number and six is three times the same number less than ten"', '6X= 10-3X', '6X= 10-(X+3)', '6X-10=3X', '6X= 10-3X', '6X= 3X-10'),
(19, '-10(X+ 4) -5(-X+ 6X) ', '-35X-40', '-10X+15', '-35X-40', '-15X+100', '35+40X'),
(20, 'The hour and minute hands are at equal distance from the 6 hour, what time will it be exactly?', '8 hour, 18 minutes, 27 9/13 second.', '8 hour, 18 minutes, 27second.', '8 hour, 18 minutes, 28 13/4 second.', '8 hour, 18 minutes, 27 9/13 second.', '8 hour, 18 minutes, 28 second.'),
(21, 'How many steps are required to break an m x n bar of chocolate into 1 x 1 pieces?   You can break an existing piece of chocolate horizontally or vertically.   You cannot break two or more pieces at once (so no cutting through stacks).', '1', '1', '12', '2', '34'),
(22, 'I have some pencils and some jars.  If I put 4 pencils into each jar I will have one jar left over. If I put 3 pencils into each jar I will have one pencil left over. How many pencils and how many jars?', '16 pencils and 5 jars', '16 pencils and 3 jars', '17 pencils and 5 jars', '17 pencils and 3 jars', '16 pencils and 5 jars'),
(23, 'What is the probability that the next person you meet has an above average number of arms?', 'Very Likely', 'Certain', 'Very Likely', 'Likely', 'Impossible'),
(24, 'Does 0.999... = 1 ?', 'Yes', 'Yes', 'No', 'I don''t know', 'None of the above'),
(25, ' Use the numerals 1, 9, 9 and 6 exactly in that order to make the following numbers: 28, 32, 35, 38, 72, 73, 76, 77, 100 and 1000  You can use the mathematical symbols +, -, ×, /, √, ^ (exponent symbol) and brackets.  Example: 63 = 1×9+9×6', '28 = 1+9+√(9)×6', '74 = (1+√(9))×√(9)×6', '28 = 1+9+√(9)×6', '96 = 1+√(9)+96', '1996 = (1+9)^(9-6)'),
(26, ' How can I get the answer 24 by only using the numbers 8,8,3,3.  You can use add, subtract, multiply, divide, and parentheses.  Bonus rules: also allowed are logarithms, factorials and roots', '((8 x 3!)/3)+8', '8/(3-(8/3))+3', '((8 x 3!)/3)+8', '8/(3-(8/3))/8', '8/(3-(8/3))/3'),
(27, ' What 5-digit number has the following features:   If we put the numeral 1 at the beginning, we get a number three times smaller than if we put the numeral 1 at the end of the number.', '3(100000 + x) = 10x+1', '3(100000 + x) = 10x+1', '3(100000 + x) = 10x+2', '3(100000 + x) = 10x+3', '3(100000 + x) = 10x+4'),
(28, 'Find a 10-digit number where the first digit is how many zeros in the number, the second digit is how many 1s in the number etc. until the tenth digit which is how many 9s in the number.', '6210001000', '621000200', '6210001099', '621000100', '6210001000'),
(29, ' Last month I sent off for one of those kits which you can use to make your own Christmas Crackers. The kit contained:  Three colours of hat: Red, Yellow and Blue Four types of novelty: toy car, spinning top, magnifying glass and miniature hair brush', '48', '24', '48', '72', '10024'),
(30, ' Find a number with its letters in alphabetical order.  Example: "five" has "fiv" in alphabetical order, but not "e".', '40', '10', '2', '30', '40');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `News_id` int(11) NOT NULL AUTO_INCREMENT,
  `News_Title` varchar(250) NOT NULL,
  `News_Picture` varchar(250) NOT NULL,
  `News_Description` text NOT NULL,
  PRIMARY KEY (`News_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`News_id`, `News_Title`, `News_Picture`, `News_Description`) VALUES
(1, 'Duuude i got awweseome idea...', 'resource/stoner_guy.png', 'We are gonna build a company that is gonna dig holes and stuff. It will be huge profit man and we will call it GOIL or WEBSTER whichever you like.'),
(2, 'WEBSTER name!!!!!!!', 'resource/Wat8.jpg', 'Our chosen leader has just declared our company will be called WEBSTER. How stupid is that we had come up with name GOIL but he refused what the hell. I hope our leader dies by going into the drilling machine.'),
(3, 'We were decided to call it GOIL!', 'resource/penguin.jpg', 'We were decided to call our company GOIL. But, our leader named it WEBSTER. It is not ''Spider web hunting company'', isn''t it? Anyway, when we got a lot of candidates, we would fire the leader.'),
(4, 'The Price', 'resource/Craig.jpg', 'Our company set our gas & oil price. Gas is 49.6$, oil is 96.9$. You can buy any type of gas and oils from us. Some consumers said that If the price was lower, We would be soo happpy.'),
(5, 'Finally, our leader...', 'resource/achievementKid.jpg', 'We were publishing that we hate our leader who named the company Webster. And we wish him to die. And finally, he did.'),
(6, 'Did you think it is it?', 'resource/bazinga.jpg', 'Did you think it is news? NO! Bazinga.'),
(7, 'Our New Leader''s Secret Photo', 'resource/OhSpidey.jpg', 'Our great hacker hacked into our new Leader''s computer. His password was ''MaryJaneHot''. Then, he found this picture. BAZINGA!');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `candidate_education`
--
ALTER TABLE `candidate_education`
  ADD CONSTRAINT `FKCandidate_541713` FOREIGN KEY (`C_id`) REFERENCES `candidate` (`C_id`);

--
-- Constraints for table `candidate_exp`
--
ALTER TABLE `candidate_exp`
  ADD CONSTRAINT `FKCandidate_949757` FOREIGN KEY (`C_id`) REFERENCES `candidate` (`C_id`);

--
-- Constraints for table `candidate_personal`
--
ALTER TABLE `candidate_personal`
  ADD CONSTRAINT `FKCandidate_553689` FOREIGN KEY (`C_id`) REFERENCES `candidate` (`C_id`);

--
-- Constraints for table `general_result`
--
ALTER TABLE `general_result`
  ADD CONSTRAINT `FKGeneral_Re433670` FOREIGN KEY (`C_id`) REFERENCES `candidate` (`C_id`);

--
-- Constraints for table `it_result`
--
ALTER TABLE `it_result`
  ADD CONSTRAINT `FKIt_Result103688` FOREIGN KEY (`C_id`) REFERENCES `candidate` (`C_id`);

--
-- Constraints for table `math_result`
--
ALTER TABLE `math_result`
  ADD CONSTRAINT `FKMath_Resul159063` FOREIGN KEY (`C_id`) REFERENCES `candidate` (`C_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
