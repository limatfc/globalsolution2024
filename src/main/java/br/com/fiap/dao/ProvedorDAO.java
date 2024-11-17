package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;

import java.sql.*;

public class ProvedorDAO {
    private Connection conexao;
    CallableStatement callableStatement = null;

    public ProvedorDAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public String getProvedorDB(String siglaEstado) throws SQLException {
        callableStatement = conexao.prepareCall("{ call ConsultaEmpresasDisponiveisPorEstado(?, ?) }");
        callableStatement.setString(1, siglaEstado.toUpperCase());
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.execute();
        String result = callableStatement.getString(2);
        if (result != null){
            return result;
        }
        fecharConexao();
        return ("");
    }
}
