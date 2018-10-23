# Headless CMS Proof of Concept - Strapi

A simple Spring Boot application that reads from and writes to a headless CMS. For this proof of concept, the headless
CMS solution being showcased is [Strapi](https://strapi.io/).

## Setting up Strapi

Strapi provides a project on GitHub that includes a compose file that can be used to run Strapi in a container. The
compose file starts up a both the Strapi API and a Mongo instance.

```bash
$ git clone https://github.com/strapi/strapi-docker.git
$ docker-compose up -d
```

You can now access the Strapi API at `http://YOUR_DOCKER_HOST:1337/`. Browse to `http://YOUR_DOCKER_HOST:1337/admin`
to create a user account.

## Configuring Proof of Concept Application

By default, the application will attempt to connect to the Strapi API on `localhost:1337`. If the API is running
somewhere else, you can override the default behaviour by setting the `STRAPI_API_HOST` environment variable to
the correct host and port for your Strapi API instance.

## Running the Proof of Concept Application

```bash
$ mvn spring-boot:run
```

If you do not have Maven installed, you can use the Maven Wrapper that is included with the project instead.

```bash
$ ./mvnw spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## Setting up Data

Some things need to be set up in the Strapi admin application before the proof of concept application can begin to
access the API. The application will attempt to read from a single content type called "products". The content type
and its role access must be defined manually.

1. Create the content type.
   * Click "Content Type Builder" and then "Add Content Type".
   * Enter the name "product".
   * Click "Save".
   * Click "Add New Field", select "String", enter the name "name", and click "Add New Field".
   * Select "String", enter the name "description" and click "Add New Field".
   * Select "Number" and number format "decimal", enter the name "price", and click "Continue".
3. Grant access to the new content type for authenticated users.
   * Click "Roles & Permission" and then select "Authenticated".
   * Click "Select All" under "Permissions" and then click "Save".

## Observations

* Appears to be an extremely flexible API.
