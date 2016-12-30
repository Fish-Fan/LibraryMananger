package entity;

import java.util.Date;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class Borrow {
    private String rno;
    private String bisbn;
    private String startdate;
    private String enddate;
    private float fine;

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getBisbn() {
        return bisbn;
    }

    public void setBisbn(String bisbn) {
        this.bisbn = bisbn;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "rno='" + rno + '\'' +
                ", bisbn='" + bisbn + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", fine=" + fine +
                '}';
    }
}
