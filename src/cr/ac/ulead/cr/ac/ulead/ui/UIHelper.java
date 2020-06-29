package cr.ac.ulead.cr.ac.ulead.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class UIHelper {

    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in);

    public void showMenu() {
        output.println("LEAD UNIVERSITY");
        output.println("Alumna: Lolita Maldonado");
        output.println("Profesor: Mario Aguero");
        output.println("Tarea Programada 1");
        output.println("Que desea ingresar?");
        output.println("1. Personas");
        output.println("2. Mascotas");;
        output.println("3. Salir");
    }

    public void wrongOption() {
        output.println("Opcion incorrecta!");
    }

    public String readNombre() {
        output.println("Introduzca el Nombre: ");
        return input.next();
    }

    public String readApellido() {
        output.println("Introduzca el Apellido: ");
        return input.next();
    }

    public String readFnac() {
        output.println("Introduzca su fecha de nacimiento: ");
        return input.next();
    }

    public float readPeso() {
        output.println("Introduzca su peso en kilos: ");
        return input.nextFloat();
    }
    public float readEst() {
        output.println("Introduzca su estatura en cms: ");
        return input.nextFloat();
    }


    //Mascota

    public String readNombreMascota() {
        output.println("Introduzca el Nombre de su Mascota: ");
        return input.next();
    }

    public String readTipoAnimal() {
        output.println("Introduzca que tipo de animal es: ");
        return input.next();
    }

    public int readEdad() {
        output.println("Introduzca su Edad: ");
        return input.nextInt();
    }


    public void printMessage(String message) {
        output.println(message);
    }

    public void minimenu(){
        output.println("Archivo a Serializar:");
        output.println("1- XML");
        output.println("2- JSON");
    }
}

