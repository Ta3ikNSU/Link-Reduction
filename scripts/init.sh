#!/bin/bash

sqlplus sys/password@//localhost:1521 as sysdba @/scripts/init.sql
