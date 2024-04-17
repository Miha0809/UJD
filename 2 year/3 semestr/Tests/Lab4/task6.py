from selenium import webdriver

browser = webdriver.Chrome()

browser.get('https://demoqa.com/text-box')

name_input = browser.find_element_by_id('userName')
email_input = browser.find_element_by_id('userEmail')
current_address_input = browser.find_element_by_id('currentAddress')
permanent_address_input = browser.find_element_by_id('permanentAddress')
submit_button = browser.find_element_by_id('submit')

name_input.send_keys('John Doe')
email_input.send_keys('john.doe@example.com')
current_address_input.send_keys('Current Address')
permanent_address_input.send_keys('Permanent Address')

submit_button.click()

browser.quit()