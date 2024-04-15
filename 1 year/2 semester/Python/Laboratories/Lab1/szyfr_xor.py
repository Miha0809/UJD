import math


def szyfruj(file_read, file_write, number):
  if number not in range(256):
    return
  
  try:
    file = open(file_read, 'r')
    # buff = bytearray(file.read())

    # for i in range(math.ceil(len(buff) / 32)):
    #   print(buff)

    
    file.close()
  except NameError as name:
    print(name)


  try:
    file = open(file_write, 'wb')

    file.close()
  except NameError as name:
    print(name)

def main():
  szyfruj('test.txt', 'test2.txt', 255)

main()