package jcb.com.peliculas.datos;

import java.io.*;
import java.util.*;
import jcb.com.peliculas.domain.Pelicula;
import jcb.com.peliculas.excepciones.*;

//capa de datos, hace todas las operaciones directamente sobre el almacenamiento en este caso
//es un archivo .txt pero podria ser una base de datos SQL
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArvhivo) throws AccesoDatosEx {

        File archivo = new File(nombreArvhivo);
        return archivo.exists();

    }

    @Override
    public List<Pelicula> listar(String nombre) throws AccesoDatosEx {

        File archivo = new File(nombre);
        List<Pelicula> miLista = new ArrayList();

        try {

            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();

            while (lectura != null) {

                if (!lectura.equals("")) {

                    Pelicula pelicula = new Pelicula(lectura);
                    miLista.add(pelicula);

                }

                lectura = entrada.readLine();

            }

            entrada.close();

        } catch (FileNotFoundException ex) {

            throw new LecturaDatosEx("ERROR: no se pudo listar el catalogo de peliculas");

        } catch (IOException ex) {

            ex.printStackTrace(System.out);

        }

        return miLista;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoDatosEx {

        File archivo = new File(nombreArchivo);

        try {

            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            //si se usa println imprime antes un salto de linea y despues si se imprime la variable
            //si se usa print solo imprime la variable
            salida.println("Pelicula{" + pelicula + "}");
            salida.println();
            salida.close();
            System.out.println("Se anexo con exito la pelicula : " + pelicula);

        } catch (FileNotFoundException ex) {

            throw new EscrituraDatosEx("ERROR: no se ha podido agregar la pelicula");

        } catch (IOException ex) {

            ex.printStackTrace(System.out);

        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws AccesoDatosEx {

        List<Pelicula> miLista = listar(nombreArchivo);
        int i = 0;
        for (Pelicula elemento : miLista) {

            i++;
            if (elemento.getNombre().equals("Pelicula{" + buscar + "}")) {

                return "Se encontro la " + elemento.toString() + " en la posicion [" + i + "]";

            }

        }

        return "No se encontro la pelicula de nombre " + buscar;

    }

    @Override
    //Crea el arcvhio .txt en la ruta definida
    public void crear(String nombeArchivo) throws AccesoDatosEx {

        File archivo = new File(nombeArchivo);
        try {

            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("El catalogo : " + nombeArchivo + " fue creado con exito ");

        } catch (FileNotFoundException ex) {

            throw new LecturaDatosEx("ERROR: no se pudo acceder al catalogo, revise que la ruta del archivo exista");

        }

    }

    @Override
    //Este metodo lee las peliculas guardadas y busca la que debe eliminar
    public List<Pelicula> borrar(String nombreArchivo, String buscar) throws AccesoDatosEx {

        List<Pelicula> miLista = listar(nombreArchivo);
        int i = -1;
        int borrar = -1;
        for (Pelicula elemento : miLista) {

            //si encuentra el elemento buscado, asifna el valor del contador a la variable borrar
            //ese numero correspondera a el inidice que debe remover
            i++;
            if (elemento.getNombre().equals("Pelicula{" + buscar + "}")) {
                 
                borrar = i;
                System.out.println("ELIMINANDO LA PELICULA = " + elemento.getNombre() + " " + i);

            }

        }
        //si la variable borrar tiene otro valor quiere decir que la pelicula existe y se removio,
        //se retorna la nueva lista.
        if (borrar != -1) {
            miLista.remove(borrar);
        }else{
            System.out.println("No se encontro la pelicula " + buscar + "para ser eliminada");
        }

        return miLista;

    }

    @Override
    //Este metodo reescribe todo el contenido de el archivo .txt que contiene las peliculas,
    //despues de que se removio una del catalogo
    public void reesccribir(String nombreArchivo, List<Pelicula> peliculas) throws AccesoDatosEx {

        File archivo = new File(nombreArchivo);
        try {

            PrintWriter salida = new PrintWriter(archivo);
            for (Pelicula pelicula : peliculas) {
                salida.println(pelicula);
                salida.println("");
            }

            salida.close();

        } catch (FileNotFoundException ex) {

            ex.printStackTrace(System.out);

        }

    }

}
