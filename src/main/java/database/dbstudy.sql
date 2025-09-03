-- create database 'dbstudy'
CREATE SCHEMA `dbstudy` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `dbstudy`;
SELECT * FROM information_schema.schemata WHERE schema_name = 'dbstudy';

-- drop table 'tbl_city_company'
DROP TABLE IF EXISTS `dbstudy`.`tbl_city_company`;
-- drop table 'tbl_mayor'
DROP TABLE IF EXISTS `dbstudy`.`tbl_mayor`;
-- drop table 'tbl_city'
DROP TABLE IF EXISTS `dbstudy`.`tbl_city`;
-- drop table 'tbl_state'
DROP TABLE IF EXISTS `dbstudy`.`tbl_state`;
-- drop table 'tbl_company'
DROP TABLE IF EXISTS `dbstudy`.`tbl_company`;
-- drop function 'getIdState'
DROP FUNCTION IF EXISTS `dbstudy`.`getIdState`;

-- create table 'tbl_state'
CREATE TABLE IF NOT EXISTS `dbstudy`.`tbl_state` ( 
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT, 
  `col_name` VARCHAR(45) NOT NULL, 
  `col_uf` VARCHAR(2) NOT NULL, 
  `col_region` ENUM('North', 'North East', 'South', 'South East', 'Midwest') NOT NULL, 
  `col_population` DECIMAL(5, 2) NOT NULL, 
  PRIMARY KEY (`id`), 
  UNIQUE KEY `uk__tbl_state__name` (`col_name`), 
  UNIQUE KEY `uk__tbl_state__uf` (`col_uf`)
);

-- create table 'tbl_city'
CREATE TABLE IF NOT EXISTS `dbstudy`.`tbl_city` ( 
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT, 
  `col_name` VARCHAR(45) NOT NULL, 
  `col_area` DECIMAL(10, 3) NOT NULL, 
  `id_state` INT UNSIGNED NOT NULL, 
  PRIMARY KEY (`id`), 
  UNIQUE KEY `uk__tbl_city__name_state` (`col_name`, `id_state`), 
  CONSTRAINT `fk__tbl_city__state` 
    FOREIGN KEY (`id_state`) REFERENCES `tbl_state` (`id`) ON DELETE CASCADE
);

-- create table 'tbl_mayor'
CREATE TABLE IF NOT EXISTS `tbl_mayor` ( 
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT, 
  `col_name` VARCHAR(100) NOT NULL, 
  `id_city` INT UNSIGNED DEFAULT NULL, 
  PRIMARY KEY (`id`), 
  UNIQUE KEY `uk__tbl_mayor__city` (`id_city`), 
  CONSTRAINT `fk__tbl_mayor__city` 
    FOREIGN KEY (`id_city`) REFERENCES `tbl_city` (`id`) ON DELETE CASCADE
);

-- create table 'tbl_company'
CREATE TABLE IF NOT EXISTS `tbl_company` ( 
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT, 
  `col_name` VARCHAR(255) NOT NULL, 
  `col_cnpj` VARCHAR(15) NOT NULL, 
  PRIMARY KEY (`id`), 
  UNIQUE KEY `uk__tbl_company__cnpj` (`col_cnpj`) 
);

-- create table 'tbl_city_company'
CREATE TABLE IF NOT EXISTS `tbl_city_company` ( 
  `id_city` INT UNSIGNED NOT NULL, 
  `id_company` INT UNSIGNED NOT NULL, 
  `col_isactive` TINYINT(1) NOT NULL, 
  PRIMARY KEY (`id_city`, `id_company`), 
  UNIQUE KEY `uk__tbl_city_company` (`id_city`, `id_company`), 
  CONSTRAINT `fk__tbl_city_company__city` 
    FOREIGN KEY (`id_city`) REFERENCES `tbl_city` (`id`) ON DELETE CASCADE, 
  CONSTRAINT `fk__tbl_city_company__company` 
    FOREIGN KEY (`id_company`) REFERENCES `tbl_company` (`id`) ON DELETE CASCADE
);

