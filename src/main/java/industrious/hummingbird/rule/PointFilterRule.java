package industrious.hummingbird.rule;

import industrious.hummingbird.pojo.Point;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hummingbird on 2018/3/28.
 */
@Component
public class PointFilterRule {

    public boolean filter(List<Point> polygon, Point point) {
        List<Double> xs = new ArrayList<>();
        List<Double> ys = new ArrayList<>();
        for (Point pointInPolygon : polygon) {
            xs.add(pointInPolygon.getX().doubleValue());
            ys.add(pointInPolygon.getY().doubleValue());
        }
        BigDecimal minX = new BigDecimal(Double.toString(Collections.min(xs)));
        BigDecimal minY = new BigDecimal(Double.toString(Collections.min(ys)));
        BigDecimal maxX = new BigDecimal(Double.toString(Collections.max(xs)));
        BigDecimal maxY = new BigDecimal(Double.toString(Collections.max(ys)));

        if(point.getX().compareTo(minX) < 0 || point.getX().compareTo(maxX) >0 || point.getY().compareTo(minY) <0 ||
                point.getY().compareTo(maxY) >0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
