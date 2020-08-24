# MercedesTest
Created a service for finding POI for a particular location.

Usecase:
Use the Here Maps Places Search API’s to find Parking spots, Charging
Stations and Restaurants near the user provided location.
What to build:
Build a microservice, that will expose one end point for capturing the
request and return the response as per the business rules below.
Input :
A Place/location. For Eg. A city name.
Business rules:
• Output must contain 3 closest POI’s of each type in the response.
• The calls to all the three services must be done in parallel.
• To avoid multiple calls to the provider (Here Maps) the results
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
-
- HERE Map&#39;s discover API can be used to retrieve search result. Use the
&quot;distance&quot; attribute in the search response to identify the
- nearby results.
-
https://discover.search.hereapi.com/v1/discover?at=52.5228,13.412&amp;q=restaur
ant&amp;limit=10&amp;lang=en-US&amp;apiKey=ABCDEFGJHIJKLMNOPQRST
-
- at - logitude and latitude
- q - search category
Sample Request –
Url - http://127.0.0.1:8080/poi/v1/location/nearest-poi?location=berlin
Method- Get
Sample Response - {
&quot;restaurantPOI&quot;: [
{
&quot;position&quot;: {
&quot;lat&quot;: &quot;27.33153&quot;,
&quot;lng&quot;: &quot;88.61397&quot;

},
&quot;title&quot;: &quot;Sonnys Oasis Cafe&quot;,
&quot;distance&quot;: 1,
&quot;openingHours&quot;: null
},
{
&quot;position&quot;: {
&quot;lat&quot;: &quot;27.33153&quot;,
&quot;lng&quot;: &quot;88.61397&quot;
},
&quot;title&quot;: &quot;Tandoori Zaika&quot;,
&quot;distance&quot;: 1,
&quot;openingHours&quot;: null
},
{
&quot;position&quot;: {
&quot;lat&quot;: &quot;27.33153&quot;,
&quot;lng&quot;: &quot;88.61397&quot;
},
&quot;title&quot;: &quot;Momo Huts&quot;,
&quot;distance&quot;: 1,
&quot;openingHours&quot;: null
}
],
&quot;chargingStationPOI&quot;: [
{
&quot;position&quot;: {
&quot;lat&quot;: &quot;21.28487&quot;,
&quot;lng&quot;: &quot;-157.83903&quot;
},
&quot;title&quot;: &quot;Modern Honolulu&quot;,
&quot;distance&quot;: 11057301,
&quot;openingHours&quot;: [
{
&quot;text&quot;: [
&quot;Mon, Wed, Thu, Sun: 00:00 - 24:00, 10:00 - 22:00&quot;,
&quot;Tue: 00:00 - 24:00, 17:00 - 22:00&quot;,
&quot;Fri, Sat: 00:00 - 24:00, 09:00 - 22:00&quot;
],
&quot;isOpen&quot;: true
}
]
},
{
&quot;position&quot;: {
&quot;lat&quot;: &quot;47.62624&quot;,
&quot;lng&quot;: &quot;-122.3301&quot;
},
&quot;title&quot;: &quot;Seattle Cancer Care Alliance&quot;,
&quot;distance&quot;: 11123817,
&quot;openingHours&quot;: [

{
&quot;text&quot;: [
&quot;Mon-Fri: 08:00 - 17:00&quot;
],
&quot;isOpen&quot;: false
}
]
},
{
&quot;position&quot;: {
&quot;lat&quot;: &quot;47.54528&quot;,
&quot;lng&quot;: &quot;-122.03727&quot;
},
&quot;title&quot;: &quot;Walgreens&quot;,
&quot;distance&quot;: 11141948,
&quot;openingHours&quot;: [
{
&quot;text&quot;: [
&quot;Mon-Sun: 00:00 - 24:00&quot;
],
&quot;isOpen&quot;: true
}
]
}
],
&quot;parkingSpotPOI&quot;: [
{
&quot;position&quot;: {
&quot;lat&quot;: &quot;27.33325&quot;,
&quot;lng&quot;: &quot;88.61375&quot;
},
&quot;title&quot;: &quot;Car Parking&quot;,
&quot;distance&quot;: 193,
&quot;openingHours&quot;: null
},
{
&quot;position&quot;: {
&quot;lat&quot;: &quot;22.5667&quot;,
&quot;lng&quot;: &quot;88.34217&quot;
},
&quot;title&quot;: &quot;Netaji Indoor Stadium&quot;,
&quot;distance&quot;: 530532,
&quot;openingHours&quot;: null
},
{
&quot;position&quot;: {
&quot;lat&quot;: &quot;22.49495&quot;,
&quot;lng&quot;: &quot;88.34934&quot;
},
&quot;title&quot;: &quot;Royal Calcutta Golf Club&quot;,
&quot;distance&quot;: 538464,

&quot;openingHours&quot;: null
}
]
}
