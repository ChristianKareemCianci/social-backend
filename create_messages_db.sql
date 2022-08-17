DROP SCHEMA IF EXISTS `message-and-notifications`;

CREATE SCHEMA `message-and-notifications`;

use `message-and-notifications`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(128) DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  `to_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
