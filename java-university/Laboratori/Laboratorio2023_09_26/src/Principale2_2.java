//02
// Altra classe persona

import java.util.Date;

class Persona2 {
    String nome;
    int nascita;

    // Metodo per calcolare l'età
    int eta(int annoattuale) {
        return annoattuale - this.nascita;
    }
    int eta() {    	
    	return eta(new Date().getYear() + 1900);
    }
}

class Studente extends Persona2 {               // Estende la classe Persona2, rappresenta uno studente (studente comprende Persona + la matricola)
    int matricola;
}

class StudenteLavoratore extends Studente {     // Estende la classe Studente, rappresenta uno studente che lavora
    int annoAssunzione;
}

// Classe principale che contiene il metodo main
public class Principale2_2 {
    // Metodo statico per calcolare l'età di una persona
    static int eta2(Persona2 p, int annoattuale) {
        return annoattuale - p.nascita;
    }

    public static void main(String[] args) {
        String s;
        Persona2 p;
        p = new Persona2();

        // Inseriamo valori per l'oggetto p di tipo Persona2
        p.nome = "Francesco";
        p.nascita = 2000;

        System.out.println(p.nome + " " + p.nascita);

        // Creiamo un'altra istanza della classe Persona2
        Persona2 q = new Persona2();
        q.nome = "Luca";
        q.nascita = 1999;

        // Creiamo un array di persone e inseriamo p e q nell'array
        Persona2[] persone = new Persona2[2];
        persone[0] = p;
        persone[1] = q;

        // Stampiamo le informazioni sulle persone nell'array usando un ciclo
        for (int i = 0; i < persone.length; i++) {
            System.out.println(persone[i].nome + " " + persone[i].nascita);
        }

        // Calcoliamo e stampiamo l'età usando i due metodi
        int annoAttuale = 2023;

        System.out.println("Età di " + p.nome + " (metodo eta1): " + p.eta(annoAttuale));
        System.out.println(p.eta());
        
        // Creiamo un oggetto di tipo Studente
        Studente st = new Studente();
        st.nome = "Roberto";
        st.nascita = 2004;
        st.matricola = 2000000;

        // Creiamo un array di oggetti Persona2 e inseriamo un oggetto Persona2 e uno Studente
        Persona2 a[] = new Persona2[3];
        a[0] = new Persona2();
        a[1] = new Studente();

        // Assegniamo l'oggetto Studente st a una variabile di tipo Persona2
        Persona2 j = st;
        j.nome = "Luca";
        st.matricola++;

        // Stampiamo l'età di Luca utilizzando l'oggetto j di tipo Persona2
        System.out.println("Età Luca: " + j.eta());
        System.out.println("Matricola aumentata: " + st.matricola);

        // Creiamo un oggetto di tipo StudenteLavoratore
        StudenteLavoratore sl = new StudenteLavoratore();
        sl.nome = "Marco";
        sl.nascita = 2000;
        sl.matricola = 234500;
        sl.annoAssunzione = 2010;

        // Assegniamo l'oggetto StudenteLavoratore sl a una variabile di tipo Persona2
        //Persona2 M = sl;    // Viene trattato come Persona2, non come StudenteLavoratore

        // Stampiamo l'età di Marco e l'anno di assunzione
        System.out.println("Età " + sl.nome + ": " + sl.eta());
        System.out.println("Anno assunzione " + sl.nome + ": " + sl.annoAssunzione);
    }
}
