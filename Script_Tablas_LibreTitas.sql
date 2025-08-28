USE db_libretitas; -- Seleccionamos la DB a usar
SHOW TABLES; -- Muestra tablas de la DB

-- Llenado tabla Usuario
 SELECT * FROM usuario; -- Muestra contenido en tabla usuario
 
 INSERT INTO usuario -- AGREGAR ELEMENTOS
VALUES (null, "Alejandra", "Echavarria", "alejandraegib@gmail.com", "Alejandra123!", 8341010016, 1),
        (null, "Natalia", "Esquivel", "nataliaeo12@gmail.com", "NataliaEO12@", 5589631585, 1),
        (null, "Mariell", "Zamora", "zamoramariell29@gmail.com", "MarZamora29!", 5581808909, 1),
        (null, "Marisol", "Díaz", "jimenezdiazm158@gmail.com", "Mary2322.", 5566173426, 0),
        (null, "Anya" , "Mares" , "anyamares@gmail.com" , "anyvany" , 3317796365, 0);
 -- Modificación tipo de variable de decripción de 100 a 150: VARCHAR(150)
 ALTER TABLE producto
 MODIFY COLUMN descripcion VARCHAR(150) NOT NULL;
 -- Llenado tabla Producto
 SELECT * FROM producto; -- Muestra contenido en tabla producto
 
 INSERT INTO producto -- AGREGAR ELEMENTOS
VALUES (null, "Modelo: Taquilla", "Libreta tamaño media carta, cubierta tapa dura, encuadernado tipo wire-o, papel rayado, 90 hojas", 250, "https://res.cloudinary.com/libretitaspi/image/upload/v1755039753/mockup_de_libreta_media_carta_kathkath_iffsyo.png", 5),
 (null, "Modelo: Piel", "Libreta tamaño media carta, cubierta tapa dura de vinipiel suave al tacto, encuadernado tipo costura francesa, papel rayado, 90 hojas", 500, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038924/IMG_20210731_015909_rocibk.jpg", 6),
 (null, "Modelo: Burrito de Mar", "Libreta tamaño media carta, cubierta tapa dura de vinipiel suave al tacto, encuadernado tipo costura francesa, papel rayado, 90 hojas", 500, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038922/IMG_20220731_224841_t9kffe.jpg", 7),
 (null , "Modelo: IPN anatómico","Libreta tamaño media carta, cubierta tapa dura, encuadernado tipo wire-o, papel rayado, 90 hojas",250, "https://res.cloudinary.com/libretitaspi/image/upload/v1755038923/IMG_20220809_205901_vi3581.jpg" ,3);
 -- Llenado tabla Orden
 SELECT * FROM orden; -- Muestra contenido en tabla orden
 
 INSERT INTO orden
 VALUES (NULL, "2025-08-28", 250, 1),
 (NULL, "2025-09-06", 750, 2),
 (NULL, "2025-08-20", 500, 3),
 (NULL, "2025-07-04" ,600,3);
