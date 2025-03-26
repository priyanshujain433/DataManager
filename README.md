# User CRUD API

## Overview
This is a Spring Boot-based RESTful API for managing users with basic CRUD (Create, Read, Update, Delete) operations. It includes pagination, validation, exception handling, and unit tests using Mockito.

## Features
- Create a user
- Retrieve a user by ID
- Retrieve all users with pagination
- Update a user
- Delete a user
- Bulk user creation
- Manual validation class for input validation
- Exception handling
- JUnit tests with Mockito

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL/MySQL (Configurable)
- Mockito (For unit testing)

## Endpoints
| HTTP Method | Endpoint        | Description |
|------------|----------------|-------------|
| GET        | /users?page=0&size=10 | Get all users with pagination |
| GET        | /users/{id}    | Get user by ID |
| POST       | /users         | Create a new user |
| POST       | /users/bulk    | Create multiple users |
| PUT        | /users/{id}    | Update a user |
| DELETE     | /users/{id}    | Delete a user |

## Request and Response Examples
### Create User
**Request:**
```json
POST /users
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 30,
"address":{
        "addId": 1,
        "houseNumber": "7-C-20",
        "area": "M.N.3",
        "city": "Kota",
        "state": "Rajasthan",
        "pincode": 324005
}
```
**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 30,
        "address":{
        "addId": 1,
        "houseNumber": "7-C-20",
        "area": "M.N.3",
        "city": "Kota",
        "state": "Rajasthan",
        "pincode": 324005
        }
}
```

### Get User by ID
**Request:**
```json
GET /users/1
```
**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com",
  "age": 30,
        "address":{
        "addId": 1,
        "houseNumber": "7-C-20",
        "area": "M.N.3",
        "city": "Kota",
        "state": "Rajasthan",
        "pincode": 324005
        }
}
```

### Error Handling
If validation fails or a user is not found, appropriate error messages are returned.
```json
{
  "error": "User not found"
}
```

## Setup and Running the Project
1. Clone the repository.
2. Update `application.properties` with your database configuration.
3. Build the project 
4. Run the application

## Running Tests
run jUnit tests

## Future Improvements
- Implement authentication and authorization
- Add more advanced validation
- Enhance logging and monitoring

---
This project demonstrates a clean architecture for building scalable user management APIs in Spring Boot.

