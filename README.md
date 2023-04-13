# TestNG-Appiu

iOS Automation Real Device


Pre-condition
1. Make sure you’ve reset the device
2. Run WebDriver Command
3. Start Appium Dependency and Install App through Appium
4. Run the Testcases


1. Install all the required library  : https://appiumpro.com/editions/40-how-to-test-on-real-ios-devices-with-appium-part-1
2. Install Xcode
3. Install Appium and open first
4. Then open WebDriverAgent Xcode project and sign with the Apple ID, change the bundle id if required with “com.testsec.WebDriverAgentLib”

5. Go to Folder of Xcode : /Applications/Appium 2.app/Contents/Resources/app/node_modules/appium/node_modules/appium-webdriveragent
6. Run the command : xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=00008101-0012643E0A40001E' test -allowProvisioningUpdates
7. You can run the app from Xcode and check the WebDriver app is installed or not.
8. If WebDriver app is installed then you are good to go and run the your application from Appium

xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id= 620a4ba58ec5f54fee7d7782b975737eb06e16dd' test -allowProvisioningUpdates


- Make sure you’ve trusted profile from iPhone settings
- If getting error restart the Mac and Device

For iPhone XS Max : 

xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=00008020-000B75610238002E' test -allowProvisioningUpdates


#-----IOS (QA TEST)----
platformName = iOS
deviceName = iPhone 12 mini
udid = 00008101-001405D42139003A
updatedWDABundleId = com.testone.WebDriverAgentRunner
platformVersion = 14.2
automationName = XCUITest
appPath = /Users/Jarvis/Downloads/.ipa