##IS2545 - DELIVERABLE 5: Security Testing

**Team Member**
>qi chen (qic30)

>jie zhang (jiz124)

**Test Evironment**
>Test Tool: OWAPS ZAP 2.5.0

>Browser: Firefox 49.0.1

**Summary**
<br>
We use OWAPS to help us find the vulnerability of the website, and try to attack the website on Firefox browser. We choose three attack methods: XSS,Command Injection,SQL Injection.

**1.XSS Attack(Cross-Site Scripting)**
<br>
1.1 URL of the website with the described vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;http://demo.testfire.net/search.aspx
<br>
1.2 Steps taken to exploit the vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(1)input some query into search box, and then submit. (for example, I input “Hello”)

<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2)it will return a result with what query you input

<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3)Then, inspect the elements, I find that what I input into the search box, finally add into this span tag.


<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(4)So, it will be easy to inject script. for example, if I input “\</span>alert(1);\<script>\</script>\<span>” into search box and submit,I will get an alert box with  value 1;
<br>

1.3 what part of the InfoSec Triad does this vulnerability attack
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	in this case, it is integrity, because, it can change the data that should be displayed to user.
	<br>
	
1.4 what kind of security attack can exploit this vulnerability 
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	modification. because it modify the data;
	<br>
	
1.5 are attacks that exploit this vulnerability active or passive
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	active, because, it modify the output data;
	<br>
	
1.6 what business value would be lost cut to exploiting this vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	data loss.
	<br>
	
1.7 what steps should the development team take to fix this vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	(1) filter the input data. for example(Regular expression), delete the html tags.
	<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	(2) change some special symbol to ascii.for example, “<” , “>” should be transformed

