s = input("Inserisci stringa: ")
t = 0
l2 = int(len(s)/2)

for i in range(0, len(s)):
    
    for n in range(len(s)-1, l2-1, -1):

        if (s[i]==s[n] and i!= n and t==i):
            t=t+1


print(int(t))


'''
Diciamo che una stringa è palindroma di livello 1 se il primo e
ltimo carattere sono uguali, di livello 2 se il primo è uguale all’ultimo
e il secondo al penultimo, e così via.
Scrivere un programma Python che prende in input una stringa s e
calcola il livello massimo di palindromicità della stringa.
Ad esempio, se la stringa s vale ‘alidfefcila’ allora il livello è 3.
Se la stringa è palindroma allora il suo livello deve essere uguale
alla sua lunghezza.
'''
