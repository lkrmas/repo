package main.util;

import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;

@SuppressWarnings("serial")
public class WrapGridLayout extends GridLayout {

    private int[][] layout;
    private int cursor;

    public WrapGridLayout() {
        super();
        layout = new int[0][0];
        cursor = 0;
    }

    public WrapGridLayout(int columns, int rows) {
        super(columns, rows);
        layout = new int[0][0];
        cursor = 0;
    }

    public WrapGridLayout(int columns, int rows, int[][] layout) {
        super(columns, rows);
        this.layout = layout;
        cursor = 0;
    }

    public void prepare(int columns, int rows, int[][] layout) {
        setColumns(columns);
        setRows(rows);
        this.layout = layout;
        cursor = 0;
    }

    @Override
    public void addComponent(Component component) {
        if (cursor < layout.length) {
            int co = layout[cursor][0] - 1;
            int ro = layout[cursor][1] - 1;
            int coSpan = co + layout[cursor][2] - 1;
            int roSpan = ro + layout[cursor][3] - 1;
            super.addComponent(component, co, ro, coSpan, roSpan);
            cursor ++;
        }
        else {
            super.addComponent(component);
        }
    }

}
