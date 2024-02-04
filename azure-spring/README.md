# azure-demo

This project is to test the azure storage (container blob storage and queues), this also has CRUD app that connects to local DB (can also be modigied to point to azure databse)

Prior to running the app amke sure you have .env file created in the project folder and define the following properties

PORT=
AZURE_STORAGE=
ZURE_STORAGE_ACCOUNT_NAME=
AZURE_STORAGE_SUBSCRIPTION_ID=
AZURE_STORAGE_RESOURCE_GROUP=
AZURE_STORAGE_CONNECTION_STRING=
AZURE_STORAGE_ACCOUNT_KEY=
AZURE_STORAGE_QUEUE_NAME=
DB_PASSWORD=
JDBC_URL=
AZURE_STORAGE_CONTAINER_NAME=
AZURE_STORAGE_CONTAINER_FILE_NAME=

If you are using Intellij, then make sure that in the run configuration you specify this environment variable file