-- disable foreign key constraint
SET FOREIGN_KEY_CHECKS = 0;
-- truncate table 'tbl_city_company'
TRUNCATE TABLE `dbstudy`.`tbl_city_company`;
-- truncate table 'tbl_mayor'
TRUNCATE TABLE `dbstudy`.`tbl_mayor`;
-- truncate table 'tbl_city'
TRUNCATE TABLE `dbstudy`.`tbl_city`;
-- truncate table 'tbl_state'
TRUNCATE TABLE `dbstudy`.`tbl_state`;
-- truncate table 'tbl_company'
TRUNCATE TABLE `dbstudy`.`tbl_company`;
-- enable foreign key constraint
SET FOREIGN_KEY_CHECKS = 1;

DESC `dbstudy`.`tbl_state`;
DESC `dbstudy`.`tbl_city`;
DESC `dbstudy`.`tbl_mayor`;
DESC `dbstudy`.`tbl_company`;
DESC `dbstudy`.`tbl_city_company`;

-- function 'getIdState'
DELIMITER $$
CREATE FUNCTION `getIdState`(uf character(2)) RETURNS int
    READS SQL DATA
BEGIN
DECLARE idState INTEGER;
SELECT `st`.`id` INTO IdState FROM `dbstudy`.`tbl_state` AS `st` WHERE `st`.`col_uf` = uf;
RETURN idState;
END$$
DELIMITER ;

-- insert table 'tbl_state'
INSERT INTO `dbstudy`.`tbl_state` (`id`, `col_name`, `col_uf`, `col_region`, `col_population`) 
  VALUE (1, 'Acre', 'AC', 'North', 0.83);

-- insert table 'tbl_state'
INSERT INTO `dbstudy`.`tbl_state` (`id`, `col_name`, `col_uf`, `col_region`, `col_population`) 
  VALUE (2, 'Alagoas', 'AL', 'North East', 3.13);

-- insert table 'tbl_state'
INSERT INTO `dbstudy`.`tbl_state` (`col_name`, `col_uf`, `col_region`, `col_population`) VALUES 
  ('Amapá', 'AP', 'North', 0.73), ('Amazonas', 'AM', 'North', 3.94), 
  ('Bahia', 'BA', 'North East', 14.14), ('Ceará', 'CE', 'North East', 8.79), 
  ('Distrito Federal', 'DF', 'Midwest', 2.82), ('Espírito Santo', 'ES', 'South East', 3.83), 
  ('Goiás', 'GO', 'Midwest', 7.06), ('Maranhão', 'MA', 'North East', 6.78), 
  ('Mato Grosso', 'MT', 'Midwest', 3.66), ('Mato Grosso do Sul', 'MS', 'Midwest', 2.76), 
  ('Minas Gerais', 'MG', 'South East', 20.54), ('Pará', 'PA', 'North', 8.12), 
  ('Paraíba', 'PB', 'North East', 3.97), ('Paraná', 'PR', 'South', 11.44), 
  ('Pernambuco', 'PE', 'North East', 9.06), ('Piauí', 'PI', 'North East', 3.27), 
  ('Rio de Janeiro', 'RJ', 'South East', 16.05), ('Rio Grande do Norte', 'RN', 'North East', 3.30), 
  ('Rio Grande do Sul', 'RS', 'South', 10.88), ('Rondônia', 'RO', 'North', 1.58), 
  ('Roraima', 'RR', 'North', 0.64), ('Santa Catarina', 'SC', 'South', 7.61), 
  ('São Paulo', 'SP', 'South East', 44.41), ('Sergipe', 'SE', 'North East', 2.21), 
  ('Tocantins', 'TO', 'North', 1.51);

