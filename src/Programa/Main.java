package Programa;

import java.util.ArrayList;
import java.util.Scanner;
import Programa.Cliente;
import Programa.Conta;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        System.out.println("\tBEM VINDOS A NOSSA AGÊNCIA\n");
        System.out.println("*** Selecione a operação que deseja realizar ***");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Transferir");
        System.out.println("6 - Listar");
        System.out.println("7 - Sair");

        int operacao = input.nextInt();;

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
            	saldo();
            	break;
            case 3:
                depositar();
                break;

            case 4:
                sacar();
                break;

            case 5:
                transferir();
                break;

            case 6:
                listarContas();
                break;

            case 7:
                System.out.println("Obrigado por usar nossa agência!");
                System.exit(0);

            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = input.next();
        clearBuffer(input);
        
        System.out.println("\nCPF: ");
        String cpf = input.next();
        clearBuffer(input);
        
        System.out.println("Telefone: ");
        String telefone = input.next();
        clearBuffer(input);
        
        Cliente cliente = new Cliente(nome, cpf, telefone);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("--- Sua conta foi criada com sucesso! ---");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumeroConta() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }
    
    public static void saldo() {
		System.out.println("Número da Conta que deseja ver o saldo: ");
		int numeroConta = input.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		if(conta != null) {
			System.out.println(conta);
		} else {
			System.out.println("Conta não encontrada!");
		}
		operacoes();
	}

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();

            conta.depositar(valorDeposito);
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        operacoes();

    }

    public static void transferir() {
        System.out.println("Número da conta que vai enviar a transferência: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);

            }else {
                System.out.println("--- A conta para depósito não foi encontrada ---");
            }

        }else {
            System.out.println("--- Conta para transferência não encontrada ---");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else {
            System.out.println("--- Não há contas cadastradas ---");
        }

        operacoes();
    }
    
    public static void clearBuffer(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
    }
}
