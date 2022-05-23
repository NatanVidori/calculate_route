# Calculate Route

Aplicação que realiza a consulta na API da google maps [distance matrix](https://developers.google.com/maps/documentation/distance-matrix) e calcula o total da distancia percorida entre os endereços de origem e destino informados utilizando java e spring boot.

# Para utilizar

1 - Habilitar o uso da API google maps.

2 - Habilitar o uso da Google Maps Distance Matrix API.

3 - Atualizar a propriedade api.google.key do arquivo src/main/resources/application.properties. (para quem quiser testar o google disponibilizar 300$ para poder testar)

4 - Compilar.

5 - 
> GET

````javascript
URL:
http://localhost:8080/distance/calculate
````

````javascript
JSON:
{
  "origins": "SAO PAULO - SP|BELO HORIZONTE - MG",
  "destinations": "CAJAMAR - SP|CONTAGEM - MG"
}
````

Utilizando a barra vertical "|" você pode passar multiplos endereços.


> Response
````javascript
{
	"destinationAddresses": [
		"Cajamar, State of São Paulo, Brazil",
		"Contagem - Parque Industrial, Contagem - State of Minas Gerais, Brazil"
	],
	"originAddresses": [
		"State of São Paulo, Brazil",
		"Belo Horizonte, State of Minas Gerais, Brazil"
	],
	"rows": [
		{
			"elements": [
				{
					"distance": {
						"text": "498 km",
						"value": 497521.0
					},
					"duration": {
						"text": "5 hours 46 mins",
						"value": 20762.0
					}
				},
				{
					"distance": {
						"text": "816 km",
						"value": 816348.0
					},
					"duration": {
						"text": "10 hours 47 mins",
						"value": 38791.0
					}
				}
			],
			"totalDistanceRow": 1313.869
		},
		{
			"elements": [
				{
					"distance": {
						"text": "572 km",
						"value": 571798.0
					},
					"duration": {
						"text": "7 hours 31 mins",
						"value": 27031.0
					}
				},
				{
					"distance": {
						"text": "15.6 km",
						"value": 15649.0
					},
					"duration": {
						"text": "28 mins",
						"value": 1690.0
					}
				}
			],
			"totalDistanceRow": 587.447
		}
	],
	"totalDistance": 1901.316
}
````
