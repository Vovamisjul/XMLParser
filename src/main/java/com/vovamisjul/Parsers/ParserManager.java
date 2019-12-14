package com.vovamisjul.Parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class ParserManager {
    private static Logger logger = LogManager.getLogger(ParserManager.class);
    public static ParsedDocumentTable parseXML(InputStream text, String type) {
        switch (type) {
            case "SAX":
            {
                try {
                    var xr = SAXParserFactory.newInstance().newSAXParser();
                    var handler = new SAXParser();
                    xr.parse(text, handler);
                    return handler.getTable();
                }
                catch (Exception e){
                    logger.error(e.getMessage(), e);
                    return null;
                }
            }
            case "StAX":
            {
                var staxParser = new StAXParser(text);
                return staxParser.parse();
            }
            case "DOM":
            {
                var domParser = new DOMParser();
                return domParser.parse(text);
            }
        }
        return null;
    }
}
