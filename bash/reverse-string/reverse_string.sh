#!/bin/bash

#if there are no arguments, exit
if [ $# -eq 0 ]
then
  echo "Input String required."
  exit 1
fi

echo $1 | rev
