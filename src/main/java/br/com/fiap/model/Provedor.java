package br.com.fiap.model;

import br.com.fiap.dao.ProvedorDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Provedor {
    private String provedor;
    private String siglaEstado;

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String estado) {
        this.siglaEstado = estado;
    }
    public void getProvedorFromEstadoInputed(Scanner sc){
        System.out.println("Para começar a busca de quais empresas fornecem energia, por favor, insira o estado desejado. Utilize somente a sigla, por exemplo, MG ou SP.");
    try{
        String estadoDigitado = sc.next();
        if (estadoDigitado.length() != 2){
            System.out.println("Ops, a sigla deve conter somente 2 caracteres");
            getProvedorFromEstadoInputed(sc);
        } else {
            siglaEstado = estadoDigitado;
            buscaProvedorPorEstado();
        }
    } catch (Exception e){
        System.out.println("Ops, parece que algo deu errado. Por favor, tente novamente");
        getProvedorFromEstadoInputed(sc);
    }
    }
    public void buscaProvedorPorEstado() throws SQLException {
        ProvedorDAO dao = new ProvedorDAO();
         provedor = dao.getProvedorDB(siglaEstado);
    }

    public void getInformacaoProvedor(){
        System.out.println("Para o estado " + siglaEstado.toUpperCase() + ", o provedor de energia disponível é " + provedor);
    }
}
