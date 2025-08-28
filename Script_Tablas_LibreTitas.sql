USE db_libretitas; -- Seleccionamos la DB a usar
SHOW TABLES; -- Muestra tablas de la DB

-- Llenado tabla Usuario
 SELECT * FROM usuario; -- Muestra contenido en tabla usuario
 
 INSERT INTO usuario -- AGREGAR ELEMENTOS
VALUES (null, "Alejandra", "Echavarria", "alejandraegib@gmail.com", "Alejandra123!", 8341010016, 1),
        (null, "Natalia", "Esquivel", "nataliaeo12@gmail.com", "NataliaEO12@", 5589631585, 1);
 -- Modificación tipo de variable de decripción de 100 a 150: VARCHAR(150)
 ALTER TABLE producto
 MODIFY COLUMN descripcion VARCHAR(150) NOT NULL;
 -- Llenado tabla Producto
 SELECT * FROM producto; -- Muestra contenido en tabla producto
 
 INSERT INTO producto -- AGREGAR ELEMENTOS
VALUES (null, "Modelo: Taquilla", "Libreta tamaño media carta, cubierta tapa dura, encuadernado tipo wire-o, papel rayado, 90 hojas", 250, "https://res.cloudinary.com/libretitaspi/image/upload/v1755039753/mockup_de_libreta_media_carta_kathkath_iffsyo.png", 5),
 (null, "Modelo: Piel", "Libreta tamaño media carta, cubierta tapa dura de vinipiel suave al tacto, encuadernado tipo costura francesa, papel rayado, 90 hojas", 500, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038924/IMG_20210731_015909_rocibk.jpg", 6);
 -- Llenado tabla Orden
 SELECT * FROM orden; -- Muestra contenido en tabla orden
 
 INSERT INTO orden
 VALUES (NULL, "2025-08-28", 250, 1),
 (NULL, "2025-09-06", 750, 2);
