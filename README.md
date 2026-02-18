# RESTful API Assignment - Product Management System

A Spring Boot REST API for managing products with complete CRUD (Create, Read, Update, Delete) operations integrated with PostgreSQL database.

---

## 📋 Features

✅ **Create** - Add new products  
✅ **Read** - Retrieve all products or specific product by ID  
✅ **Update** - Modify existing product details  
✅ **Delete** - Remove products from the database  
✅ **Error Handling** - Proper HTTP status codes and messages  
✅ **PostgreSQL Integration** - Persistent data storage  

---

## 🛠️ Technologies Used

- **Java** - Programming language
- **Spring Boot** - REST API framework
- **Spring Data JPA** - Database ORM
- **PostgreSQL** - Database
- **Maven** - Build tool
- **Hibernate** - ORM tool

---

## 🚀 Installation & Setup

### 1. Clone or Download Project
\`\`\`bash
git clone https://github.com/Gikundiroleondrie/CRUD_27192.group_E.git
cd restfullApiAssignment
\`\`\`

### 2. Create PostgreSQL Database
\`\`\`sql
CREATE DATABASE ecommerce_bd;
\`\`\`

### 3. Configure Database Connection
Edit \`src/main/resources/application.properties\`:
\`\`\`properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_bd
spring.datasource.username=postgres
spring.datasource.password=123gikundiro
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
\`\`\`

### 4. Build Project
\`\`\`bash
mvn clean install
\`\`\`

### 5. Run Application
\`\`\`bash
mvn spring-boot:run
\`\`\`

The API will start on **http://localhost:8080**

---

## 🔌 API Endpoints

### Base URL
\`\`\`
http://localhost:8080/api/products
\`\`\`

---

### **1. CREATE - Add New Product**
\`\`\`http
POST /api/products/addProduct
Content-Type: application/json

{
  "id": 1,
  "name": "Laptop",
  "description": "Dell XPS 13",
  "price": 999.99,
  "category": "Electronics",
  "stockQuantity": 10
}
\`\`\`

**Response (201 Created):**
\`\`\`json
"Product saved successfully."
\`\`\`

---

### **2. READ - Get All Products**
\`\`\`http
GET /api/products
\`\`\`

**Response (200 OK):**
\`\`\`json
[
  {
    "id": 1,
    "name": "Laptop",
    "description": "Dell XPS 13",
    "price": 999.99,
    "category": "Electronics",
    "stockQuantity": 10
  },
  {
    "id": 2,
    "name": "iPhone 15",
    "description": "Apple iPhone 15 Pro Max",
    "price": 1299.99,
    "category": "Electronics",
    "stockQuantity": 15
  }
]
\`\`\`

---

### **3. READ - Get Product by ID**
\`\`\`http
GET /api/products/1
\`\`\`

**Response (200 OK):**
\`\`\`json
{
  "id": 1,
  "name": "Laptop",
  "description": "Dell XPS 13",
  "price": 999.99,
  "category": "Electronics",
  "stockQuantity": 10
}
\`\`\`

**Response (404 Not Found):**
\`\`\`json
"Product with id 1 not found."
\`\`\`

---

### **4. UPDATE - Update Existing Product**
\`\`\`http
PUT /api/products/1
Content-Type: application/json

{
  "name": "Gaming Laptop Pro",
  "description": "Dell XPS 13 with RTX Graphics",
  "price": 1499.99,
  "category": "Gaming Electronics",
  "stockQuantity": 5
}
\`\`\`

**Response (200 OK):**
\`\`\`json
"Product updated successfully."
\`\`\`

**Response (404 Not Found):**
\`\`\`json
"Product with id 1 not found."
\`\`\`

---

### **5. DELETE - Delete Product**
\`\`\`http
DELETE /api/products/1
\`\`\`

**Response (200 OK):**
\`\`\`json
"Product deleted successfully."
\`\`\`

**Response (404 Not Found):**
\`\`\`json
"Product with id 1 not found."
\`\`\`

---

## 🧪 Testing with Postman

### Using REST Client Extension (VS Code)
Create a \`test.http\` file:
\`\`\`http
### Get all products
GET http://localhost:8080/api/products

### Create product
POST http://localhost:8080/api/products/addProduct
Content-Type: application/json

{
  "id": 1,
  "name": "Laptop",
  "description": "Dell XPS 13",
  "price": 999.99,
  "category": "Electronics",
  "stockQuantity": 10
}

### Get product by ID
GET http://localhost:8080/api/products/1

### Update product
PUT http://localhost:8080/api/products/1
Content-Type: application/json

{
  "price": 1299.99,
  "stockQuantity": 5
}

### Delete product
DELETE http://localhost:8080/api/products/1
\`\`\`

### Using cURL
\`\`\`bash
# Create
curl -X POST http://localhost:8080/api/products/addProduct \
  -H "Content-Type: application/json" \
  -d '{"id":1,"name":"Laptop","description":"Dell XPS 13","price":999.99,"category":"Electronics","stockQuantity":10}'

# Read All
curl http://localhost:8080/api/products

# Read by ID
curl http://localhost:8080/api/products/1

# Update
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"price":1299.99,"stockQuantity":5}'

# Delete
curl -X DELETE http://localhost:8080/api/products/1
\`\`\`

---

## 📊 Database Schema

**Table: product**

| Column | Type | Constraints |
|--------|------|-------------|
| id | bigint | PRIMARY KEY |
| name | varchar(255) | NOT NULL |
| description | varchar(255) | |
| price | double precision | |
| category | varchar(255) | |
| stock_quantity | integer | |

---

## 🐛 Troubleshooting

### Database Connection Error
- Verify PostgreSQL is running
- Check database credentials in \`application.properties\`
- Ensure database \`ecommerce_bd\` exists

### Hibernate Table Not Created
- Verify \`spring.jpa.hibernate.ddl-auto=update\` in properties
- Check application logs for errors

---

## 📝 CRUD Operations Summary

| Operation | Method | Endpoint | Status |
|-----------|--------|----------|--------|
| **Create** | POST | \`/api/products/addProduct\` | ✅ Working |
| **Read (All)** | GET | \`/api/products\` | ✅ Working |
| **Read (By ID)** | GET | \`/api/products/{id}\` | ✅ Working |
| **Update** | PUT | \`/api/products/{id}\` | ✅ Working |
| **Delete** | DELETE | \`/api/products/{id}\` | ✅ Working |

---

## 👨‍💻 Author

Gikundiro leondrie- REST API Assignment

---

## 📜 License

This project is open source and available under the MIT License.

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork and submit pull requests.

