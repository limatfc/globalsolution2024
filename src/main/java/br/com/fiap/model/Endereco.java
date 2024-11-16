package br.com.fiap.model;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Endereco {
    private String logradouro;
    private String nome;
    private int numero;
    private String cidade;
    private String cep;
    private String siglaEstado;

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        if (numero <1){
            System.out.println("Ops, números em endereços não podem ser negativos");
            this.numero = 0;
            return;
        }
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        if (cep.contains("-")){
            cep.replace("-", "");
        } else if (Pattern.matches("[a-zA-Z]+", cep) == true && cep.trim().length() != 8) {
            System.out.println("Ops, um CEP deve conter 8 números. Tente novamente");
            this.cep = "";
            return;
        }
        this.cep = cep;
    }

    public void setSiglaEstado(String estado) {
        if (estado.length() != 2) {
             System.out.println("Ops, uma sigla deve conter somente 2 caracteres");
             this.siglaEstado = "";
             return;
        }
        this.siglaEstado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return siglaEstado;
    }

    public void setEnderecoFromInput(Scanner sc){
        try{
            System.out.println("Qual o logradouro? ex. rua, avenida, complexo");
            String logradouroDigitado = sc.next();
            setLogradouro(logradouroDigitado);
            System.out.println("Qual o nome do logradouro?");
            setNome(sc.next());
            System.out.println("Qual o número?");
            setNumero(sc.nextInt());
            if ( numero == 0){
                setNumero(sc.nextInt());
            }
            System.out.println("Qual a cidade?");
            cidade = sc.next();
            System.out.println("Qual o CEP?");
            setCep(sc.next());
            System.out.println("Qual o estado? Utilize a sigla, ex. MG, SP");
            setSiglaEstado(sc.next());
            if (logradouro.isEmpty() || nome.isEmpty() || cidade.isEmpty()  || siglaEstado.isEmpty() || cep.isEmpty()){
                System.out.println("Ops, parece que algo deu errado. Por favor, insira um endereço válido");
                setEnderecoFromInput(sc);
            }
        } catch (Exception e){
            System.out.println("Ops, parece que algo deu errado. Por favor, insira um endereço válido");
            Scanner newScanner = new Scanner(System.in);
            setEnderecoFromInput(newScanner);
        }
    }

    public String toString(){
       return "\n" + logradouro + " " +
               nome + ", " + numero +
               "\n" + cidade + ", " + cep +  ", " + siglaEstado;
    }
}
