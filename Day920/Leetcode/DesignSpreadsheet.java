//Leetcode
//3484. Design Spreadsheet
//Time complexity: O(1) for all the functions
//Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class DesignSpreadsheet {

    static class Spreadsheet {

        int rows;
        Map<String, Integer> cells;

        public Spreadsheet(int rows) {
            this.rows = rows;
            this.cells = new HashMap<>();
        }

        public void setCell(String cell, int value) {
            cells.put(cell, value);
        }

        public void resetCell(String cell) {
            cells.remove(cell);
        }

        public int getValue(String formula) {
            String[] parts = formula.substring(1).split("\\+");
            return get(parts[0]) + get(parts[1]);
        }

        public int get(String s) {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return cells.getOrDefault(s, 0);
            }
        }
    }

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3); // Initializes a spreadsheet with 3 rows and 26 columns
        System.out.println(spreadsheet.getValue("=5+7")); // returns 12 (5+7)
        spreadsheet.setCell("A1", 10); // sets A1 to 10
        System.out.println(spreadsheet.getValue("=A1+6")); // returns 16 (10+6)
        spreadsheet.setCell("B2", 15); // sets B2 to 15
        System.out.println(spreadsheet.getValue("=A1+B2")); // returns 25 (10+15)
        spreadsheet.resetCell("A1"); // resets A1 to 0
        System.out.println(spreadsheet.getValue("=A1+B2")); // returns 15 (0+15)
    }
}
