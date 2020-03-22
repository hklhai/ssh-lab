package mylog.logtest;

import org.apache.log4j.Logger;

/**
 * Created by Ocean lin on 2020/3/22.
 *
 * @author Ocean lin
 */
public class JulTest {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("JUL");
        logger.info("JUL - log");
    }
}
