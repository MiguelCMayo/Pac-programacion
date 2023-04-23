package pac_programcion; /**
 * @autor Castellanos Guijarro, Miguel Ángel
 * @version 1.0
 *
 * Clase Usuario.
 * PAC de desarrollo.
 * Aplicación de M03B en el curso 1s2223.
 * */

import java.util.regex.Pattern;

public class Usuario {

    //ATRIBUTOS
    private String nombre;
    private int edad;
    private String DNI;

    //CONSTRUCTOR
    public Usuario() {
    }

    //MÉTODOS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public boolean setDNI(String DNI) {
        this.DNI = DNI;
        String regex = "^[0-9]{8}-?[A-Z]{1}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(DNI).matches();
    }

    @Override
    public String toString() {
        return "\tNombre: " + nombre + "\n\tEdad: " +
                edad + "\n\tDNI: " + DNI;
    }
}
