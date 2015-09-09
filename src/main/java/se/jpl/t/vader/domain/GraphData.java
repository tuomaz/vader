package se.jpl.t.vader.domain;

public class GraphData {
    String key;
    Object[][] values;
    int size = 0;
    int position = 0;

    public GraphData(int size) {
        values = new Object[size][2];
    }

    public String getKey() {
        return key;
    }

    public void setKey(String series) {
        this.key = series;
    }

    public Object[][] getValues() {
        return values;
    }

    public void addPoint(GraphPoint gp) {
        if (values == null) {
            values = new Object[100][2];
            size = 0;
            position = 0;
        }
        values[position] = gp.getPoint();
        position++;
    }
}
