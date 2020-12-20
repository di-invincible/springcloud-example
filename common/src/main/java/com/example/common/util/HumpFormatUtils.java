package com.example.common.util;

/**
 * 大驼峰 、小驼峰 转换工具
 * @author battle
 */
public class HumpFormatUtils {

    /**
     * 大写字母 起始位置 ASCII
     */
    private static final char A = 'A';

    /**
     * 大写字母 结束位置 ASCII
     */
    private static final char Z = 'Z';

    private static final byte TMP = 32;


    public static String toLower(String big){
        char[] chars = big.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if (c >= A && c <= Z) {
                if (big.charAt(0) == c) {
                    stringBuilder.append((char) (c + TMP));
                } else {
                    stringBuilder.append("_").append((char) (c + TMP));
                }
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static String toPropertyUpper(String small){
        char[] chars = small.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int pre = 0;
        int i = 0 ;
        while (i < chars.length) {
            char c = chars[i];
            if(c == '_') {
                pre = i + 1;
            } else if (pre == i && pre != 0) {
                stringBuilder.append((char) (c - TMP));
            } else {
                stringBuilder.append(c);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static String toClassUpper(String small){
        char[] chars = small.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int pre = 0;
        int i = 0 ;
        while (i < chars.length) {
            char c = chars[i];
            if(c == '_') {
                pre = i + 1;
            } else if (pre == i) {
                stringBuilder.append((char) (c - TMP));
            } else {
                stringBuilder.append(c);
            }
            i++;
        }
        return stringBuilder.toString();
    }
}
