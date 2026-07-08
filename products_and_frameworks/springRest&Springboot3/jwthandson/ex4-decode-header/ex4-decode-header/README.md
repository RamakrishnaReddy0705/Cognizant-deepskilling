# Exercise 4: Decoding the Authorization Header

## How to import into IntelliJ IDEA
1. Open IntelliJ IDEA -> File > Open -> select this folder (ex4-decode-header).
2. IntelliJ will detect it as a Maven project and auto-import dependencies
   (requires internet access to Maven Central).
3. Wait for indexing/dependency download to finish.
4. Run SpringLearnApplication.java (right-click -> Run), or use the Maven
   spring-boot:run goal.
5. The app starts on http://localhost:8090.

## Project structure
```
src/main/java/com/cognizant/springlearn/
├── SpringLearnApplication.java     (main class)
├── controller/
│   ├── CountryController.java      (/countries endpoint)
│   └── AuthenticationController.java  (from Exercise 3 onward)
├── security/
│   ├── SecurityConfig.java
│   └── JwtAuthorizationFilter.java (Exercise 6 only)
└── model/
    └── Country.java
src/main/resources/application.properties
screenshots/expected_output.png    (reference/expected output for this exercise)
```

## Test it
```
curl -s -u user:pwd http://localhost:8090/authenticate
```

See screenshots/expected_output.png in this folder for the expected result of
running the exercise's test commands, built from the sample responses documented
in the assignment. Run the project in IntelliJ to reproduce a live screenshot
of your own if your submission requires one.
