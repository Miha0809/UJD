import csv
from selenium import webdriver

browser = webdriver.Chrome()
browser.get('http://the-internet.herokuapp.com/tables')

table = browser.find_element_by_id('table1')
rows = table.find_elements_by_tag_name('tr')

with open('table_data.csv', 'w', newline='') as csvfile:
    csv_writer = csv.writer(csvfile)

    for row in rows:
        row_data = [cell.text for cell in row.find_elements_by_tag_name('td')]
        csv_writer.writerow(row_data)

browser.quit()
