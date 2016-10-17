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

>**Stor2**

>As a user

>I want to search the items I want to buy

>So that I can get the items list;

>>Scenario1

>**Given** an specific item name that exist in this website

>**When** I try to search

>**Then** Then I should get a list with the certain item;

>>Scenario2 

>**Given** an item name that not exist in this website

>**When** I try to search

>**Then** Then I should receive an error message with "Sorry, but nothing matched your search criteria. Please try again with some different keywords."

>>Scenario3   

>**Given** an item name that match multiple items;

>**When** I try to search

>**Then** I should get a list with the all matched items;

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

