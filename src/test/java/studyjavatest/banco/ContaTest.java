package studyjavatest.banco;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaTest {

    @Test
    @DisplayName("Should initialize attributes when non-parameterized constructor is called")
    public void shouldInitializeAttributesWhenNonParameterizedConstructorIsCalled() {
        Conta conta = new Conta();

        assertNotNull(conta);
    }

    @Test
    @DisplayName("Should initiate attributes when parameterized constructor is called")
    public void shouldInitiateAttributeWhenParameterizedConstructorIsCalled() {
        int codigo = 1;
        double limite = 50.0;
        double saldo = 0.0;
        Conta conta = new Conta(codigo, limite);

        assertNotNull(conta);
        assertEquals(conta.getCodigo(), codigo);
        assertEquals(conta.getSaldo(), saldo, 0);
        assertEquals(conta.getLimite(), limite, 0);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when parameterized constructor receive negative Codigo parameter")
    public void shouldThrowIllegalArgumentExceptionWhenParameterizedConstructorReceiveNegativeCodigoParameter() {
        int codigo = -1;
        double limite = 50.0;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Conta(codigo, limite)
        );

        assertEquals("O código não pode ser negativo", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when parameterized constructor receive negative Limite parameter")
    public void shouldThrowIllegalArgumentExceptionWhenParameterizedConstructorReceiveNegativeLimiteParameter() {
        int codigo = 1;
        double limite = -50.0;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Conta(codigo, limite)
        );

        assertEquals("O limite não pode ser negativo", exception.getMessage());
    }

    @Test
    @DisplayName("Get Codigo should get Codigo attribute")
    public void getCodigo_ShouldGetCodigoAttribute() {
        int codigo = 1;
        double limite = 50.0;

        Conta conta = new Conta(codigo, limite);

        assertEquals(conta.getCodigo(), codigo);
    }

    @Test
    @DisplayName("Get Limite should get Limite attribute")
    public void getLimite_ShouldGetLimiteAttribute() {
        int codigo = 1;
        double limite = 50.0;

        Conta conta = new Conta(codigo, limite);

        assertEquals(conta.getLimite(), limite, 0);
    }

    @Test
    @DisplayName("Get Saldo should get Saldo attribute")
    public void getSaldo_ShouldGetSaldoAttribute() {
        int codigo = 1;
        double limite = 50.0;
        double saldo = 0.0;

        Conta conta = new Conta(codigo, limite);

        assertEquals(conta.getSaldo(), saldo, 0);
    }

    @Test
    @DisplayName("Depositar should add a value to Saldo attribute and return true")
    public void Depositar_ShouldAddValueToSaldoAttributeAndReturnTrue() {
        int codigo = 1;
        double limite = 50.0;
        double saldoInicial = 0.0;
        double valor = 10.0;

        Conta conta = new Conta(codigo, limite);

        assertTrue(conta.depositar(valor));
        assertEquals(conta.getSaldo(), valor, 0);
        assertFalse(conta.getSaldo() == saldoInicial);
    }

    @Test
    @DisplayName("Depositar should return false and not add a value to Saldo attribute when value paramiter is negative")
    public void Depositar_ShouldReturnFalseAndNitAddValueToSaldoAttributeWhenValueParameterIsNegative() {
        int codigo = 1;
        double limite = 50.0;
        double saldoInicial = 0.0;
        double valor = -10.0;

        Conta conta = new Conta(codigo, limite);

        assertFalse(conta.depositar(valor));
        assertEquals(conta.getSaldo(), saldoInicial, 0);
        assertFalse(conta.getSaldo() == valor);
    }

    @Test
    @DisplayName("Depositar should return false and not add a value to Saldo attribute when value paramiter is zero")
    public void Depositar_ShouldReturnFalseAndNitAddValueToSaldoAttributeWhenValueParameterIsZero() {
        int codigo = 1;
        double limite = 50.0;
        double saldoInicial = 0.0;
        double valor = 0.0;

        Conta conta = new Conta(codigo, limite);

        assertFalse(conta.depositar(valor));
        assertEquals(conta.getSaldo(), saldoInicial, 0);
    }

    @Test
    @DisplayName("Sacar should remove a value from Saldo attribute and return true")
    public void Sacar_ShouldRemoveValueFromSaldoAttributeAndReturnTrue() {
        int codigo = 1;
        double limite = 50.0;
        double valorDepositado = 10.0;
        double valorSacado = 5.0;

        Conta conta = new Conta(codigo, limite);
        conta.depositar(valorDepositado);

        assertTrue(conta.sacar(valorSacado));
        assertEquals(conta.getSaldo(), (valorDepositado - valorSacado), 0);
        assertFalse(conta.getSaldo() == valorDepositado);
    }

    @Test
    @DisplayName("Sacar should remove a value from Saldo attribute and return true when value parameter is greater than Saldo")
    public void Sacar_ShouldRemoveValueFromSaldoAttributeAndReturnTrueWhenValueParameterIsGreaterThanSaldo() {
        int codigo = 1;
        double limite = 50.0;
        double valorDepositado = 10.0;
        double valorSacado = 20.0;

        Conta conta = new Conta(codigo, limite);
        conta.depositar(valorDepositado);

        assertTrue(conta.sacar(valorSacado));
        assertEquals(conta.getSaldo(), (valorDepositado - valorSacado), 0);
        assertFalse(conta.getSaldo() == valorDepositado);
    }

    @Test
    @DisplayName("Sacar should return false and not remove a value from Saldo attribute when value parameter is negative")
    public void Sacar_ShouldReturnFalseAndNotRemoveValueFromSaldoAttributeWhenValueParameterIsNegative() {
        int codigo = 1;
        double limite = 50.0;
        double valorDepositado = 10.0;
        double valorSacado = -5.0;

        Conta conta = new Conta(codigo, limite);
        conta.depositar(valorDepositado);

        assertFalse(conta.sacar(valorSacado));
        assertEquals(conta.getSaldo(), valorDepositado, 0);
    }

    @Test
    @DisplayName("Sacar should return false and not remove a value from Saldo attribute when value parameter is greater than sum of Limite and Saldo")
    public void Sacar_ShouldReturnFalseAndNotRemoveValueFromSaldoAttributeWhenValueParameterIsGreaterThanSumOfLimiteAndSaldo() {
        int codigo = 1;
        double limite = 50.0;
        double valorDepositado = 10.0;
        double valorSacado = 90.0;

        Conta conta = new Conta(codigo, limite);
        conta.depositar(valorDepositado);

        assertFalse(conta.sacar(valorSacado));
        assertEquals(conta.getSaldo(), valorDepositado, 0);
    }

    @Test
    @DisplayName("Transferir should remove a value from Saldo attribute, add a value to another Conta and return true")
    public void Transferir_ShouldRemoveValueFromSaldoAttributeAddValueToAnotherContaAndReturnTrue() {
        int codigo = 1;
        int codigo2 = 2;
        double limite = 50.0;
        double limite2 = 60.0;
        double valorDepositado = 10.0;
        double valorTransferido = 10.0;

        Conta conta = new Conta(codigo, limite);
        Conta conta2 = new Conta(codigo2, limite2);

        conta.depositar(valorDepositado);

        assertTrue(conta.transferir(conta2, valorTransferido));
        assertEquals(conta.getSaldo(), (valorDepositado - valorTransferido), 0);
        assertEquals(conta2.getSaldo(), valorTransferido, 0);
    }

    @Test
    @DisplayName("Transferir should remove a value from Saldo attribute, add a value to another Conta and return true when value parameter is greater than Saldo")
    public void Transferir_ShouldRemoveValueFromSaldoAttributeAddValueToAnotherContaAndReturnTrueWhenValueParameterIsGreaterThanSaldo() {
        int codigo = 1;
        int codigo2 = 2;
        double limite = 50.0;
        double limite2 = 60.0;
        double valorDepositado = 10.0;
        double valorTransferido = 20.0;

        Conta conta = new Conta(codigo, limite);
        Conta conta2 = new Conta(codigo2, limite2);

        conta.depositar(valorDepositado);

        assertTrue(conta.transferir(conta2, valorTransferido));
        assertEquals(conta.getSaldo(), (valorDepositado - valorTransferido), 0);
        assertEquals(conta2.getSaldo(), valorTransferido, 0);
    }

    @Test
    @DisplayName("Transferir should return false, not remove value from Saldo attribute and not add a value to another Conta when value parameter is negative")
    public void Transferir_ShouldReturnFalseNotRemoveValueFromSaldoAttributeNotAddValueToAnotherContaWhenValueParameterIsNegative() {
        int codigo = 1;
        int codigo2 = 2;
        double limite = 50.0;
        double limite2 = 60.0;
        double valorDepositado = 10.0;
        double valorTransferido = -10.0;

        Conta conta = new Conta(codigo, limite);
        Conta conta2 = new Conta(codigo2, limite2);

        conta.depositar(valorDepositado);

        assertFalse(conta.transferir(conta2, valorTransferido));
        assertFalse(conta.getSaldo() == (valorDepositado - valorTransferido));
        assertFalse(conta2.getSaldo() == valorTransferido);
    }

    @Test
    @DisplayName("Transferir should return false, not remove value from Saldo attribute and not add a value to another Conta  when value parameter is greater than sum of Limite and Saldo")
    public void Transferir_ShouldReturnFalseNotRemoveValueFromSaldoAttributeNotAddValueToAnotherContaWhenValueParameterIsGreaterThanSumOfLimiteAndSaldo() {
        int codigo = 1;
        int codigo2 = 2;
        double limite = 50.0;
        double limite2 = 60.0;
        double valorDepositado = 10.0;
        double valorTransferido = 90.0;

        Conta conta = new Conta(codigo, limite);
        Conta conta2 = new Conta(codigo2, limite2);

        conta.depositar(valorDepositado);

        assertFalse(conta.transferir(conta2, valorTransferido));
        assertFalse(conta.getSaldo() == (valorDepositado - valorTransferido));
        assertFalse(conta2.getSaldo() == valorTransferido);
    }

}
