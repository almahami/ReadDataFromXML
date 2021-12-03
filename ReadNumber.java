import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;


public class ReadNumber {
    
    private static  String FILENAME = "";
    private static final ArrayList<Double> areaNumbers = new ArrayList<>();


    public static ArrayList<Double> readNumbers(String inputFileName) throws Exception {  

        FILENAME = inputFileName;
        //System.out.println("fifi"+FILENAME);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("xml/"+FILENAME));
        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("city");
        for (int temp = 0; temp < list.getLength(); temp++) {

            Node node = list.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;
                String area = element.getElementsByTagName("area").item(0).getTextContent();
                Double didi =  Double.valueOf(area);
                areaNumbers.add(didi);

            }
        }
        //System.out.println(areaNumbers);
        return areaNumbers;
    }
    
  }





