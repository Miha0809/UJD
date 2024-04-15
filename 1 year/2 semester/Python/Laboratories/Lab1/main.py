import sys

def task1():
	if len(sys.argv) == 2:
		with open(sys.argv[1], 'rb') as file:
			for i in [137, 80, 78, 71, 13, 10, 26, 10]:
				byte = file.read(1)

				if i != ord(byte):
					print("This is not png image")
					return 0
		print("Is png image")
	else:
		print("")
		return 1

def task2():
	if len(sys.argv) >= 1:
		for i in range(1, len(sys.argv)):
			with open(sys.argv[i], 'rb') as file:
				for j in [137, 80, 78, 71, 13, 10, 26, 10]:
					byte = file.read(1)

					if j != ord(byte):
						print("This is not png image")
						return 0
			print("Is png image")
	else:
		print("")
		return 1

def szyfruj(buf, mask):
	bytes_array = bytearray(b'')

	for byte in buf:
		bytes_array.append(mask^byte)

	return bytes(bytes_array)

def szyfr_cezara(buf, bytes):
	result = ''

	for letter in buf:
		result += chr(letter + bytes)

	return result

def szyfr_cezara2(buf, mask):
	bytes_array = bytearray(b'')
	buf = szyfr_cezara(buf, mask)

	for byte in buf:
		bytes_array.append(mask+ord(byte))

	return bytes(bytes_array)


def main():
	print(szyfr_cezara2(b'Python', -6))
	print(szyfruj(b'Python', 255))
              


if __name__ == "__main__":
    main()