# Movie Ticket Booking System

A complete starter web application converted to **Spring Boot + Hibernate/JPA + MySQL + Thymeleaf + Bootstrap**.

## Features
- User registration and login
- Browse/search movies
- View shows by movie
- Select seats and book tickets
- Booking confirmation and My Bookings
- Simulated payment record
- Admin dashboard
- Admin CRUD for movies, theatres, screens, and shows
- JPA/Hibernate entity relationships
- REST endpoints for movies and shows
- Responsive frontend

## Tech Stack
Java 17, Spring Boot 3.5.5, Spring Data JPA/Hibernate, MySQL, Thymeleaf, HTML5, CSS3, Bootstrap 5, Maven.

## Run
1. Create MySQL database `movie_ticket_booking_system`.
2. Open `src/main/resources/application.properties` and set your MySQL username/password.
3. Run `mvn spring-boot:run` or run `MovieTicketBookingApplication` from IntelliJ/Eclipse.
4. Open `http://localhost:8080`.

The application uses `spring.jpa.hibernate.ddl-auto=update`, so tables are created/updated automatically from entities. A seed initializer creates sample admin/user, movies, theatre, screen, seats and shows on first run.

### Demo accounts
- Admin: `admin@movieticket.com` / `admin123`
- User: `user@movieticket.com` / `user123`

> Passwords are intentionally simple for this academic/demo project. For production, use Spring Security and BCrypt.
