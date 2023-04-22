public class Map {
    private int rows;
    private int columns;
    private int[][] scoreMap;
    private char[][] vacationMap;

    public Map(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.scoreMap = new int[rows][columns];
        this.vacationMap = new char[rows][columns];
    }

    @Override
    public String toString() {
        String print = new String();
        for(int[] row : scoreMap) {
            for (int x : row)
                print += x + " ";
            print += "\n";
        }
        print += "\n";
        for(char[] row : vacationMap) {
            for (char x : row)
                print += x + " ";
            print += "\n";
        }
        return print;
    }

    public void setScoreMap(int[][] scoreMap){
        if(scoreMap.length == this.rows && scoreMap[0].length == this.columns){
            this.scoreMap = scoreMap;
        }
    }

    public void setVacationMap(char[][] vacationMap){
        if(vacationMap.length == this.rows && vacationMap[0].length == this.columns){
            this.vacationMap = vacationMap;
        }
    }

    public void setScoreCell(int row, int column, int x){
        row = normalizeRow(row);
        column = normalizeColumn(column);
        this.scoreMap[row][column] = x;
    }

    public int getScoreCell(int row, int column){
        row = normalizeRow(row);
        column = normalizeColumn(column);
        return this.scoreMap[row][column];
    }

    public void setVacationCell(int row, int column, char x){
        row = normalizeRow(row);
        column = normalizeColumn(column);
        this.vacationMap[row][column] = x;
    }

    public char getVacationCell(int row, int column){
        row = normalizeRow(row);
        column = normalizeColumn(column);
        return this.vacationMap[row][column];
    }

    private int normalizeRow(int row){return row % this.rows;}
    private int normalizeColumn(int column){return column % this.columns;}
}
