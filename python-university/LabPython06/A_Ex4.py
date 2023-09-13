n1 = 20
n2 = 1
d1 = 0
d2 = 1
g = 0

for i in range(1,1000):

    d1 = d1+20
    d2 = d2+i
    
    '''print("i =", i)
    print("d1 =", d1)
    print("d2 =", d2)'''

    g +=1

    if d2>=d1:
        print(g)
        break

'''
Due viaggiatori partono insieme a velocità differenti:
il primo viaggiatore viaggia alla velocità di 20 chilometri al giorno;
il secondo viaggia alla velocità di 1 chilometro al giorno il primo giorno,
2 il secondo, 3 il terzo e così via (problema posto da Fibonacci nel 1200).
Scrivere un programma Python, parametrico rispetto alle due velocità,
che stampa il numero di giorni necessari al primo viaggiatore per raggiungere
il secondo, senza usare la formula della successione.
Usare un ciclo for con mille iterazioni con un break al suo interno.
'''
