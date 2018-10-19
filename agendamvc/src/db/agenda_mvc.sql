CREATE DATABASE agenda_mvc;

USE agenda_mvc;

CREATE TABLE contactos( 
    id_contacto integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    telefono varchar(15) not null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO contactos (nombre, email, telefono) VALUES 
('Dejah Thoris','dejah@barson.ma', '7751017401'), 
('Jhon Carter','jhon@barson.ma', '7751347695'),
('Carthoris Carter','carthoris@barson.ma', '7751897302');


SELECT * FROM contactos;


