package cr.ac.ucr.paraiso.ie.progra2.tema1.poo.paco;

public class Vehiculo {
    private String marca;
    private String color;
    private boolean funcional;
    private Persona personaPropietaria;

    public Vehiculo() {
        marca=color="";
        personaPropietaria = new Persona();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFuncional() {
        return funcional;
    }

    public void setFuncional(boolean funcional) {
        this.funcional = funcional;
    }

    public Persona getPersonaPropietaria() {
        return personaPropietaria;
    }

    public void setPersonaPropietaria(Persona personaPropietaria) {
        this.personaPropietaria = personaPropietaria;
    }
}
