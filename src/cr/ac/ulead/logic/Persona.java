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




public  class Persona implements SerializadorUlead {
    static String nombre =null;
    static String apellido = null;
    static String fNac = null;
    static float peso = 0;
    static float est = 0;

    UIHelper ui = new UIHelper();
    Logic logic = new Logic();
    public void execute_persona() throws ParserConfigurationException, TransformerConfigurationException {
        setNombre(ui.readNombre());
        apellido = ui.readApellido();
        System.out.println(nombre+getNombre());
        fNac = ui.readFnac();
        peso = ui.readPeso();
        est = ui.readEst();
        int timePeriod = 1;
//        mandado(nombre,apellido,fNac,peso,est);
        logic.verificarmenu2(timePeriod);

    }

    void setNombre(String _nombre){
        nombre = _nombre;
    }
    String getNombre(){
        return this.nombre;
    }

//    String mandado(String n, String a, String F, float p, int e){
//
//    }

    @Override
    public void SerializarXML() throws ParserConfigurationException, TransformerConfigurationException {
//        System.out.println(nombre+getNombre());

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document documento = implementation.createDocument(null,"PersonaXML",null);
            documento.setXmlVersion("1.0");

            Element datosPersona =documento.createElement("datospersona");
            Element persona =documento.createElement("persona");

            Element Nombre = documento.createElement("nombre");
            Text textnombre = documento.createTextNode(getNombre());
            Nombre.appendChild(textnombre);
            persona.appendChild(Nombre);

            Element Apellido = documento.createElement("apellido");
            Text textapellido = documento.createTextNode(apellido);
            Apellido.appendChild(textapellido);
            persona.appendChild(Apellido);

            Element Nacimiento = documento.createElement("fecha_nacimiento");
            Text textnacimiento = documento.createTextNode(fNac);
            Nacimiento.appendChild(textnacimiento);
            persona.appendChild(Nacimiento);

            Element Peso = documento.createElement("peso");
            Text textpeso = documento.createTextNode(String.valueOf(peso));
            Peso.appendChild(textpeso);
            persona.appendChild(Peso);

            Element Estatura = documento.createElement("estatura");
            Text textestatura = documento.createTextNode(String.valueOf(est));
            Estatura.appendChild(textestatura);
            persona.appendChild(Estatura);

            datosPersona.appendChild(persona);

            documento.getDocumentElement().appendChild(datosPersona);
            Source source = new DOMSource (documento);
            Result result = new StreamResult(new File("Persona.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source,result);

        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void SerializarJSON() {

    }


}