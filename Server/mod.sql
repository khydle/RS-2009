SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

UPDATE `npc_configs` SET `lifepoints` = '15' WHERE `npc_configs`.`id`=6142 OR `npc_configs`.`id`=6143 OR `npc_configs`.`id`=6144 OR `npc_configs`.`id`=6145 OR `npc_configs`.`id`=6146 OR `npc_configs`.`id`=6147 OR `npc_configs`.`id`=6148 OR `npc_configs`.`id`=6149 OR `npc_configs`.`id`=6150 OR `npc_configs`.`id`=6151 OR `npc_configs`.`id`=6152 OR `npc_configs`.`id`=6153 OR `npc_configs`.`id`=6154 OR `npc_configs`.`id`=6155 OR `npc_configs`.`id`=6156 OR `npc_configs`.`id`=6157 OR `npc_configs`.`id`=7551 OR `npc_configs`.`id`=7552 OR `npc_configs`.`id`=7553 OR `npc_configs`.`id`=7554 OR `npc_configs`.`id`=7555 OR `npc_configs`.`id`=7556 OR `npc_configs`.`id`=7557 OR `npc_configs`.`id`=7558;

UPDATE `shops` SET `stock` = '{438,10}-{436,10}-{440,10}-{442,10}-{453,10}-{444,10}-{447,10}-{449,10}-{451,10}-{1623,10}-{1621,10}-{1619,10}-{1617,10}-{1631,10}-{6571,10}-{9194,50}' WHERE `shops`.`id` = 122;

UPDATE `npc_drops` SET `main` = '{1391,1,1,0.0,UNCOMMON}~{869,1,1,0.0,RARE}~{565,3,11,0.0,COMMON}~{563,2,2,0.0,COMMON}~{560,10,10,0.0,COMMON}~{5280,1,1,0.0,UNCOMMON}~{1437,15,15,0.0,UNCOMMON}~{7937,15,15,0.0,UNCOMMON}~{448,3,14,0.0,UNCOMMON}~{187,1,1,0.0,RARE}~{2745,1,1,0.0,RARE}~{9008,1,1,0.0,UNCOMMON}~{1442,1,1,0.0,RARE}' WHERE `npc_drops`.`npc_id` = 4381 OR `npc_drops`.`npc_id` = 4382 OR `npc_drops`.`npc_id` = 4383;
UPDATE `npc_drops` SET `main` = '{1145,1,1,0.0,UNCOMMON}~{888,5,17,0.0,COMMON}~{890,5,14,0.0,COMMON}~{1165,1,1,0.0,COMMON}~{333,1,1,0.0,UNCOMMON}~{329,1,1,0.0,UNCOMMON}~{1437,15,15,0.0,UNCOMMON}~{1437,30,30,0.0,UNCOMMON}~{555,7,7,0.0,COMMON}~{7937,15,15,0.0,COMMON}~{2849,1,1,0.0,RARE}~{9010,1,1,0.0,UNCOMMON}' WHERE `npc_drops`.`npc_id` = 4397 OR `npc_drops`.`npc_id` = 4398 OR `npc_drops`.`npc_id` = 4399;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;