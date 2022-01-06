# api_usuarios
spring boot for api usuarios

-- ejemplo de consumo

curl --request POST \
  --url http://127.0.0.1:9090/oauth/token \
  --header 'Authorization: Basic YW5ndWxhcmFwcDpwYXNz' \
  --header 'Content-Type: application/x-www-form-urlencoded' \
  --data grant_type=password \
  --data username=aospino \
  --data password=123456789
