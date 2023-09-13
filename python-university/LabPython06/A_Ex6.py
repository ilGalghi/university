nA="349776123345679876543234567876543234569055"
nT=9510990939794952322311710154344301747012051743844839


for i in range(11, len(nA)):
    n = 0
    for j in range(len(nA)):
        
        n += int(nA[len(nA)-1-j])*pow(i,j)
    if n == nT:
        break

print(i)

'''
Un ipotetico messaggio dallo spazio fa scoprire una razza extraterrestre
umanoide (due gambe, due braccia).
Dal messaggio si scopre che gli extraterrestri rappresentano i
numeri con una notazione posizionale e nel messaggio è presente
una equazione (numeroTerrestre)10=(numeraleAlieno)x.
Scrivere un programma Python che stampa il numero di dita degli extraterrestri. N.B.: i valori numeroTerrestre e numeraleAlieno sono già presenti nel codice e si assume che gli alieni usino una base x uguale al numero delle loro dita.
'''
