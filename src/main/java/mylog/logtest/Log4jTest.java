package mylog.logtest;

import org.apache.log4j.Logger;

/**
 * Created by Ocean lin on 2020/3/22.
 *
 * @author Ocean lin
 */
public class Log4jTest {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Log4j");
        logger.info("Log4jTest - log");
    }
}
