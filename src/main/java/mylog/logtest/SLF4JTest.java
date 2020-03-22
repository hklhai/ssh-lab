package mylog.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ocean lin on 2020/3/22.
 *
 * @author Ocean lin
 */
public class SLF4JTest {

    public static void main(String[] args) {
        Logger slf4JTest = LoggerFactory.getLogger("SLF4JTest");
        slf4JTest.info("SLF4JTest");
    }
}