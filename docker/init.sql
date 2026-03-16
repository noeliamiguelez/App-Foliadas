DROP TABLE IF EXISTS foliada_grupo;
DROP TABLE IF EXISTS foliada;
DROP TABLE IF EXISTS grupo;
DROP TABLE IF EXISTS usuario;


-- TABLA USUARIO
CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL
);


-- TABLA GRUPO
CREATE TABLE grupo (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT
);


-- TABLA FOLIADA
CREATE TABLE foliada (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(200) NOT NULL,
    fecha DATE NOT NULL,
    hora TIMESTAMP,
    lugar VARCHAR(200),
    provincia VARCHAR(50),
    descripcion TEXT,
    latitude DOUBLE,
    lonxitude DOUBLE,
    imaxe VARCHAR(500)
);


-- TABLA RELACION FOLIADA - GRUPO
CREATE TABLE foliada_grupo (
    foliada_id INT,
    grupo_id INT,
    PRIMARY KEY (foliada_id, grupo_id),
    FOREIGN KEY (foliada_id) REFERENCES foliada(id) ON DELETE CASCADE,
    FOREIGN KEY (grupo_id) REFERENCES grupo(id) ON DELETE CASCADE
);



-- USUARIOS
INSERT INTO usuario (nombre, email, password) VALUES
('Noelia', 'noelia@email.com', '1234'),
('Carlos', 'carlos@email.com', '1234'),
('Ana', 'ana@email.com', '1234');



-- GRUPOS
INSERT INTO grupo (nombre, descripcion) VALUES
('Os Gaiteiros', 'Grupo tradicional de gaita galega'),
('Cantareiras do Norte', 'Grupo de cantareiras tradicionais'),
('Pandeireteiras da Terra', 'Grupo feminino de pandeireta');



-- FOLIADAS
INSERT INTO foliada (nombre, fecha, hora, lugar, provincia, descripcion, latitude, lonxitude, imaxe) VALUES
('Foliada de Lugo', '2026-06-10', '2026-06-10 21:00:00', 'Praza Maior', 'LUGO',
 'Gran foliada tradicional', 43.012, -7.556, 'lugo.jpg'),

('Foliada de Compostela', '2026-07-15', '2026-07-15 20:30:00', 'Praza do Obradoiro', 'A_CORUNA',
 'Foliada aberta a todo o mundo', 42.880, -8.545, 'compostela.jpg'),

('Foliada de Ourense', '2026-08-05', '2026-08-05 22:00:00', 'Praza Maior', 'OURENSE',
 'Música tradicional e baile', 42.336, -7.864, 'ourense.jpg');



-- RELACION FOLIADA - GRUPO
INSERT INTO foliada_grupo (foliada_id, grupo_id) VALUES
(1,1),
(1,2),
(2,2),
(2,3),
(3,1);