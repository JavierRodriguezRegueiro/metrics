# Metrics. :construction: Work in progress
Simple service to save and find metrics

## How To Start

1. Create JAR file: `./mvnw clean package -DskipTests`
2. Go to `src/main/java/com/factorial/metrics/web/frontend` and run `npm intall`
3. Go into script folder and execute:  `./prod-mode.sh`. It will change some application properties and run docker-compose

For develop proposes:

1. Go into script folder and execute:  `./dev-mode.sh`. It will run mongodb and mongo-express only.
2. Run the main class **MetricsApplication.java** 
3. Go to `src/main/java/com/factorial/metrics/web/frontend` and run `npm intall` and then `npm start`.


After that, the frontend will be running in `localhost:3000` and the backend API in `localhost:8080`

## API

| Request                        | Type   | Parameters                                                                                                                                                                   |
|--------------------------------|--------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| /metrics/{id}                  | PUT    | <ul><li>id (String in the URL): Metric id</li><li>timestamp (Timestamp): Metric timestamp</li><li>name (String): Metric name</li> <li>value (String): Metric value</li></ul> |
| /metrics?init={init}&end={end} | GET    | <ul><li>init (Timestamp): Initial date</li><li> end (Number): end date</li></ul>                                                                                             |
## Tests execution

- Backend tests: Inside root project directory, exec `./mvnw test`
- Frontend tests: Inside `src/main/java/com/factorial/metrics/web/frontend` exec `npm test`

## About the project

This service follows Hexagonal clean architecture to avoid having dependencies with the UI and the database. In the same
way, this project tries to do not have anemic classes (without logic) and to be more testable.

### Used technologies

- Java spring boot
- React
- Jest
- Docker


