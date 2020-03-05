# fraud-check-service
Fraud Check Service

docker network create -d bridge social-insurance  
docker network ls  

docker build -t gar2000b/fraud-check-service .  
docker run -it -d -p 9083:9083 --network="social-insurance" --name fraud-check-service gar2000b/fraud-check-service  

All optional:

docker create -it gar2000b/fraud-check-service bash  
docker ps -a  
docker start ####  
docker ps  
docker attach ####  
docker remove ####  
docker image rm gar2000b/fraud-check-service  
docker exec -it fraud-check-service sh  
docker login  
docker push gar2000b/fraud-check-service  