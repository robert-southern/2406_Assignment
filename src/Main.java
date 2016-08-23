import com.sun.xml.internal.txw2.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;



public class Main {

    ArrayList deck = new ArrayList();

    public static void main(String[] args) {

        try {
            //File deckList = new File("DeckList.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            org.w3c.dom.Document document = documentBuilder.parse(new File("DeckList.xml"));

            // normalise text representation:
            document.getDocumentElement().normalize();
            System.out.println("Root: " + document.getDocumentElement().getNodeName());


        } catch (Exception e) {
            e.printStackTrace();
        }



        //still in main


        ArrayList a = new ArrayList();

        System.out.println(a.size());


    }




}
