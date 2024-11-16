package br.com.fiap.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ConsumoItem {
    Month mes;
    int consumo;
    Double valor;
    Boolean faturaPaga;

    public Month getMes() {
        return mes;
    }

    public int getConsumo() {
        return consumo;
    }

    public Double getValor() {
        return valor;
    }

    public Boolean getFaturaPaga() {
        return faturaPaga;
    }

    public void setMes(LocalDate data) {
        this.mes = data.getMonth();
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setFaturaPaga(Boolean faturaPaga) {
        this.faturaPaga = faturaPaga;
    }

    public void mostrarLista(List<ConsumoItem> lista){
        for (ConsumoItem item : lista){
            System.out.println("Consumo: " + item.getConsumo() + "Mês: " + item.getMes() + "Valor: " + item.getValor() + "Fatura paga: " + getFaturaPaga());
        }
    }
}
