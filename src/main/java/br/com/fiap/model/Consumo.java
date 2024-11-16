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

    public String toString(){
        ConsumoItem novoConsumoItem = new ConsumoItem();
        novoConsumoItem.mostrarLista(listaConsumoItem);
        return "Aqui está o seu consumo: " + menorConsumo + maiorConsumo + totalConsumo + dataInicio + dateFim ;
    }
}
