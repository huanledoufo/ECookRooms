package Bean;

/**
 * Created by Administrator on 2015/4/30.
 */
public class DrawerBean {
    private int iv1;
    private String tv;
    private int iv2;


    public DrawerBean(int iv1, String tv, int iv2) {
        this.iv1 = iv1;
        this.tv = tv;
        this.iv2 = iv2;

    }


    public int getIv1() {
        return iv1;
    }

    public void setIv1(int iv1) {
        this.iv1 = iv1;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public int getIv2() {
        return iv2;
    }

    public void setIv2(int iv2) {
        this.iv2 = iv2;
    }

    @Override
    public String toString() {
        return "DrawerBean{" +
                "iv1=" + iv1 +
                ", tv='" + tv + '\'' +
                ", iv2=" + iv2 +
                '}';
    }
}
