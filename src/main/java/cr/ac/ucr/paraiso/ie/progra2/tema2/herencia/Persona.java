package cr.ac.ucr.paraiso.ie.progra2.tema2.herencia;

public abstract class Persona {
    protected int idPersona;
    protected String nombre;
    protected String apellidos;

    public Persona(int idPersona, String nombre,
                   String apellidos){
        this.setIdPersona(idPersona);
        this.setNombre(nombre);
        this.setApellidos(apellidos);
    }
    public void setIdPersona(int idPersona){
        this.idPersona = idPersona;
    }
    public int getIdPersona(){
        return this.idPersona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Persona){
            Persona p = (Persona)o;
            boolean resu =(this.idPersona == p.idPersona &&
                    this.nombre.equals(p.nombre) &&
                    this.apellidos.equals(p.apellidos)?true:false);
            return resu;
        }else return false;
    }
    @Override
    public String toString() {
        return "Id: " + this.getIdPersona() + "\n" +
                "Nombre: "+ this.getNombre() + "\n" +
                "Apellidos: " + this.getApellidos();
    }
}