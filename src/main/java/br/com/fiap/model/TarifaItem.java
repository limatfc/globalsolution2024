package br.com.fiap.model;

import java.time.LocalTime;
import java.util.List;

public class TarifaItem {
    private LocalTime hora;
    private Double preco;

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Double getPreco() {
        return preco;
    }

    public void mostrarLista(List<TarifaItem> lista){
        for (TarifaItem item : lista){
            System.out.println("Hora: " + item.getHora() + "Preço: " + item.getPreco() + "R$");
        }
    }
}
