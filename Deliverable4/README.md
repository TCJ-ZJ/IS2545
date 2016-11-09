# IS2545 - DELIVERABLE 4: Performance Testing

### Development Evironment

>IDE: *Eclipse*

>JDK: *JAVA SE 7[1.7.0_79]*

>Test Tool: *JUnit 4, VisualVM*

### Summary
During the test, I choose 15 as argument, and the VisualVM shows that **MainPanel.convertToInt(int)** is the most CPU cost function. And after read the most CPU cost functions, I found that all of these three has meaningless for-loop. So, I delete all of these for-loop to improve the performacne of the program.

###Intiate the Program

 ![image](https://github.com/TCJ-ZJ/IS2545/blob/master/Deliverable4/screenShot/begin.jpeg)

###Profiling(Before)
 ![image](https://github.com/TCJ-ZJ/IS2545/blob/master/Deliverable4/screenShot/profileBefore.jpeg)
 
 we can see that MainPanel.convertToInt(int) function cost most

###Result

 ![image](https://github.com/TCJ-ZJ/IS2545/blob/master/Deliverable4/screenShot/result.jpeg)

###Code I changed

**1.MainPanel.convertToInt(int)**
</br>
I think this function is meaningless,add multiple "0" which will not influence the return value.
```java
/*Before*/
private int convertToInt(int x) {
	int c = 0;
	String padding = "0";
	while (c < _r) {
	    String l = new String("0");
	    padding += l;
	    c++;
	}
	
	String n = padding + String.valueOf(x);
	int q = Integer.parseInt(n);
	return q;
}
/*After*/
private int convertToInt(int x) {
	return x
}
```
**2.MainPanel.runContinuous()**
</br>
In this function, there is a for-loop, which is doing nothing. In loop, it changes the value _r, but after the loop, _r is assigned to original value.
```java
/*Before*/
public void runContinuous() {
	_running = true;
	while (_running) {
	    System.out.println("Running...");
	    int origR = _r;
	    try {
		Thread.sleep(20);
	    } catch (InterruptedException iex) { }
	    for (int j=0; j < _maxCount; j++) {
	    	_r += (j % _size) % _maxCount;
		_r += _maxCount;
	    }
	    _r = origR;
	    backup();
	    calculateNextIteration();
	}
    }

/*After*/
public void runContinuous() {
	_running = true;
	while (_running) {
	    System.out.println("Running...");
	    try {
		Thread.sleep(20);
	    } catch (InterruptedException iex) { }
	    backup();
	    calculateNextIteration();
	}
    }
```
