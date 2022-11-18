-- MySQL Workbench Synchronization
-- Generated: 2022-11-17 14:33
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: SSAFY

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER TABLE `whereismyhouse`.`housedealonsale` 
DROP FOREIGN KEY `fk_housedealonsale_user1`;

ALTER TABLE `whereismyhouse`.`question` 
CHANGE COLUMN `author` `author` VARCHAR(20) NOT NULL ,
ADD INDEX `fk_question_user1_idx` (`author` ASC) VISIBLE;
;

ALTER TABLE `whereismyhouse`.`user` 
ADD COLUMN `userKind` TINYINT(4) NOT NULL DEFAULT 0 AFTER `password`;

ALTER TABLE `whereismyhouse`.`question` 
ADD CONSTRAINT `fk_question_user1`
  FOREIGN KEY (`author`)
  REFERENCES `whereismyhouse`.`user` (`email`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `whereismyhouse`.`housedealonsale` 
ADD CONSTRAINT `fk_housedealonsale_user1`
  FOREIGN KEY (`dealer_email`)
  REFERENCES `whereismyhouse`.`user` (`email`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
