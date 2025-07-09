# Message Queue Project

A Spring Boot microservices project demonstrating message queue implementation using RabbitMQ. The project consists of a producer service that sends messages and a consumer service that processes them asynchronously.

## Technologies Used

- **Java 21**
- **Spring Boot 3.5.3**
- **Spring AMQP** (RabbitMQ integration)
- **RabbitMQ 3** with Management Plugin
- **Docker & Docker Compose**

## Prerequisites

- Docker and Docker Compose
- Java 21 (for local development)
- Maven (for local development)

## Quick Start

### Using Docker Compose (Recommended)

1. Clone the repository:

```bash
git clone <repository-url>
cd message-queue
```

2. Start all services:

```bash
docker-compose up --build
```

This will start:

- RabbitMQ server on port 5672 (AMQP) and 15672 (Management UI)
- Producer service on port 8080
- Consumer service on port 8081

### Local Development

1. Start RabbitMQ locally or use Docker:

```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

2. Set environment variables:

```bash
export RABBITMQ_HOST=localhost
export RABBITMQ_PORT=5672
export RABBITMQ_USER=guest
export RABBITMQ_PASSWORD=guest
export QUEUE_NAME=my_queue
export EXCHANGE_NAME=my_exchange
export ROUTING_KEY=my_routing_key
```

3. Build and run services:

```bash
# Producer
cd producer
./mvnw spring-boot:run

# Consumer (in another terminal)
cd consumer
./mvnw spring-boot:run
```

## API Endpoints

### Producer Service

#### Send Message

- **URL**: `POST /produce`
- **Port**: 8080
- **Content-Type**: `application/json`
- **Body**: Plain text message

**Example:**

```bash
curl -X POST http://localhost:8080/produce \
  -H "Content-Type: application/json" \
  -d "Hello, RabbitMQ!"
```

## RabbitMQ Management UI

Access the RabbitMQ Management UI at: `http://localhost:15672`

- **Username**: `guest`
- **Password**: `guest`

The management UI provides:

- Queue statistics and message counts
- Exchange and binding information
- Connection and channel details
- Message rates and throughput metrics
