Run the application

From the project root
    cd infra

    run : 
        docker compose --env-file .env -f docker-compose.db.yml up -d
    
    stop:
        docker compose --env-file .env -f docker-compose.db.yml down
    
    To stop and remove volumes
        docker compose --env-file .env -f docker-compose.db.yml down -v
    

Connect to DB from Adminer mysql client
    Open:
        http://localhost:8088

    Use:
    System: MySQL
    Server: mysql (if Adminer is inside Docker network)
    Username: root
    Password: root

Connect to mongo 
    Mongo Express
    Open:
        http://localhost:8089

1. Create databases in mysql using sql commands under the mysql/init path 


