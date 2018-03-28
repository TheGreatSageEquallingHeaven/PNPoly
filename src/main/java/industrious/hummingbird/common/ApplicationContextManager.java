package industrious.hummingbird.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaoxuwang on 2018/3/28.
 */
public class ApplicationContextManager {

    private static final String SPRING_CONFIG_FILE_PATH = "spring-master.xml";

    public static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILE_PATH);

    private ApplicationContextManager(){
    }
}
