# BasicAuthExample
BasicAuthExample Spring Security
1. This uses the form based authentication with default login page
2.  It has been made stateless which means no jsession cookie is created
3.  It uses the in-memory authentication with a two users and roles.
4.  It uses method level authorization using @PreAuthorize annotation


# Things covered
1. Spring Security with form based authentication
2. Spring Security with basic authentication
3. Spring Security with in Memory authentication(WHERE WE HAVE TWO USERS DEFINED IN JAVA CLASS InMemoryUserCreationWithRolesConfig)
4. Spring Security with in memory authentication(WHERE WE HAVE TWO USERS DEFINED IN PROPERTIES FILE H2 DATABASE)
5. Spring Security with method level authorization using @PreAuthorize annotation
6. Spring Security with stateless session management
7. Spring Security with Password encryption using BCryptPasswordEncoder

# Findings
1. If java class and .properties file both are present with some initialization values,
then the values in the java class will override the values in the properties file.
2. If you want to create initial database tables for spring security, use schema.sql file.
This file has been taken from users.dll from spring security github poject.