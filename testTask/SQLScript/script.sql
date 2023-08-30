CREATE SCHEMA `testtask` ;

CREATE TABLE `testtask`.`equation` (
                                       `id` INT NOT NULL AUTO_INCREMENT,
                                       `Equation` VARCHAR(255) NOT NULL,
                                       `root1` VARCHAR(45) NULL,
                                       `root2` VARCHAR(45) NULL,
                                       PRIMARY KEY (`id`));

INSERT INTO `testtask`.`equation` (`Equation`, `root1`) VALUES ('x+5=10', '5');
INSERT INTO `testtask`.`equation` (`Equation`, `root1`, `root2`) VALUES ('x*x+4=8', '2', '2');
INSERT INTO `testtask`.`equation` (`Equation`, `root1`) VALUES ('2*x+5=15', '10');