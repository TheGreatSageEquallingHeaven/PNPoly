package industrious.hummingbird;

import industrious.hummingbird.algorithm.PointInPolygonAlgo;
import industrious.hummingbird.pojo.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static industrious.hummingbird.common.ApplicationContextManager.CONTEXT;

/**
 * Created by xiaoxuwang on 2018/3/28.
 */
public class TestPNPoly {

    @Test
    public void testPNPoly() {
        PointInPolygonAlgo  pointInPolygonAlgo = CONTEXT.getBean(PointInPolygonAlgo.class);
        String testPloygon = "1,1,2,2,3,2,3,5,1,3";
        String testPoint = "4,4";
        String[] pointArr = testPoint.split(",");
        Point p =  new Point();
        p.setX(Double.parseDouble(pointArr[0]));
        p.setY(Double.parseDouble(pointArr[1]));
        List<Point> polygon = getPolygon(testPloygon);
        boolean result = pointInPolygonAlgo.isPointInPolygon(p, polygon);
        System.out.print(result);
    }

    private List<Point> getPolygon(String points) {
        List<Point> polygon = new ArrayList<>();
        Point p = null;
        String[] pointArr = points.split(",");
        for (int i = 0; i < pointArr.length; i = i + 2) {
            p = new Point();
            p.setX(Double.parseDouble(pointArr[i]));
            p.setY(Double.parseDouble(pointArr[i + 1]));
            polygon.add(p);
        }
        return polygon;
    }




}
