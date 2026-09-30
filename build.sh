#!/bin/bash
# build.sh
set -e
mkdir -p bin
javac -cp "lib/*" -d bin $(find src -name "*.java")
echo "Build complete -> bin/"