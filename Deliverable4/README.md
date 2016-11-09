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
**3.Cell.toString()**
</br>
In this function, actually, there is also a meaningless for-loop,add multiple times of currentState,but return only the first word of the string
```java
/*Before*/
public String toString() {
	String toReturn = new String("");
	String currentState = getText();
	for (int j = 0; j < _maxSize; j++) {
	    toReturn += currentState;
	}
	if (toReturn.substring(0,1).equals("X")) {
	    return toReturn.substring(0,1);
	} else {
	    return ".";
	}

    }
/*After*/
public String toString() {
	String toReturn = getText();
	if (toReturn.substring(0,1).equals("X")) {
	    return toReturn.substring(0,1);
	} else {
	    return ".";
	}

    }
```

###Unit Test
**1.MainPanel.convertToInt(int)**
</br>
For test this function, I create 3 tests. each test has different size of the world, then to give the argument to convertToInt function which should return the integer type of the argument.
The code is in test/Test1.java

**2.MainPanel.runContinuous()**
</br>
For this part, it return nothing, so,It difficult to use unit test. for this, I try different size of the world and different initialization, and compare the results between the code I changed and the code I don't changed.
And, the results shows no difference.

**3.Cell.toString()**
For this function, it returns the string type of the current state of cell. when initiate a cell with nothing, it should return ".", when initiate a cell with boolean true, it should return "X", when initiate a cell with boolean false, it should return ".".
The code is in test/Test2.java
