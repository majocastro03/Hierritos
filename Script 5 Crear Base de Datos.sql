-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DB_Hierritos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DB_Hierritos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DB_Hierritos` DEFAULT CHARACTER SET utf8 ;
USE `DB_Hierritos` ;

-- -----------------------------------------------------
-- Table `DB_Hierritos`.`CLIENTES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`CLIENTES` (
  `idcliente` INT NOT NULL AUTO_INCREMENT COMMENT 'Este el identificador de cada cliente.',
  `nombres` VARCHAR(100) NOT NULL COMMENT 'Aqui se almacenan los nombres y apellidos del cliente que compra.',
  `telefono` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el numero del telefono e identificador si es necesario, de cada cliente que realiza una compra.',
  `tipoDocumento` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el tipo del documento del cliente que realiza la compra.',
  `numDocumento` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el numero del documento del cliente que realiza la compra.',
  `direccion` VARCHAR(200) NOT NULL COMMENT 'Aqui se almacena la direccion de residencia  del cliente que realiza la compra.',
  `correo` VARCHAR(100) NOT NULL COMMENT 'Aqui se almacena el correo electronico o email  del cliente que realiza la compra.',
  `tipoPersona` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el tipo de persona  del cliente que realiza la compra, ya sea \"NATURAL\" o \"JURIDICA\".',
  `responsableDeIva` TINYINT NOT NULL COMMENT 'Aqui se almacena un TYNYINT que representa si el cliente es responsable de Iva o no. Uno(1) representa que si es reponsable de Iva y Dos(2) representa que no es Responsable del Iva.',
  `clienteFrecuente` TINYINT NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB
COMMENT = 'Esta es la tabla donde se registran los clientes que compran en la ferreteria Hierritos.';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`USUARIOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`USUARIOS` (
  `idusuario` INT NOT NULL AUTO_INCREMENT COMMENT 'Este es el identificador de cada Usuario.',
  `nombres` VARCHAR(100) NOT NULL COMMENT 'Aqui se almacenan los nombres y apellidos de cada usuario.',
  `telefono` VARCHAR(10) NOT NULL COMMENT 'Aqui se almacena el numero de telefono de cada usuario.',
  `tipoDocumento` VARCHAR(15) NOT NULL COMMENT 'Aqui se almacena el tipo de documento de cada usuario.',
  `numDocumento` VARCHAR(15) NOT NULL COMMENT 'Aqui se almacena el numero de documento de cada usuario.',
  `direccion` VARCHAR(200) NOT NULL COMMENT 'Aqui se almacena la direccion o lugar de residencia de cada usuario.',
  `correo` VARCHAR(100) NOT NULL COMMENT 'Aqui se almacena el correo o email de cada usuario.',
  `tipoUsuario` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el tipo de usuario.',
  `nombreUsuario` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el nombre con el que se identifica cada usuario.',
  `contrasena` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena la contrasena de cada usuario.',
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB
COMMENT = 'En esta tabla se almacenan los datos de cada usuario ya sea: Administrador, Ingeniero, Bodeguero o Vendedor.';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`PRODUCTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`PRODUCTOS` (
  `idproducto` INT NOT NULL AUTO_INCREMENT COMMENT 'Este es el identificador del producto.',
  `codigo` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el codigo para su respectivo producto.',
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Aqui se almacena el nombre de cada producto.',
  `descripcion` VARCHAR(500) NOT NULL COMMENT 'Aqui se almacena una corta descripcion  de cada producto.',
  `existencia` DOUBLE NOT NULL COMMENT 'Aqui se almacena la existencia del producto.',
  `pDescuento` DOUBLE NOT NULL COMMENT 'Aqui se almacena el porcentaje de descuento correspondiente de cada producto.',
  `pIva` DOUBLE NOT NULL COMMENT 'Aqui se almacena el porcentaje del Iva correspondiente de cada producto.',
  `precioCompra` DOUBLE NOT NULL COMMENT 'Aqui se almacena el precio de la compra de cada producto.',
  `precioVenta` DOUBLE NOT NULL COMMENT 'Aqui se almacena el precio para la venta de cada producto.',
  `cantidadMinima` DOUBLE NOT NULL COMMENT 'Aqui se almacena la cantidad minima de productos de la ferreteria.',
  `cantidadMaxima` DOUBLE NOT NULL COMMENT 'Aqui se almacena la cantidad maxima de productos de la ferrreteria.',
  PRIMARY KEY (`idproducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`FERRETERIAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`FERRETERIAS` (
  `idferreteria` INT NOT NULL AUTO_INCREMENT COMMENT 'Este es el identificador de la ferreteria.',
  `nombre` VARCHAR(100) NOT NULL COMMENT 'Aqui se almacena el nombre de la ferreteria(Hierritos).',
  `telefono` VARCHAR(10) NOT NULL COMMENT 'Aqui se almacena el telefono de la ferreteria.',
  `nit` VARCHAR(10) NOT NULL COMMENT 'Aqui se almcena el numero de identificacion tributaria de la ferreteria.',
  `direccion` VARCHAR(200) NOT NULL COMMENT 'Aqui se almacena la direccion o lugar de residencia de la ferreteria.',
  `correo` VARCHAR(100) NOT NULL COMMENT 'Aqui se almacena el correo o email de la ferreteria.',
  PRIMARY KEY (`idferreteria`))
ENGINE = InnoDB
COMMENT = 'En esta tabla se almacenan los datos de la ferreterría.';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`FACTURAS_DE_VENTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`FACTURAS_DE_VENTA` (
  `idfacturaDeVenta` INT NOT NULL AUTO_INCREMENT COMMENT 'Este es el identificador de la Factura de Venta.',
  `fechaYHora` TIMESTAMP(6) NOT NULL COMMENT 'Aqui se almacena la fecha y hora del dia en que se realice la venta de los productos.',
  `consecutivoDian` INT NOT NULL COMMENT 'Este es un identificador que da la Dian para cada factura.',
  `formaDePago` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacenan la forma de pago con la que se realizo la compra.',
  `FERRETERIA_idferreteria` INT NOT NULL COMMENT 'Llave foranea de la tabla Ferreteria.',
  `USUARIOS_idusuario` INT NOT NULL COMMENT 'Llave foranea de la tabla Usuarios.',
  `CLIENTES_idcliente` INT NOT NULL COMMENT 'Llave foranea de la tabla Clientes.',
  `total` DOUBLE NOT NULL COMMENT 'Aqui se almacena el total de la factura de venta.',
  PRIMARY KEY (`idfacturaDeVenta`),
  INDEX `fk_FACTURAS_DE_VENTA_FERRETERIA_idx` (`FERRETERIA_idferreteria` ASC) VISIBLE,
  INDEX `fk_FACTURAS_DE_VENTA_USUARIOS1_idx` (`USUARIOS_idusuario` ASC) VISIBLE,
  INDEX `fk_FACTURAS_DE_VENTA_CLIENTES1_idx` (`CLIENTES_idcliente` ASC) VISIBLE,
  CONSTRAINT `fk_FACTURAS_DE_VENTA_FERRETERIA`
    FOREIGN KEY (`FERRETERIA_idferreteria`)
    REFERENCES `DB_Hierritos`.`FERRETERIAS` (`idferreteria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURAS_DE_VENTA_USUARIOS1`
    FOREIGN KEY (`USUARIOS_idusuario`)
    REFERENCES `DB_Hierritos`.`USUARIOS` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURAS_DE_VENTA_CLIENTES1`
    FOREIGN KEY (`CLIENTES_idcliente`)
    REFERENCES `DB_Hierritos`.`CLIENTES` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Esta tabla almacena los atributos de las facturas de los productos que se venden al cliente.';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`EMPRESAS_PROVEEDORAS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`EMPRESAS_PROVEEDORAS` (
  `idempresaProveedora` INT NOT NULL AUTO_INCREMENT COMMENT 'Este es el identificador de la empresa proveedora.',
  `nombre` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el nombre de la empresa proveedora',
  `nit` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el numero de identificacion tributario de la empresa proveedora.',
  `banco` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el nombre del banco.',
  `cuentaBancaria` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena la cuenta bancaria de la empresa proveedora para poder realizar sus ventas.',
  PRIMARY KEY (`idempresaProveedora`))
ENGINE = InnoDB
COMMENT = 'Esta tabla almacena los datos de las empresas proveedoras a las que se les realiza la compra.';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`FACTURAS_DE_COMPRA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`FACTURAS_DE_COMPRA` (
  `idfacturaDeCompra` INT NOT NULL AUTO_INCREMENT COMMENT 'Este es el identificador de la factura de compra.',
  `nombreVendedor` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena el nombre del vendedor que realiza la compra de los productos.',
  `formaDePago` VARCHAR(45) NOT NULL COMMENT 'Aqui se almacena la forma de pago con la cual se realiza la compra de productos.',
  `EMPRESAS_PROVEEDORAS_idempresaProveedora` INT NOT NULL COMMENT 'Llave foranea de Empresas proveedoras.',
  `fechaYHora` TIMESTAMP(6) NOT NULL COMMENT 'Aqui se almacena la fecha y la hora en que se realizo la compra de los productos.',
  `total` DOUBLE NOT NULL COMMENT 'Aqui se almacena el total de la compra de todos los productos.',
  PRIMARY KEY (`idfacturaDeCompra`),
  INDEX `fk_FACTURAS_DE_COMPRA_EMPRESAS_PROVEEDORAS1_idx` (`EMPRESAS_PROVEEDORAS_idempresaProveedora` ASC) VISIBLE,
  CONSTRAINT `fk_FACTURAS_DE_COMPRA_EMPRESAS_PROVEEDORAS1`
    FOREIGN KEY (`EMPRESAS_PROVEEDORAS_idempresaProveedora`)
    REFERENCES `DB_Hierritos`.`EMPRESAS_PROVEEDORAS` (`idempresaProveedora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'En esta tabla se almacenan los datos de cada factura de las compras que se realizan para suministrar productos al almacen.';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`PRODUCTOS_has_FACTURAS_DE_VENTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`PRODUCTOS_has_FACTURAS_DE_VENTA` (
  `PRODUCTOS_idproducto` INT NOT NULL COMMENT 'Llave foranea de la tabla Productos.',
  `FACTURAS_DE_VENTA_idfacturaDeVenta` INT NOT NULL COMMENT 'Llave foranea de la tabla Facturas de Venta.',
  `cantidadProducto` DOUBLE NOT NULL COMMENT 'Aqui se almacena la cantidad del producto que se relaciona con la factura de venta correspondiente.',
  PRIMARY KEY (`PRODUCTOS_idproducto`, `FACTURAS_DE_VENTA_idfacturaDeVenta`),
  INDEX `fk_PRODUCTOS_has_FACTURAS_DE_VENTA_FACTURAS_DE_VENTA1_idx` (`FACTURAS_DE_VENTA_idfacturaDeVenta` ASC) VISIBLE,
  INDEX `fk_PRODUCTOS_has_FACTURAS_DE_VENTA_PRODUCTOS1_idx` (`PRODUCTOS_idproducto` ASC) VISIBLE,
  CONSTRAINT `fk_PRODUCTOS_has_FACTURAS_DE_VENTA_PRODUCTOS1`
    FOREIGN KEY (`PRODUCTOS_idproducto`)
    REFERENCES `DB_Hierritos`.`PRODUCTOS` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCTOS_has_FACTURAS_DE_VENTA_FACTURAS_DE_VENTA1`
    FOREIGN KEY (`FACTURAS_DE_VENTA_idfacturaDeVenta`)
    REFERENCES `DB_Hierritos`.`FACTURAS_DE_VENTA` (`idfacturaDeVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'En esta tabla se relaciona cada producto con las facturas de venta que contiene y cada factura de venta con los productos que contiene.';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`FACTURAS_DE_COMPRA_has_PRODUCTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`FACTURAS_DE_COMPRA_has_PRODUCTOS` (
  `FACTURAS_DE_COMPRA_idfacturaDeCompra` INT NOT NULL COMMENT 'Llave foranea de Facturas de Compra',
  `PRODUCTOS_idproducto` INT NOT NULL COMMENT 'Llave foranea de Productos',
  `cantidadProducto` DOUBLE NOT NULL COMMENT 'Aqui se almacena la cantidad del producto que se relaciona con la factura de compra correspondiente.',
  PRIMARY KEY (`FACTURAS_DE_COMPRA_idfacturaDeCompra`, `PRODUCTOS_idproducto`),
  INDEX `fk_FACTURAS_DE_COMPRA_has_PRODUCTOS_PRODUCTOS1_idx` (`PRODUCTOS_idproducto` ASC) VISIBLE,
  INDEX `fk_FACTURAS_DE_COMPRA_has_PRODUCTOS_FACTURAS_DE_COMPRA1_idx` (`FACTURAS_DE_COMPRA_idfacturaDeCompra` ASC) VISIBLE,
  CONSTRAINT `fk_FACTURAS_DE_COMPRA_has_PRODUCTOS_FACTURAS_DE_COMPRA1`
    FOREIGN KEY (`FACTURAS_DE_COMPRA_idfacturaDeCompra`)
    REFERENCES `DB_Hierritos`.`FACTURAS_DE_COMPRA` (`idfacturaDeCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURAS_DE_COMPRA_has_PRODUCTOS_PRODUCTOS1`
    FOREIGN KEY (`PRODUCTOS_idproducto`)
    REFERENCES `DB_Hierritos`.`PRODUCTOS` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'En esta tabla se relaciona cada producto con las facturas de compra que lo contienen y cada factura de compra con los productos que contiene.';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`INVENTARIOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`INVENTARIOS` (
  `idinventario` INT NOT NULL AUTO_INCREMENT COMMENT 'Este es el identificador del inventario.',
  `valorVentas` DOUBLE NOT NULL COMMENT 'Aqui se almacena el valor de las ventas realizadas.',
  `fecha` DATE NOT NULL COMMENT 'Aqui se almacena la fecha en que se realiza el cierre de inventario.',
  PRIMARY KEY (`idinventario`))
ENGINE = InnoDB
COMMENT = 'En esta tabla se almacenan los productos que se compraron. ';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`INVENTARIO_has_PRODUCTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`INVENTARIO_has_PRODUCTOS` (
  `INVENTARIO_idinventario` INT NOT NULL COMMENT 'Llave foranea de la tabla de Inventario.',
  `PRODUCTOS_idproducto` INT NOT NULL COMMENT 'Llave foranea de la tabla Productos.',
  `cantidadProductos` DOUBLE NOT NULL COMMENT 'Aqui se almacena la cantidad del producto que se relaciona con el registro de inventario correspondiente.',
  PRIMARY KEY (`INVENTARIO_idinventario`, `PRODUCTOS_idproducto`),
  INDEX `fk_INVENTARIO_has_PRODUCTOS_PRODUCTOS1_idx` (`PRODUCTOS_idproducto` ASC) VISIBLE,
  INDEX `fk_INVENTARIO_has_PRODUCTOS_INVENTARIO1_idx` (`INVENTARIO_idinventario` ASC) VISIBLE,
  CONSTRAINT `fk_INVENTARIO_has_PRODUCTOS_INVENTARIO1`
    FOREIGN KEY (`INVENTARIO_idinventario`)
    REFERENCES `DB_Hierritos`.`INVENTARIOS` (`idinventario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_INVENTARIO_has_PRODUCTOS_PRODUCTOS1`
    FOREIGN KEY (`PRODUCTOS_idproducto`)
    REFERENCES `DB_Hierritos`.`PRODUCTOS` (`idproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'En esta tabla se relacionan los productos con cada registro de inventario.';


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`FORMAS_DE_PAGO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`FORMAS_DE_PAGO` (
  `idforma_de_pago` INT NOT NULL AUTO_INCREMENT,
  `formaDePago` ENUM('EFECTIVO', 'TARJETA', 'TRANSFERENCIA') NOT NULL,
  PRIMARY KEY (`idforma_de_pago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DB_Hierritos`.`EMPRESAS_PROVEEDORAS_has_FORMAS_DE_PAGO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_Hierritos`.`EMPRESAS_PROVEEDORAS_has_FORMAS_DE_PAGO` (
  `EMPRESAS_PROVEEDORAS_idempresaProveedora` INT NOT NULL,
  `FORMAS_DE_PAGO_idforma_de_pago` INT NOT NULL,
  PRIMARY KEY (`EMPRESAS_PROVEEDORAS_idempresaProveedora`, `FORMAS_DE_PAGO_idforma_de_pago`),
  INDEX `fk_EMPRESAS_PROVEEDORAS_has_FORMAS_DE_PAGO_FORMAS_DE_PAGO1_idx` (`FORMAS_DE_PAGO_idforma_de_pago` ASC) VISIBLE,
  INDEX `fk_EMPRESAS_PROVEEDORAS_has_FORMAS_DE_PAGO_EMPRESAS_PROVEED_idx` (`EMPRESAS_PROVEEDORAS_idempresaProveedora` ASC) VISIBLE,
  CONSTRAINT `fk_EMPRESAS_PROVEEDORAS_has_FORMAS_DE_PAGO_EMPRESAS_PROVEEDOR1`
    FOREIGN KEY (`EMPRESAS_PROVEEDORAS_idempresaProveedora`)
    REFERENCES `DB_Hierritos`.`EMPRESAS_PROVEEDORAS` (`idempresaProveedora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EMPRESAS_PROVEEDORAS_has_FORMAS_DE_PAGO_FORMAS_DE_PAGO1`
    FOREIGN KEY (`FORMAS_DE_PAGO_idforma_de_pago`)
    REFERENCES `DB_Hierritos`.`FORMAS_DE_PAGO` (`idforma_de_pago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;