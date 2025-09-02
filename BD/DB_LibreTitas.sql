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
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombreProducto` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `imagen` VARCHAR(200) NOT NULL,
  `existencias` INT ZEROFILL NOT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_LibreTitas`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_LibreTitas`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `promociones` TINYINT NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_LibreTitas`.`Orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_LibreTitas`.`Orden` (
  `idOrden` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `totalOrden` DOUBLE NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
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
  `fk_idProduct` INT NOT NULL,
  `fk_idOrden` INT NOT NULL,
  INDEX `fk_Producto_has_Orden_Orden1_idx` (`fk_idOrden` ASC) VISIBLE,
  INDEX `fk_Producto_has_Orden_Producto1_idx` (`fk_idProduct` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_has_Orden_Producto1`
    FOREIGN KEY (`fk_idProduct`)
    REFERENCES `DB_LibreTitas`.`Producto` (`idProducto`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Producto_has_Orden_Orden1`
    FOREIGN KEY (`fk_idOrden`)
    REFERENCES `DB_LibreTitas`.`Orden` (`idOrden`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
