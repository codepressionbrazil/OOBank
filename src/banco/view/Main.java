package banco.view;

import banco.controller.ClienteController;
import banco.controller.ContaPessoalController;
import banco.controller.GerenteController;
import banco.model.dao.ContaPessoalDAO;
import banco.model.entities.Cliente;
import banco.model.entities.ContaPessoal;
import banco.model.entities.Gerente;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Cliente clienteLogado = null;
    static Gerente gerenteLogado = null;

    public static void main(String[] args) {
        atualizarSistema();
        login();
    }

    public static void atualizarSistema(){
        ContaPessoalController.atualizarRendas();
        ContaPessoalController.buscarDadosBD();
        ClienteController.buscarDadosBD();
//        GerenteController.buscarDadosBD();
    }

    public static Cliente getUsuario() {
        return clienteLogado;
    }

    private static void login() {
        System.out.print("Opção de login:\n1- Cliente\n2- Gerente\n-->: ");
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
        System.out.print("Insira seu usuario: ");
        sc.nextLine();
        String usuario = sc.nextLine();
        System.out.print("\nInsira sua senha: ");
        String senha = sc.nextLine();
        if (tipo == 1) {
            ClienteController clienteController = new ClienteController();
            clienteLogado = clienteController.logar(usuario, senha);

            if (clienteLogado != null) {
                menuCliente();
            } else {
                System.out.println("Erro ao logar-se");
            }
        } else if (tipo == 2) {
            GerenteController gerenteController = new GerenteController();
            gerenteLogado = gerenteController.logar(usuario, senha);
            if (gerenteLogado != null) {
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
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Senha: ");
            String senha = sc.next();
            System.out.print("Endereco: ");
            String endereco = sc.next();
            System.out.print("CPF: ");
            String cpf = sc.next();
            System.out.print("Profissao: ");
            String profissao = sc.next();
            System.out.print("Renda: ");
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
        System.out.print("Deseja fazer o que? \n1- Criar conta pessoal\n2- Sacar\n3- Depositar" +
                "\n4- Transferir\n5- Mostrar conta\n6- Sair\n-->: ");
        int opcaoMenu = sc.nextInt();
        while (opcaoMenu != 6) {
            if (opcaoMenu == 1) {
                System.out.println("Agencia: ");
                int agencia = sc.nextInt();
                System.out.println("Numero: ");
                int numero = sc.nextInt();
                System.out.println("Senha: ");
                String senha = sc.next();
                ContaPessoalController.cadastrarConta(agencia, numero, senha, clienteLogado.getCpf());

            } else if (opcaoMenu == 2) {
                System.out.println("Numero da conta: ");
                int numero = sc.nextInt();
                System.out.println("Senha: ");
                String senha = sc.next();
                System.out.println("Quanto deseja sacar? ");
                double valor = sc.nextDouble();
                ContaPessoalController.sacar(numero, senha, valor);

            } else if (opcaoMenu == 3) {
                System.out.println("Depositar para qual conta (numero contaPessoal): ");
                int numero = sc.nextInt();
                System.out.println("Quanto deseja depositar: ");
                double valor = sc.nextDouble();
                ContaPessoalController.depositar(numero, valor);

            } else if (opcaoMenu == 4) {
                System.out.print("Numero da conta: ");
                int numero = sc.nextInt();
                System.out.print("Senha: ");
                String senha = sc.next();
                ContaPessoal conta = ContaPessoalController.verificaConta(numero, senha);
                if(conta != null){
                    System.out.print("Conta do beneficiado: ");
                    int numeroBeneficiado = sc.nextInt();
                    System.out.print("Valor da transferência: ");
                    double valorTransferencia = sc.nextDouble();
                    ContaPessoalController.tranferir(conta, numeroBeneficiado, valorTransferencia);
                    System.out.println("Transferência concluída com sucesso!");
                }
            } else if(opcaoMenu == 5){
                System.out.print("Número da conta: ");
                int numero = sc.nextInt();
                System.out.print("Senha: ");
                String senha = sc.next();
                ContaPessoalController.mostrarConta(numero, senha);

            } else if(opcaoMenu == 6){
                login();
            }
            System.out.print("Deseja fazer o que? \n1- Criar conta pessoal\n2- Sacar\n3- Depositar" +
                    "\n4- Transferir\n5- Mostrar conta\n6- Sair\n-->: ");
            opcaoMenu = sc.nextInt();
        }
    }
}
