#!/bin/bash

if [[ $# -eq 0 ]]
then
  echo "See usage: grains_test.sh"
  exit 1
fi

case "$1" in
  [1-9]|[1-5][0-9]|6[0-4])
    echo 2^$(($1-1)) | bc
    ;;
  total)
    echo 2^64 - 1 | bc
    ;;
  *)
    echo 'Error: invalid input'
    exit 1
    ;;
esac
