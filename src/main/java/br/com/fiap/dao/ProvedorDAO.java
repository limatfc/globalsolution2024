package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ProvedorDAO {
    private Connection conexao;

    public ProvedorDAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public String getProvedorDB(String siglaEstado) throws SQLException {
        fecharConexao();
        return "Conectar com o banco, CEMIG ";

    }
}
