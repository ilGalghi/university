public class Rettangolo extends FiguraGeometrica {
    private double lunghezza;
    private double larghezza;

    public Rettangolo(String descrizione, double lunghezza, double larghezza) {
        super(descrizione);
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
    }

    
    public double area() {
        return lunghezza * larghezza;
    }

    
    public double perimetro() {
        return 2 * (lunghezza + larghezza);
    }
}