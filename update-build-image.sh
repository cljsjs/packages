#!/bin/bash
set -euo pipefail

TAG="cljsjs/build-image:0.0.1"

docker build -t "$TAG" .
docker push "$TAG"

