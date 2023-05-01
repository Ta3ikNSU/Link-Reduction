alter session set "_ORACLE_SCRIPT"=true;
CREATE USER myuser IDENTIFIED BY mypassword;
GRANT CONNECT, RESOURCE, DBA TO myuser;