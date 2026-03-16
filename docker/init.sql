CREATE DATABASE "foliadeiros"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;*/

/*CREATE TABLE usuario(
usuario_id SERIAL PRIMARY KEY,
nombre_usuario VARCHAR(50) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
password VARCHAR(50) NOT NULL,
fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);*/

CREATE TABLE foliada(
foliada_id SERIAL PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
fecha DATE NOT NULL,
hora TIME,
provincia VARCHAR(50),
descripcion VARCHAR(700),
latitud DOUBLE PRECISION,
longitud DOUBLE PRECISION,
imagen_cartel VARCHAR(100)
);

CREATE TABLE grupo(
grupo_id SERIAL PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
origen VARCHAR(100),
tipo VARCHAR(50)
);

CREATE TABLE foliada_grupo(
foliada_id INT,
grupo_id INT,
PRIMARY KEY (foliada_id, grupo_id),
FOREIGN KEY (foliada_id) REFERENCES foliada(foliada_id) ON DELETE CASCADE,
FOREIGN KEY (grupo_id) REFERENCES grupo(grupo_id) ON DELETE CASCADE
);

CREATE TABLE favorita(
favorita_id SERIAL PRIMARY KEY,
usuario_id INT,
foliada_id INT,
FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id) ON DELETE CASCADE,
FOREIGN KEY (foliada_id) REFERENCES foliada(foliada_id) ON DELETE CASCADE
);

INSERT INTO usuario (nombre_usuario, email, password)
VALUES
('foliadeiro1', 'usuario1@email.com', '123'),
('foliadeiro2', 'usuario2@email.com', '123');

INSERT INTO grupo (nombre, origen, tipo)
VALUES
('Cantareiras da Terra', 'Santiago', 'Cantareiras'),
('Os Gaiteiros do Miño', 'Lugo', 'Gaitas'),
('Fol da Chousa', 'Visantoña', 'Grupo Tradicional'),
('Pandeireteiras de Vigo', 'Vigo', 'Pandereteiras');

INSERT INTO foliada (nombre, fecha, hora, lugar, provincia, descripcion)
VALUES
(
'Foliada de Melide',
'2026-04-25',
'12:00',
'Melide',
'A_CORUNA',
'A foliada de melide e mito máis, é ensalzar a artesanía , cultura e tradición galega. Podrás disfrutar durante todo o fin de semana de: obradoiros de baile galego para nenos e adultos, mostra de artesanía e instrumentos, xigantes e cabezudos, sesión vermú, orquesta, xogos populares, exhibicion de baile e concertos'
),
(
'Foliada de Lugo',
'2026-07-10',
'20:30',
'Lugo centro histórico',
'LUGO',
'Encontro de grupos tradicionais.'
),
(
'Foliada de Pontevedra',
'2026-08-05',
'22:00',
'Praza da Ferrería',
'PONTEVEDRA',
'Foliada popular aberta a todo o público.'
);

INSERT INTO foliada_grupo (foliada_id, grupo_id)
VALUES
(1,3),
(1,2),
(2,2),
(3,1);

INSERT INTO favorita (usuario_id, foliada_id)
VALUES
(1,1),
(1,2),
(2,3);
