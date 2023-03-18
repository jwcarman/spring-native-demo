# Spring Native Demo Application

A demo application to illustrate how to build and run a Spring Boot application using Spring Native.

## Building

Using Maven, execute the following command to build the native image:
```shell
mvn -Pnative spring-boot:build-image
```

## Running

Once the image is built, you can run it using Docker:

```shell
docker run --rm -p 8080:8080 docker.io/library/spring-native-demo:0.0.1-SNAPSHOT
```

## Testing

Using [httpie](https://httpie.io/), execute the following command:

```shell
http localhost:8080/persons/12345
```

You should see output similar to the following:

```shell
HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Sat, 18 Mar 2023 14:21:30 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "Spring",
    "id": "12345",
    "lastName": "Native"
}
```


