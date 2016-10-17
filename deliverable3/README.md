# IS2545 - DELIVERABLE 3: Web Testing

### Development Evironment

>IDE: *Eclipse*

>JDK: *JAVA SE 7[1.7.0_79]*

>Test Tool: *JUnit 4, selenium*

### ISSUE
>1.Actually, it easy for me to do something with web, but I don't familar with java or selenium,So, it hard to me to learn selenium api to get the DomElement from webpage.

>2.I have design a story about user login, But when I test it time by time, it shows "Login failed because your IP address has been blocked. Please contact the administrator." So it hard to me to test it.

### User Stories
>**Story1**

>As a user

>I want to log in

>So that I can access my shopping account

>>Scenario1

>**Given** empty username and password

>**When** I try to login

>**Then** I should receive an error message with "Please enter your username and password."

>>Scenario2 

>**Given** non-empty username and empty password

>**When** I try to login

>**Then** I should receive an error message with "ERROR: The password field is empty."

>>Scenario3   

>**Given** wrong username and wrong password

>**When** I try to login

>**Then** I should receive an error message with "ERROR: Invalid login credentials."
