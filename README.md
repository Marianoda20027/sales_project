# University Project — Software Engineering Course

This project was developed as part of the **Software Engineering course** at university. It consists of an **e-commerce platform** designed to enable **local small and medium-sized enterprises (SMEs)** to publish and sell their products online.

The platform allows users to:

- Browse a catalog of products from various vendors
- Manage shopping carts and user accounts
- Complete secure purchases through an intuitive interface

## Architecture and Technologies

To meet scalability, maintainability, and modular design goals, the platform was built using a **microservices architecture**, which provides independent service deployment and clear separation of responsibilities.

### Key technologies used:

- **Backend (Microservices)**:
  - Spring Boot for developing RESTful services
  - Spring Cloud for service discovery and load balancing
  - Kafka as the message broker to enable asynchronous communication between services
  - Zookeeper to coordinate distributed services and Kafka

- **Frontend**:
  - Vite for fast development and optimized builds
  - React for creating a responsive and dynamic user interface
