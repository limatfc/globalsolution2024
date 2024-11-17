package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Endereco;
import br.com.fiap.model.TarifaItem;
import oracle.jdbc.internal.OracleTypes;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TarifaDAO {
    private final Connection conexao;
    CallableStatement callableStatement = null;

    public TarifaDAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public List<TarifaItem> getTarifasDB(String provedor) throws SQLException {
        callableStatement = conexao.prepareCall("{ call ConsultaPrecosPorHora(?, ?) }");
        callableStatement.setString(1, provedor);
        callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
        callableStatement.execute();
        ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
        List novaLista = new ArrayList<>();
        while (resultSet.next()) {
            TarifaItem novaTarifaItem = new TarifaItem();
            Timestamp hora = resultSet.getTimestamp("Hora");
            float preco = resultSet.getFloat("Preco");
            novaTarifaItem.setHora(hora);
            novaTarifaItem.setPreco((double) preco);
            novaLista.add(novaTarifaItem);
        }
        fecharConexao();


        return novaLista;
    }
}
