package industrious.hummingbird.common;

import java.math.BigDecimal;

/**
 * Created by xiaoxuwang on 2018/3/28.
 */
public enum ConstantEnum {

    ZERO("0"),                      // 数字0
    ONE("1"),                       // 数字1
    NEGATIVE_ONE("-1"),             //数字-1
    CALCULATE_ERROR("0.000000001"), //误差值
    PRECISION("10");                //精度

    private BigDecimal value ;

    public BigDecimal getValue() {
        return value;
    }

    ConstantEnum(String param){
        value = new BigDecimal(param);
    }

}
