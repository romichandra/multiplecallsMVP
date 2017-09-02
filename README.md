# multiplecallsMVP
This is an android app demonstrating the MVP Design pattern with three network calls and parsing the results into respective views using custom rx converters.

The "Start" Button starts the requests, each request has its own subscriber to the results which return either a success response or a  network error.
The Presenter handles the flow of calls from UI to Data Model, thus updating the views once the model returns parsed results.


External Libraries used to implement the MVP architecture :

/* rxjava 2.x, retrofit 2.x and gson 2.x to process HttpRequests */

/* dagger 2.2 for Dependency Injection */
