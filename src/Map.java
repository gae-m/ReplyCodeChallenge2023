public class Map {
    private final int rows;
    private final int columns;
    private final Cell[][] field;

    public Map(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.field = new Cell[rows][columns];
    }

    @Override
    public String toString() {
        String print = new String();
        for(Cell[] row : field) {
            for (Cell x : row)
                print += x + " ";
            print += "\n";
        }
        return print;
    }

    public void setField(String[][] stringField){
        if(stringField.length == this.rows && stringField[0].length == this.columns){
            int s;
            for(int i = 0; i < this.rows; i++){
                for(int j = 0; j < this.columns; j++){
                    if(stringField[i][j].equals("*")){
                        s = 0;
                    }
                    else{
                        s = Integer.parseInt(stringField[i][j]);
                    }
                    this.field[i][j] = new Cell(i,j,s,stringField[i][j].equals("*"));
                }
            }
        }
    }

    private int normalizeRow(int row){return row % this.rows;}
    private int normalizeColumn(int column){return column % this.columns;}
}
