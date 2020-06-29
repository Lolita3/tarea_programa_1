package cr.ac.ulead;

import java.util.Scanner;
import cr.ac.ulead.cr.ac.ulead.ui.UIHelper;
import cr.ac.ulead.logic.Logic;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException {

        ejecutar();

    }

    private static void ejecutar() throws ParserConfigurationException, TransformerConfigurationException {
        UIHelper ui = new UIHelper();
        Scanner input = new Scanner(System.in);



        int option = 0;
        do {
            ui.showMenu();
            option = input.nextInt();
            Logic.execute(option);
        } while (option != 3);

    }


}
