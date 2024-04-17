from selenium import webdriver

browser = webdriver.Chrome()
browser.get('http://the-internet.herokuapp.com/')

links = browser.find_elements_by_tag_name('a')
selected_link = links[0]
link_url = selected_link.get_attribute('href')

browser.get(link_url)
browser.quit()
