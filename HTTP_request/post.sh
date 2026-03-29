#!/bin/bash

url='http://localhost:8080/api/v1/libros'
json_file=repository.json
libro_1=post/libro_1.json
libro_2=post/libro_2.json
libro_3=post/libro_3.json
libro_4=post/libro_4.json

#curl -v $url --json @$json_file && echo
curl -v $url --json @$libro_1 && echo
curl -v $url --json @$libro_2 && echo
curl -v $url --json @$libro_3 && echo
curl -v $url --json @$libro_4 && echo
