package jcb.com.peliculas.negocio;

import jcb.com.peliculas.excepciones.*;
import jcb.com.peliculas.datos.*;
import java.util.List;
import jcb.com.peliculas.domain.Pelicula;

//Capa de negocio, se encarga de llamar a los metodos necesarios de la capa de datos
//para ejecutar la accion pedida por el ususario
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos = new AccesoDatosImpl();

    public CatalogoPeliculasImpl() {

    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) throws AccesoDatosEx {

        if (datos.existe(nombreArchivo)) {

            Pelicula pelicula = new Pelicula(nombrePelicula);
            datos.escribir(pelicula, nombreArchivo, true);

        } else {

            throw new EscrituraDatosEx("EEROR: no se encontro el catalogo, primero debe iniciar el catalogo para poder agregar una pelicula");

        }

    }

    @Override
    public void listarPeliculas(String nombreArchivo) throws AccesoDatosEx {

        if (datos.existe(nombreArchivo)) {

            List coleccion = datos.listar(nombreArchivo);
            int i = 0;

            for (Object elemento : coleccion) {
                i++;
                System.out.println("[" + i + "]" + elemento);

            }
            System.out.println("");

        } else {

            throw new LecturaDatosEx("EEROR: no se encontro el catalogo, primero debe iniciar el catalogo para poder listar la peliculas");

        }

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) throws AccesoDatosEx {

        if (datos.existe(nombreArchivo)) {

            String peliculaEncontrada = datos.buscar(nombreArchivo, buscar);

            System.out.println("Resultado de busqueda = " + peliculaEncontrada);

        } else {

            throw new LecturaDatosEx("EEROR: no se encontro el catalogo, primero debe iniciar el catalogo para poder buscar la pelicula");

        }

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) throws AccesoDatosEx {

        if (datos.existe(nombreArchivo)) {

            System.out.println("El catalogo : " + nombreArchivo + " ya habia sido creado por ende no es necesario iniciarlo de nuevo");

        } else {

            datos.crear(nombreArchivo);

        }

    }

    @Override
    public void borrarPelicula(String nombreArchivo, String buscar) throws AccesoDatosEx {

        if (datos.existe(nombreArchivo)) {
            
            List<Pelicula> miLista = datos.borrar(nombreArchivo, buscar);
            
            datos.reesccribir(nombreArchivo, miLista);

        } else {

            throw new LecturaDatosEx("EEROR: no se encontro el catalogo, primero debe iniciar el catalogo para poder buscar la pelicula");

        }

    }

}
