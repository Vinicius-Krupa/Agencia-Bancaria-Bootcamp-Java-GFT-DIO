package Programa;

import java.util.Date;
import Utilitarios.Utils;

public class Cliente {

    private static int counter = 1;

    private int numeroPessoa ;
    private String name;
    private String cpf;
    private String telefone;
    private Date accountCreationDate;

    public Cliente() { }

    public Cliente(String name, String cpf, String telefone) {
        this.numeroPessoa = Cliente.counter;
        this.name = name;
        this.cpf = cpf;
        this.telefone = telefone;
        this.accountCreationDate = new Date();
        Cliente.counter += 1;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Date getAccountCreationDate() {
        return this.accountCreationDate;
    }

    public String toString() {
        return  "\nName: " + this.getName() +
                "\nCPF: " + this.getCpf() +
                "\nTelefone: " + this.getTelefone() +
                "\nAccount Creation Date: " + Utils.dateToString(this.getAccountCreationDate());
    }


}
