package com.vovamisjul.Parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SAXParser extends DefaultHandler {

    private ParsedDocumentTable table = new ParsedDocumentTable(Arrays.asList("Event", "Name"));
    public SAXParser() {
        super();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        table.getCells().add(new ArrayList<>() { { add("Characters"); add(new String(Arrays.copyOfRange(ch, start, start + length))); } } );
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        table.getCells().add(new ArrayList<>() { { add("Start element"); add(qName); } } );
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        table.getCells().add(new ArrayList<>() { { add("End element"); add(qName); } } );
    }

    public ParsedDocumentTable getTable() {
        return table;
    }
}
