#!/bin/bash

# -x: all executed commands are printed to the terminal.
#set -x
# -e exits whenever anything returns a non-zero value.
# -u makes it an error to reference a non-existent environment variable
set -eu
# raises error for misspelled commands
set -o pipefail


#if there are no arguments, exit
if [ $# -eq 0 ]
then
  echo "Date argument required."
  exit 1
fi

start_date=$1
gigasecond=1000000000
date_to_seconds=$(date +%s --date="$start_date")
date --date="@$((date_to_seconds + $gigasecond))"