package jcb.com.peliculas.negocio;

import jcb.com.peliculas.excepciones.AccesoDatosEx;


public interface CatalogoPeliculas {
    
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) throws AccesoDatosEx;
    
    public void listarPeliculas(String nombreArchivo) throws AccesoDatosEx;
    
    public void buscarPelicula(String nombreArchivo, String buscar) throws AccesoDatosEx;
    
    public void iniciarArchivo(String nombreArchivo) throws AccesoDatosEx;
    
    public void borrarPelicula(String nombreArchivo, String buscar) throws AccesoDatosEx;
    
}
