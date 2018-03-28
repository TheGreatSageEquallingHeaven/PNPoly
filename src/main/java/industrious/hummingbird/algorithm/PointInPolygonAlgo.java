package industrious.hummingbird.algorithm;

import industrious.hummingbird.pojo.Point;
import industrious.hummingbird.rule.PointFilterRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by xiaoxuwang on 2018/3/28.
 */
@Component
public class PointInPolygonAlgo {

    @Autowired
    private IntersectAlgo intersectAlgo;

    @Autowired
    private PointInLineAlgo pointInLineAlgo;

    @Autowired
    private PointFilterRule pointFilterRule;

    public boolean isPointInPolygon(Point p, List<Point> polygon) {
        boolean isIn = Boolean.FALSE;
        Point p0;
        Point p1;
        if(!pointFilterRule.filter(polygon,p)){
            return isIn;
        }
        for (int i = 0, j = polygon.size() - 1; i < polygon.size(); j = i++) {
            p0 = polygon.get(j);
            p1 = polygon.get(i);
            if (p.equals(p0)) {
                return Boolean.TRUE;
            }
            if(pointInLineAlgo.isIntersect(p, p0, p1)) {
                return Boolean.TRUE;
            }
            if (intersectAlgo.isIntersect(p, p0, p1)) {
                isIn = !isIn;
            }
        }
        return isIn;
    }

}
