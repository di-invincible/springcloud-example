package com.example.common.util.communication;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author battle
 * @since 2019/12/31 11:12
 */
public class VerifyCodeUtils {

    /**
     * 纯字母验证码的 字符表
     */
    private final static char[] CHARS = {
            'A','B','C','D','E','F','G',
            'H','I','J','K','L','M','N',
            'O','P','Q','R','S','T',
            'U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g',
            'h','i','j','k','l','m','n',
            'o','p','q','r','s','t',
            'u','v','w','x','y','z'
    };

    /**
     * 混合验证码的 字符表
     */
    private final static String[] STRINGS = {
            "A","B","C","D","E","F","G",
            "H","I","J","K","L","M","N",
            "O","P","Q","R","S","T",
            "U","V","W","X","Y","Z",
            "a","b","c","d","e","f","g",
            "h","i","j","k","l","m","n",
            "o","p","q","r","s","t",
            "u","v","w","x","y","z",
            "1","2","3","4","5","6","7","8","9","0"
    };

    /**
     * 遍历初始位置
     */
    private final static int START_INDEX = 0;

    /**
     * 默认的遍历结束位置
     */
    private final static int END_DEFAULT_INDEX = 6;

    /**
     * 数字验证码的 随机数 范围
     */
    private final static int DIGITAL_RANGE = 10;

    /**
     * 生成 size 位的随机数
     * @param size 位数
     * @return String
     */
    public static String digitalCode(Integer size){
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(START_INDEX,verifySize(size)).forEach( i ->
                stringBuilder.append(new Random().nextInt(DIGITAL_RANGE))
        );
        return stringBuilder.toString();
    }

    /**
     * 字母验证码
     * @param size 位数
     * @return String
     */
    public static String alphabetCode(Integer size){
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(START_INDEX,verifySize(size)).forEach( i ->
            stringBuilder.append(CHARS[new Random().nextInt(CHARS.length)])
        );
        return stringBuilder.toString();
    }

    /**
     * 字母数字混合验证码
     * @param size 位数
     * @return String
     */
    public static String mixingCode(Integer size){
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(START_INDEX,verifySize(size)).forEach( i ->
            stringBuilder.append(STRINGS[new Random().nextInt(STRINGS.length)])
        );
        return stringBuilder.toString();
    }

    /**
     * 验证 位数 size
     * @param size 位数
     * @return Integer
     */
    private static Integer verifySize(Integer size){
        return ((size == null) || (size <= 0)) ? END_DEFAULT_INDEX : size;
    }
}
