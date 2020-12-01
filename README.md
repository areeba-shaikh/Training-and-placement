# How to set up development environment

1. Install mysql
<https://www.onlinetutorialspoint.com/mysql/install-mysql-on-windows-10-step-by-step.html>

2. Import data from DB-information/full.sql by using following steps:
    i) open MySQL workbench
    ii) connect to local instance
    iii) Click on Server -> Data Import -> Import from Self-Contained File -> Select the DB-information/full.sql file -> Start Import

3. Change username and password in MySqlConnect.java file. Currently, username is root and password is root123
