import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;

public interface Reader {

    void readFile(String filename);


}


class XMLReader implements Reader {

    public void readFile(String filename) {

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
    }
}


class CSVReader implements Reader {

    public void readFile(String filename) {
//        try {
//            br = new BufferedReader(new FileReader(csvFile));
//            while ((line = br.readLine()) != null) {
//
//                String[] tempFd = line.split(sc);
//
//                value = Integer.parseInt(tempFd[0]);
//
//                fd = new FolderData(value, tempFd[1]);
//
//                folderData.add(lineNumber, fd);
//
//                lineNumber++;
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

}