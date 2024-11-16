package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Endereco;
import br.com.fiap.model.TarifaItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TarifaDAO {
    private final Connection conexao;

    public TarifaDAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    public void fecharConexao() throws SQLException{
        conexao.close();
    }

    public List<TarifaItem> getTarifasDB(Endereco endereco, LocalDate data) throws SQLException {
        fecharConexao();
        List novaLista = new ArrayList<>();
        TarifaItem novaTarifaItem = new TarifaItem();
        novaTarifaItem.setHora(LocalTime.parse("00:00"));
        novaTarifaItem.setPreco(123.09);
        novaLista.add(novaTarifaItem);
        novaTarifaItem.setHora(LocalTime.parse("01:00"));
        novaTarifaItem.setPreco(124.09);
        novaLista.add(novaTarifaItem);
        novaTarifaItem.setHora(LocalTime.parse("02:00"));
        novaTarifaItem.setPreco(125.09);
        novaLista.add(novaTarifaItem);
        return novaLista;
    }
}
