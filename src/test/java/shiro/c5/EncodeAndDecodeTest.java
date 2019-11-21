package shiro.c5;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.BlowfishCipherService;
import org.apache.shiro.crypto.DefaultBlockCipherService;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;

/**
 * Created by Ocean lin on 2017/9/13.
 */
public class EncodeAndDecodeTest {

    public void testAES() {
        //AES 算法实现：
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置key长度
        //生成key
        Key key = aesCipherService.generateNewKey();
        String text = "admin";
        //加密
        String encrptText = aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        System.out.println(encrptText);
        //解密
        String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());
        Assert.assertEquals(text, text2);
    }

    public void testBlowfishCipherService() {
        //Blowfish 算法实现：
        BlowfishCipherService blowfishCipherService = new BlowfishCipherService();
        blowfishCipherService.setKeySize(128);

        //生成key
        Key key = blowfishCipherService.generateNewKey();

        String text = "admin";

        //加密
        String encrptText = blowfishCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        System.out.println(encrptText);
        //解密
        String text2 = new String(blowfishCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());

        junit.framework.Assert.assertEquals(text, text2);
    }

    public void testDefaultBlockCipherService() throws Exception {
        //对称加密，使用Java的JCA（javax.crypto.Cipher）加密API，常见的如 'AES', 'Blowfish'
        DefaultBlockCipherService cipherService = new DefaultBlockCipherService("AES");
        cipherService.setKeySize(128);

        //生成key
        Key key = cipherService.generateNewKey();

        String text = "admin";
        //加密
        String encrptText = cipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        System.out.println(encrptText);
        //解密
        String text2 = new String(cipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());
        junit.framework.Assert.assertEquals(text, text2);
    }


}
