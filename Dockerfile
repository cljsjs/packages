FROM clojure:boot-2.7.1

# Image for Cljsjs builds
# - Java
# - Boot
# - GPG (included in debian base?)
# - jq
# - node & npm
# - Closure compiler jar file /usr/local/bin/closure-compiler.jar

# Jq, for json manipulation
# used by cicle.sh to check for running Circle builds

RUN apt-get update && apt-get install -y --no-install-recommends jq \
            && rm -rf /var/lib/apt/lists/*

# Node
# Copied from https://github.com/nodejs/docker-node/blob/master/7.10/Dockerfile

RUN groupadd --gid 1000 node \
  && useradd --uid 1000 --gid node --shell /bin/bash --create-home node

# gpg keys listed at https://github.com/nodejs/node#release-team
RUN set -ex \
  && for key in \
    9554F04D7259F04124DE6B476D5A82AC7E37093B \
    94AE36675C464D64BAFA68DD7434390BDBE9B9C5 \
    FD3A5288F042B6850C66B31F09FE44734EB7990E \
    71DCFD284A79C3B38668286BC97EC7A07EDE3FC1 \
    DD8F2338BAE7501E3DD5AC78C273792F7D83545D \
    B9AE9905FFD7803F25714661B63B535A4C206CA9 \
    C4F0DFFF4E8C1A8236409D08E73BC641CC11F4C8 \
    56730D5401028683275BD23C23EFEFE93C4CFFFE \
  ; do \
    gpg --keyserver ha.pool.sks-keyservers.net --recv-keys "$key" || \
    gpg --keyserver pgp.mit.edu --recv-keys "$key" || \
    gpg --keyserver keyserver.pgp.com --recv-keys "$key" ; \
  done

ENV NODE_VERSION 7.10.0
ENV NPM_CONFIG_LOGLEVEL info

RUN curl -SLO "https://nodejs.org/dist/v$NODE_VERSION/node-v$NODE_VERSION-linux-x64.tar.xz" \
  && curl -SLO "https://nodejs.org/dist/v$NODE_VERSION/SHASUMS256.txt.asc" \
  && gpg --batch --decrypt --output SHASUMS256.txt SHASUMS256.txt.asc \
  && grep " node-v$NODE_VERSION-linux-x64.tar.xz\$" SHASUMS256.txt | sha256sum -c - \
  && tar -xJf "node-v$NODE_VERSION-linux-x64.tar.xz" -C /usr/local --strip-components=1 \
  && rm "node-v$NODE_VERSION-linux-x64.tar.xz" SHASUMS256.txt.asc SHASUMS256.txt \
  && ln -s /usr/local/bin/node /usr/local/bin/nodejs

# Yarn part skipped for now

# Closure compiler

ENV CLOSURE_COMPILER_VERSION 20170423

RUN curl -SLO "http://dl.google.com/closure-compiler/compiler-$CLOSURE_COMPILER_VERSION.tar.gz" \
  && tar -xf "compiler-$CLOSURE_COMPILER_VERSION.tar.gz" closure-compiler-v$CLOSURE_COMPILER_VERSION.jar \
  && mv closure-compiler-v$CLOSURE_COMPILER_VERSION.jar /usr/local/bin/closure-compiler.jar \
  && chown root:root /usr/local/bin/closure-compiler.jar \
  && chmod ugo+r /usr/local/bin/closure-compiler.jar \
  && rm "compiler-$CLOSURE_COMPILER_VERSION.tar.gz"
