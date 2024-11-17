-- Project Study by Cod3R
CREATE DATABASE IF NOT EXISTS `javastudy`;
SELECT schema_name
  FROM information_schema.schemata
WHERE schema_name = 'javastudy';

DROP TABLE IF EXISTS `javastudy`.`tbl_person`;
TRUNCATE TABLE `javastudy`.`tbl_person`;

CREATE TABLE IF NOT EXISTS `javastudy`.`tbl_person`(
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `col_firstname` VARCHAR(150) NOT NULL,
  `col_gender` CHAR(1) NOT NULL,
  `col_weight` FLOAT NULL,
  `col_height` FLOAT NULL,
  `col_borndate` DATE NOT NULL,
  `col_deathdate` DATE NULL
);

SELECT date_add(date_sub(DATE(now()), interval(25) year), interval(5) month), DATE(now());

INSERT INTO `javastudy`.`tbl_person` 
  (`id`, 
   `col_firstname`, 
   `col_gender`, 
   `col_weight`, 
   `col_height`, 
   `col_borndate`, 
   `col_deathdate`) 
  VALUES
   (NULL, 'Peter', 'M', 89.5, 1.83, DATE('1999-05-01'), NULL), 
   (NULL, 'Nany', 'F', 65.5, 1.74, DATE('1987-10-25'), NULL), 
   (NULL, 'John', 'M', 75.0, 1.70, DATE('2004-02-15'), NULL);

SELECT * FROM `javastudy`.`tbl_person`;
SELECT * FROM `javastudy`.`tbl_person` AS `p` WHERE `p`.`col_firstname` LIKE '%N%';
SELECT * FROM `javastudy`.`tbl_person` AS `p` WHERE `p`.`col_firstname` NOT LIKE '%N%';

DELETE FROM `javastudy`.`tbl_person`
WHERE 1;
