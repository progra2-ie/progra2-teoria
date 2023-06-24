package cr.ac.ucr.paraiso.ie.progra2.tema2.herencia;

public final class Estudiante extends Persona {
    private float notaAdmision;
    private String carrera;


    public Estudiante(int idPersona, String nombre,
                      String apellidos, float notaAdmision,
                      String carrera){
        //	llamado del constructor de la superclase Persona
        super(idPersona,nombre, apellidos);
        this.setNotaAdmision(notaAdmision);
        this.setCarrera(carrera);
    }

    public float getNotaAdmision() {
        return notaAdmision;
    }

    public void setNotaAdmision(float notaAdmision) {
        this.notaAdmision = notaAdmision;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public boolean equals(Object o) {
        boolean resu = false;
        if (o instanceof Estudiante){
            Estudiante e = (Estudiante)o;
            resu = this.notaAdmision == e.notaAdmision &&
                    this.carrera.equals(e.carrera) &&
                    super.equals(e);
        }
        return resu;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Nota Admision " + this.getNotaAdmision() + "\n" +
                "Carrera " + this.getCarrera();
    }

}
