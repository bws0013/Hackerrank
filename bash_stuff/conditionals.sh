#!/bin/bash

read letter

case $letter in
  "y") echo "YES"
  ;;
  "Y") echo "YES"
  ;;
  "n") echo "NO"
  ;;
  "N") echo "NO"
  ;;
esac
