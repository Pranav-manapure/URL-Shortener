# 🌐 URL Shortener Application

A simple and efficient **URL Shortener** application built using **Spring Boot**. This project allows users to shorten URLs, retrieve the original URL using the short link, and track the top 3 domains based on usage metrics.

---

## 📑 Table of Contents
- [✨ Features](#-features)
- [📂 Directory Structure](#-directory-structure)
- [🔗 REST API Endpoints](#-rest-api-endpoints)
- [💻 Technologies Used](#-technologies-used)
- [⚙️ Setup and Installation](#%EF%B8%8F-setup-and-installation)
- [📸 Screenshots](#-screenshots)
- [✅ Unit Tests](#-unit-tests)
- [👥 Contributors](#-contributors)

---

## Project Overview

The URL Shortener Application provides a seamless way to shorten long URLs and redirect to the original links using the shortened URL. It includes domain-level metrics to track the number of times URLs from specific domains have been shortened, with support for returning the top 3 domains.

---

## ✨ Features
- ✂️ Shorten long URLs into concise short URLs.
- 🔄 Retrieve the original URL using the shortened link.
- 📊 Metrics API to track the **top 3 domains** with the most shortened URLs.
- 🔗 RESTful API: Accessible via standardized API endpoints.
- 🐳 Dockerized Deployment: Easily deployable using Docker.
- ✅ Built-in **unit tests** for application functionality.

---

## 📂 Directory Structure


![image](https://github.com/user-attachments/assets/80fc6bfb-9d92-46af-b352-9b179588e18d)



---

## 🔗 REST API Endpoints

| **HTTP Method** | **Endpoint**                  | **Description**                                                                                | **Request Body**                                   | **Response**                                |
|------------------|-------------------------------|------------------------------------------------------------------------------------------------|---------------------------------------------------|--------------------------------------------|
| `POST`          | `/shorten`                   | Shortens the provided URL.                                                                     | `{ "originalUrl": "https://www.linkedin.com/in/pranav-manapure/" }` | Shortened URL as a string.                |
| `GET`           | `/{shortUrl}`                | Redirects to the original URL associated with the short URL.                                   | None                                              | Redirects to the original URL.             |
| `GET`           | `/metrics/domains`           | Returns the top 3 domains that have been shortened the most.                                   | None                                              | JSON object with domain names and counts.  |

---

## 💻 Technologies Used
- **Java**
- **Spring Boot**
- **Maven**
- **JUnit** (for testing)

---

## Steps to Run the Project

### Prerequisites

- Java 17 or higher.
- Maven (for dependencies).
- Docker (optional, for containerized deployment).

---

## ⚙️ Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Pranav-manapure/url-shortener.git

2. Navigate to the project directory:
   ```bash
   cd url-shortener
3. Build the project:
    ```bash
    mvn clean install
4. Run the application:
    ```bash
    mvn spring-boot:run
5. Access the application at http://localhost:8080.


---

## Example Requests

### Shorten URL

   ```bash
      POST /shorten
      Content-Type: application/json
      {
        "originalUrl": "https://example.com"
      }
   ```
### Redirect to Original URL
   ```bash
      GET localhost:8080/abc123
   ```
### Get Metrics
   ```bash
      GET localhost:8080/metrics/domains
   ```
---

## 📸 Screenshots
1. Shorten URL

  ![image](https://github.com/user-attachments/assets/a728388a-0452-4c85-9096-e968167263e5)

2. Domain Metrics

  ![image](https://github.com/user-attachments/assets/b014ae4e-6bed-473b-8c6c-99062c58dc40)
  

---

## ✅ Unit Tests
Test Cases Table


| **Test Case ID** | **Test Name**             | **Input**                                                                                                   | **Expected Output**                                                     | **Remarks**                                             |
|-------------------|--------------------------|-------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------|---------------------------------------------------------|
| TC-01            | `testGenerateShortUrl1`  | Original URL: `https://www.linkedin.com/in/pranav-manapure/`                                                | A non-null shortened URL of exactly 8 characters.                        | Validates basic functionality of `generateShortUrl`.    |
| TC-02            | `testGenerateShortUrl2`  | Original URL: `https://en.wikipedia.org/wiki/Car`                                                          | A non-null shortened URL of exactly 8 characters.                        | Ensures `generateShortUrl` works for a Wikipedia link.  |
| TC-03            | `testGenerateShortUrl3`  | Complex Amazon URL.                                                                                        | A non-null shortened URL of exactly 8 characters.                        | Validates the method for complex URLs.                 |
| TC-04            | `testGenerateShortUrl4`  | Original URL: `https://www.youtube.com/watch?v=ljfdGYlcA_M`                                                 | A non-null shortened URL of exactly 8 characters.                        | Checks functionality for YouTube links.                |
| TC-05            | `testGenerateShortUrl5`  | Complex Udemy URL.                                                                                         | A non-null shortened URL of exactly 8 characters.                        | Ensures consistent results for parameter-heavy URLs.    |
| TC-06            | `testDomainMetrics`      | - Three URLs saved:                                                                                         | Domain metrics: `www.linkedin.com` → 2, `en.wikipedia.org` → 1           | Verifies the `getDomainMetrics` functionality.          |


---

## 🐳 Docker Integration

### 📁 Dockerfile

   ```bash
   FROM openjdk:17-jdk-slim
   COPY target/url-shortener-0.0.1-SNAPSHOT.jar url-shortener.jar
   ENTRYPOINT ["java", "-jar", "url-shortener.jar"]
   ```
### Steps to Build and Run Docker Image
1. Build the Docker image:
   ```bash
   docker build -t url-shortener .
2. Run the Docker container:
   ```bash
   docker run -p 8080:8080 url-shortener
3. Push to Docker Hub:
   ```bash
   docker tag url-shortener-app pranav3199/url-shortener:latest
   docker push pranav3199/url-shortener:latest
4. Share the image with reviewers:
   ```bash
   docker pull pranav3199/url-shortener:latest
   docker run -p 8080:8080 pranav3199/url-shortener:latest

---

## 👥 Contributors

Pranav Sanjay Manapure
- 📧 Email: manapurepranav03@gmail.com
- 🔗 LinkedIn: linkedin.com/in/pranav-manapure
- 🐙 GitHub: github.com/Pranav-manapure
