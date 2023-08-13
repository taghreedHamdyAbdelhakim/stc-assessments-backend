# stc-assessments-backend
Build maven project using cmd : mvn install -DskipTests
Run docker compose  using cmd : docker-compose up --build
Create Space API (run post api in postman ) :  http://localhost:8080/item/saveSpace?name=stc-assessments&type=space&permisstionGroupName=admin
Create Folder Item API (run post api in postman ) :  http://localhost:8080/item/saveItemChild?name=backend&parentItemName=stc-assessments&userEmail=admin@stc.com

Create File Item API (run post api in postman ) :  http://localhost:8080/item/saveItemChild?name=assessment.pdf&parentItemName=backend&userEmail=admin@stc.com
