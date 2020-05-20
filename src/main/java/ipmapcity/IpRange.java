package ipmapcity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * IP 范围类
 *
 * Created by Ocean lin on 2020/5/20.
 *
 * @author Ocean lin
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IpRange {

    /**
     * 开始IP
     */
    private String startIp;

    /**
     * 结束IP
     */
    private String endIp;


}
