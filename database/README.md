# FLYWAY DATABASE MIGRATION MODULE

You can configure flyway with a config file 'flyway.conf' at the root of the project where you specify
database details, or you can use plugin configuration in pom.xml.

In order to use 'flyway:undo' command you need a license/paid version of Flyway.

!!! 'flyway.locations' from flyway.conf won't work(bug??) unless you specify with the maven command 
the location for flyway.conf as 'mvn -define flyway.configFiles=classpath:flyway.conf flyway:info'


If you use MySQL with Docker when creating new users use @'172.17.0.1' instead of @'localhost'.
You can't connect to those with 'localhost'.