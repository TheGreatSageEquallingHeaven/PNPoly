package industrious.hummingbird.algorithm;

import industrious.hummingbird.common.ConstantEnum;
import industrious.hummingbird.pojo.Point;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by xiaoxuwang on 2018/3/28.
 * 1、当 x0 != x1 时
 *      a = (y0-y1)/(x0-x1)
 *      b = -1
 *      c = (x0y1-x1y0)/(x0-x1)
 * 2、当 x0 == x1 时
 *      a = 1
 *      b = 0
 *      c = -x0
 * 直线方程：ax+by+c=0
 * 判断点到直线距离
 */

@Component
public class PointInLineAlgo {

    /** 保留小数点后位数 */
    private static final int PRECISION = ConstantEnum.PRECISION.getValue().intValue();
    private static final BigDecimal NEGATIVE_ONE = ConstantEnum.NEGATIVE_ONE.getValue();
    private static final BigDecimal ZERO = ConstantEnum.ZERO.getValue();
    private static final BigDecimal ONE = ConstantEnum.ONE.getValue();
    private static final BigDecimal CALCULATE_ERROR = ConstantEnum.CALCULATE_ERROR.getValue().pow(2);

    public boolean isIntersect(Point p, Point p0, Point p1) {
        boolean xFlag = p0.getX().compareTo(p1.getX()) == 0;
        BigDecimal a = xFlag ? ONE : p0.getY().subtract(p1.getY()).divide(p0.getX().subtract(p1.getX()), PRECISION,
                RoundingMode.HALF_UP);
        BigDecimal c = xFlag ? ZERO.subtract(p0.getX()) : p0.getX().multiply(p1.getY()).subtract(p1.getX()
                .multiply(p0.getY())).divide(p0.getX().subtract(p1.getX()),PRECISION, RoundingMode.HALF_UP);
        BigDecimal b = xFlag ? ZERO : NEGATIVE_ONE;
        BigDecimal powD = a.multiply(p.getX()).add(b.multiply(p.getY())).add(c).pow(2).divide(a.pow(2).add(b.pow(2)));
        if(ZERO.compareTo(powD) == 0){
            return (p.getY().compareTo(p0.getY()) > 0 && p.getY().compareTo(p1.getY()) > 0) ||
                    (p.getY().compareTo(p0.getY()) < 0 && p.getY().compareTo(p1.getY())< 0)? Boolean.FALSE : Boolean.TRUE;
        }
        return CALCULATE_ERROR.compareTo(powD) >= 0;

    }

}
