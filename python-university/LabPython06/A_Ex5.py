s = input("Inserisci stringa: ")
t0 = 0
if len(s)!=0:

    t0 = s.count(s[0])

    for i in s[1]:      
        t = s.count(i)

        if t>t0:
            t=t
    print(i, t)

else:
    print("Stringa non valida")


'''
Scrivere un programma Python che riceve in ingresso una stringa alfanumerica non vuota s
e stampa il carattere con più occorrenze consecutive e il numero di occorrenze dello stesso.
Se due caratteri condividono il massimo numero di occorrenze il programma stampa il secondo.
Ad esempio, se s vale 'a32ppp7666' il programma stampa 6 3.
'''
