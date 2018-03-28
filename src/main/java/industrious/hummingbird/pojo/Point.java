package industrious.hummingbird.pojo;

import java.math.BigDecimal;

/**
 * Created by xiaoxuwang on 2018/3/28.
 */
public class Point {

    private double x;
    private double y;

    public Point(){}

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public BigDecimal getX() {
        return new BigDecimal(Double.toString(x));
    }

    public void setX(double x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return new BigDecimal(Double.toString(y));
    }

    public void setY(double y) {
        this.y = y;
    }

}
