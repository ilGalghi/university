public class Ellisse extends FiguraGeometrica {
    private double semiasseMaggiore;
    private double semiasseMinore;

    public Ellisse(String descrizione, double semiasseMaggiore, double semiasseMinore) {
        super(descrizione);
        this.semiasseMaggiore = semiasseMaggiore;
        this.semiasseMinore = semiasseMinore;
    }

    @Override
    public double area() {
        return Math.PI * semiasseMaggiore * semiasseMinore;
    }

    @Override
    public double perimetro() {
        double a = semiasseMaggiore/2;
        double b = semiasseMinore/2;
        return 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
    }
}