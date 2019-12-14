package com.vovamisjul.Parsers;

import java.util.ArrayList;
import java.util.List;

public class ParsedDocumentTable {

    private List<String> headers;
    private List<List<String>> cells = new ArrayList<>();

    public ParsedDocumentTable(List<String> headers) {
        this.headers = headers;
    }

    public List<List<String>> getCells() {
        return cells;
    }

    public void setCells(List<List<String>> cells) {
        this.cells = cells;
    }
    public List<String> getHeaders() {
        return headers;
    }
}
