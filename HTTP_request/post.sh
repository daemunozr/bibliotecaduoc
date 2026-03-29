#!/bin/bash

url='http://localhost:8080/api/v1/libros'
json_file=repository.json

curl $url --json @$json_file
