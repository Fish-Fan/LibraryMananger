package entity;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class Reader {
    private String rno;
    private String rname;
    private String rgender;
    private int rage;
    private String rspecialty;

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRgender() {
        return rgender;
    }

    public void setRgender(String rgender) {
        this.rgender = rgender;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

    public String getRspecialty() {
        return rspecialty;
    }

    public void setRspecialty(String rspecialty) {
        this.rspecialty = rspecialty;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "rno=" + rno +
                ", rname='" + rname + '\'' +
                ", rgender='" + rgender + '\'' +
                ", rage=" + rage +
                ", rspecialty='" + rspecialty + '\'' +
                '}';
    }
}
