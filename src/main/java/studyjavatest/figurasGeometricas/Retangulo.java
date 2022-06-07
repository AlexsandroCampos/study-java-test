package studyjavatest.figurasGeometricas;

public class Retangulo {

    private double base;
    private double altura;

    public Retangulo() { }

    public Retangulo(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return this.base;
    }

    public void setBase(double base) {
        if(base <= 0)
            throw new IllegalArgumentException("A base precisa ser maior do que 0.");
        this.base = base;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        if(altura <= 0)
            throw new IllegalArgumentException("A altura precisa ser maior do que 0.");
        this.altura = altura;
    }

    public double calcularArea(){
        return base*altura;
    }
    public double calcularPerimetro(){
        return 2*(base + altura);
    }
}
