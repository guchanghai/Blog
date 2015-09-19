SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `BLOGDB` DEFAULT CHARACTER SET utf8 ;
USE `BLOGDB` ;

-- -----------------------------------------------------
-- Table `BLOG`.`ActionModel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BLOGDB`.`BLOG` ;

CREATE  TABLE IF NOT EXISTS `BLOGDB`.`BLOG` (
  `id` VARCHAR(20) NOT NULL ,
  `title` VARCHAR(32) NULL DEFAULT NULL ,
  `category` VARCHAR(32) NULL DEFAULT NULL ,
  `content` VARCHAR(32) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `blog_id` ON `BLOGDB`.`BLOG` (`id` ASC) ;

INSERT INTO `BLOGDB`.`BLOG` (`id`, `title`, `category`, `content`) VALUES ('1', 'MyBatis学习', '技术', '今天开始学习Java相关的持久层相关的知识。');
INSERT INTO `BLOGDB`.`BLOG` (`id`, `title`, `category`, `content`) VALUES ('2', 'Linux内核', '专研', '彻底解决心中的关于操作系统的疑惑。');
INSERT INTO `BLOGDB`.`BLOG` (`id`, `title`, `category`, `content`) VALUES ('3', '数据结构', '研究', '学完了相当一部分的数据结构。');

