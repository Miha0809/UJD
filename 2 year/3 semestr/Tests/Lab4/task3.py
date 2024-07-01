from selenium import webdriver

browser = webdriver.Chrome()
browser.get('https://www.oponeo.pl/konto/zaloguj?rUrl=https://www.oponeo.pl')

username_element = browser.find_element_by_name('Email')
password_element = browser.find_element_by_name('password')

username_element.send_keys('your_username')
password_element.send_keys('your_password')

password_element.submit()

browser.quit()