FROM clojure:openjdk-18-lein-slim-buster

ARG APP_DIR
ENV APP_DIR=${APP_DIR:-/usr/src/app}
RUN mkdir -p ${APP_DIR}
WORKDIR ${APP_DIR}

COPY project.clj ${APP_DIR}
RUN lein deps

ARG REPL_PORT
ENV REPL_PORT=${REPL_PORT:-7888}
EXPOSE ${REPL_PORT}

ENTRYPOINT ["/bin/sh", "-c"]
CMD ["lein repl :headless :host 0.0.0.0 :port $REPL_PORT"]

