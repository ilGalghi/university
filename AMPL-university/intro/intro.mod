#MODULE

set INV;  			# Creo un insieme chiamato "INV"

param Costo{INV};  	# Creo un parametro chiamato "Costo" indicizzato sull'insieme "INV"
                  	# →(questo parametro assegnerà un valore specifico a ciascun elemento dell'insieme "INV")

param Ricavo{INV};  # Creo un parametro chiamato "Ricavo" indicizzato sull'insieme "INV"
                   	# →(questo parametro assegnerà un valore specifico a ciascun elemento dell'insieme "INV")

param budget;  		# Creo un parametro chiamato "budget" che è fisso, non varia per ogni elemento di "INV"

var x{INV} binary; 	# Creo variabile x che, per ogni elemento dell'insieme INV, assume un valore binari (0-1)
                   

maximize output:  	# Definisco la funzione che MASSIMIZZA il risultato obiettivo "output"
    budget + sum{i in INV}(Ricavo[i] - Costo[i]) * x[i];

subject to limite:  # Definisco un vincolo chiamato "limite" (soggetto a "limite")
    sum{i in INV} Costo[i] * x[i] <= budget;  # Il budget totale non può superare il budget fisso
