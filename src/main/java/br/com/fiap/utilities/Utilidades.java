package br.com.fiap.utilities;

import br.com.fiap.model.Provedor;
import br.com.fiap.model.Tarifa;
import br.com.fiap.model.Usuario;

import java.util.Scanner;

public class Utilidades {
    int userSelection;
    public void menuInicial(Scanner sc){
        System.out.println("Ola, bem-vindo à Electric Check! Por favor, escolha qual opção você deseja para continuar:" +
                "\n1. Consultar fornecedores de energia por estado" +
                "\n2. Cálculo de custo diário hora a hora" +
                "\n3. Informações sobre o cliente" +
                "\n0. ou 0 para Sair."
        );
        try {
            this.userSelection = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Ops, parece que a opção escolhida não existe. Por favor, tente novamente.");
            sc.nextLine();
            menuInicial(sc);
        }
    }

    public void selecaoMenu(Scanner sc) throws Exception {
        do {
            if (userSelection == 1) {
                System.out.println("Opção selecionada: Consulta de fornecedores de energia");
                Provedor novoProvedor = new Provedor();
                novoProvedor.getProvedorFromEstadoInputed(sc);
                novoProvedor.getInformacaoProvedor();
                sideMenu(sc);
            } else if (userSelection == 2) {
                System.out.println("Opção selectionada: Cálculo de custo diário hora e hora");
                Tarifa novaTarifa = new Tarifa();
                novaTarifa.getEnderecoFromUsuario(sc);
                novaTarifa.getInformacaoTarifa();
                sideMenu(sc);
            } else if (userSelection == 3) {
                System.out.println("Opção selectionada: Informações sobre o cliente");
                Usuario novoUsuario = new Usuario();
                novoUsuario.getInformacaoUsuario();
                sideMenu(sc);
            } else if (userSelection == 0) {
                System.out.println("Saindo do programa");
            } else {
                System.out.println("Ops, parece que a opção escolhida não existe. Por favor, tente novamente.");
                menuInicial(sc);
            }
        } while (this.userSelection != 0);
        sc.close();
    }

    public void sideMenu(Scanner sc){
        System.out.println("\n\n\nComo deseja proceguir?" +
                "\n1. Voltar para o menu principal" +
                "\n0. Sair" );
        try {
            this.userSelection = sc.nextInt();
            if (userSelection == 1) {
                menuInicial(sc);
            } else if (userSelection == 0) {
                System.out.println("Saindo do programa");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
                sideMenu(sc);
            }
        } catch (Exception e) {
            System.out.println("Ops, parece que a opção escolhida não existe. Por favor, tente novamente.");
            sc.nextLine();
            sideMenu(sc);
        }
    }
}
