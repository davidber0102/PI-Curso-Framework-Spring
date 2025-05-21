-- se crea la base de datos para trabajar con spring y java en eclipse
DROP DATABASE  IF EXISTS `spring_security_sin_encriptar`;
CREATE DATABASE  IF NOT EXISTS `spring_security_sin_encriptar`;

-- se pone en uso de la nuea base creadsa
USE `spring_security_sin_encriptar`;

-- se crea la tabla user 
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- se inserta los datos a tabla user
INSERT INTO `users` 
VALUES 
('Juan','{noop}123',1),
('Antonio','{noop}456',1),
('Ana','{noop}789',1),
('Laura','{noop}321',1);

-- se crea tabla autoriies
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- se insertan datos en la ultima nueva tabla
INSERT INTO `authorities` 
VALUES 
('Juan','ROLE_USUARIO'),
('Juan','ROLE_ADMINISTRADOR'),
('Antonio','ROLE_USUARIO'),
('Ana','ROLE_USUARIO'),
('Ana','ROLE_AYUDANTE'),
('Laura','ROLE_USUARIO'),
('Laura','ROLE_ADMINISTRADOR');


SELECT * FROM spring_security_sin_encriptar.users;

SELECT * FROM spring_security_sin_encriptar.authorities
