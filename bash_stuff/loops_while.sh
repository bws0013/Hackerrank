#!/bin/bash

count=1

while [ $count -lt 100 ]; do
    echo $count
    let count=count+2
done
