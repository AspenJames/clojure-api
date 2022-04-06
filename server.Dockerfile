FROM clojure:openjdk-18-lein-slim-buster as build

ARG APP_DIR
ENV APP_DIR=${APP_DIR:-/usr/src/app}
RUN mkdir -p ${APP_DIR}
WORKDIR ${APP_DIR}

COPY project.clj ${APP_DIR}
RUN lein deps

COPY . ${APP_DIR}
RUN lein uberjar

FROM openjdk:18-slim-buster as final

ARG APP_DIR
ENV APP_DIR=${APP_DIR:-/usr/src/app}
RUN mkdir -p ${APP_DIR}
WORKDIR ${APP_DIR}

COPY --from=build ${APP_DIR}/target/uberjar/*-standalone.jar ./built.jar

ARG API_PORT
ENV API_PORT=${API_PORT:-4200}

EXPOSE ${API_PORT}
ENTRYPOINT ["/bin/sh", "-c"]
CMD ["java -jar built.jar --port ${API_PORT}"]
