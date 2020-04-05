package recurssion.globe;

enum Site {
    WATER(0),
    LAND(1);

    int value;

    Site(int i) {
        this.value = i;
    }

    public static Site[][] toSite(int[][] data) {
        if (null == data) {
            return new Site[0][0];
        }
        int rows = data.length;
        int cols = (rows > 0) ? data[0].length : 0;

        Site[][] sites = new Site[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sites[row][col] = (data[row][col] == LAND.value) ? LAND : WATER;
            }
        }

        return sites;
    }

    public int getValue() {
        return value;
    }
}
