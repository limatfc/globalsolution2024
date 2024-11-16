package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Consumo;
import br.com.fiap.model.ConsumoItem;
import br.com.fiap.model.Endereco;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final Connection conexao;
    public UsuarioDAO() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }
    public void fecharConexao() throws SQLException{
        conexao.close();
    }
    public Usuario getUsuarioDB() throws SQLException {
        fecharConexao();
        Usuario newUser = new Usuario();
        Endereco newEndereco = new Endereco();
        newEndereco.setNome("Josefino Dias");
        newEndereco.setNumero(43);
        newEndereco.setLogradouro("Rua");
        newEndereco.setCidade("Lavras");
        newEndereco.setCep("12345678");
        newEndereco.setSiglaEstado("MG");
        Consumo newConsumo = new Consumo();
        newConsumo.setDataInicio(LocalDate.now());
        newConsumo.setMaiorConsumo(345);
        newConsumo.setMenorConsumo(45);
        newConsumo.setTotalConsumo(4567);
        List novaLista = new ArrayList<>();
        ConsumoItem novoConsumoItem = new ConsumoItem();
        novoConsumoItem.setConsumo(345);
        novoConsumoItem.setFaturaPaga(false);
        novoConsumoItem.setValor(45.98);
        novoConsumoItem.setMes(LocalDate.parse("2024-09-18"));
        novaLista.add(novoConsumoItem);
        novoConsumoItem.setConsumo(345);
        novoConsumoItem.setFaturaPaga(false);
        novoConsumoItem.setValor(45.98);
        novoConsumoItem.setMes(LocalDate.parse("2024-09-18"));
        novaLista.add(novoConsumoItem);
        novoConsumoItem.setConsumo(345);
        novoConsumoItem.setFaturaPaga(false);
        novoConsumoItem.setValor(45.98);
        novoConsumoItem.setMes(LocalDate.parse("2024-09-18"));
        novaLista.add(novoConsumoItem);
        newConsumo.setListaConsumoItem(novaLista);
        newUser.setNome("Roberto");
        newUser.setEndereco(newEndereco);
        newUser.setConsumo(newConsumo);
        return newUser;
    }
}
