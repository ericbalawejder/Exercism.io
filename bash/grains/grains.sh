#!/bin/bash

if [[ $# -eq 0 ]]
then
  echo "See usage: grains_test.sh"
  exit 1
fi

case "$1" in
  [1-9]|[1-5][0-9]|6[0-4])
    printf "%u\n" $((1 << $1 - 1))
    #echo 2^$(($1-1)) | bc
    ;;
  total)
    printf "%u\n" $((2**64-1))
    #printf "%llu\n" $((((1 << 64)) - 1))
    #echo 2^64 - 1 | bc
    ;;
  *)
    echo "Error: invalid input"
    exit 1
    ;;
esac
