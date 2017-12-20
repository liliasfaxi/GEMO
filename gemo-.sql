-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 19 déc. 2017 à 10:50
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gemo`
--

-- --------------------------------------------------------

--
-- Structure de la table `dci`
--

DROP TABLE IF EXISTS `dci`;
CREATE TABLE IF NOT EXISTS `dci` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `dci`
--

INSERT INTO `dci` (`id`, `name`) VALUES
(1, 'Voriconazole '),
(2, 'foscarnet '),
(3, 'Danatrol'),
(4, 'Meprobamate'),
(5, 'Vancomycine/Imipeneme '),
(6, 'Entecavir '),
(7, 'Methotrexate / Esomeprasol'),
(8, 'Morphine'),
(9, 'Metoclopramide'),
(10, 'lenograstim'),
(11, 'Imatinib'),
(12, 'Teicoplanine'),
(13, 'Etoposide'),
(14, 'Colistine'),
(15, 'Imatinib/ciclosporine '),
(16, 'Aciclovir/ Ciclosporine '),
(17, 'Colistine');

-- --------------------------------------------------------

--
-- Structure de la table `intervention`
--

DROP TABLE IF EXISTS `intervention`;
CREATE TABLE IF NOT EXISTS `intervention` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `intervention`
--

INSERT INTO `intervention` (`id`, `name`) VALUES
(1, 'Association possible'),
(2, 'Substitution d\'un médicament'),
(3, 'Arrêt du médicament'),
(4, 'Changement de médicament'),
(5, 'Ajout (prescription nouvelle)'),
(6, 'Suivi thérapeutique'),
(7, 'Améliorer les méthodes de dispensation/d\'administration'),
(8, 'Choix de la voie d\'administration'),
(9, 'Adaptation posologique'),
(10, 'Arrêt ou refus de délivrer'),
(11, '');

-- --------------------------------------------------------

--
-- Structure de la table `med`
--

DROP TABLE IF EXISTS `med`;
CREATE TABLE IF NOT EXISTS `med` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `med`
--

INSERT INTO `med` (`id`, `name`) VALUES
(1, 'Anti-inflammatoire'),
(2, 'Anti-émetique'),
(3, 'Analgesique'),
(4, 'Anti viraux'),
(5, 'Antifongique'),
(6, 'Antibiotiques'),
(7, 'Divers'),
(8, 'Organes sensoriels'),
(9, 'Système respiratoire'),
(10, 'Antiparasitaires,insecticides'),
(11, 'Système nerveux'),
(12, 'Muscle et squelette'),
(13, 'Antinéoplastiques/immunomodulateurs'),
(14, 'Anti-infectieux systémiques'),
(15, 'Hormones systémiques'),
(16, 'Système génito-urinaire/Hormones Sex.'),
(17, 'Médicaments dermatologiques'),
(18, 'Système cardiovasculaire'),
(19, 'Sang/Organes hématopoïétiques'),
(20, 'Voie digestive/Métabolisme '),
(21, '');

-- --------------------------------------------------------

--
-- Structure de la table `med_dci`
--

DROP TABLE IF EXISTS `med_dci`;
CREATE TABLE IF NOT EXISTS `med_dci` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_dci` int(11) NOT NULL,
  `id_med` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_dci` (`id_dci`,`id_med`),
  KEY `med_dci_ibfk_2` (`id_med`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `med_dci`
--

INSERT INTO `med_dci` (`id`, `id_dci`, `id_med`) VALUES
(1, 1, 14),
(2, 2, 14),
(3, 3, 15),
(4, 4, 11),
(5, 5, 14),
(6, 6, 14),
(7, 7, 13),
(8, 8, 21),
(9, 9, 21),
(10, 10, 13),
(11, 11, 13),
(12, 12, 21),
(13, 13, 13),
(14, 14, 14);

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `birth_date` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `first_name`, `last_name`, `birth_date`) VALUES
(1, 'flen ', 'foulen', '2017-10-10'),
(2, 'ouled', 'flen foulen', '2017-10-13'),
(3, 'John', 'ValJohn', '1970-12-01'),
(4, 'Guy', 'de Mauppassant', '1960-01-17'),
(5, 'Beji', 'Caid Essebsi', '1920-10-11'),
(6, 'Victor', 'Hugo', '1940-07-12'),
(7, 'Jules', 'Verne', '1940-03-15'),
(8, 'Ahmed', 'Ben Ahmed', '1990-05-15'),
(9, 'Charles ', 'Baudelaire', '1950-08-30'),
(10, 'Arthur', 'Rimbaud', '1955-09-05'),
(11, 'Paul', 'Verlaine', '1977-11-23'),
(12, 'Emile', 'Zola', '1933-04-11'),
(13, 'chayma', 'fourati', '2017-10-09');

-- --------------------------------------------------------

--
-- Structure de la table `problem`
--

DROP TABLE IF EXISTS `problem`;
CREATE TABLE IF NOT EXISTS `problem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `problem`
--

