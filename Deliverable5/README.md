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
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2)it will return a result with what query you input.
<br>
![image](https://github.com/TCJ-ZJ/IS2545/blob/master/Deliverable5/img/1.jpeg)
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3)Then, inspect the elements, I find that what I input into the search box, finally add into this span tag.
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![image](https://github.com/TCJ-ZJ/IS2545/blob/master/Deliverable5/img/1.2.jpeg)
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(4)So, it will be easy to inject script. for example, if I input “\</span>alert(1);\<script>\</script>\<span>” into search box and submit,I will get an alert box with  value 1;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![image](https://github.com/TCJ-ZJ/IS2545/blob/master/Deliverable5/img/1.3.jpeg)
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


**2.Command Injection**
<br>
2.1 URL of the website with the described vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;http://www.webscantest.com/osrun/whois.php
<br>
2.2 Steps taken to exploit the vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(1)whois server is a protocol used to  quering databases that store the registered users or assignees of an internet resource, such as a domain name,an IP assess block,etc.
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2)so, it is must pass the input data to system shell, if it don’t do anything to check the data, it will be a chance to attack.
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3)I input “anystr&cat /etc/passwd&” in input box, and submit, this command will  return some useful information like user ID, group ID, home directory, shell, etc.
![image](https://github.com/TCJ-ZJ/IS2545/blob/master/Deliverable5/img/2.1.jpeg)
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(4)I got system information
<br>

2.3 what part of the InfoSec Triad does this vulnerability attack
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	in this case, it is confidentiality, because, unauthorized users may read system data;
	<br>
	
2.4 what kind of security attack can exploit this vulnerability 
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	interception. because it eavesdrop the system information;
	<br>
	
2.5 are attacks that exploit this vulnerability active or passive
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	passive, because, it does not modify system;
	<br>
	
2.6 what business value would be lost cut to exploiting this vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	unauthorized access
	<br>
	
2.7 what steps should the development team take to fix this vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	(1) filter the input data. for example(Regular expression)
	<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	(2)using some library to detect the input.

**1.SQL Injection**
<br>
3.1 URL of the website with the described vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;http://demo.testfire.net/bank/login.aspx
<br>
3.2 Steps taken to exploit the vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(1)For a login operation, most situation, input will be as a part of sql.
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(2)so, if it not check the input data , it has chance to attack
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(3)I input “ dd' or 1=1 - ”
![image](https://github.com/TCJ-ZJ/IS2545/blob/master/Deliverable5/img/2.2.jpeg)
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(4)login success
<br>

3.3 what part of the InfoSec Triad does this vulnerability attack
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	in this case, it is confidentiality, because, unauthorized users may read the data;
	<br>
	
3.4 what kind of security attack can exploit this vulnerability 
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	interception. because it login into the system, and read related data;
	<br>
	
3.5 are attacks that exploit this vulnerability active or passive
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	passive, because, it does not modify system;
	<br>
	
3.6 what business value would be lost cut to exploiting this vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	unauthorized access
	<br>
	
3.7 what steps should the development team take to fix this vulnerability
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	(1) filter the input data. for example(Regular expression)
	<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	(2) using some library to detect the input.
	
	
	

