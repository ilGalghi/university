public abstract class FiguraGeometrica {
    protected String descrizione;

    public FiguraGeometrica(String descrizione) {
        this.descrizione = descrizione;
    }

    public abstract double area();
    public abstract double perimetro();

    
    public String toString() {
        return "Descrizione: " + descrizione + "\nArea: " + area() + "\nPerimetro: " + perimetro();
    }
}