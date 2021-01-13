package sample.Estructura;

import javafx.beans.property.SimpleStringProperty;

public class pedido {
    SimpleStringProperty Instrumentos;
    SimpleStringProperty Cantinstrumentos;

    public pedido(String instrumentos, String cantinst) {
        this.Instrumentos = new SimpleStringProperty(instrumentos);
        this.Cantinstrumentos = new SimpleStringProperty(cantinst);
    }

    public String getInstrumentos() {
        return Instrumentos.get();
    }

    public SimpleStringProperty instrumentosProperty() {
        return Instrumentos;
    }

    public void setInstrumentos(String instrumentos) {
        this.Instrumentos.set(instrumentos);
    }

    public String getCantinstrumentos() {
        return Cantinstrumentos.get();
    }

    public SimpleStringProperty cantinstrumentosProperty() {
        return Cantinstrumentos;
    }

    public void setCantinstrumentos(String cantinstrumentos) {
        this.Cantinstrumentos.set(cantinstrumentos);
    }
}
