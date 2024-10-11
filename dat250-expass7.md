# DAT250 Expass 7

## Using PostgreSQL Docker Image
- I have sucessfully added PostgreSQL Docker Image to JPA assignment. The JUnit-tests works exactly as they did previously with H2 database (note: the tests will still fail due to the same error from the earlier assignment).
- For the first exercise, the arguments -p and -e were respectively 5432:5432 and POSTGRES_PASSWORD='(password of choice)'. 5432 is the PostgreSQL port that localhost will connect to, while POSTGRES_PASSWORD is an argument to set up the password for the default user postgres. Afterwards, I followed rest of the CLI steps with no apparent issues.
- I used the inbuilt database client for IntelliJ. This led to some confusion with connecting it to the PostgreSQL at first since I have never used the inbuilt client before, but I managed to fix it later on after looking into some error messages that occured during testing the connection and java files. 
- I used the SQL console on IntelliJ to create the jpa_client user with the assigned password 'secret'.
- I added the new dependency to build.gradle.kts, and replaced the old connection parameters in persistance.xml with PostgreSQL. Lastly, I added the three other lines that would generate SQL tables in persistance.xml.
- schema.(up/down).sql were not connected to the database client at first, which was solved by changing the run configuration for both files to apply their actions onto the postgres database's scheme.
- jpa_client had not the necessary privileges to run the tables when running CreditCardMain and CreditCardMainTest, which was solved by using the SQL console on IntelliJ with the GRANT command of two instances: GRANT pg_read_all_data/pg_write_all_data TO jpa_client;. I gave the client all privileges for debugging purposes, which made the Main and Test files work.

### Link to JPA assignment
<a href="https://github.com/Mantonio02/dat250-jpa-tutorial/tree/master">JPA Assignment</a>

## Creating own Docker Image
