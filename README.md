# Spring Boot Native Image Demo

A demo application to illustrate how to build and run a Spring Boot native image.

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

To see the resources consumed by this Docker container:

```shell
docker stats
```

The output should look similar to the following:

```shell
CONTAINER ID   NAME                 CPU %     MEM USAGE / LIMIT    MEM %     NET I/O           BLOCK I/O        PIDS
6c4ded529676   awesome_fermi        0.01%     67.6MiB / 31.3GiB    0.21%     1.63kB / 746B     0B / 0B          19
```

Here, we see that our natively-built Spring Boot application is only using `67.6BiB` of memory! Let's compare that with
a container running using a non-native Spring Boot application:

```shell
CONTAINER ID   NAME                 CPU %     MEM USAGE / LIMIT    MEM %     NET I/O           BLOCK I/O        PIDS
b7edbc9c7a23   zealous_montalcini   0.08%     419.2MiB / 31.3GiB   1.31%     4.03kB / 2.73kB   0B / 463kB       49
```

That's quite a difference!

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