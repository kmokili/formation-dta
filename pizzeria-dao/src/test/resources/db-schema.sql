CREATE TABLE IF NOT EXISTS `pizza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` decimal(19,2) DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);