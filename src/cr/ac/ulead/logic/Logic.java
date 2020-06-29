package cr.ac.ulead.logic;
import cr.ac.ulead.cr.ac.ulead.ui.UIHelper;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.util.Scanner;

public class Logic {

    public static void execute(int op) throws ParserConfigurationException, TransformerConfigurationException {

        Persona p = new Persona();
        Mascota m = new Mascota();
        UIHelper ui = new UIHelper();
        switch (op){
            case 1:
                p.execute_persona();
                break;
            case 2:
                m.execute_mascota();
                break;
            case 3:
                break;
            default:
                ui.wrongOption();
        }

    }

    public void verificarmenu2(int decision) throws ParserConfigurationException, TransformerConfigurationException {
        Persona p = new Persona();
        Mascota m = new Mascota();
        Scanner input = new Scanner(System.in);
        int opcion= 1;
        UIHelper ui = new UIHelper();
        do {

            if(opcion<1 || opcion>2){
                ui.wrongOption();
            }
            ui.minimenu();
            opcion = input.nextInt();

        }while (opcion<1 || opcion>2);
        if (decision==2){
            opcion+=2;
        }

        switch (opcion){
            case 1:
                p.SerializarXML();
                break;
            case 2:
                p.SerializarJSON();
                break;
            case 3:
                m.SerializarXML();
                break;
            case 4:
                m.SerializarJSON();
                break;
        }
    }

}


