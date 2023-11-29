# Davide Demo of Api First project that is K8S Ready

## Api Editor
https://studio.apicur.io/apis/97263/editor

## OpenApi Generator
https://openapi-generator.tech/docs/generators/spring

## Liquibase
`gradle generateChangelog`

## ETC Folder
for local dev, use the etc folder to run docker-compose with postgres 

## Docker Building Image
### Build the docker image manually
delete the plain file and run the following command to build the image
`docker build --build-arg JAR_FILE=build/libs/*.jar -t ghcr.io/avrabie/davide-demo-0.0.1 .`

### Build with gradle
`./gradlew bootBuildImage 
--imageName ghcr.io/avrabie/catalog-service 
--publishImage 
-PregistryUrl=ghcr.io 
-PregistryUsername=avrabie 
-PregistryToken=<your_github_token>`