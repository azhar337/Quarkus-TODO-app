# Quarkus-TODO-app

## Step to run
- Clone the repository 
```sh
   git clone https://github.com/azhar337/Quarkus-TODO-app.git
   ```
- Load the pom.xml and download all the dependency (maven)
Get your docker running 
- Run the command on the terminal to get the postgres running :
```sh
docker run --name todo -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -e POSTGRE_DB=todo -p 5432:5432 postgres:10.5 
```
