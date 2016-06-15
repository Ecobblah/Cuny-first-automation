This is an Automation program that automates every hour checking cunyfirst if a class is full. If the class is available 
it will take a seat for you and swap (need to comment out the swap) end the program and print out in the text field congrats!.

#WARNING  
I'm not responsible if it messes up your Cunyfirst info by any possible way. My Program never comes close to 
a delete button for a class, but things happen so becareful.

#Requirements
Need 2 things to add to your library "JTatoo-1.6.11"  and "selenium-server-standalone-2.53.0" JAR files not the demos Just google them up and you will 
find the download page. Make sure you download firefox web broswer "https://www.mozilla.org/en-US/firefox/new/?scene=2&f=66" and run it. IF using the Google Chrome version of the CunyFirst you must download https://sites.google.com/a/chromium.org/chromedriver/home and remember the file loction. When that done i believe on line 162 in CUnyFIrstGUIchrome System.setProperty("webdriver.chrome.driver", "File location"); eneter in the file location of the chromedrive, see my code to see an example. Then you change WebDriver driver = new  FirefoxDriver(); to WebDriver driver = new  ChromeDriver(); on line 163.

#Problems i haven't fixed yet.

1. If you enter the wrong password the program will crash.

2. I never asked the user how many classes in the shopping cart, So the default value is 1 "P_SELECT$0" class. Plan on using an array for this. When user
has N classes in the shopping cart ill use a for loop with an array that has "P_SELECT$100".

3. This Program Will Also swap Classes, so i need to make it a option for the user.

4. Once you get into at least one class the programs ends without continuing enrolling your other classes. One class at a time.

5. The GUI Interface positioning is off.

This Program is NOT FINAL, There a lot of silly mistakes in my code and usless stuff on it too.