-- insert table 'tbl_city'
INSERT INTO `dbstudy`.`tbl_city` (`col_name`, `col_area`, `id_state`) VALUES 
  ('São Paulo', 248219.485, (SELECT getIdState('SP'))), 
  ('Belo Horizonte', 586513.983, (SELECT getIdState('MG'))), 
  ('Vitória', 46074.448, (SELECT getIdState('ES'))), 
  ('Rio Branco', 8835.154, (SELECT getIdState('AC'))), 
  ('Palmas', 2227.329, (SELECT getIdState('TO'))), 
  ('Cuiabá', 4327.448, (SELECT getIdState('MT'))), 
  ('Curitiba', 434.892, (SELECT getIdState('PR'))), 
  ('Florianópolis', 674.844, (SELECT getIdState('SC'))), 
  ('Porto Alegre', 495.390, (SELECT getIdState('RS'))), 
  ('Porto Velho', 34090.952, (SELECT getIdState('RO'))), 
  ('Boa Vista', 5687.037, (SELECT getIdState('RR'))), 
  ('Campo Grande', 357142.082, (SELECT getIdState('MS'))), 
  ('Maceió', 509.320, (SELECT getIdState('AL'))), 
  ('Campinas', 794.571, (SELECT getIdState('SP'))), 
  ('Bauru', 667.684, (SELECT getIdState('SP'))), 
  ('Rio de Janeiro', 43750.425, (SELECT getIdState('RJ'))), 
  ('Manaus', 11401.092, (SELECT getIdState('AM'))), 
  ('Macapá', 6563.849, (SELECT getIdState('AP'))), 
  ('Salvador', 693.442, (SELECT getIdState('BA'))), 
  ('Fortaleza', 312.353, (SELECT getIdState('CE'))), 
  ('Brasília', 5760.784, (SELECT getIdState('DF'))), 
  ('Goiânia', 729.296, (SELECT getIdState('GO'))), 
  ('São Luís', 583.063, (SELECT getIdState('MA'))), 
  ('Belém', 1059.466, (SELECT getIdState('PA'))), 
  ('João Pessoa', 210.044, (SELECT getIdState('PB'))), 
  ('Teresina', 251755.481, (SELECT getIdState('PI'))), 
  ('Natal', 167.401, (SELECT getIdState('RN'))), 
  ('Aracaju', 21938.188, (SELECT getIdState('SE'))), 
  ('Caruaru', 923.150, (SELECT getIdState('PE')));

-- insert table 'tbl_mayor'
INSERT INTO `dbstudy`.`tbl_mayor` (`col_name`, `id_city`) VALUES 
  ('Ricardo Luis Reis Nunes', 1), ('Fuad Jorge Noman Filho', 2), 
  ('Lorenzo Silva de Pazolini', 3), ('Luiz Carlos', 4), 
  ('Cinthia Alves Caetano Ribeiro', 5), ('Emanuel Pinheiro', 6), 
  ('Zenaldo Coutinho', null), ('Rafael Greca', null);

-- insert table 'tbl_company'
INSERT INTO `dbstudy`.`tbl_company` (`id`, `col_name`, `col_cnpj`) VALUES 
  (1, 'Pastelaria Sabor Divino ME', '64040659000154'), 
  (2, 'Paraiso Fotografia ME', '71677927000109'), 
  (3, 'Papelaria Universo Ltda', '57122549000176');

-- insert table 'tbl_city_company'
INSERT INTO `dbstudy`.`tbl_city_company` (`id_city`, `id_company`, `col_isactive`) VALUES 
  (1, 1, 1), (13, 2, 0), (14, 3, 1);

-- select table 'tbl_state'
SELECT `id` AS `id`, `col_name` AS `state`, `col_uf` AS `uf`, 
  `col_region` AS `region`, `col_population` AS `population` 
  FROM `dbstudy`.`tbl_state` 
    ORDER BY `state` ASC
    LIMIT 0, 10;

-- select table 'tbl_state' limit and offset
SELECT `id` AS `id`, `col_name` AS `state`, `col_uf` AS `uf`, 
  `col_region` AS `region`, `col_population` AS `population` 
  FROM `dbstudy`.`tbl_state` 
    ORDER BY `state` DESC 
    LIMIT 10 OFFSET 0; 

-- select table 'tbl_state' 
SELECT `st`.`id`, `st`.`col_name` AS `state`, `st`.`col_uf` AS `uf`, 
  `st`.`col_region` AS `region`, `st`.`col_population` AS `population` 
  FROM `dbstudy`.`tbl_state` AS `st`;

-- select table 'tbl_state' 
SELECT `st`.`col_uf` AS `uf`, `st`.`col_population` AS `population` 
  FROM `dbstudy`.`tbl_state` AS `st` WHERE `st`.`col_region` = 'South' 
    ORDER BY `st`.`col_population` DESC;

-- select table 'tbl_state' 
SELECT `st`.`col_uf` AS `uf`, `st`.`col_population` AS `population` 
  FROM `dbstudy`.`tbl_state` AS `st` WHERE `st`.`col_region` = 'South East' 
  ORDER BY `st`.`col_population`;

