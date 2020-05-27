package program;

import model.Universe;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;

public class Program2 {
    public static void main(String[] args) {
        String[] arr = {"aa", "b", "a", "bb", "aa", "bb"};
        ArrayList<ArrayList<String>> res = Universe.group(arr);
        System.out.println(res);

        try {
            ArrayList<ArrayList<Element>> arrayLists = Universe.groupPlanet("Universe.xml");
            /*for (int i = 0; i < arrayLists.size(); i++) {
                for (int j = 0; j < arrayLists.get(i).size(); j++) {
                    System.out.println(arrayLists.get(i).get(j).getElementsByTagName("Title").item(0).getTextContent());
                }
            }*/

            Universe.writeXML("result.xml", arrayLists);

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
