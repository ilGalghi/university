public class Cerchio extends FiguraGeometrica {
    private double raggio;

    public Cerchio(String descrizione, double raggio) {
        super(descrizione);
        this.raggio = raggio;
    }

    @Override
    public double area() {
        return Math.PI * raggio * raggio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * raggio;
    }
}
