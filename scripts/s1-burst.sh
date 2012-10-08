#!/bin/bash
if [ ${BURST_HOME+x} ] 
  then tmux -f ${BURST_HOME}/scripts/s1-burst.conf attach
  else echo "BURST_HOME must be set"; exit;
fi
