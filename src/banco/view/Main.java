package banco.view;

import banco.controller.ClienteController;
import banco.controller.ContaPessoalController;
import banco.controller.GerenteController;
import banco.model.entities.Cliente;
import banco.model.entities.ContaCorrente;
import banco.model.entities.ContaPessoal;
import banco.model.entities.Gerente;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Cliente clienteLogado = null;
    static Gerente gerenteLogado = null;

    public static void main(String[] args) {
        login();
    }

    public static Cliente getUsuario() {
        return clienteLogado;
    }

    private static void login() {
        System.out.println("1- Cliente\n2- Gerente");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {
                executarLogin(1);
            }
            case 2 -> {
                executarLogin(2);
            }
        }
    }

    private static void executarLogin(int tipo) {
        System.out.println("Insira seu usuario: ");
        String usuario = sc.next();
        System.out.println("Insira sua senha: ");
        String senha = sc.next();
        if (tipo == 1) {
            ClienteController clienteController = new ClienteController();
            if (clienteController.logar(usuario, senha)) {
                clienteLogado = clienteController.buscarCliente(usuario, senha);
                menuCliente();
            } else {
                System.out.println("Erro ao logar-se");
            }
        } else if (tipo == 2) {
            GerenteController gerenteController = new GerenteController();
            if (gerenteController.logar(usuario, senha)) {
                gerenteLogado = gerenteController.buscarGerente(usuario, senha);
                menuGerente();
            } else {
                System.out.println("Erro ao logar-se");
            }
        }
        login();
    }

    private static void menuGerente() {
        GerenteController gerenteController = new GerenteController();
        System.out.println("1- Cadastrar Cliente\n2- Listar Clientes\n3- Voltar");
        int opcao = sc.nextInt();
        if (opcao == 1) {
            System.out.println("Cadastrar Cliente!!!");
            System.out.println("Nome: ");
            String nome = sc.next();
            System.out.println("Senha: ");
            String senha = sc.next();
            System.out.println("Endereco: ");
            String endereco = sc.next();
            System.out.println("CPF: ");
            String cpf = sc.next();
            System.out.println("Profissao: ");
            String profissao = sc.next();
            System.out.println("Renda: ");
            Double renda = sc.nextDouble();
            if (gerenteController.cadastrarCliente(nome, senha, endereco, cpf, profissao, renda)) {
                System.out.println("Cliente cadastrado!");
            } else {
                System.out.println("Erro ao cadastrar cliente!");
            }
        } else if (opcao == 2) {
            System.out.println(gerenteController.listarClientes());
        } else if (opcao == 3) {
            login();
        }
        menuGerente();
    }

    private static void menuCliente() {
        System.out.println("Deseja fazer o que? \n1- Criar conta pessoal\n2- Sacar\n3- Depositar" +
                "\n4- Transferir\n5- Mostrar conta\n6- Sair");
        int opcaoMenu = sc.nextInt();
        while (opcaoMenu != 5) {
            if (opcaoMenu == 1) {
                System.out.println("Agencia: ");
                int agencia = sc.nextInt();
                System.out.println("Numero: ");
                int numero = sc.nextInt();
                System.out.println("Senha: ");
                String senha = sc.next();
                new ContaPessoal(agencia, numero, senha, clienteLogado, 0.0);
                System.out.println("Conta pessoal criada!");
                menuCliente();
            } else if (opcaoMenu == 2) {
                int tipoConta = tipoConta();
                System.out.println("Quanto deseja sacar? ");
                double sacar = sc.nextDouble();
                ContaPessoalController.sacar(tipoConta, sacar);
                menuCliente();
            } else if (opcaoMenu == 3) {
                int tipoConta = tipoConta();
                System.out.println("Depositar para qual conta (numero contaPessoal): ");
                int numero = sc.nextInt();
                System.out.println("Quanto deseja depositar: ");
                double valor = sc.nextDouble();
                ContaPessoalController.depositar(tipoConta, numero, valor);
                menuCliente();
            } else if (opcaoMenu == 4) {
                menuCliente();
            } else if(opcaoMenu == 5){
                int tipoConta = tipoConta();
//                ContaPessoal conta = ContaPessoalController.buscarConta(Main.getUsuario(), tipoConta).toString());
//                JOptionPane.showMessageDialog(null, conta);
                menuCliente();
            } else if(opcaoMenu == 6){
                login();
            }
        }
    }

    public static int tipoConta() {
        System.out.println("1- Conta corrente\n2- Conta poupanca\n3- Conta credito");
        return sc.nextInt();
    }

}
