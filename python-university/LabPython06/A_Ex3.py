'''n = int(input("Inserisci numero tabellina: "))


for i in range(8):
    for j in range(8):
        print(i, "*", j, "=", oct(i+j)[2:])
'''



#per stampare la tabella pitagorica in base ottale considereremo su righe e colonne i numeri da 01 e 10 (8 in decimale) 
#e per ogni cella calcoleremo il prodotto i*j per poi convertirlo in base 8 
for i in range(1,9):
    for j in range(1,9):
        if (i!=8 or j!=8):
            p=i*j
            print(p//8,p%8,'\t',sep='',end='') #per la conversione consideriamo che ci è stato richiesto di usare 2 cifre
            #quindi avremo nella cifra a sinistra la divisione intera per 8 e nella cifra a sinistra il resto 
        else:
            print(100,end='') #nel caso 8x8 va fatta una distinzione in quanto 64 non è rappresentabile in base 8 con soli due caratteri

    print()

'''
Scrivere un programma Python che stampa la tabellina pitagorica dei
numeri in base ottale.
Usare due cifre, e.g., 02x04=10.
'''
