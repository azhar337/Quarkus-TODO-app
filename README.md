# Quarkus-TODO-app

## Introduction
This project is intended to do a TODO webapp with google login. The webapp is done using quarkus. The webapp will recieve google jwt token from front end and the user email will be used to store todo list.

The web app will able to:
1. Add list 
2. Mark list as done
3. Delete list 
4. View list

Unfotunantly the webapp is not tested with the google jwt token therefore the webapp contain 2 version.

1. The oauth2 verification
   - Not tested using google jwt token as it have inspection url problem
2. Normal jwt token
   - Tested using normal jwt token with public key but not with google jwt token

In this documentation we will have guide to run both the version.

## Build with
* [Quarkus](https://quarkus.io/)

## Step to run

### The oauth2 verificaiton

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
- Configure the client id and secret in the application.properties . See [this](https://www.balbooa.com/gridbox-documentation/how-to-get-google-client-id-and-client-secret) to get the client id and secret.

- Run quarkus 
```sh
   ./mvnw compile quarkus:dev
```
NOTE : This version of webapp is not tested and have high chance of not running as intended.

### The Normal JWT Token
- Clone the repository 
```sh
   git clone https://github.com/azhar337/Quarkus-TODO-app.git
   ```
- Change the head to 2aa6681e87b737e252faa4bf80006a1be8049062 
```sh
   git checkout 2aa6681e87b737e252faa4bf80006a1be8049062
   ```
- Load the pom.xml and download all the dependency (maven) Get your docker running 
- Run the command on the terminal to get the postgres running :
```sh
docker run --name todo -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -e POSTGRE_DB=todo -p 5432:5432 postgres:10.5 
```
- Go to https://dinochiesa.github.io/jwt/ and get your public key and paste it at resource/jwtkey/test

- Add this string inside the Decoded Payload section at the https://dinochiesa.github.io/jwt/ 
```sh
 "groups": [
    "ROLE_USER"
  ]
```
- Get the generted token and use it to access the todo api end point
- Run quarkus 
```sh
   ./mvnw compile quarkus:dev
```
NOTE : This is stable verison and working with no issue

## Docker 

### The oauth2 verificaiton
```sh
docker pull afwe234f/quarkus:todo-oauth-jvm
```

```sh
docker run -i --rm -e QUARKUS_OAUTH_CLIENT_ID=xxx -e QUARKUS_OAUTH_CLIENT_SECRET=xxx -e QUARKUS_OAUTH_INTROSPECTION_URL=xxx -p 8080:8080 afwe234f/quarkus:todo-jvm
```


### The Normal JWT Token
```sh
docker pull afwe234f/quarkus:todo-jvm
```

```sh
docker run -i --rm -p 8080:8080 afwe234f/quarkus:todo-jvm
```


<!-- LICENSE -->
## License

Distributed under the MIT License.


<!-- CONTACT -->
## Contact

Your Name - [@123](https://twitter.com/123) - 123@gmail.com

Project Link: [https://github.com/azhar337/Quarkus-TODO-app](https://github.com/azhar337/Quarkus-TODO-app)
