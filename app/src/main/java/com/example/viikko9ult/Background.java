package com.example.viikko9ult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Background {

    public void Background() {
        return;
    }

    public void readXML(ArrayList theatersList) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            System.out.println("TEST: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");


            for (int i=0;i<nList.getLength();i++) {
                Theater theater = new Theater();
                Node node = nList.item(i);
                //System.out.println("Element " + i + " is: " + node.getNodeName());

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.getElementsByTagName("Name").item(0).getTextContent().indexOf(':') != -1) {
                        theater.setId(Integer.parseInt(element.getElementsByTagName("ID").item(0).getTextContent()));
                        theater.setName(element.getElementsByTagName("Name").item(0).getTextContent());
                        theatersList.add(theater);

                        System.out.println(element.getElementsByTagName("ID").item(0).getTextContent());
                        System.out.println("Paikan nimi: " + element.getElementsByTagName("Name").item(0).getTextContent());
                    }

                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return;
    }

    public void createTheaterNameList(ArrayList<Theater> theaterList, ArrayList<String> theaterNames) {
        int i;
        for (i=0;i<theaterList.size();i++) {
            theaterNames.add(theaterList.get(i).getName());
        }

    }

}
