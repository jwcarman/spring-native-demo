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

Testing out the API is simple using [httpie](https://httpie.io/)!

#### Creating a Person

To create a new `Person` record, execute the following:

```shell
http POST localhost:8080/persons firstName=Spring lastName=Native
```

You should see output similar to the following:

```shell
HTTP/1.1 201
Connection: keep-alive
Content-Type: application/json
Date: Sat, 18 Mar 2023 18:51:34 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "Spring",
    "id": "cddaca53-214c-459a-8eae-96b19a29577f",
    "lastName": "Native"
}
```

#### Finding a Person

To find an existing `Person` record, execute the following:

```shell
http localhost:8080/persons/cddaca53-214c-459a-8eae-96b19a29577f
```

You should see output similar to the following:

```shell
HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Sat, 18 Mar 2023 18:54:33 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "Spring",
    "id": "cddaca53-214c-459a-8eae-96b19a29577f",
    "lastName": "Native"
}
```

#### Updating a Person

To update an existing `Person` record, execute the following:

```shell
http PUT localhost:8080/persons/cddaca53-214c-459a-8eae-96b19a29577f firstName=Spring lastName=Boot
```

You should see output similar to the following:

```shell
HTTP/1.1 200
Connection: keep-alive
Content-Type: application/json
Date: Sat, 18 Mar 2023 18:55:42 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "Spring",
    "id": "cddaca53-214c-459a-8eae-96b19a29577f",
    "lastName": "Boot"
}
```

#### Deleting a Person

To delete an existing `Person` record, execute the following:

```shell
http DELETE localhost:8080/persons/cddaca53-214c-459a-8eae-96b19a29577f
```

You should see output similar to the following:

```shell
HTTP/1.1 200
Connection: keep-alive
Content-Length: 0
Date: Sat, 18 Mar 2023 18:56:49 GMT
Keep-Alive: timeout=60
```