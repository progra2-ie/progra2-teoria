package cr.ac.ucr.paraiso.ie.progra2.tema1.poo.cuenta;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.File;
import java.nio.file.Path;

public class CuentaTest {
    @Test
    public void llamado_toString_funciona(){
        Cuenta cuenta1 = new Cuenta("c12", 1200000f);
        String valorRetornado = cuenta1.toString();
        assert(valorRetornado.equals("Numero de cuenta:c12 Saldo:1200000.0"));
    }

    @Test
    public void llamado_equals_funciona(){
        Cuenta cuenta1 = new Cuenta("c15", 500000f);
        Cuenta cuenta2 = new Cuenta("c15", 500000f);
         boolean resultado = cuenta1.equals(cuenta2);
         boolean valorEsperado = true;
         assert (resultado==valorEsperado);

        Gson gson = new Gson();
        String jsonGenerado = gson.toJson(cuenta1);
        System.out.println(jsonGenerado);
        Cuenta cuentaRecuperada = gson.fromJson(jsonGenerado, Cuenta.class);
        System.out.println(cuentaRecuperada.toString());
    }
    @Test
    public void llamado_equals_no_funciona(){
        Cuenta cuenta1 = new Cuenta("c15", 500000f);
       JLabel cuenta2 = new JLabel("c15 500000f");
        boolean resultado = cuenta1.equals(cuenta2);
        boolean valorEsperado = false;
        assert (resultado==valorEsperado);

    }
}
