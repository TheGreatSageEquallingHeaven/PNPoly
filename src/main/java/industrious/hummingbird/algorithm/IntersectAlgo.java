package industrious.hummingbird.algorithm;

import industrious.hummingbird.common.ConstantEnum;
import industrious.hummingbird.pojo.Point;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by xiaoxuwang on 2018/3/28.
 * x=((y-y1)*x0-(y-y0)*x1)/(y0-y1)
 * 计算射线与线段的交点
 */
@Component
public class IntersectAlgo {

    /** 保留小数点后位数 */
    private static final int PRECISION = ConstantEnum.PRECISION.getValue().intValue();
    private static final BigDecimal ZERO = ConstantEnum.ZERO.getValue();

    public boolean isIntersect(Point p, Point p0, Point p1){
        BigDecimal interceptP0P = p0.getY().subtract(p.getY());
        BigDecimal interceptP1P = p1.getY().subtract(p.getY());
        BigDecimal interceptP0P1 = p0.getY().subtract(p1.getY());
        int p0pFlag = ZERO.compareTo(interceptP0P);
        int p1pFlag = ZERO.compareTo(interceptP1P);
        /** 当点p与线段p0p1在同一水平直线l上时，点p与线段p0p1的位置关系（在左侧（true），在右侧（false），在中间（true））*/
        if(0 == p0pFlag && 0 == p1pFlag) {
            return  p.getX().compareTo(p0.getX()) > 0 && p.getX().compareTo(p1.getX()) > 0 ? Boolean.FALSE : Boolean.TRUE;
        }
        /** 点p在线段p0p1上方或下方时，向右水平射线P与线段p0p1上必然不存在相交点*/
        if((p0pFlag > 0 && p1pFlag > 0) || (p0pFlag < 0 && p1pFlag < 0)) {
            return Boolean.FALSE;
        }
        /** 计算交点横坐标 */
        BigDecimal deltaX = p.getY().subtract(p1.getY()).multiply(p0.getX()).subtract(p.getY().subtract(p0.getY())
                .multiply(p1.getX())).divide(p0.getY().subtract(p1.getY()), PRECISION, RoundingMode.HALF_UP);
        if(deltaX.compareTo(p.getX()) >= 0){
            /** 所有交点均算作上侧点 */
            if(ZERO.compareTo(interceptP0P1) > 0){
                return p1pFlag < 0;
            }else{
                return p0pFlag < 0;
            }
        }
        return Boolean.FALSE;
    }

}
