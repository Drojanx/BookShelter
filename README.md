# BOOKSHELTER
***
Esisten varias ramas del proyecto:
1. Develop: el proyecto base configurado para funcionar en local con una base de datos MySql.

      Para crear la base de datos en Docker:
```
docker run -d -p 3306:3306 --name bookshelter-db -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=bookshelter -e MYSQL_USER=bsuser -e MYSQL_PASSWORD=100316 mysql
```

Libros de ejemplo para cargar en la Base de Datos
```
INSERT INTO books VALUES(1, 'Elvis', 'Accion', '1984-04-12', 'El libro de la selva', 23);
```
```
INSERT INTO books VALUES(2, 'Chayanne', 'Filosofia', '1999-10-24', 'La republica', 30);
```
```
INSERT INTO books VALUES(3, 'Obama', 'Politica', '2010-06-12', 'Call of Duty 4', 60);
```
```
INSERT INTO books VALUES(4, 'Rajoy', 'Cocina', '2016-06-12', 'Heist', 22);
```
```
INSERT INTO books VALUES(5, 'Chanel', 'Chanelazo', '2022-05-15', 'Tongo Eurovision', 100);
```
2. Two-enviroments: en esta rama encontramos el proyecto configurado para poder funcionar en 2 entornos simultaneamente: uno Dev con una base de datos en memoria H2 y uno Pro con la base de datos desplegada en Azure (más en README de la rama en cuestión).
3. Deploy-version: una version simple configurada para funcionar con la base de datos de Azure.
4. Docker-compose: contiene los ficheros Docker necesarios para ejecutar un docker-compose para lanzar conjuntamente la aplicación y la base de datos.
