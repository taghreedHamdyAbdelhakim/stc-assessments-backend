# stc-assessments-backend
1- Build maven project using cmd : 
mvn install -DskipTests .


2- Run docker compose  using cmd :
docker-compose up --build .


3- Create Space API (run post api in postman ) :  http://localhost:8080/item/saveSpace?name=stc-assessments&type=space&permisstionGroupName=admin


4- Create Folder Item API (run post api in postman ) :  http://localhost:8080/item/saveItemChild?name=backend&parentItemName=stc-assessments&userEmail=admin@stc.com

5- Create File Item API (run post api in postman ) :  http://localhost:8080/item/saveItemChild?name=assessment.pdf&parentItemName=backend&userEmail=admin@stc.com
