Run the application

1. From the project root
    cd infra

    run : 
        docker compose --env-file .env -f docker-compose.db.yml up -d
    
    stop:
        docker compose --env-file .env -f docker-compose.db.yml down
    
    To stop and remove volumes
        docker compose --env-file .env -f docker-compose.db.yml down -v
    
2. Connect to DB from Adminer mysql client
    Open:
        http://localhost:8088

    Use:
    System: MySQL
    Server: mysql (if Adminer is inside Docker network)
    Username: root
    Password: root

3. Connect to mongo 
    Mongo Express
    Open:
        http://localhost:8089

4. Create databases in mysql using sql commands under the mysql/init path 




