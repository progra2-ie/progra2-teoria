package cr.ac.ucr.paraiso.ie.progra2.tema1.poo.cuenta;

public class Cuenta {
    private String numeroCuenta;
    private float saldo;
    private boolean activa;

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    //constructor
    public Cuenta(){
        this.numeroCuenta = "";
        this.saldo = 0.0f;
    }
    public Cuenta(String numeroCuenta, float saldo){
        this.setNumeroCuenta(numeroCuenta);
        //this.numeroCuenta=numeroCuenta;
        this.saldo=saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Numero de cuenta:" +  this.numeroCuenta +
                " Saldo:" + this.getSaldo();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cuenta == false)
            return false;
        if (obj instanceof  Cuenta){
            Cuenta cuentaRecibida = (Cuenta)obj;
            return this.numeroCuenta==cuentaRecibida.numeroCuenta &&
                    this.saldo==cuentaRecibida.saldo;
        }
        return  false;
    }
}
