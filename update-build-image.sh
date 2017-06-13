#!/bin/bash
set -euo pipefail

TAG="cljsjs/build-image:0.0.3"

docker build -t "$TAG" .
docker push "$TAG"

