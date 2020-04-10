package studyCollections;

class PerformanceMeasure {
    private String name;
    private int n;
    private long createTime;
    private long readTime;
    private long reverseReadTime;
    private long deleteTime;
    private long reverseDeleteTime;

    public PerformanceMeasure(String name, int n, long createTime, long readTime, long reverseReadTime, long deleteTime, long reverseDeleteTime) {
        this.name = name;
        this.n = n;
        this.createTime = createTime;
        this.readTime = readTime;
        this.reverseReadTime = reverseReadTime;
        this.deleteTime = deleteTime;
        this.reverseDeleteTime = reverseDeleteTime;
    }

    public String toTab() {
        return name + "\t" +
                n + "\t" +
                createTime + "\t" +
                readTime + "\t" +
                reverseReadTime + "\t" +
                deleteTime + "\t" +
                reverseDeleteTime;
    }

    public String toCsv() {
        return name + "," +
                createTime + "," +
                readTime + "," +
                reverseReadTime + "," +
                deleteTime + "," +
                reverseDeleteTime + "," +
                n;
    }

    @Override
    public String toString() {
        return name + " {" +
                "n=" + n +
                ", createTime=" + createTime +
                ", readTime=" + readTime +
                ", reverseReadTime=" + reverseReadTime +
                ", deleteTime=" + deleteTime +
                ", reverseDeleteTime=" + reverseDeleteTime +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getN() {
        return n;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getReadTime() {
        return readTime;
    }

    public long getReverseReadTime() {
        return reverseReadTime;
    }

    public long getDeleteTime() {
        return deleteTime;
    }

    public long getReverseDeleteTime() {
        return reverseDeleteTime;
    }
}
