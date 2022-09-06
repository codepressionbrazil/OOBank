package banco.view;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        login();
    }

    private static void login() {
        System.out.println("1- banco.model.entities.Cliente\n2- banco.model.entities.Gerente");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1 -> {

            }
            case 2 -> {

            }
        }
    }

}
