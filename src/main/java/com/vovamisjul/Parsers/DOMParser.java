package com.vovamisjul.Parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class DOMParser {
    private final Logger logger = LogManager.getLogger(DOMParser.class);
    ParsedDocumentTable table = new ParsedDocumentTable(Arrays.asList("Parent node", "Attributes", "Node"));
    public ParsedDocumentTable parse(InputStream is) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(is);
            fillRecursion(document.getChildNodes(), "top of document");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return table;
    }

    private void fillRecursion(NodeList nodeList, String parent) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            var attributes = nodeList.item(i).getAttributes();
            var attributesStr = new StringBuilder();
            if (attributes != null) {
                for (int j = 0; j < attributes.getLength(); j++) {
                    attributesStr.append(attributes.item(j).getNodeName()).append("=").append(attributes.item(j).getNodeValue());
                }
            }

            table.getCells().add(Arrays.asList(parent, attributesStr.toString(), nodeList.item(i).getNodeName()));
            fillRecursion(nodeList.item(i).getChildNodes(), nodeList.item(i).getNodeName());
        }
    }

}
