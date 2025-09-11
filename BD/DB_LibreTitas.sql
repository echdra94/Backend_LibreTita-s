-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DB_LibreTitas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DB_LibreTitas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DB_LibreTitas` DEFAULT CHARACTER SET utf8 ;
USE `DB_LibreTitas` ;

-- -----------------------------------------------------
-- Table `DB_LibreTitas`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_LibreTitas`.`Producto` (
  `idProducto` BIGINT NOT NULL AUTO_INCREMENT,
  `nombreProducto` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(500) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `imagen` VARCHAR(250) NOT NULL,
  `existencias` BIGINT ZEROFILL NOT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_LibreTitas`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_LibreTitas`.`Usuario` (
  `idUsuario` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(300) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `promociones` TINYINT NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_LibreTitas`.`Orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_LibreTitas`.`Orden` (
  `idOrden` BIGINT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `totalOrden` DOUBLE NOT NULL,
  `Usuario_idUsuario` BIGINT NOT NULL,
  PRIMARY KEY (`idOrden`),
  INDEX `fk_Orden_Usuario_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Orden_Usuario`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `DB_LibreTitas`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_LibreTitas`.`Producto_has_Orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_LibreTitas`.`Producto_has_Orden` (
  `idProductoHasOrden` BIGINT NOT NULL AUTO_INCREMENT,
  `fkIdProduct` BIGINT NOT NULL,
  `fkIdOrden` BIGINT NOT NULL,
  PRIMARY KEY (`idProductoHasOrden`),
  INDEX `fk_Producto_has_Orden_Orden1_idx` (`fkIdOrden` ASC) VISIBLE,
  INDEX `fk_Producto_has_Orden_Producto1_idx` (`fkIdProduct` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_has_Orden_Producto1`
    FOREIGN KEY (`fkIdProduct`)
    REFERENCES `DB_LibreTitas`.`Producto` (`idProducto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Producto_has_Orden_Orden1`
    FOREIGN KEY (`fkIdOrden`)
    REFERENCES `DB_LibreTitas`.`Orden` (`idOrden`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
