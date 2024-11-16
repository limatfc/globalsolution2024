package br.com.fiap.model;

import br.com.fiap.dao.TarifaDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Tarifa {
    private Endereco endereco;
    private LocalDate data;
    private List<TarifaItem> listaTarifaItem;
    public  Tarifa(){
    data = LocalDate.now();
    endereco = new Endereco();
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public LocalDate getData() {
        return data;
    }

    public List<TarifaItem> getListaTarifaItem() {
        return listaTarifaItem;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setListaTarifaItem(List<TarifaItem> listaTarifaItem) {
        this.listaTarifaItem = listaTarifaItem;
    }

    public void getEnderecoFromUsuario(Scanner sc){
        System.out.println("Para ver as tarifas do dia de hoje para a sua região, por favor, insira um endereço válido");
        endereco.setEnderecoFromInput(sc);
    }

    public void getInformacaoTarifa() throws SQLException {
        System.out.println("Para o endereço " + endereco.toString() + ", as tarifas para hoje, dia " + data + " são: ");
        TarifaDAO dao = new TarifaDAO();
        listaTarifaItem = dao.getTarifasDB(endereco, data);
        TarifaItem newTarifaItem = new TarifaItem();
        newTarifaItem.mostrarLista(listaTarifaItem);
    }
}
