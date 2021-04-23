##RUN Local
### Create custom docker network
`docker network create --driver bridge speedway-net`

### Run Postgres DB (dockerized)
`docker run --network speedway-net -p 5432:5432 --name speedway-postgres --rm -e POSTGRES_DB=speedway_db -e POSTGRES_PASSWORD=open -d postgres`

### Build the app image
`docker build -t speedway:dev .`

### Run the docker app image on developer machine
`docker run --name speedway --network speedway-net --rm -e PORT=8080 -e SPRING_PROFILES_ACTIVE=docker -p 9000:8080 -d speedway:dev`

### Heroku Deployment
URL: https://alpha-speedwaytrials-app.herokuapp.com/docs/index.html