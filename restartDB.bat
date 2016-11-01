
SETLOCAL

%MYSQL_HOME%\bin\mysqladmin -u root shutdown
%MYSQL_HOME%\bin\mysqld

exit
