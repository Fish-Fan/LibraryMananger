package entity;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class Book {
    private String bisbn;
    private String bname;
    private String bauthor;
    private String bpublisher;
    private float bprice;
    private String bcategory;

    public String getBisbn() {
        return bisbn;
    }

    public void setBisbn(String bisbn) {
        this.bisbn = bisbn;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBpublisher() {
        return bpublisher;
    }

    public void setBpublisher(String bpublisher) {
        this.bpublisher = bpublisher;
    }

    public float getBprice() {
        return bprice;
    }

    public void setBprice(float bprice) {
        this.bprice = bprice;
    }

    public String getBcategory() {
        return bcategory;
    }

    public void setBcategory(String bcategory) {
        this.bcategory = bcategory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bisbn='" + bisbn + '\'' +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", bpublisher='" + bpublisher + '\'' +
                ", bprice=" + bprice +
                ", bcategory='" + bcategory + '\'' +
                '}';
    }
}
