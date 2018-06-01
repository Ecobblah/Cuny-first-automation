# i'm discontinuing this project.
This is an Automation program that automates every hour checking Cunyfirst if a class is full. If the class is available 
it will take a seat for you or swap classes. At the end of the program it prints out in the text field congrats! (need to comment out the swap if you don't want to swap)

#WARNING  
I'm not responsible if it messes up your Cunyfirst info by any possible way. My Program never comes close to 
a delete button for a class, but things happen so be careful.

#Requirements
Need 2 things to add to your library "JTatoo-1.6.11"  and "selenium-server-standalone-3.0.1.jar" JAR files Not the demos. Google them up and you will 
find the download page, but if there an updated versions of it that fine. Make sure you download geckodriver to use Firefox browser "https://github.com/mozilla/geckodriver/releases" if using windows make sure you pick Windows file if Mac pick the Mac file. When that done make sure you place those drivers in your project folder, because as you can see in CunyfirstGUi.java on line 161 I placed mine inside my Cunyfirst project "System.setProperty("webdriver.firefox.marionette", "C://Users/User/Emmanuel_workspace/Personal  Projects/Cunyfirst/Firefox/geckodriver.exe");" 

#Sites I used
https://www.mozilla.org/en-US/firefox/new/ (Firefox browser itself if you don't have)
https://github.com/mozilla/geckodriver/releases (geckodriver)
http://www.seleniumhq.org/download/        (Selenium stand alone)
http://www.jtattoo.net/Download.html(Jtattoo not the Demo just the Jar file please)
https://sites.google.com/a/chromium.org/chromedriver/downloads (I have not tested Chrome driver yet so don't use)

#How to use it

1. Before running it make sure you have classes in your Cunyfirst shopping cart.

2. Inside the CunyfirstGUI code line from 193 to 222 is the swap classes code, comment it out if you don't want to swap any classes.

3. On line 183 "driver.findElement(By.id("P_SELECT$0")).click();" represents the number of classes which is only one in this case. If you have 2 classes all you have to do is copy and paste "driver.findElement(By.id("P_SELECT$0")).click();" and  change P_SELECTt$0 to P_SELECT$1
 then that it. For 3 classes in shopping cart just copy and paste and change to P_SELECT$2, as you can see there a pattern. In case you're curious I'm getting P_SELECT from their site itself, if you right click the box icon and inspect you will see the ID in HTML.

4. After that run the program Enter your Cunyfirst user ID and password then it will do the rest. It advisable to not move your mouse when the Firefox browser is OPEN on your screen and doing it job. So if you don't feel like watching it work just minimize it and you can do whatever you want on your computer.

#Problems I haven't fixed yet.

1. If you enter the wrong password the program will crash.

2. I never asked the user how many classes in the shopping cart, so the default value is 1 "P_SELECT$0" class. Plan on using an array for this. When user has N classes in the shopping cart ill use a for loop with an array that has "P_SELECT$100".

3. This Program Will Also swap Classes, so i need to make it an option for the user.

4. Once you get into at least one class the programs ends without continuing enrolling your other classes. One class at a time.

5. The GUI Interface positioning is off.

This Program is NOT FINAL, There a lot of silly mistakes in my code and useless stuff on it too.
