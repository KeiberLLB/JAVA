import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        // System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        /*
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }
        */

        //Ejercio 3
        //Kilometros a millas
        String input = "";
        double number=0;
        boolean validInput = false;
        while (!validInput) {
            input = JOptionPane.showInputDialog(null, "Ingrese los kilometros a convertir:");
            // Verifica si el input es un número válido
            try {
                number = Double.parseDouble(input);
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (number <=0){
            JOptionPane.showInputDialog(null, "Valor ingresado no es valido");
        }else{
            JOptionPane.showMessageDialog(null,  number + " kilometros"+"="+(number/1.60934)+" "+"millas");
        }
    }
}f