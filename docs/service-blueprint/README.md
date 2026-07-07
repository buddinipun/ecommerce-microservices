# Service Blueprint

This module defines the standard structure for all microservices.

## Standard Package Layout

src/main/java/com/ecommerce/{service-name}/

- config
- controller
- dto
- entity
- exception
- mapper
- repository
- service
- validation

## Required Features

- Spring Boot 3.x
- Flyway migrations
- BaseAuditEntity usage
- DTO-based API design
- Global Exception Handling
- OpenAPI documentation
- Docker support
- Health checks

## Rules

- No business logic in controllers
- No entity exposure in APIs
- All DB changes via Flyway
- UUID primary keys