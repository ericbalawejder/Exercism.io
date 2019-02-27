#!/bin/bash

#https://www.gnu.org/software/bash/manual/html_node/Shell-Parameter-Expansion.html
# If the first argument ${1} is not set, set the value to "you".
echo "One for ${1-you}, one for me."