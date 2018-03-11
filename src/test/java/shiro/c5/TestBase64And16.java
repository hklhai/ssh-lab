package shiro.c5;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.*;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Ocean lin on 2017/9/13.
 */
public class TestBase64And16 {

    @Test
    public void testBase64() {
        String str = "hello";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        String str2 = Base64.decodeToString(base64Encoded);
        System.out.println(base64Encoded);
        Assert.assertEquals(str, str2);

    }

    @Test
    public void test16() {
        String str = "hello";
        String hexEncoded = Hex.encodeToString(str.getBytes());
        String str2 = new String(Hex.decode(hexEncoded.getBytes()));
        Assert.assertEquals(str, str2);
        System.out.println(hexEncoded);
    }

    //类CodecSupport，提供了toBytes(str, "utf-8") / toString(bytes,"utf-8")用于在byte 数组/String 之间转换。
    @Test
    public void testCodecSupport() {
        String str = "hello";
        byte[] bytes = CodecSupport.toBytes(str, "utf-8");
        System.out.println(bytes);
        String s = CodecSupport.toString(bytes, "utf-8");
        System.out.println(s);
    }

    @Test
    public void testHash() {
        String str = "admin";
        String salt = "admin" + "12346";  //Name+ID
        String md5 = new Md5Hash(str, salt).toString();//还可以转换为toBase64()/toHex()
        System.out.println(md5);
        String base64Encoded = Base64.encodeToString(str.getBytes());
        System.out.println(base64Encoded);
        String hexEncoded = Hex.encodeToString(str.getBytes());
        System.out.println(hexEncoded);

        //多次Hash
        String md5for2time = new Md5Hash(str, salt, 2).toString();
        System.out.println(md5for2time);

        String sha1 = new Sha256Hash(str, salt).toString();
        System.out.println(sha1);

        //通用的散列支持--内部使用MessageDigest
        String simpleHash = new SimpleHash("SHA-1", str, salt).toString();
        System.out.println(simpleHash);
    }

    @Test
    public void tesHashService() {
        DefaultHashService hashService = new DefaultHashService(); //默认算法SHA-512
        hashService.setHashAlgorithmName("SHA-512");
        hashService.setPrivateSalt(new SimpleByteSource("123")); //私盐，默认无
        hashService.setGeneratePublicSalt(true);//是否生成公盐，默认false
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐。默认就这个
//        RandomNumberGenerator randomNumberGenerator = hashService.getRandomNumberGenerator().;
        hashService.setHashIterations(1); //生成Hash值的迭代次数
        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex = hashService.computeHash(request).toHex();
        System.out.println(hex);

    }


}
