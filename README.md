# clojure-api

Basic API -- Clojure learning project.

## Installation

Clone from GitHub:

    $ git clone https://github.com/AspenJames/clojure-api.git

Setup `.env` file:

    $ cp .env.sample .env


## Usage

### Docker

There are `Dockerfile`s and a `docker-compose.yml` for running this project in
a REPL or as a standalone binary.

To run the REPL:

    $ docker-compose up repl

This runs an nREPL server at `nrepl://0.0.0.0:7888`, to which you may connect
from your favorite editor.

To run the server:

    $ docker-compose up server

This builds and runs the API server as a standalone JAR.

### Leiningen

This project may also be run and managed with
[leiningen](https://leiningen.org/). Use `lein help` for more information.

To run the REPL in interactive mode:

    $ lein repl

To run the server:

    $ lein run [--port PORT=4200]


To build a JAR:

    $ lein uberjar



## License

Copyright © 2022 Aspen James

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