-- select table 'tbl_state'
SELECT `st`.`col_name` AS `state`, `st`.`col_region` AS `region`, `st`.`col_population` AS `population` 
  FROM `dbstudy`.`tbl_state` AS `st` WHERE `st`.`col_population` >= 10.0 
    ORDER BY `population` DESC;

-- select table 'tbl_state' total and average population
SELECT sum(`st`.`col_population`) AS `Total`, avg(`st`.`col_population`) AS `Average` 
  FROM `dbstudy`.`tbl_state` AS `st`;

-- select table 'tbl_state' with aggregation
SELECT `st`.`col_region` AS `region`, sum(`st`.`col_population`) AS `population` 
  FROM `dbstudy`.`tbl_state` AS `st` GROUP BY `region` 
    ORDER BY `population` DESC;

-- update table 'tbl_state'
UPDATE `tbl_state` AS `st` SET `st`.`col_population` = 1.52 WHERE `st`.`id` = (SELECT getIdState('TO'));
SELECT * FROM `dbstudy`.`tbl_state` AS `st` WHERE `st`.`col_uf` = 'TO';

-- select tables 'tbl_state', 'tbl_city' with where
SELECT * FROM `dbstudy`.`tbl_city` AS `c`, `dbstudy`.`tbl_state` AS `s` 
  WHERE `s`.`id` = `c`.`id_state`;

-- select tables 'tbl_state', 'tbl_city' with join
SELECT `c`.`col_name` AS `city`, `s`.`col_name` AS `state`, `s`.`col_uf` AS `uf`, `s`.`col_region` AS `region` 
  FROM `dbstudy`.`tbl_city` AS `c` 
    INNER JOIN `dbstudy`.`tbl_state` AS `s` ON `s`.`id` = `c`.`id_state` 
    ORDER BY `s`.`col_name`, `c`.`col_name` ASC;

-- select tables 'tbl_city', 'tbl_mayor' with join
SELECT `c`.`col_name` AS `city`, `m`.`col_name` AS `mayor` 
  FROM `dbstudy`.`tbl_city` AS `c` 
    LEFT JOIN `dbstudy`.`tbl_mayor` AS `m` ON `m`.`id_city` = `c`.`id` 
    ORDER BY `c`.`col_name` ASC;

-- select tables 'tbl_city', 'tbl_mayor' with inner join
SELECT * FROM `dbstudy`.`tbl_city` AS `c` 
    INNER JOIN `dbstudy`.`tbl_mayor` AS `m` ON `m`.`id_city` = `c`.`id`;

-- select tables 'tbl_city', 'tbl_mayor' with left union
SELECT * FROM `dbstudy`.`tbl_city` AS `c` 
    LEFT JOIN `dbstudy`.`tbl_mayor` AS `m` ON `m`.`id_city` = `c`.`id`;

-- select tables 'tbl_city', 'tbl_mayor' with right union
SELECT * FROM `dbstudy`.`tbl_city` AS `c` 
    RIGHT JOIN `dbstudy`.`tbl_mayor` AS `m` ON `m`.`id_city` = `c`.`id`;

-- select tables 'tbl_city', 'tbl_mayor' with union full join
SELECT * FROM `dbstudy`.`tbl_city` AS `c` 
    LEFT JOIN `dbstudy`.`tbl_mayor` AS `m` ON `m`.`id_city` = `c`.`id` 
      UNION -- ALL
SELECT * FROM `dbstudy`.`tbl_city` AS `c` 
    RIGHT JOIN `dbstudy`.`tbl_mayor` AS `m` ON `m`.`id_city` = `c`.`id`;

-- select tables 'tbl_company', 'tbl_city'
SELECT `co`.`col_name` AS `company`, `ci`.`col_name` AS `city`, IF(`cc`.`col_isactive` = 1, 'enable', 'disabled') AS `status` 
  FROM `dbstudy`.`tbl_company` AS `co` 
    INNER JOIN `dbstudy`.`tbl_city_company` AS `cc` ON `cc`.`id_company` = `co`.`id` 
    INNER JOIN `dbstudy`.`tbl_city` AS `ci` ON `ci`.`id` = `cc`.`id_city`;
