public class Main {
	public static void main(String[] args) {
        FiguraGeometrica[] g;
        g = new FiguraGeometrica[5];

        g[0] = new Rettangolo("Rettangolo", 3, 4);
        g[1] = new Quadrato("Quadrato", 5);
        g[2] = new Cerchio("Cerchio", 2);
        g[3] = new Triangolo("Triangolo",3,4,5);
        g[4] = new Ellisse("Ellisse", 2,5);

        double somma = 0;
        for (int i = 0; i < g.length; i++) {
            System.out.println(g[i]+"\n");
            somma += g[i].perimetro();
        }
        System.out.println("Somma dei perimetri: " + somma);
	}
}


/* ABSTRACT: può avere solo sottoclassi complete: no oggetti, solo oggetti sottoclasse.
 * Non ha spazi, ad esempio occupati e disoccupati non hanno bisogno di spazio.
 * 
 * PRIVATE: variabile chiusa dentro la classe
 */