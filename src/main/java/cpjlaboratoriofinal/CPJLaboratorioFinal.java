package cpjlaboratoriofinal;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jcb.com.peliculas.excepciones.AccesoDatosEx;
import jcb.com.peliculas.excepciones.EscrituraDatosEx;
import jcb.com.peliculas.excepciones.LecturaDatosEx;
import jcb.com.peliculas.negocio.CatalogoPeliculas;
import jcb.com.peliculas.negocio.CatalogoPeliculasImpl;

public class CPJLaboratorioFinal {

    private static int opcion = -1;
    //Esta es la ruta donde se guardara el archivo que tendra la infromación de peliculas, la carpeta debe existir 
    //antes de ejecutar el programa, el archivo no es necesario ya que se da la opcion de crearlo durante la ejecución
    private static final String nombreArchivo = "c:\\CatalogoPeliculas\\peliculas.txt";
    private static final CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();

    private static final Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {

        while (opcion != 0) {

            System.out.println("");
            System.out.println("*****************************************");
            System.out.println("**Digite el numero de la opción deseada**");
            System.out.println("** 1-Iniciar catalogo peliculas        **");
            System.out.println("** 2-Agregar pelicula                  **");
            System.out.println("** 3-Listar peliculas                  **");
            System.out.println("** 4-Buscar pelicula                   **");
            System.out.println("** 5-Eliminar pelicula                 **");
            System.out.println("** 0-Salir                             **");
            System.out.println("*****************************************");
            System.out.println("");

            opcion = scaner.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1: {
                    try {

                        catalogoPeliculas.iniciarArchivo(nombreArchivo);

                    } catch (LecturaDatosEx ex) {

                        System.out.println("ERROR: no se pueden leer los datos");
                        ex.printStackTrace(System.out);

                    } catch (AccesoDatosEx ex) {

                        System.out.println("ERROR: no se pudo acceder a los datos");
                        ex.printStackTrace(System.out);

                    }
                }

                System.out.println("OPCION 1");
                break;

                case 2:

                    System.out.println("Ingrese el nombre de la pelicula que desea agregar : ");
                    Scanner scaner2 = new Scanner(System.in);
                    String nombrePelicula = scaner2.nextLine();

                    try {

                        catalogoPeliculas.agregarPelicula(nombrePelicula, nombreArchivo);

                    } catch (EscrituraDatosEx ex) {

                        System.out.println("ERROR: no se pudo escribir el dato");
                        ex.printStackTrace(System.out);

                    } catch (AccesoDatosEx ex) {

                        System.out.println("ERROR: no se pudo acceder a los datos");
                        ex.printStackTrace(System.out);

                    }

                    System.out.println("OPCION 2");
                    break;

                case 3: {
                    try {

                        catalogoPeliculas.listarPeliculas(nombreArchivo);

                    } catch (LecturaDatosEx ex) {

                        System.out.println("ERROR: no se pueden leer los datos");
                        ex.printStackTrace(System.out);

                    } catch (AccesoDatosEx ex) {

                        System.out.println("ERROR: no se pudo acceder a los datos");
                        ex.printStackTrace(System.out);

                    }
                }

                System.out.println("OPCION 3");
                break;

                case 4: {

                    System.out.println("Ingrese el nombre de la pelicula que desea buscar");
                    Scanner scanner3 = new Scanner(System.in);
                    String buscar = scanner3.nextLine();

                    try {

                        catalogoPeliculas.buscarPelicula(nombreArchivo, buscar);

                    } catch (LecturaDatosEx ex) {

                        System.out.println("ERROR: no se pueden leer los datos");
                        ex.printStackTrace(System.out);

                    } catch (AccesoDatosEx ex) {

                        System.out.println("ERROR: no se pudo acceder a los datos");
                        ex.printStackTrace(System.out);

                    }
                }

                System.out.println("OPCION 4");
                break;

                case 5: {

                    System.out.println("Ingrese el nombre de la pelicula que desea eliminar");
                    Scanner scanner4 = new Scanner(System.in);
                    String buscar = scanner4.nextLine();

                    try {

                        catalogoPeliculas.borrarPelicula(nombreArchivo, buscar);

                    } catch (LecturaDatosEx ex) {

                        System.out.println("ERROR: no se pueden leer los datos");
                        ex.printStackTrace(System.out);

                    } catch (AccesoDatosEx ex) {

                        System.out.println("ERROR: no se pudo acceder a los datos");
                        ex.printStackTrace(System.out);

                    }
                }

                System.out.println("OPCION 5");
                break;

                case 0:
                    System.out.println("SALIR");
                    break;
                default:
                    System.out.println("DEBE ELEGIR UNA OPCIÓN VALIDA");
            }

        }

    }

}
