package com.example.juegodel21;

public class data {
    private String Nombre;
    private int Cantidad;
    private String urlImg;

    public data(String nombre, int cantidad, String urlImg) {
        this.Nombre = nombre;
        this.Cantidad = cantidad;
        this.urlImg = urlImg;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
