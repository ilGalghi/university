import java.util.Date;

class LinkedList <T>{
    //
    void add (T o){
        //
    }
}



public class Prova2 {
    public static void main(String[] args){
        LinkedList<Persona> l = new LinkedList<Persona>();
        LinkedList<String> s = new LinkedList<String>();


        //l.add("abcd");      //dà errore perché non una persona
        s.add("abcd");      //funziona perché è stringa
        //l.add(2);           //funziona perché oggetto

        Coppia<Persona,String> c = new Coppia<Persona,String>(new Persona("Mario"), "abcd");

    }
}
