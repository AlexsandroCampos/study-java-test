package studyjavatest.figurasGeometricas;

public class Quadrado {

    private double lado;

    public double calcularArea() {
        return lado * lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }
}
