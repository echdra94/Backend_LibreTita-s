USE db_libretitas; -- Seleccionamos la DB a usar
SHOW TABLES; -- Muestra tablas de la DB

-- Llenado tabla Usuario
 SELECT * FROM usuario; -- Muestra contenido en tabla usuario
 
 INSERT INTO usuario -- AGREGAR ELEMENTOS
VALUES (null, "Alejandra", "Echavarria", "alejandraegib@gmail.com", "Alejandra123!", 8341010016, 1),
        (null, "Natalia", "Esquivel", "nataliaeo12@gmail.com", "NataliaEO12@", 5589631585, 1),
        (null, "Mariell", "Zamora", "zamoramariell29@gmail.com", "MarZamora29!", 5581808909, 1),
        (null, "Marisol", "Díaz", "jimenezdiazm158@gmail.com", "Mary2322.", 5566173426, 0),
        (null, "Anya" , "Mares" , "anyamares@gmail.com" , "anyvany" , 3317796365, 0),
        (null, "Ana", "Guevara", "anaguevaraaguilar37@gmail.com", "Ana12!", 5551234567, 0),
		(null, "Stefani", "Cosío", "stefanicos@gmail.com", "Stefani123$", 5580334144, 0),
        (null, "Griselda", "Romero", "griselda.romero.mart@gmail.com", "Gr1s3lD&", 5540846124, 1);

 -- Modificación tipo de variable de decripción de 100 a 150: VARCHAR(150)
 ALTER TABLE producto
 MODIFY COLUMN descripcion VARCHAR(500) NOT NULL;
 -- Llenado tabla Producto
 SELECT * FROM producto; -- Muestra contenido en tabla producto
 
 INSERT INTO producto -- AGREGAR ELEMENTOS
VALUES (null, "Modelo: Taquilla", "Libreta tamaño media carta, cubierta tapa dura, encuadernado tipo wire-o, papel rayado, 90 hojas", 250, "https://res.cloudinary.com/libretitaspi/image/upload/v1755039753/mockup_de_libreta_media_carta_kathkath_iffsyo.png", 5),
 (null, "Modelo: Piel", "Libreta tamaño media carta, cubierta tapa dura de vinipiel suave al tacto, encuadernado tipo costura francesa, papel rayado, 90 hojas", 500, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038924/IMG_20210731_015909_rocibk.jpg", 6),
 (null, "Modelo: Burrito de Mar", "Libreta tamaño media carta, cubierta tapa dura de vinipiel suave al tacto, encuadernado tipo costura francesa, papel rayado, 90 hojas", 500, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038922/IMG_20220731_224841_t9kffe.jpg", 7),
 (null , "Modelo: IPN anatómico","Libreta tamaño media carta, cubierta tapa dura, encuadernado tipo wire-o, papel rayado, 90 hojas",250, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/IMG_20220809_205901_vi3581.jpg" ,3),
 (null, "Modelo: Tradicional", "Libreta media carta, cubierta dura , con 90 hojas, encuadernado tipo wire-o, lista para ti.", 250, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/agenda_guinda_simulacion_2_riicmb.png", 3),
 (null, "Modelo: Huelum", "Libreta tamaño media carta, cubierta dura, encuadernado tipo wire-o, papel rayado, 90 hojas", 250, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038924/4_f5vumn.png",5),
 (null, "Modelo: Lazarillo", "Libreta pocket,pasta blanda,con 60 hojas,comoda para llevar a todas partes.", 200, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/IMG_20220731_224530_l6j4lu.jpg",5),
 (null, "Modelo: Esimio", "Libreta pocket con 60 hojas, ofrece un espacio para tomar notas, escribir tus aventuras o escribir ideas. Su tamaño hace que sean portables y ocupen poco espacio en tu bolsa o mochila", 200, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/IMG_20220731_224040_pbkirv.jpg",5),
 (null, "Modelo: México", "libreta profesional con 90 hojas, con encuadernación anillada wire-o, cuadro grande. Ideal para tus apuntes escolares o grandes ideas que requieran un amplio espacio para ser plasmadas.", 250, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/Modelo_M%C3%A9xico_1_pxjtwr.png",5),
 (null, "Carpeta: Insignia", "carpeta profesional, con encuadernación en tapa dura y capacidad para 250 hojas, las cuales se venden por separado pudiendo elegir el modelo de tu elección.", 300, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038922/insignia_c1_g0tlm7.jpg",5);

 -- Llenado tabla Orden
 SELECT * FROM orden; -- Muestra contenido en tabla orden
 
 INSERT INTO orden
 VALUES (NULL, "2025-08-28", 250, 1),
 (NULL, "2025-09-06", 750, 2),
 (NULL, "2025-08-20", 500, 3),
 (NULL, "2025-07-04" ,600,3),
 (NULL, "2025-08-25",600,3);
 
SELECT * FROM producto_has_orden;
INSERT INTO producto_has_orden (fk_idProduct, fk_idOrden)
VALUES
(56, 1),
(57, 1),
(58, 2),
(59, 2),
(60, 3),
(61, 3),
(62, 4),
(63, 4),
(64, 5),
(65, 5),
(65, 5);