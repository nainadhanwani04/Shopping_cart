# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.26)
# Database: shopping_cart
# Generation Time: 2017-02-05 06:29:07 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table order_details
# ------------------------------------------------------------

DROP TABLE IF EXISTS `order_details`;

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `amount` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;

INSERT INTO `order_details` (`id`, `order_id`, `product_id`, `quantity`, `price`, `amount`)
VALUES
	(1,1,7,12,100000,100000),
	(4,1,6,1,5000,5000),
	(5,3,1,1,500,500);

/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table orders
# ------------------------------------------------------------

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL,
  `amount` double NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;

INSERT INTO `orders` (`id`, `order_date`, `amount`, `user_id`)
VALUES
	(1,'2017-02-05',1000,1),
	(3,'2017-02-05',105000,1),
	(4,'2017-02-05',7000,2),
	(6,'2017-02-05',500,3),
	(8,'2017-02-05',1000,1),
	(9,'2017-02-05',500,2),
	(10,'2017-02-05',105000,1),
	(11,'2017-02-05',7000,2),
	(12,'2017-02-05',500,3),
	(13,'2017-02-05',500,3),
	(15,'2017-02-05',1000,1),
	(16,'2017-02-05',500,2),
	(17,'2017-02-05',105000,1),
	(18,'2017-02-05',7000,2),
	(19,'2017-02-05',500,3),
	(20,'2017-02-05',500,3);

/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table products
# ------------------------------------------------------------

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `code` varchar(20) NOT NULL DEFAULT '',
  `price` double NOT NULL,
  `stock` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;

INSERT INTO `products` (`id`, `name`, `code`, `price`, `stock`)
VALUES
	(1,'Coffee','1111',500,9),
	(2,'Tea','2222',500,20),
	(4,'Fruits','4444',2000,49),
	(5,'Soap','5555',300,15),
	(6,'Bag','6666',5000,8),
	(7,'Laptop','7777',100000,1);

/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL DEFAULT '',
  `first_name` varchar(20) NOT NULL DEFAULT '',
  `last_name` varchar(20) NOT NULL DEFAULT '',
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `user_name`, `first_name`, `last_name`, `address`)
VALUES
	(1,'Shei4','Shela','Dubey','Luer ganj'),
	(2,'Maina','Nana','Dhanwan','200 luker '),
	(3,'Rish','Rishi','Chaurasia','20 Luker');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
