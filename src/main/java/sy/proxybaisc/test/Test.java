package sy.proxybaisc.test;


import sy.proxybaisc.dao.LubanDao;
import sy.proxybaisc.dao.LubanDaoImpl;
import sy.proxybaisc.util.ProxyUtil;

public class Test {
    public static void main(String[] args) {

        LubanDao proxy = (LubanDao) ProxyUtil.newInstance(new LubanDaoImpl());
        proxy.query();

    }
}
