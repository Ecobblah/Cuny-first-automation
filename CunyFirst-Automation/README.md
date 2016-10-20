This is an Automation program that automates every hour checking cunyfirst if a class is full. If the class is available 
it will take a seat for you and swap (need to comment out the swap if you dont want to swap) end the program and print out in the text field congrats!.

#WARNING  
I'm not responsible if it messes up your Cunyfirst info by any possible way. My Program never comes close to 
a delete button for a class, but things happen so becareful.

#Requirements
Need 2 things to add to your library "JTatoo-1.6.11"  and "selenium-server-standalone-3.0.1.jar" JAR files not the demos Just google them up and you will 
find the download page, but if there an updated versions of it that fine. Make sure you download geckodriver web broswer to use Firefox browser "https://github.com/mozilla/geckodriver/releases" if using windows make sure you pick either Windows file if Mac pick the Mac file. When that done make sure you place those drivers in your project folder, because as you can see in CunyfirstGUi.java on line 161 i placed mine inside my Cunyfirst project "System.setProperty("webdriver.firefox.marionette", "C://Users/User/Emmanuel_workspace/Personal  Projects/Cunyfirst/Firefox/geckodriver.exe");" 
#Problems i haven't fixed yet.

#sites i used
https://www.mozilla.org/en-US/firefox/new/ (Firefox broswer itself if you dont have)
https://github.com/mozilla/geckodriver/releases (geckodriver)
http://www.seleniumhq.org/download/(Selenium stand alone)
http://www.jtattoo.net/Download.html(Jtattoo not the Demo just the Jar file please)
https://sites.google.com/a/chromium.org/chromedriver/downloads (I have not tested Chrome driver yet so dont use)

#How to use it
1.Before running it make sure you have classes in your Cunyfirst shopping cart.

2.Inside the CunyfirstGUI code line from 193 to 222 is the swap classes code, comment it out if you dont want to sawp any classes.

3.on line 183 "driver.findElement(By.id("P_SELECT$0")).click();" represents the number of classes which is only one. if you have 2 classes all you have to do is copy and paste "driver.findElement(By.id("P_SELECT$0")).click();" and  change P_SELECTt$0 to P_SELECT$1
then that it for 3 classes in shopping cart just copy and paste and change to P_SELECT$2, as you can see there a pattern. Incase your curious im getting P_SELECT from their site itself, if your right lcik the box icon you will see the ID in HTML.

4.After that Run the program Enter your Cunyfirst userID and password then it will do the rest.It avisible to not move your mouse when the firefoxbrowser is OPEN on your screen and doing it thing, so that why when you dont feel like watching it work just minimize it and you can do whatever you want on your computer.

#Things i need to do
1. If you enter the wrong password the program will crash.

2. I never asked the user how many classes in the shopping cart, So the default value is 1 "P_SELECT$0" class. Plan on using an array for this. When user has N classes in the shopping cart ill use a for loop with an array that has "P_SELECT$100".

3. This Program Will Also swap Classes, so i need to make it a option for the user.

4. Once you get into at least one class the programs ends without continuing enrolling your other classes. One class at a time.

5. The GUI Interface positioning is off.

This Program is NOT FINAL, There a lot of silly mistakes in my code and usless stuff on it too.
