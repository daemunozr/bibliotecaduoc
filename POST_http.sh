#!/bin/bash

url=http://localhost:8080/api/v1/libros 
header='Content-Type: application/json' 
body='{"id": 100, "isbn": "8654654x", "titulo": "Pedrito y el lobo", "editorial": "Cuentitos SPA", "fechaPublicacion": 1800, "author": "desconocido"}'

curl -v $url \
	-H $header \
	-d $body
curl -v $url && echo
