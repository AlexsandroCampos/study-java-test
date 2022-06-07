package studyjavatest.figurasGeometricas;

public class Retangulo {

    private double base;
    private double altura;

    public double calcularArea(){
        return base*altura;
    }
    public double calcularPerimetro(){
        return 2*(base + altura);
    }
}
