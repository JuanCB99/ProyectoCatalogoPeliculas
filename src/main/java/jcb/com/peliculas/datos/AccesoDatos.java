package jcb.com.peliculas.datos;

import java.util.List;
import jcb.com.peliculas.domain.Pelicula;
import jcb.com.peliculas.excepciones.AccesoDatosEx;

public interface AccesoDatos {
    
    public boolean existe(String nombreArvhivo) throws AccesoDatosEx;
    
    public List<Pelicula> listar(String nombre) throws AccesoDatosEx;
    
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoDatosEx;
    
    public String buscar(String nombreArchivo, String buscar) throws AccesoDatosEx;
    
    public void crear(String nombeArchivo) throws AccesoDatosEx;
    
    public List<Pelicula> borrar(String nombreArchivo, String buscar) throws AccesoDatosEx;
    
    public void reesccribir(String nombreArchivo, List<Pelicula> peliculas) throws AccesoDatosEx;
    
}
