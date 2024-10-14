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
- For the base image, I chose eclipse-temurin:21-alpine, and the builder would be gradle:8-jdk21, with both being used in the Dockerfile of lecture 14 as well.
- I followed it up with copying my application into gradle by COPY; this included the gradle kts files settings.gradle.kts, build.gradle.kts and gradlew, as well as ./, src- and gradle directory.
- Thereafter, I used the suggested RUN gradle bootJar as well as renaming the build file to something more suitable; in this case app.jar.
- To assure root is not being used when running the application, I added two RUN-instructions, first with addgroup and then with adduser. The non-root user would later on gain a copy of the build after directing to the new user in the Dockerfile. The non-root user would be nicknamed 'app' in this file.
- Lastly, for the Dockerfile, I added CMD and specified what file should run and instances, hence CMD ("java", "-jar", "app.jar").
- After being done with the Dockerfile, I ran it through my preferred IDE, IntelliJ, to create the container, which would also give an insight whether there was anything wrong or if the build succeeded though the 'Build Log'.
- I used the Dockerfile of lecture 14 as a reference/starting point for the Dockerfile.

### Link to Dockerfiles
<a href="https://github.com/Mantonio02/MyRepo/blob/main/Dockerfile">My Dockerfile</a>
<a href="https://github.com/selabhvl/dat250public/blob/master/lectureexamples/l14_containers/Dockerfile">Lecture Dockerfile</a>
