package recurssion.globe;

class Country {
    private int row;
    private int col;

    public Country(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "[" + row + ", " + col + ']';
    }
}
