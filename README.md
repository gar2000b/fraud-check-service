# fraud-check-service
Fraud Check Service

docker network create -d bridge social-insurance  
docker network ls  

docker build -t onlineinteract/fraud-check-service .  
docker run -it -d -p 9083:9083 --network="social-insurance" --name fraud-check-service onlineinteract/fraud-check-service  

All optional:

docker create -it onlineinteract/fraud-check-service bash  
docker ps -a  
docker start ####  
docker ps  
docker attach ####  
docker remove ####  
docker image rm onlineinteract/fraud-check-service  
docker exec -it fraud-check-service sh  