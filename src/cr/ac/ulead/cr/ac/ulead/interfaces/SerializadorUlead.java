package cr.ac.ulead.cr.ac.ulead.interfaces;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;

public interface SerializadorUlead {

    public void SerializarXML() throws ParserConfigurationException, TransformerConfigurationException;
    public void SerializarJSON();

}
