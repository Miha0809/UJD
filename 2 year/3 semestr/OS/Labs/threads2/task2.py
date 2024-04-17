import threading
import urllib.request
import time

def download_page(url, lock, result):
    try:
        with urllib.request.urlopen(url) as response:
            page_source = response.read()
            with lock:
                result.append(len(page_source))
    except Exception as e:
        print(f"Error downloading {url}: {e}")

urls = [input(f"Enter URL for page {i + 1}: ") for i in range(5)]

result = []
lock = threading.Lock()

download_threads = []
for url in urls:
    thread = threading.Thread(target=download_page, args=(url, lock, result))
    download_threads.append(thread)
    thread.start()

while any(thread.is_alive() for thread in download_threads):
    time.sleep(1)
    print("Waiting for download...")

total_chars = sum(result)
print(f"Total characters in downloaded pages: {total_chars}")
