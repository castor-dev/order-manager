# order-manager

## Running instructions

1.  At the project root directory, build the package with the following command:
```bash
mvn clean package
```
2. With the package built, run the docker compose file:
```bash
docker-compose up -d
```

## Application usage

- Once the application is started, it is available on `http://localhost:8085`
- The API endpoints description are available on the file `./reference/order-manager-api`
  -  To run the applicaion, is it possible to import this file to a tool such as Postman
