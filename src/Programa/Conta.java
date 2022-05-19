package Programa;

import Utilitarios.Utils;

public class Conta {

    private static int accountCounter = 1;

    private int numeroConta;
    private Cliente cliente;
    private Double saldo = 0.0;


    public Conta(Cliente cliente) {
        this.numeroConta = Conta.accountCounter;
        this.cliente = cliente;
        this.updateSaldo();
        Conta.accountCounter += 1;
    }


    public int getNumeroConta() {
        return numeroConta;
    }
    public Cliente getClient() {
        return cliente;
    }
    public void setClient(Cliente cliente) {
        this.cliente = cliente;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }

    public String toString() {

        return "\nBank account: " + this.getNumeroConta() +
                "\nCliente: " + this.cliente.getName() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nTelefone: " + this.cliente.getTelefone() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n" ;
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu dep�sito foi realizado com sucesso!");
        }else {
            System.out.println("N�o foi poss�vel realizar o dep�sito!");
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("N�o foi poss�vel realizar o saque!");
        }
    }

    public void transferencia(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transfer�ncia realizada com sucesso!");
        }else {
            System.out.println("N�o foi poss�vel realizar a tranfer�ncia");
        }

    }

}
