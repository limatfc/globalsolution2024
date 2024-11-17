package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.*;
import oracle.jdbc.internal.OracleTypes;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final Connection conexao;
    CallableStatement callableStatement = null;
    public UsuarioDAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    public void fecharConexao() throws SQLException{
        conexao.close();
    }
    public Usuario getUsuarioDB() throws SQLException {
        Usuario newUser = new Usuario();
        newUser.setNome("Roberto dos Santos");
        Endereco newEndereco = new Endereco();
        newEndereco.setNome("Josefino Dias");
        newEndereco.setNumero(43);
        newEndereco.setLogradouro("Rua");
        newEndereco.setCidade("Sorocaba");
        newEndereco.setCep("13106-508");
        newEndereco.setSiglaEstado("SP");
        newUser.setEndereco(newEndereco);

        callableStatement = conexao.prepareCall("{ call DetalhesConsumoCliente(?, ?, ?) }");
        callableStatement.setString(1, "12345678901");
        callableStatement.setString(2, "senha123");
        callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
        callableStatement.execute();
        ResultSet resultSet = (ResultSet) callableStatement.getObject(3);
        List novaLista = new ArrayList<>();

        if (resultSet.next()) {
            Consumo newConsumo = new Consumo();
            double menorConsumo = resultSet.getDouble("Menor_Consumo");
            newConsumo.setMenorConsumo((int) menorConsumo);
            double maiorConsumo = resultSet.getDouble("Maior_Consumo");
            newConsumo.setMaiorConsumo((int) maiorConsumo);
            double totalConsumo = resultSet.getDouble("Total_Consumo");
            newConsumo.setTotalConsumo((int) totalConsumo);
            Date mes = resultSet.getDate("Mes");
            newConsumo.setDataInicio(mes.toLocalDate());
            newUser.setConsumo(newConsumo);
            do {
                ConsumoItem novoConsumoItem = new ConsumoItem();
                Date mesVariable = resultSet.getDate("Mes");
                novoConsumoItem.setMes(mesVariable.toLocalDate());
                double consumoUnidade = resultSet.getDouble("Consumo_Unidade");
                novoConsumoItem.setConsumo((int) consumoUnidade);
                double valorFatura = resultSet.getDouble("Valor_Fatura");
                novoConsumoItem.setValor(valorFatura);
                String pago = resultSet.getString("Pago");
                novoConsumoItem.setFaturaPaga(pago);
                novaLista.add(novoConsumoItem);
            } while (resultSet.next());
            newConsumo.setListaConsumoItem(novaLista);
        }
        fecharConexao();
        return newUser;
    }
}
