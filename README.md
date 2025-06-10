# Dịch Vụ Thống Kê Nhân Viên (Employee Statistics Service)

## Giới Thiệu

Dự án **Employee Statistics Service** là một ứng dụng web được xây dựng bằng Spring Boot để quản lý và thống kê thông tin nhân viên trong tổ chức. Ứng dụng cung cấp các API RESTful để thực hiện các thao tác CRUD với dữ liệu nhân viên và tạo các báo cáo thống kê chi tiết.

## Công Nghệ Sử Dụng

- **Java 17** - Ngôn ngữ lập trình chính
- **Spring Boot 3.4.4** - Framework phát triển ứng dụng
- **Spring Data JPA** - ORM và quản lý dữ liệu
- **MySQL** - Cơ sở dữ liệu
- **Maven** - Quản lý dependencies và build
- **Lombok** - Giảm thiểu boilerplate code
- **Spring Boot DevTools** - Hỗ trợ phát triển

## Yêu Cầu Hệ Thống

- Java 17 hoặc cao hơn
- Maven 3.6+ 
- MySQL 8.0+
- RAM tối thiểu: 2GB
- Dung lượng ổ đĩa: 1GB

## Cài Đặt và Chạy Ứng Dụng

### 1. Clone dự án
```bash
git clone <repository-url>
cd employee-statistics-service
```

### 2. Cấu hình cơ sở dữ liệu
Tạo database MySQL và cập nhật thông tin kết nối trong file `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_statistics
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Chạy ứng dụng

#### Sử dụng Maven Wrapper (khuyến nghị):
```bash
./mvnw spring-boot:run
```

#### Hoặc sử dụng Maven:
```bash
mvn spring-boot:run
```

#### Build JAR file:
```bash
./mvnw clean package
java -jar target/employee-statistics-service-0.0.1-SNAPSHOT.jar
```

Ứng dụng sẽ chạy trên port 8080: http://localhost:8080

## Cấu Trúc Dự Án

```
employee-statistics-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/example/
│   │   │       ├── controller/     # REST Controllers
│   │   │       ├── service/        # Business Logic
│   │   │       ├── repository/     # Data Access Layer
│   │   │       ├── entity/         # JPA Entities
│   │   │       ├── dto/            # Data Transfer Objects
│   │   │       └── config/         # Configuration Classes
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/                       # Unit Tests
├── target/                         # Build output
├── pom.xml                         # Maven configuration
└── README.md
```

## API Endpoints

### Quản Lý Nhân Viên
- `GET /api/employees` - Lấy danh sách tất cả nhân viên
- `GET /api/employees/{id}` - Lấy thông tin nhân viên theo ID
- `POST /api/employees` - Tạo nhân viên mới
- `PUT /api/employees/{id}` - Cập nhật thông tin nhân viên
- `DELETE /api/employees/{id}` - Xóa nhân viên

### Thống Kê
- `GET /api/statistics/total` - Tổng số nhân viên
- `GET /api/statistics/by-department` - Thống kê theo phòng ban
- `GET /api/statistics/by-position` - Thống kê theo vị trí
- `GET /api/statistics/salary-range` - Thống kê theo mức lương

## Chạy Tests

```bash
# Chạy tất cả tests
./mvnw test

# Chạy tests với coverage report
./mvnw test jacoco:report
```

## Môi Trường Phát Triển

### IDE được khuyến nghị:
- IntelliJ IDEA
- Eclipse
- Visual Studio Code với Extension Pack for Java

### Plugins hữu ích:
- Lombok Plugin
- Spring Boot Tools
- Git Integration

## Đóng Góp

1. Fork dự án
2. Tạo feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit thay đổi (`git commit -m 'Add some AmazingFeature'`)
4. Push lên branch (`git push origin feature/AmazingFeature`)
5. Mở Pull Request

## Coding Standards

- Sử dụng Java Code Style của Google
- Viết unit tests cho tất cả business logic
- Sử dụng meaningful commit messages
- Tuân thủ nguyên tắc SOLID principles

## Troubleshooting

### Lỗi thường gặp:

1. **Lỗi kết nối database:**
   - Kiểm tra MySQL service đã chạy chưa
   - Xác nhận thông tin kết nối trong application.properties

2. **Port 8080 đã được sử dụng:**
   - Thay đổi port trong application.properties: `server.port=8081`

3. **Out of Memory:**
   - Tăng heap size: `java -Xmx2g -jar target/employee-statistics-service.jar`

## Phiên Bản

- **v0.0.1-SNAPSHOT** - Phiên bản phát triển hiện tại


## Liên Hệ

- Email: dattq.b21cn222@stu.ptit.edu.vn
- Project Link: [https://github.com/quydatsadboy/employee-statistics-service](https://github.com/yourusername/employee-statistics-service)

---

⭐ Nếu dự án này hữu ích, hãy cho một star nhé!