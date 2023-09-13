s1 = input("Inserisci stringa 1: ")
s2 = input("Inserisci stringa 2: ")
n = int(input("Inserisci numero: "))
l1 = len(s1)
l2 = len(s2)

for i in s1:
    #print("III", i)
    for j in s2:
        #print("J", j)
        if j==i and s1.find(j)-s2.find(i)==n or s2.find(i)-s1.find(j)==n:
            print(i, end="")


'''
Scrivere un programma Python che prende in input 2 stringhe s1 ed s2
e un numero intero n e calcola una nuova stringa composta dei caratteri
di s1 che sono presenti anche in s2 in una posizione distante al massimo
n posizioni (prima o dopo) da quella che hanno in s1.
Ad esempio, se s1 vale ‘cestello’, s2 vale ‘sportina’ ed n vale 2,
allora il risultato deve essere ‘st’
'''
