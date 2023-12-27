FROM eclipse-temurin:17.0.9_9-jre-jammy

MAINTAINER "Jawahar"

WORKDIR /azure-demo

COPY target/demo-0.0.1-SNAPSHOT.jar .

EXPOSE $PORT
EXPOSE $AZURE_STORAGE
EXPOSE $AZURE_STORAGE_ACCOUNT_NAME
EXPOSE $AZURE_STORAGE_SUBSCRIPTION_ID
EXPOSE $AZURE_STORAGE_RESOURCE_GROUP
EXPOSE $AZURE_STORAGE_CONNECTION_STRING
EXPOSE $AZURE_STORAGE_ACCOUNT_KEY
EXPOSE $AZURE_STORAGE_QUEUE_NAME
EXPOSE $DB_PASSWORD
EXPOSE $SQL_SERVER
EXPOSE $AZURE_STORAGE_CONTAINER_NAME
EXPOSE $AZURE_STORAGE_CONTAINER_FILE_NAME

ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]