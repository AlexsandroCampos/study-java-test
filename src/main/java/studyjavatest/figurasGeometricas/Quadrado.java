package studyjavatest.figurasGeometricas;

public class Quadrado {

    private double lado;

    public Quadrado() { }
    public Quadrado(double lado) { 
        setLado(lado);
    }

    public double getLado() {
        return this.lado;
    }

    public void setLado(double lado) {
        if(lado <= 0)
            throw new IllegalArgumentException("O lado precisa ser maior do que 0.");
        this.lado = lado;
    }

    public double calcularArea() {
        return lado * lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }

    
}
