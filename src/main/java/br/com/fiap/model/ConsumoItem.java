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

    public void setFaturaPaga(String faturaPaga) {
        if (faturaPaga == "0"){
            this.faturaPaga = false;
            return;
        }
        this.faturaPaga = true;
    }
public String formatMonth(Month mes){
    String formattedMonth = mes.toString().substring(0, 1).toUpperCase() +
            mes.toString().substring(1).toLowerCase();
    return formattedMonth;
}
    public void mostrarLista(List<ConsumoItem> lista){
        for (ConsumoItem item : lista){
            System.out.println("\nHistórico de consumo: + " +
                    "\nConsumo: " + item.getConsumo() +
                    "\nMês: " + item.formatMonth(item.getMes()) +
                    "\nValor: " + item.getValor() +
                    "\nFatura paga: " + getFaturaPaga());
        }
    }
}
