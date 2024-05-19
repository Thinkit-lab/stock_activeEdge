# Stock Management API

This is a Java-based backend application built using Spring Boot. It provides a RESTful API for managing stock information. The application supports basic CRUD operations such as creating, reading, updating, and listing stocks.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [License](#license)

## Features

- List all stocks
- Get details of a specific stock by ID
- Create a new stock
- Update the price of an existing stock

## Technologies Used

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- H2 Database
- Lombok

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/thinkit-lab/stock_activeEdge.git


### API Endpoints

1. **List All Stocks**

   - **URL:** `/api/v1/stocks`
   - **Method:** `GET`
   - **Response:**
     ```json
     [
       {
         "id": 1,
         "name": "Apple",
         "currentPrice": 145.30,
         "createDate": "2023-10-12T07:20:50.52",
         "lastUpdate": "2023-10-12T07:20:50.52"
       },
       {
         "id": 2,
         "name": "Google",
         "currentPrice": 2731.45,
         "createDate": "2023-10-12T07:20:50.52",
         "lastUpdate": "2023-10-12T07:20:50.52"
       }
     ]
     ```

2. **Get Stock by ID**

   - **URL:** `/api/v1/stocks/{id}`
   - **Method:** `GET`
   - **Response:**
     ```json
     {
       "id": 1,
       "name": "Apple",
       "currentPrice": 145.30,
       "createDate": "2023-10-12T07:20:50.52",
       "lastUpdate": "2023-10-12T07:20:50.52"
     }
     ```

3. **Create a New Stock**

   - **URL:** `/api/v1/stocks`
   - **Method:** `POST`
   - **Request Body:**
     ```json
     {
       "name": "Microsoft",
       "currentPrice": 299.80
     }
     ```
   - **Response:**
     ```json
     {
       "id": 3,
       "name": "Microsoft",
       "currentPrice": 299.80,
       "createDate": "2023-10-12T07:20:50.52",
       "lastUpdate": "2023-10-12T07:20:50.52"
     }
     ```

4. **Update Stock Price**

   - **URL:** `/api/v1/stocks/{id}`
   - **Method:** `PUT`
   - **Request Parameters:** `newPrice` (decimal)
   - **Response:**
     ```json
     {
       "id": 1,
       "name": "Apple",
       "currentPrice": 150.00,
       "createDate": "2023-10-12T07:20:50.52",
       "lastUpdate": "2023-10-12T08:30:40.30"
     }
     ```
