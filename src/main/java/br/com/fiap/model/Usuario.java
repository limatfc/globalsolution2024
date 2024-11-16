package br.com.fiap.model;

import br.com.fiap.dao.UsuarioDAO;

import java.sql.SQLException;

public class Usuario {
    private String nome;
    private Endereco endereco;
    private Consumo consumo;
    public Usuario(){
        endereco = new Endereco();
        consumo = new Consumo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }
    public void getInformacaoUsuario() throws SQLException {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario newUser = dao.getUsuarioDB();
        System.out.println("Aqui estão as suas informações, " + newUser.nome);
        System.out.println(newUser.endereco.toString());
        System.out.println(newUser.consumo.toString());

    }


}
