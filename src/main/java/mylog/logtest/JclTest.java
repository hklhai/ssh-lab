package mylog.logtest;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Ocean lin on 2020/3/22.
 *
 * @author Ocean lin
 */
public class JclTest {

    public static void main(String[] args) {
        Log log = LogFactory.getLog("JCL");
        log.info("JCL - log");
    }
}
