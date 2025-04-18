package TCG_Game;

abstract public class Carta_Accion {
    protected String nombre; //Nombre de la carta
    protected String descripcion;//Describe que hace la carta
    protected int costo; //Define el costo de dados elementales se necesitan para usarlo
    protected int duracion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Carta_Accion(String nombre, String descripcion, int costo, int duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.duracion = duracion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public abstract void aplicarEfecto();//Es para aplicar el efecto de la carta
}