INSERT INTO `problem` (`id`, `name`) VALUES
(1, 'Incompatibilité'),
(2, 'Problème d\'administration'),
(3, 'Monitorage à suivre'),
(4, 'Pharmacodépendance'),
(5, 'Prescription non conforme'),
(6, 'Redondance'),
(7, 'Prescription d\'un médicament non justifié'),
(8, 'Médicament ou dispositif non reçu par le patient'),
(9, 'Oubli de prescription'),
(10, 'Effet indésirable'),
(11, 'Interaction médicamenteuse'),
(12, 'Problème de posologie'),
(13, 'Contre-indication/Non conformité aux réferentiels'),
(14, '');

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`id`, `name`) VALUES
(1, 'US'),
(2, 'pédiatrie'),
(3, 'UH');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(40) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `userName` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `status` text NOT NULL,
  `email` varchar(70) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `firstName`, `lastName`, `userName`, `password`, `status`, `email`, `admin`) VALUES
(1, 'responsable', 'number_one', 'resp.one', 'patatipatatou', 'pharmacien', '1', 1),
(2, 'responsable', 'number_two', 'responsable.two', 'patatipatata', 'interne', '0', 0),
(3, 'hela', 'hela', 'hela', 'hela', 'hela', '0', 1),
(4, 'imenfaith', 'imenfaith', 'imenfaith', 'imenfaith', 'imenfaith', 'imenfaith', 0),
(5, 'chayma', 'fourati', 'chayma', 'chayma', 'chayma@.', 'chayma', 1),
(6, 'khalil', 'khalil', 'khalil', 'khalil', 'khalil', 'khalil', 0);

-- --------------------------------------------------------

--
-- Structure de la table `userpending`
--

DROP TABLE IF EXISTS `userpending`;
CREATE TABLE IF NOT EXISTS `userpending` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `status` varchar(70) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `userpending`
--

INSERT INTO `userpending` (`id`, `firstName`, `lastName`, `userName`, `status`, `email`, `password`, `admin`) VALUES
(24, 'hela', 'hela', 'ashhh', 'hela', 'hela', 'hela', 0),
(16, 'ahmed', 'bendaly', 'hmed', 'hheeeh@', 'hhhhh', 'hhhhh', 0),
(22, 'hela', 'hela', 'hela', 'hela', 'hela', 'hela', 0),
(23, '22', '22', '22', '22', '22', '22', 1),
(8, 'imen', 'jaouadi', 'imenfaithpend', 'imen.hhhh@com', 'imenfaith', 'imenfaith', 0);

-- --------------------------------------------------------

--
-- Structure de la table `visit`
--

