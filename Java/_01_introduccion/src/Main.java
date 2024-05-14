import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        //System.out.println nos permite imprimir un mensaje por consola (println: imprimir en una linea)
        System.out.println("Hola Mundo!");

        //instanciar la clase scanner nos permite crear un objeto para
        //leer datos desde la consola
        Scanner objScanner = new Scanner(System.in);
        //cursor al final de la palabra Scanner para importar control + espacio y luego enter

        System.out.println("Ingresa tu nombre");
        String nombre = objScanner.nextLine();

        System.out.println("Ingresa tu edad");
        int edad = objScanner.nextInt();

        System.out.println("Ingresa tu altura");
        double altura = objScanner.nextDouble();

        //shorcut para imprimir en consola = sout
        System.out.println("Datos" +" "+ "-nombre: " + nombre +" "+ "-edad: " + edad +" "+ "altura: " + altura);

        objScanner.close();

        if (edad>= 18){
            System.out.println(nombre + " Eres mayor de edad");
            if (altura >= 1.80){
                System.out.println(" Eres una persona alta");
            } else if (altura < 1.80 && altura > 1.70){
                System.out.println(" Eres una persona de estatura promedio");
            } else {
                System.out.println(" Eres una persona de estatura baja");
            }
        } else {
            System.out.println(nombre + " Eres menor de edad");
        }

         */
        //Ejercicio 1
        //Calculadora basica
        Scanner objScanner1 = new Scanner(System.in);
        Object message;
        String option = JOptionPane.showInputDialog(null, "MENU DE OPERACIONES \n 1. Sumar \n 2. Restar \n 3. Multiplicar \n 4. Dividir");

        double c = Double.parseDouble(option);
        if (c>4){
            JOptionPane.showMessageDialog(null, "Opcion no valida");
        }else{
            //obtener los dos numeros a operar
            String num1 = JOptionPane.showInputDialog(null,"Ingrese el primer numero");
            String num2 = JOptionPane.showInputDialog(null,"Ingrese el segundo numero");
            //convertir los numeros que estan en string a enteros
            double a = Double.parseDouble(num1);
            double b = Double.parseDouble(num2);

            switch (option){
                case "1":
                    JOptionPane.showInputDialog(null, a + " + " + b + " = " + (a+b));
                    break;
                case "2":
                    JOptionPane.showInputDialog(null, a + " - " + b + " = " + (a-b));
                    break;
                case "3":
                    JOptionPane.showInputDialog(null, a + " x " + b + " = " + (a*b));
                    break;
                case "4":
                    if (b==0){
                        JOptionPane.showMessageDialog(null, "El numero b debe ser diferente de 0");
                    }else{
                        JOptionPane.showInputDialog(null, a + " / " + b + " = " + (a/b));}
                    break;
            }
        }
    }
}


