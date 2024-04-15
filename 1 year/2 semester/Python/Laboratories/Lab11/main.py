import re
def usun_poczatkowe_zera(adres_ip):
    # Tworzenie wzorca wyrażenia regularnego
    wzorzec = r'\b0+(\d+)\b'
    
    # Zastępowanie początkowych zer pustym ciągiem
    adres_ip = re.sub(r'\b0+(\d+)', r'1', adres_ip)
    
    return adres_ip

# Przykładowe użycie
adres_ip = '192.168.001.001'
adres_ip = usun_poczatkowe_zera(adres_ip)
print(adres_ip)