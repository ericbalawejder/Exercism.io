#!/bin/bash

#if there are no arguments, exit
if [ $# -eq 0 ]
then
  echo "Date argument required."
  exit 1
fi

start_date=$1
gigasecond=1000000000
date_to_seconds=$(date +%s --date="$start_date")
date --date="@$((date_to_seconds + $gigasecond))" +"%a %b %-e %T %Z %Y"
