from selenium import webdriver

browser = webdriver.Chrome()
browser.get('http://demo.guru99.com/test/radio.html')

radio_buttons = browser.find_elements_by_xpath('//input[@type="radio"]')

selected_radio = radio_buttons[0]
selected_radio.click()

browser.quit()
