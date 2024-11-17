package br.com.fiap.model;

import java.time.LocalDate;
import java.util.List;

public class Consumo {
    int menorConsumo;
    int maiorConsumo;
    int totalConsumo;
    LocalDate dataInicio;
    LocalDate dateFim;
    List<ConsumoItem> listaConsumoItem;

    public int getMenorConsumo() {
        return menorConsumo;
    }

    public int getMaiorConsumo() {
        return maiorConsumo;
    }

    public int getTotalConsumo() {
        return totalConsumo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDateFim() {
        return dateFim;
    }

    public List<ConsumoItem> getListaConsumoItem() {
        return listaConsumoItem;
    }

    public void setMenorConsumo(int menorConsumo) {
        this.menorConsumo = menorConsumo;
    }

    public void setMaiorConsumo(int maiorConsumo) {
        this.maiorConsumo = maiorConsumo;
    }

    public void setTotalConsumo(int totalConsumo) {
        this.totalConsumo = totalConsumo;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDateFim(LocalDate dateFim) {
        this.dateFim = dateFim;
    }

    public void setListaConsumoItem(List<ConsumoItem> listaConsumoItem) {
        this.listaConsumoItem = listaConsumoItem;
    }

    public void getInformacaoConsumo(){
        System.out.println(this);
        ConsumoItem novoConsumoItem = new ConsumoItem();
        novoConsumoItem.mostrarLista(listaConsumoItem);
    }

    public String toString(){
        return "\nAqui está o seu consumo: " +
                "\nMenor consumo: " + menorConsumo + "kWh" +
                "\nMaior consumo: " + maiorConsumo + "kWh" +
                "\nTotal consumo: " + totalConsumo + "kWh" +
                "\nA sua conta está ativa desde: " + dataInicio;
    }
}
