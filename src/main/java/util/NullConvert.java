package util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by Ocean lin on 2017/12/14.
 */
public class NullConvert {

    public static void main(String[] args) {

    }

    /**
     * 把 VO 中所有属性为 null 的转为 ""
     */
    public void nullConverNullString(Object obj) {
        if (obj != null) {

            Class classz = obj.getClass();
            // 获取所有该对象的属性值
            Field fields[] = classz.getDeclaredFields();

            // 遍历属性值，取得所有属性为 null 值的
            for (Field field : fields) {
                try {
                    Type t = field.getGenericType();
                    if (!t.toString().equals("boolean")) {
                        Method m = classz.getMethod("get"
                                + change(field.getName()));
                        // 调用该字段的get方法
                        Object name = m.invoke(obj);
                        if (name == null) {
                            // 取得所需类的方法对象
                            Method mtd = classz.getMethod("set" + change(field.getName()), new Class[]{String.class});
                            // 执行相应赋值方法
                            mtd.invoke(obj, new Object[]{""});
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param src 源字符串
     * @return 字符串，将src的第一个字母转换为大写，src为空时返回null
     */
    public static String change(String src) {
        if (src != null) {
            StringBuffer sb = new StringBuffer(src);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            return sb.toString();
        } else {
            return null;
        }
    }
}
