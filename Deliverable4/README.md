# IS2545 - DELIVERABLE 4: Performance Testing

### Development Evironment

>IDE: *Eclipse*

>JDK: *JAVA SE 7[1.7.0_79]*

>Test Tool: *JUnit 4, VisualVM*

### Summary
During the test, I choose 15 as argument, and the VisualVM shows that **MainPanel.convertToInt(int)** is the most CPU cost function. And after read the most CPU cost functions, I found that all of these three has meaningless for-loop. So, I delete all of these for-loop to improve the performacne of the program.

###Profiling(Before)
