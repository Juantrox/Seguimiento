package Archivos;

public class Archivos
{

    private String marca;
    private String Modelo;
    private String Descripcion;
    private Boolean Reparado;
    private String fechaIn; 
    private String fechaOut;
    private String fechaReparacion;
    private int id;

    public Archivos(){}

    public Archivos(String marca, String Modelo, String Descripcion, Boolean Reparado)
    {
        this.marca = marca;
        this.Modelo = Modelo;
        this.Descripcion = Descripcion;
        this.Reparado = Reparado;
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
        this.fechaReparacion = fechaReparacion;
        this.id = id;
    }

    //getters and setters

    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}

    public String getModelo() {return Modelo;}
    public void setModelo(String Modelo) {this.Modelo = Modelo;}

    public String getDescripcion() {return Descripcion;}
    public void setDescripcion(String Descripcion) {this.Descripcion = Descripcion;}

    public Boolean getReparado() {return Reparado;}
    public void setReparado(Boolean Reparado) {this.Reparado = Reparado;}

    public String getFechaIn() {return fechaIn;}
    public void setFechaIn(String fechaIn) {this.fechaIn = fechaIn;}

    public String getFechaOut() {return fechaOut;}
    public void setFechaOut(String fechaOut) {this.fechaOut = fechaOut;}

    public String getFechaReparacion() {return fechaReparacion;}
    public void setFechaReparacion(String fechaReparacion) {this.fechaReparacion = fechaReparacion;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
}
