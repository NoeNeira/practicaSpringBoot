DROP TABLE IF EXISTS personas;

CREATE TABLE personas (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  apellido VARCHAR(250) NOT NULL,
  edad INT NOT NULL,
  nacionalidad VARCHAR(250) NOT NULL,
  genero VARCHAR(250) NOT NULL
);

INSERT INTO personas (nombre, apellido, edad, nacionalidad, genero) VALUES
('Carla', 'Gonzalez', 37, 'argentina', 'FEMENINO'),
('Alberto', 'Fernandez', 60, 'argentina', 'MASCULINO'),
('Sol', 'Perez', 25, 'argentina', 'OTRO'),
('Sergio', 'Lapegue', 50, 'argentina', 'MASCULINO');
