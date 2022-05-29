En esta rama del proyecto contamos con 2 ficheros .properties adicionales con los que poder trabajar simultaneamente en 2 entornos: uno Dev y uno Pro.

La diferencia entre ambos es la base de datos que usan: el entorno Dev usará una base de datos en memoria H2 mientras que el Pro usará la Desplegada en Azure.

Para ejecutarlos usaremos docker (ya que de forma predeterminada, se lanzará el perfi Pro) indicando el perfil deseado en una variable de entorno:

1. Creamos la imagen del proyecto:
```
docker build -t alanz/bsdocker:1.0 .
```

2. Lanzamos el entorno Dev por el puerto 8081:

```
docker run -d -p 8081:8081 -e "spring_profiles_active=dev" --name bs-dev alanz/bsdocker:1.0
```

3. Lanzamos el entorno Pro por el puerto 8080:
```
docker run -d -p 8080:8080 -e "spring_profiles_active=pro" --name bs-pro alanz/bsdocker:1.0
```
