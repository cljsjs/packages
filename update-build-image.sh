#!/bin/bash
set -euo pipefail

TAG="cljsjs/build-image:latest"

docker build -t "$TAG" .
docker push "$TAG"

