package ipmapcity;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Map;

import static ipmapcity.Constants.ERROR_IP;
import static ipmapcity.Constants.NO_CITY_INFO;

/**
 * IP地址-城市工具类
 * <p>
 * Created by Ocean lin on 2020/5/20.
 *
 * @author Ocean lin
 */
public class IpUtils {

    /**
     * 返回IP段属于城市，
     * 如果IP非法，返回"非法IP!"；如果没有返回“无城市信息!”
     *
     * @param ipMap IP-City字典表
     * @param ip    IP地址
     * @return
     */
    public static String getCityByIp(Map<IpRange, String> ipMap, String ip) {
        if (validIpAddress(ip)) {
            for (Map.Entry<IpRange, String> entry : ipMap.entrySet()) {
                if (belongsIpRange(ip, entry.getKey())) {
                    return entry.getValue();
                }
            }
            return NO_CITY_INFO;
        } else {
            return ERROR_IP;
        }
    }

    /**
     * 检查IP是否属于IP段
     *
     * @param checkIp 检查IP
     * @param ipRange IP段
     * @return
     */
    private static boolean belongsIpRange(String checkIp, IpRange ipRange) {
        String startIp = ipRange.getStartIp();
        String endIp = ipRange.getEndIp();
        final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
        if (!checkIp.matches(REGX_IP)) {
            return false;
        }

        String[] startIpSplit = startIp.split("\\.");
        String[] endIpSplit = endIp.split("\\.");
        String[] checkIpSplit = checkIp.split("\\.");
        long ips = 0L, ipe = 0L, ipt = 0L;
        for (int i = 0; i < 4; ++i) {
            ips = ips << 8 | Integer.parseInt(startIpSplit[i]);
            ipe = ipe << 8 | Integer.parseInt(endIpSplit[i]);
            ipt = ipt << 8 | Integer.parseInt(checkIpSplit[i]);
        }
        if (ips > ipe) {
            long t = ips;
            ips = ipe;
            ipe = t;
        }
        return ips <= ipt && ipt <= ipe;
    }

    /**
     * 验证是否属于IPV4
     *
     * @param IP IP地址
     * @return
     */
    public static Boolean validIpAddress(String IP) {
        try {
            return (InetAddress.getByName(IP) instanceof Inet4Address) ? true : false;
        } catch (Exception e) {
        }
        return false;
    }


}
