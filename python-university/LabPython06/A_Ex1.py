n1 = int(input("Inserisci numero n1: "))
n2 = int(input("Inserisci numero n2: "))

if n1>0 and n2>0:

    M = int(max(n1,n2))
    m = int(min(n1,n2))


    for i in range(M+1,1,-1):

        d1 = M%i

        d2 = m%i

        if d1==0 and not(d2==0):
            
            print(i)



else:
    print("Numeri non corretti")


'''
Scrivere un programma Python che prende in input due numeri interi n1 e n2 maggiori di 0
e stampa in ordine decrescente tutti i divisori di n1 che NON sono divisori di n2.
Ad esempio, se n1 vale 24 e n2 vale 6 allora deve stampare (uno per riga): 24, 12, 8, 4.
'''
