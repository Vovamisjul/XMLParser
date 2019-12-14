package com.vovamisjul.Parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;

public class StAXParser {
    private XMLStreamReader reader;
    private final Logger logger = LogManager.getLogger(StAXParser.class);
    StAXParser(InputStream is) {
        try {
            var factory = XMLInputFactory.newInstance();
            reader = factory.createXMLStreamReader(is);
        } catch (XMLStreamException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public ParsedDocumentTable parse() {
        var table = new ParsedDocumentTable(Arrays.asList("Event", "Name"));
        try {
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLEvent.START_ELEMENT:
                        table.getCells().add(Arrays.asList("Start element", reader.getLocalName()));
                        for(int i = 0, n = reader.getAttributeCount(); i < n; ++i)
                            table.getCells().add(Arrays.asList("Attribute", reader.getAttributeName(i) + "=" + reader.getAttributeValue(i)));
                        break;
                    case XMLEvent.CHARACTERS:
                        table.getCells().add(Arrays.asList("Characters", reader.getText()));
                        break;
                    case XMLEvent.END_ELEMENT:
                        table.getCells().add(Arrays.asList("End element", reader.getLocalName()));
                        break;
                }
            }
        } catch (XMLStreamException e) {
            logger.error(e.getMessage(), e);
        }
        return table;
    }
}
