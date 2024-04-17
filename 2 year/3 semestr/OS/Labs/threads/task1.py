import threading
import time

def print_numbers():
    for i in range(1, 10):
        print(i)
        time.sleep(1)

threads = []
for _ in range(9):
    thread = threading.Thread(target=print_numbers)
    threads.append(thread)
    thread.start()

for thread in threads:
    thread.join()
