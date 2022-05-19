# BOOKSHELTER
***
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