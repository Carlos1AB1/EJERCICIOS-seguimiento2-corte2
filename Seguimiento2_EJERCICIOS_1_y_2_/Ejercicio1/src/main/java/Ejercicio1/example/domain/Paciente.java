package Ejercicio1.example.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Paciente implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String direccion;
    private String telefono;
    private ArrayList<Cita> citas; // Para la relación de agregación

    // Constructor sin citas
    public Paciente(String nombre, String apellido, int edad, String genero, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.citas = new ArrayList<>(); // Lista Vacia de citas
    }

    // Constructor con citas
    public Paciente (String nombre, String apellido, int edad, String genero, String direccion, String telefono, ArrayList<Cita> citas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.citas = citas; // Lista de citas ya existentes
    }

    // Getters y Setters
    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(Cita cita) {
        this.citas = citas;
    }

    public void agregarCita(Cita cita) {
        this.citas.add(cita);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + edad + " años) - " + telefono;
    }
}
