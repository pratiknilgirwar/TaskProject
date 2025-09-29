## URL Shortener Service
 A simple RESTful URL Shortener Service built with Spring Boot.
 This project allows users to shorten long URLs and retrieve the original URLs using short codes.


## Features

# POST /shorten
- Accepts a long URL as JSON in the request body.
- Returns a unique short code for the URL.

# GET /{shortCode}
- Redirects the user to the original URL associated with the short code.
# In-Memory Storage (Map) used for simplicity.
- Can be extended to use H2 Database or PostgreSQL.
