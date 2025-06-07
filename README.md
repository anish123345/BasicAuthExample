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

# Findings
1. If java class and .properties file both are present with some initialization values,
then the values in the java class will override the values in the properties file.