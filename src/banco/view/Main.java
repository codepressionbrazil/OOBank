package banco.view;

import banco.controller.ClienteController;
import banco.controller.GerenteController;
import banco.model.entities.Cliente;
import banco.model.entities.ContaPessoal;
import banco.model.entities.Gerente;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Cliente clienteLogado;
    static Gerente gerenteLogado;

    public static void main(String[] args) {

        System.out.println("yyyy/mm/dd HH:mm -> " + dtf5.ZonedDateTime.now());
        System.out.println(LocalDateTime.now());
        login();
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
            }
        } else if (tipo == 2) {
            GerenteController gerenteController = new GerenteController();
            if (gerenteController.logar(usuario, senha)) {
                gerenteLogado = gerenteController.buscarGerente(usuario, senha);
                menuGerente();
            }
        }
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
        System.out.println("Deseja fazer o que? 1- Criar conta pessoal\n2- Sacar\n3- Depositar\n4- Transferir");
        int opcao = sc.nextInt();
        if (opcao == 1) {
            System.out.println("Agencia: ");
            int agencia = sc.nextInt();
            System.out.println("Numero: ");
            int numero = sc.nextInt();
            System.out.println("Senha: ");
            String senha = sc.next();
            new ContaPessoal(agencia, numero, senha, clienteLogado);
            System.out.println("Conta pessoal criada!");
        } else if (opcao == 2) {

        } else if (opcao == 3) {

        } else if (opcao == 4) {

        }
    }
}
