class Una {                 //a seconda di che tipo di dato passo, sceglie il metodo
    int metodo(String a){   // -> possono avere stesso nome, ma parametri diversi
        return 0;

    }
    int metodo(int b){
        return 1;
    }

    void metodo(float b){   //si può fare

    }
}


public class Metodi {
    public static void main(String[] args){
        Una a = new Una();
        System.out.println(a.metodo("abcd"));
        System.out.println(a.metodo(3));
    }
}
