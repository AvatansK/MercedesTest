Usecase:
Use the Here Maps Places Search API’s to find Parking spots, Charging
Stations and Restaurants near the user provided location.
What to build:
Build a microservice, that will expose one end point for capturing the
request and return the response as per the business rules below.
Input :
A Place/location. For Eg. A city name.
Business rules:
-  Output must contain 3 closest POI’s of each type in the response.
-  The calls to all the three services must be done in parallel.
-  To avoid multiple calls to the provider (Here Maps) the results
must ideally be cached in memory.
Output :
The result must be returned to the caller as a single response.
Here Maps Documentation can be found in the link below. Note this requires a free
registration.
https://developer.here.com/documentation/examples/rest/places/explore-popular-
places-category

Solution Statement
- Have created one microservice for finding the poi for restaurants, parking-spots and
charging-stations. Exposed an api for providing the nearest 3 poi for a given location.
- HERE Map&#39;s gecode API can be used to retrieve latitude and longitude for a
given city.
- https://geocode.search.hereapi.com/v1/geocode?q=berlin
- q - location name
- HERE Map&#39;s discover API can be used to retrieve search result. Use the
&quot;distance&quot; attribute in the search response to identify the
- nearby results.
- https://discover.search.hereapi.com/v1/discover?at=52.5228,13.412&q=restaur
ant&apiKey=ABCDEFGJHIJKLMNOPQRST
- at - logitude and latitude
- q - search category
- Sample Request
 - Url - http://127.0.0.1:8080/poi/v1/location/nearest-poi?location=berlin
- Method- Get
- Sample Response 
- {
  	"restaurantPOI": [{
  			"position": {
  				"lat": "27.33153",
  				"lng": "88.61397"
  			},
  			"title": "Sonnys Oasis Cafe",
  			"distance": 1,
  			"openingHours": null
  		},
  		{
  			"position": {
  				"lat": "27.33153",
  				"lng": "88.61397"
  			},
  			"title": "Tandoori Zaika",
  			"distance": 1,
  			"openingHours": null
  		},
  		{
  			"position": {
  				"lat": "27.33153",
  				"lng": "88.61397"
  			},
  			"title": "Momo Huts",
  			"distance": 1,
  			"openingHours": null
  		}
  	],
  	"chargingStationPOI": [{
  			"position": {
  				"lat": "21.28487",
  				"lng": "-157.83903"
  			},
  			"title": "Modern Honolulu",
  			"distance": 11057301,
  			"openingHours": [{
  				"text": [
  					"Mon, Wed, Thu, Sun: 00:00 - 24:00, 10:00 - 22:00",
  					"Tue: 00:00 - 24:00, 17:00 - 22:00",
  					"Fri, Sat: 00:00 - 24:00, 09:00 - 22:00"
  				],
  				"isOpen": true
  			}]
  		},
  		{
  			"position": {
  				"lat": "47.62624",
  				"lng": "-122.3301"
  			},
  			"title": "Seattle Cancer Care Alliance",
  			"distance": 11123817,
  			"openingHours": [{
  				"text": [
  					"Mon-Fri: 08:00 - 17:00"
  				],
  				"isOpen": true
  			}]
  		},
  		{
  			"position": {
  				"lat": "47.54528",
  				"lng": "-122.03727"
  			},
  			"title": "Walgreens",
  			"distance": 11141948,
  			"openingHours": [{
  				"text": [
  					"Mon-Sun: 00:00 - 24:00"
  				],
  				"isOpen": true
  			}]
  		}
  	],
  	"parkingSpotPOI": [{
  			"position": {
  				"lat": "27.33325",
  				"lng": "88.61375"
  			},
  			"title": "Car Parking",
  			"distance": 193,
  			"openingHours": null
  		},
  		{
  			"position": {
  				"lat": "22.5667",
  				"lng": "88.34217"
  			},
  			"title": "Netaji Indoor Stadium",
  			"distance": 530532,
  			"openingHours": null
  		},
  		{
  			"position": {
  				"lat": "22.49495",
  				"lng": "88.34934"
  			},
  			"title": "Royal Calcutta Golf Club",
  			"distance": 538464,
  			"openingHours": null
  		}
  	]
  }

- Caching Service – We have used internal spring boot cache for implementing caching
in this service
The following cache uses LRU as cache eviction policy and we have setup a scheduler
to clear cache based on a time config defined in the application properties file. Right
now it clears every 5 minute
- Parallelism – We have used executor service and Async annotation for getting
different POI in parallel
- Testing – Unit Test cases have been written with --- code coverage
