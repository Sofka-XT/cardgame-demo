package org.example.cardgame.domain.command;

import co.com.sofka.domain.generic.Command;
import org.example.cardgame.domain.values.JuegoId;
import org.example.cardgame.domain.values.TableroId;

public class CambiarTiempoCommand extends Command {
    private JuegoId juegoId;
    private TableroId tableroId;
    private Integer tiempo;

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public JuegoId getJuegoId() {
        return juegoId;
    }

    public void setJuegoId(JuegoId juegoId) {
        this.juegoId = juegoId;
    }

    public TableroId getTableroId() {
        return tableroId;
    }

    public void setTableroId(TableroId tableroId) {
        this.tableroId = tableroId;
    }
}
