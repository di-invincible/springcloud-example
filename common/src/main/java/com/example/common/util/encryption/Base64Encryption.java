package com.example.common.util.encryption;

import java.util.Base64;

/**
 * @author nf
 * @since 2020/6/10 11:36
 */
public class Base64Encryption {

    /**
     * BASE64解密
     * @throws Exception
     */
    public static byte[] decryptBase64(String key) throws Exception {
        return Base64.getDecoder().decode(key);
    }

    /**
     * BASE64加密
     */
    public static String encryptBase64(byte[] key) throws Exception {
        return Base64.getEncoder().encodeToString(key);
    }
}
