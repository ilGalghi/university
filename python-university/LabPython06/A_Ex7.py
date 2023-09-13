s1 = input("Inserisci stringa: ")
s2 = input("Inserisci stringa: ")
l1 = len(s1)
l2 = len(s2)

M = max(l1, l2)
m = min(l1, l2)

result = (0, 0)

if l1 and l2 >0:
    for i in range(M):
        for j in range(i+1, l1+1):
            if s1[i:j] in s2:
                if j-i > result[1] - result[0]:
                    result=(i, j)
            else:
                break
    print(s1[result[0]:result[1]])
    
else:
    print("Stringhe errate")
    
'''
Scrivere un programma Python che riceve in ingresso due stringhe s1
e s2 non vuote e cerca e stampa la sequenza di caratteri più lunga
di s1 presente in s2. Ad esempio, se s1='casaletto' e s2='salerno'
il programma stampa sale. Usare un doppio ciclo for con un break nel
ciclo interno.
'''
