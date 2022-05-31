package alcaldia.soyapango.app.Model;

import java.io.Serializable;

public class DesarrolloEconomicoResponse implements Serializable{

private int id;
private String Nombre;
private String Descripcion;
private String Lugar;
private String Logo;
private String Foto;
private String Telefono;
private String Facebook;
private String Instagram;
private String WhatsApp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }

    public String getInstagram() {
        return Instagram;
    }

    public void setInstagram(String instagram) {
        Instagram = instagram;
    }

    public String getWhatsApp() {
        return WhatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        WhatsApp = whatsApp;
    }

    @Override
    public String toString(){
        return "DesarrolloEconomicoResponse{"+
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Lugar='" + Lugar + '\'' +
                ", Logo ='" + Logo + '\'' +
                ", Foto='" + Foto + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Facebook='" + Facebook + '\'' +
                ", Instagram='" + Instagram + '\'' +
                ", WhatsApp='" + WhatsApp + '\'' +
                '}';
    }
}
