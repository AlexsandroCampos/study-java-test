package studyjavatest.banco;

public class Conta {

    private int codigo;
    private double saldo;
    private double limite;

    public Conta() { }
    public Conta(int codigo, double limite) {
        setCodigo(codigo);
        setLimite(limite);        
    }

    private void setCodigo(int codigo) {
        if(codigo < 0)
            throw new IllegalArgumentException("O código não pode ser negativo");
        this.codigo = codigo;
    }

    private void setLimite(double limite) {
        if(limite < 0)
            throw new IllegalArgumentException("O limite não pode ser negativo");
        this.limite = limite;
    }

    public boolean depositar(double valor) {
        if(valor > 0){
            saldo = saldo + valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if(saldo + limite >= valor) {
            saldo = saldo - valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta conta, double valor) {
        if(saldo + limite >= valor) {
            saldo = saldo - valor;
            conta.saldo = conta.saldo + valor;
            return true;
        }
        return false;
    }
}
