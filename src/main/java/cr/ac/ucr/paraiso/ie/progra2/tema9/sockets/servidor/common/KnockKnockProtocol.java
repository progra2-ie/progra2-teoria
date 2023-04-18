package cr.ac.ucr.paraiso.ie.progra2.tema9.sockets.servidor.common;

public class KnockKnockProtocol {
    private static final int ESPERANDO = 0;
    private static final int QUIEN_ES_ENVIADO = 1;
    private static final int PALABRA_ENVIADA = 2;
    private static final int OTRA_PALABRA_MAS = 3;

    private static final int CANTIDAD_PALABRAS = 4;

    private int estado;
    private int palabraActual;
    private String[] palabras, antonimos;


    public KnockKnockProtocol() {
        estado = ESPERANDO;
        palabras = new String[]{
                "Silencio", "Frio", "Amor", "Bueno"
        };
        antonimos = new String[]{
                "Ruido", "Caliente", "Odio", "Malo"
        };
        palabraActual = 0;
    }
    public String procesarEntrada(String entrada) {
        String salida = null;
        if(estado== ESPERANDO){
            salida = "¿Quien es?";
            estado = QUIEN_ES_ENVIADO;

        }else if(estado==QUIEN_ES_ENVIADO){
            if(entrada.equalsIgnoreCase("La vieja Ines")){
                salida = palabras[palabraActual];
                estado = PALABRA_ENVIADA;
            }else{
                salida = "Debe responder \"La vieja Ines \""+
                        "Trate de nuevo. ¿Quién es?";
            }
        }else if(estado==PALABRA_ENVIADA){
            if(entrada.equalsIgnoreCase(antonimos[palabraActual])){
                salida = antonimos[palabraActual] +
                        "¿Otra palabra? (s/n)";
                estado = OTRA_PALABRA_MAS;
            }else{
                salida = "Debía responder \""+
                        antonimos[palabraActual] +"\"" +
                        "Trate de nuevo. ¿Quién es?";
                estado = QUIEN_ES_ENVIADO;
            }

        }else if(estado==OTRA_PALABRA_MAS){
            if(entrada.equalsIgnoreCase("s")){
                salida = "¿Quién es?";
                if(palabraActual == CANTIDAD_PALABRAS-1)
                    palabraActual = 0;
                else
                    palabraActual++;
                estado = QUIEN_ES_ENVIADO;
            }else{
                salida = "Chao!";
                estado = ESPERANDO;
            }


        }//else if
        return salida;
    }//procesarEntrada

}
