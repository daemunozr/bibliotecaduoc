#!/bin/bash

url='http://localhost:8080/api/v1/libros'
json_file=modified.json

curl -v -X PUT "$url/100" --json @$json_file && echo
