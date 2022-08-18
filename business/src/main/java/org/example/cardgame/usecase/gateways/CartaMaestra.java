package org.example.cardgame.usecase.gateways;

public class CartaMaestra {
    private String id;
    private String url;
    private Integer poder;
    private String nombre;

    public CartaMaestra(){

    }
    public CartaMaestra(String id, String url, Integer poder, String nombre) {
        this.id = id;
        this.url = url;
        this.poder = poder;
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
