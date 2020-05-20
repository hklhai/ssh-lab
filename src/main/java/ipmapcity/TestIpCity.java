package ipmapcity;


import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static ipmapcity.Constants.*;

/**
 * Created by Ocean lin on 2020/5/20.
 *
 * @author Ocean lin
 */
public class TestIpCity {

    @Test
    public void testIpCity() {
        // 数据初始化
        Map<IpRange, String> ipMap = new HashMap<>();
        ipMap.put(new IpRange("10.10.10.1", "10.10.11.128"), BJ);
        ipMap.put(new IpRange("10.10.12.1", "10.10.12.120"), SH);
        ipMap.put(new IpRange("100.1.1.2", "103.1.1.3"), TJ);

        String ip1 = "202.114.74.190";
        Assert.assertEquals(IpUtils.getCityByIp(ipMap, ip1), NO_CITY_INFO);

        String ip2 = "290.114.74.190";
        Assert.assertEquals(IpUtils.getCityByIp(ipMap, ip2), ERROR_IP);

        String ip3 = "10.10.10.3";
        Assert.assertEquals(IpUtils.getCityByIp(ipMap, ip3), BJ);

        String ip4 = "10.10.12.100";
        Assert.assertEquals(IpUtils.getCityByIp(ipMap, ip4), SH);

        String ip5 = "100.1.1.3";
        Assert.assertEquals(IpUtils.getCityByIp(ipMap, ip5), TJ);
    }
}
