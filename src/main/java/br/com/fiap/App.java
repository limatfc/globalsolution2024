package br.com.fiap;


import br.com.fiap.utilities.Utilidades;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws Exception {
        Scanner sc = new Scanner(System.in);
        Utilidades util = new Utilidades();
        util.menuInicial(sc);
        util.selecaoMenu(sc);
    }
}
