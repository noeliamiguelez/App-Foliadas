-- ========================================
-- TABLAS
-- ========================================

CREATE TABLE provincia(
                          id SERIAL PRIMARY KEY,
                          nombre VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE usuario(
                        id SERIAL PRIMARY KEY,
                        nome VARCHAR(100) NOT NULL,
                        email VARCHAR(100) UNIQUE NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        fecha_rexistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE grupo(
                      id SERIAL PRIMARY KEY,
                      nome VARCHAR(100) NOT NULL,
                      tipo VARCHAR(50),
                      orixen VARCHAR(100)
);

CREATE TABLE foliada(
                        id SERIAL PRIMARY KEY,
                        nome VARCHAR(150) NOT NULL,
                        fecha DATE NOT NULL,
                        hora TIME,
                        lugar VARCHAR(150),
                        descripcion TEXT,
                        latitude DECIMAL(9,6),
                        lonxitude DECIMAL(9,6),
                        imaxen VARCHAR(255),
                        provincia_id INTEGER,
                        CONSTRAINT fk_provincia FOREIGN KEY (provincia_id)
                            REFERENCES provincia(id) ON DELETE SET NULL
);

CREATE TABLE favorita(
                         id SERIAL PRIMARY KEY,
                         usuario_id INTEGER NOT NULL,
                         foliada_id INTEGER NOT NULL,
                         CONSTRAINT fk_usuario_fav FOREIGN KEY (usuario_id)
                             REFERENCES usuario(id) ON DELETE CASCADE,
                         CONSTRAINT fk_foliada_fav FOREIGN KEY (foliada_id)
                             REFERENCES foliada(id) ON DELETE CASCADE,
                         CONSTRAINT unique_favorita UNIQUE (usuario_id, foliada_id)
);

CREATE TABLE foliada_grupo(
                              foliada_id INTEGER NOT NULL,
                              grupo_id INTEGER NOT NULL,
                              PRIMARY KEY (foliada_id, grupo_id),
                              CONSTRAINT fk_foliada FOREIGN KEY (foliada_id)
                                  REFERENCES foliada(id) ON DELETE CASCADE,
                              CONSTRAINT fk_grupo FOREIGN KEY (grupo_id)
                                  REFERENCES grupo(id) ON DELETE CASCADE
);

-- ========================================
-- DATOS
-- ========================================

-- Provincias
INSERT INTO provincia (id, nombre) VALUES
                                       (1, 'A Coruña'),
                                       (2, 'Lugo'),
                                       (3, 'Ourense'),
                                       (4, 'Pontevedra');

-- Usuarios
INSERT INTO usuario (id, nome, email, password) VALUES
                                                    (1, 'Admin', 'admin@foliadas.com', '1234'),
                                                    (2, 'Laura Gómez', 'laura@gmail.com', '1234'),
                                                    (3, 'Carlos Pérez', 'carlos@gmail.com', '1234'),
                                                    (4, 'Ana López', 'ana@gmail.com', '1234');

-- Grupos
INSERT INTO grupo (id, nome, tipo, orixen) VALUES
                                               (1, 'Os Muiñeiros', 'Tradicional', 'Galicia'),
                                               (2, 'Cantareiras do Norte', 'Vocal', 'A Coruña'),
                                               (3, 'Foliada Band', 'Moderno', 'Vigo'),
                                               (4, 'Os do Tambor', 'Percusión', 'Lugo');

-- Foliadas
INSERT INTO foliada (id, nome, fecha, hora, lugar, descripcion, latitude, lonxitude, imaxen, provincia_id) VALUES
                                                                                                               (1, 'Foliada de Santiago', '2026-07-15', '20:00', 'Praza do Obradoiro',
                                                                                                                'Gran foliada tradicional con grupos locales', 42.8806, -8.5457, 'santiago.jpg', 1),
                                                                                                               (2, 'Foliada de Lugo', '2026-08-10', '21:30', 'Muralla de Lugo',
                                                                                                                'Evento con música y baile tradicional', 43.0121, -7.5558, 'lugo.jpg', 2),
                                                                                                               (3, 'Foliada de Ourense', '2026-06-20', '19:00', 'Praza Maior',
                                                                                                                'Foliada con degustación gastronómica', 42.3367, -7.8641, 'ourense.jpg', 3),
                                                                                                               (4, 'Foliada de Vigo', '2026-09-05', '22:00', 'Casco Vello',
                                                                                                                'Gran evento nocturno con grupos modernos', 42.2406, -8.7207, 'vigo.jpg', 4);

-- Favoritas
INSERT INTO favorita (usuario_id, foliada_id) VALUES
                                                  (1, 1),
                                                  (1, 2),
                                                  (2, 1),
                                                  (2, 3),
                                                  (3, 2),
                                                  (3, 4),
                                                  (4, 4);

-- Foliada_Grupo
INSERT INTO foliada_grupo (foliada_id, grupo_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (2, 4),
                                                     (3, 4),
                                                     (4, 3),
                                                     (4, 1);