DROP TABLE IF EXISTS `visit`;
CREATE TABLE IF NOT EXISTS `visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_patient` int(11) NOT NULL,
  `date` varchar(10) NOT NULL,
  `comment` text NOT NULL,
  `id_service` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_patient` (`id_patient`,`id_service`,`id_user`),
  KEY `id_service` (`id_service`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `visit`
--

INSERT INTO `visit` (`id`, `id_patient`, `date`, `comment`, `id_service`, `id_user`) VALUES
(1, 1, '2016-05-16', 'Effet indesirable frequent du voriconazole ', 1, 2),
(2, 2, '2015-05-30', 'Effet indesirable frequent du Foscarnet ', 1, 1),
(3, 3, '2016-5-30', 'Switch Nilevar(en rupture) par Danazol', 2, 2),
(4, 4, '2016-05-26', 'Prise de 2cp le soir', 1, 1),
(5, 5, '2016-06-01', '', 2, 2),
(6, 6, '2016-06-01', 'Possibilité d\'écraser le comprimé', 1, 2),
(7, 7, '2016-06-07', 'Pas d\'interaction medicamenteuse du methotrexate a faible dose', 1, 1),
(8, 8, '2016-06-11', 'posologie maximale 0,01 à 0,02 mg/kg/h', 2, 1),
(9, 9, '2016-07-26', 'Adaptation posologique selon la clerance: <30ml/min diminuer de 75% entre 30et 60ml/min diminuer de 50%', 3, 2),
(10, 10, '2016-07-26', 'Demander au medecin de prescrire le facteur de croissance apres verification du protocole', 3, 2),
(11, 11, '2016-07-26', 'matinib et Vfend association avec risque de surdosage ', 1, 1),
(12, 12, '2016-07-26', 'clearance <40ml/min soit 400mg chaque 3jours soit 1/3 de la dose journalière ', 1, 1),
(14, 2, '2017-10-10', ',fhdcu', 2, 1),
(15, 2, '2017-10-04', 'kgf', 3, 1),
(16, 13, '2017-11-28', 'comment', 1, 1),
(17, 13, '1986', 'commentsss', 2, 4),
(18, 13, '2017-12-19', 'comment from main', 1, 1),
(19, 13, '2017-12-19', 'comment from main', 1, 1),
(20, 13, '1986', 'commentsss', 1, 4),
(22, 13, '2017-12-23', 'comment from visit interface try1', 1, 4),
(23, 13, '2017-12-05', 'com try2', 3, 4),
(24, 11, '2017-12-05', 'khalil user comm', 2, 6),
(25, 6, '2017-12-05', 'khalil user com intervention errror', 2, 6),
(26, 8, '2017-12-07', 'khalil user com intervention errror try 2', 1, 6);

-- --------------------------------------------------------

--
-- Structure de la table `visit_dci`
--

DROP TABLE IF EXISTS `visit_dci`;
CREATE TABLE IF NOT EXISTS `visit_dci` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_visit` int(11) NOT NULL,
  `id_dci` int(11) NOT NULL,
  `id_problem` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_visit` (`id_visit`,`id_dci`,`id_problem`),
  KEY `id_dci` (`id_dci`),
  KEY `id_problem` (`id_problem`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `visit_dci`
--

INSERT INTO `visit_dci` (`id`, `id_visit`, `id_dci`, `id_problem`) VALUES
(1, 1, 1, 10),
(14, 1, 9, 8),
(2, 2, 2, 10),
(3, 3, 3, 12),
(4, 4, 4, 12),
(5, 5, 5, 12),
(6, 6, 6, 14),
(7, 7, 7, 11),
(8, 8, 8, 12),
(9, 9, 9, 12),
(10, 10, 10, 8),
(11, 11, 11, 11),
(12, 12, 12, 12),
(13, 17, 9, 2),
(15, 18, 9, 8),
(17, 23, 1, 8),
(18, 24, 15, 2),
(19, 25, 5, 1),
(20, 26, 8, 2);

-- --------------------------------------------------------

--
-- Structure de la table `visit_inter`
--

DROP TABLE IF EXISTS `visit_inter`;
CREATE TABLE IF NOT EXISTS `visit_inter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_visit` int(11) NOT NULL,
  `id_intervention` int(11) NOT NULL,
  `context` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_visit` (`id_visit`,`id_intervention`),
  KEY `id_intervention` (`id_intervention`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `visit_inter`
--

INSERT INTO `visit_inter` (`id`, `id_visit`, `id_intervention`, `context`) VALUES
(1, 1, 10, 'Hallucination '),
(2, 2, 6, 'Fievre '),
(3, 3, 9, 'Recherche de l\'indication et de la posologie du Danatrol dans la maladie de Fanconi'),
(4, 4, 9, 'Traitement de l\'hallucination due a la prise de Vfend '),
(5, 5, 9, 'Correction de la posologie prescrite selon le poids '),
(6, 6, 11, 'difficulté d\'administration du medicament'),
(7, 7, 11, 'Recherche d\'interaction possible'),
(8, 8, 9, 'adaptation pour population pediatrique '),
(9, 9, 9, 'Insuffisance renale '),
(10, 10, 5, 'Oubli de prescription '),
(11, 11, 6, 'risque de surdosage'),
(12, 12, 9, 'Insuffisance renale '),
(13, 17, 4, 'contexttt'),
(14, 1, 2, 'context from main'),
(15, 18, 2, 'context from main'),
(17, 23, 2, 'con try2'),
(19, 25, 1, 'khalil user con intervention error'),
(20, 26, 2, 'khalil user con intervention error try 2');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `med_dci`
--
ALTER TABLE `med_dci`
  ADD CONSTRAINT `med_dci_ibfk_1` FOREIGN KEY (`id_dci`) REFERENCES `dci` (`id`),
  ADD CONSTRAINT `med_dci_ibfk_2` FOREIGN KEY (`id_med`) REFERENCES `med` (`id`);

--
-- Contraintes pour la table `visit`
--
ALTER TABLE `visit`
  ADD CONSTRAINT `visit_ibfk_1` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id`),
  ADD CONSTRAINT `visit_ibfk_2` FOREIGN KEY (`id_service`) REFERENCES `service` (`id`),
  ADD CONSTRAINT `visit_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `visit_dci`
--
ALTER TABLE `visit_dci`
  ADD CONSTRAINT `visit_dci_ibfk_1` FOREIGN KEY (`id_dci`) REFERENCES `dci` (`id`),
  ADD CONSTRAINT `visit_dci_ibfk_2` FOREIGN KEY (`id_problem`) REFERENCES `problem` (`id`),
  ADD CONSTRAINT `visit_dci_ibfk_3` FOREIGN KEY (`id_visit`) REFERENCES `visit` (`id`);

--
-- Contraintes pour la table `visit_inter`
--
ALTER TABLE `visit_inter`
  ADD CONSTRAINT `visit_inter_ibfk_1` FOREIGN KEY (`id_intervention`) REFERENCES `intervention` (`id`),
  ADD CONSTRAINT `visit_inter_ibfk_2` FOREIGN KEY (`id_visit`) REFERENCES `visit` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
