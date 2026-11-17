# Retrieve All Tourist Records with Token Validation (Spring Boot)

This project implements the lab question using Spring Boot, Spring Data JPA, an in-memory H2 database, and Swagger UI.

## Requirements
- JDK 17 or newer
- Maven 3.6+
- Internet connection on first build (Maven downloads dependencies)

## Run
1. Extract the ZIP.
2. Open the extracted `tourist-token-validation` folder in IntelliJ IDEA / Eclipse, or open a terminal in that folder.
3. Run:

   ```bash
   mvn spring-boot:run
   ```

4. Open Swagger UI: http://localhost:8080/swagger-ui/index.html

## API
- Method: `GET`
- URL: `http://localhost:8080/api/tourists`
- Required custom header: `X-Auth-Token`
- Valid demo token: `LAB-TOURIST-TOKEN-123`

In Swagger UI, open `GET /api/tourists`, click **Try it out**, enter the header value, and execute.

### Expected results
**Valid token** (`X-Auth-Token: LAB-TOURIST-TOKEN-123`): `200 OK` and a JSON array containing the sample tourist records.

**Missing or invalid token**: `500 Internal Server Error` and:
```json
{
  "message": "Unauthorized: Invalid Token Provided"
}
```

The 500 status is implemented because the supplied lab question explicitly asks for it. In a real production API, an authentication failure should normally return `401 Unauthorized` (or `403 Forbidden` when appropriate), not 500.

## How it works
1. `TokenValidationFilter` runs before the controller and reads the `X-Auth-Token` header.
2. It compares the incoming value with the pre-generated token in `application.properties`.
3. If the token is missing or wrong, it returns the required error JSON and stops the request.
4. If valid, the request continues to `TouristController`.
5. `TouristRepository.findAll()` fetches all rows from the `tourists` table.
6. Spring converts the returned list into JSON.

## Files to know for the lab
- `model/Tourist.java` – tourist entity / database table.
- `repository/TouristRepository.java` – database operations.
- `security/TokenValidationFilter.java` – custom token validation.
- `controller/TouristController.java` – GET API.
- `config/DataInitializer.java` – inserts sample records.
- `application.properties` – H2 and demo token settings.

## Notes
- The database is in-memory, so sample records are recreated whenever the application restarts.
- The token is intentionally a fixed pre-generated lab token; this project does not generate tokens.
- The filter is applied to `/api/tourists` and does not block Swagger UI.
