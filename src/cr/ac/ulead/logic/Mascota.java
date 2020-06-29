package cr.ac.ulead.logic;
import cr.ac.ulead.cr.ac.ulead.interfaces.SerializadorUlead;
import cr.ac.ulead.cr.ac.ulead.ui.UIHelper;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Mascota implements SerializadorUlead {

    UIHelper ui = new UIHelper();
    Logic logic = new Logic();

    static String nombreMascota;
    static String tipoAnimal;
    static int edad;

    public void execute_mascota() throws ParserConfigurationException, TransformerConfigurationException {
        nombreMascota = ui.readNombreMascota();
        tipoAnimal = ui.readTipoAnimal();
        edad = ui.readEdad();
        int timePeriod = 2;
        logic.verificarmenu2(timePeriod);
    }

    public void SerializarXML() throws ParserConfigurationException, TransformerConfigurationException {
//

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document documento = implementation.createDocument(null, "MascotaXML", null);
            documento.setXmlVersion("1.0");

            Element datosMascota = documento.createElement("datosmascota");
            Element mascota = documento.createElement("mascota");

            Element Nombre = documento.createElement("nombre");
            Text textnombre = documento.createTextNode(nombreMascota);
            Nombre.appendChild(textnombre);
            mascota.appendChild(Nombre);

            Element TipoAnimal = documento.createElement("tipo_animal");
            Text textapellido = documento.createTextNode(tipoAnimal);
            TipoAnimal.appendChild(textapellido);
            mascota.appendChild(TipoAnimal);


            Element edad = documento.createElement("edad");
            Text textedad = documento.createTextNode(String.valueOf(edad));
            edad.appendChild(textedad);
            mascota.appendChild(edad);

            datosMascota.appendChild(mascota);

            documento.getDocumentElement().appendChild(datosMascota);
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("Mascota.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (TransformerException e) {
            e.printStackTrace();
        }


        }
        @Override
        public void SerializarJSON () {
    }
}
