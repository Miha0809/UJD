from selenium import webdriver
from selenium.webdriver.support.ui import Select

browser = webdriver.Chrome()

browser.get('http://the-internet.herokuapp.com/dropdown')

dropdown_menu = browser.find_element_by_id('dropdown')

select = Select(dropdown_menu)
select.select_by_visible_text('Option 1')

browser.quit()
