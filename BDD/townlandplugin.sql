-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3307
-- Généré le : mar. 01 nov. 2022 à 18:37
-- Version du serveur : 10.6.5-MariaDB
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `townlandplugin`
--

-- --------------------------------------------------------

--
-- Structure de la table `bans`
--

DROP TABLE IF EXISTS `bans`;
CREATE TABLE IF NOT EXISTS `bans` (
  `player_uuid` varchar(255) NOT NULL,
  `player_name` varchar(255) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `bans`
--

INSERT INTO `bans` (`player_uuid`, `player_name`, `ID`) VALUES
('730c8c5a-5b1b-4655-8ddb-b2768932d18a', 'TNT0532', 5),
('72896682-6446-4ce4-ab67-b6fee1114913', '0zyris', 6),
('4ad8ea0d-f946-46ce-8539-f8cac4260a5f', 'Farsight_25', 7),
('a579e965-cf16-48d2-be94-7f1ccace6afc', 'LeDemiDieu', 8);

-- --------------------------------------------------------

--
-- Structure de la table `bans_players`
--

DROP TABLE IF EXISTS `bans_players`;
CREATE TABLE IF NOT EXISTS `bans_players` (
  `#` int(11) NOT NULL AUTO_INCREMENT,
  `player_uuid` varchar(255) NOT NULL,
  `end` bigint(20) NOT NULL,
  `reason` varchar(255) NOT NULL,
  PRIMARY KEY (`#`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `bienvenue`
--

DROP TABLE IF EXISTS `bienvenue`;
CREATE TABLE IF NOT EXISTS `bienvenue` (
  `Id` int(11) NOT NULL,
  `NombreB` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bienvenue`
--

INSERT INTO `bienvenue` (`Id`, `NombreB`) VALUES
(1, 11);

-- --------------------------------------------------------

--
-- Structure de la table `home`
--

DROP TABLE IF EXISTS `Home`;
CREATE TABLE IF NOT EXISTS `Home` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `player_uuid` varchar(255) NOT NULL,
  `nom_home` varchar(255) NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  `z` double NOT NULL,
  `pitch` float NOT NULL,
  `yaw` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `melon_location`
--

DROP TABLE IF EXISTS `melon_location`;
CREATE TABLE IF NOT EXISTS `melon_location` (
  `coLocationMelon` varchar(255) NOT NULL,
  `MelonX` int(11) NOT NULL DEFAULT 0,
  `MelonY` int(11) NOT NULL DEFAULT 0,
  `MelonZ` int(11) NOT NULL DEFAULT 0,
  `WorldMelon` varchar(255) NOT NULL,
  `M` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`coLocationMelon`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `mute`
--

DROP TABLE IF EXISTS `mute`;
CREATE TABLE IF NOT EXISTS `mute` (
  `player_uuid` varchar(255) NOT NULL,
  `player_name` varchar(255) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `mute`
--

INSERT INTO `mute` (`player_uuid`, `player_name`, `ID`) VALUES
('730c8c5a-5b1b-4655-8ddb-b2768932d18a', 'TNT0532', 1),
('72896682-6446-4ce4-ab67-b6fee1114913', '0zyris', 2),
('4ad8ea0d-f946-46ce-8539-f8cac4260a5f', 'Farsight_25', 3),
('a579e965-cf16-48d2-be94-7f1ccace6afc', 'LeDemiDieu', 4);

-- --------------------------------------------------------

--
-- Structure de la table `mute_players`
--

DROP TABLE IF EXISTS `mute_players`;
CREATE TABLE IF NOT EXISTS `mute_players` (
  `#` int(11) NOT NULL AUTO_INCREMENT,
  `player_uuid` varchar(255) NOT NULL,
  `end` bigint(20) NOT NULL,
  `reason` varchar(255) NOT NULL,
  PRIMARY KEY (`#`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `players`
--

DROP TABLE IF EXISTS `players`;
CREATE TABLE IF NOT EXISTS `players` (
  `uuid_player` varchar(255) NOT NULL,
  `pseudo_player` varchar(255) NOT NULL,
  `WorkFarmer` tinyint(1) NOT NULL,
  `XPFarmer` int(255) DEFAULT NULL,
  `WorkPecheur` tinyint(1) NOT NULL DEFAULT 0,
  `XPPecheur` int(255) NOT NULL,
  `coins` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `players`
--

INSERT INTO `players` (`uuid_player`, `pseudo_player`, `WorkFarmer`, `XPFarmer`, `WorkPecheur`, `XPPecheur`, `coins`) VALUES
('730c8c5a-5b1b-4655-8ddb-b2768932d18a', 'TNT0532', 1, 10000, 0, 0, 0),
('72896682-6446-4ce4-ab67-b6fee1114913', '0zyris', 1, 1600490, 0, 0, 1100),
('4ad8ea0d-f946-46ce-8539-f8cac4260a5f', 'Farsight_25', 1, 0, 0, 0, 100000000000000),
('a579e965-cf16-48d2-be94-7f1ccace6afc', 'LeDemiDieu', 1, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `pumpkin_location`
--

DROP TABLE IF EXISTS `pumpkin_location`;
CREATE TABLE IF NOT EXISTS `pumpkin_location` (
  `coLocationPumpkin` varchar(255) NOT NULL,
  `PumpkinX` int(11) NOT NULL DEFAULT 0,
  `PumpkinY` int(11) NOT NULL DEFAULT 0,
  `PumpkinZ` int(11) NOT NULL DEFAULT 0,
  `WorldPumpkin` varchar(255) NOT NULL,
  `P` int(11) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sugar_canne_location`
--

DROP TABLE IF EXISTS `sugar_canne_location`;
CREATE TABLE IF NOT EXISTS `sugar_canne_location` (
  `coLocationSugarCanne` varchar(255) NOT NULL,
  `SugarX` int(11) NOT NULL DEFAULT 0,
  `SugarY` int(11) NOT NULL DEFAULT 0,
  `SugarZ` int(11) NOT NULL DEFAULT 0,
  `WorldSugar` varchar(255) NOT NULL,
  `S` int(11) NOT NULL DEFAULT 0
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
