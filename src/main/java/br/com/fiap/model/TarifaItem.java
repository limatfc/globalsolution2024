package br.com.fiap.model;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

public class TarifaItem {
    private LocalTime hora;
    private String preco;

    public void setHora(Timestamp hora) {
        Timestamp timestamp = Timestamp.valueOf(hora.toLocalDateTime());
        LocalTime time = timestamp.toLocalDateTime().toLocalTime();
        this.hora = time;
    }

    public void setPreco(Double preco) {
        String formattedPreco = String.format("%.2f", preco);
        formattedPreco = formattedPreco.replace(",", ".");
        this.preco = formattedPreco;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getPreco() {
        return preco;
    }

    public void mostrarLista(List<TarifaItem> lista){
        for (TarifaItem item : lista){
            System.out.println("Hora: " + item.getHora() + " --------- Preço: " + item.getPreco() + "R$");
        }
    }
}
