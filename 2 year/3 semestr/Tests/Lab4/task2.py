from selenium import webdriver

browser = webdriver.Chrome()
browser.get('http://the-internet.herokuapp.com/')

element = browser.find_element_by_link_text('Form Authentication')
element.click()

browser.quit()
