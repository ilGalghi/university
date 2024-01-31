package Interfacce;

public class Muro implements HaAltezza {
	double latitudine, longitudine, altezza;

	Muro(double latitudine, double longitudine, double altezza) {
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.altezza = altezza;
	}

	public int getAltezza() {
		return (int) (this.altezza * 100);
	}
}