CREATE TABLE IF NOT EXISTS `pizza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categorie` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` decimal(19,2) DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `pizza` ADD CONSTRAINT `code_unique` UNIQUE(`code`);

CREATE TABLE IF NOT EXISTS `performance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service` varchar(255) DEFAULT NULL,
  `date` timestamp,
  `temps_execution` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
