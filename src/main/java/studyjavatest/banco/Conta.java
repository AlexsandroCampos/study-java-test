package studyjavatest.banco;

public class Conta {

    public int codigo;
    public double saldo;
    public double limite;

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
