public class Triangolo extends FiguraGeometrica {
    private double lato1;
    private double lato2;
    private double lato3;

    public Triangolo(String descrizione, double lato1, double lato2, double lato3) {
        super(descrizione);
        this.lato1 = lato1;
        this.lato2 = lato2;
        this.lato3 = lato3;
    }

    
    
    
    
    @Override
    public double area() {
    	double perimetro = lato1+lato2+lato3;
        return Math.sqrt(perimetro/2*(perimetro/2 -lato1)*(perimetro/2 -lato2)*(perimetro/2 -lato3));
    }
    
    
    public double perimetro() {
        return lato1 + lato2 + lato3;
    }
   
    

    
    
    
}