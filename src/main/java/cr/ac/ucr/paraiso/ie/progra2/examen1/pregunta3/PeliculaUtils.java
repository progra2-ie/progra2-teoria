package cr.ac.ucr.paraiso.ie.progra2.examen1.pregunta3;

public class PeliculaUtils {
    public static void insertar (Pelicula[] peliculas, Pelicula nuevaPelicula, int cantPeliculas) throws ArregloLlenoException {
        boolean insertado=false;
        int i = 0;

        while (i<peliculas.length && insertado==false && cantPeliculas<peliculas.length){
            if (peliculas[i].getTitulo().compareTo(nuevaPelicula.getTitulo())>=0)
            {
                mover(peliculas, i, cantPeliculas-1);
                peliculas[i] = nuevaPelicula;
                insertado = true;
            } else i++;
        }//while
        if (!insertado && cantPeliculas<peliculas.length){
            peliculas[cantPeliculas] = nuevaPelicula;
        } else  throw new ArregloLlenoException("El arreglo está lleno");
    }//insertar
    private static void mover(Pelicula peliculas[], int desde, int hasta){
        for (int i = hasta; i >= desde ; i--) {
            peliculas[i+1] = peliculas[i];
        }
    }
}
