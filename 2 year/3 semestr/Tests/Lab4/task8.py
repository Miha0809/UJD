from selenium import webdriver

browser = webdriver.Chrome()

browser.get('http://the-internet.herokuapp.com/broken_images')

images = browser.find_elements_by_tag_name('img')

with open('image_urls.txt', 'w') as file:
    for image in images:
        image_url = image.get_attribute('src')
        file.write(image_url + '\n')

browser.quit()