package com.example.common.util.encryption;



import com.example.common.entity.data.DataType;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @Author wudi
 * @Date 2020/5/30 21:39
 * @Description
 * @Version 1.0
 **/
public class GenerateSha256 {

    protected static String CHECK_CODE = "RecordChecksumCode";


    public static String encryptionPassword(String password){
        try {
            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            byte[] messageDigest = md.digest(password.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (Exception e) {
            e.printStackTrace();
            return "generate fail";
        }
    }

    public static boolean matchPassword(String password,String encryptionPassword){
      return encryptionPassword(password).equals(encryptionPassword);
    }


    public static String getShaByObject(Object object) {

        try {
            String stringBuffer = getObjectValue(object);
            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            byte[] messageDigest = md.digest(stringBuffer.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "generate fail";
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return "generate fail";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "generate fail";
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return "generate fail";
        }
    }


    public static String getObjectValue(Object model) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取实体类的所有属性，返回Field数组  
        Field[] field = model.getClass().getDeclaredFields();

        StringBuffer stringBuffer = new StringBuffer();

        //遍历所有属性
        for (int j = 0; j < field.length; j++) {
            //获取属性的名字
            String name = field[j].getName();
            //将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);

            //排除
            if(CHECK_CODE.equals(name)){
                continue;
            }
            //获取属性的类型
            String type = field[j].getGenericType().toString();
            //如果type是类类型，则前面包含"class "，后面跟类名

            if (type.equals(DataType.STRING_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                //调用getter方法获取属性值
                String value = (String) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value);
                }
            }
            if (type.equals(DataType.BYTE_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                Byte value = (Byte) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.SHORT_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                Short value = (Short) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.INTEGER_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                Integer value = (Integer) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.LONG_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                Long value = (Long) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.FLOAT_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                Float value = (Float) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.DOUBLE_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                Double value = (Double) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.BIG_DECIMAL_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                BigDecimal value = (BigDecimal) m.invoke(model);
                if (value != null) {
                    BigDecimal bigDecimal = new BigDecimal("0.00");
                    value = value.add(bigDecimal);
                    stringBuffer.append(value.toString());
                }
            }

            if (type.equals(DataType.BOOLEAN_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                Boolean value = (Boolean) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.DATE_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                Date value = (Date) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.LOCAL_DATE_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                LocalDate value = (LocalDate) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.LOCAL_TIME_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                LocalTime value = (LocalTime) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
            if (type.equals(DataType.LOCAL_DATE_TYPE)) {
                Method m = model.getClass().getMethod("get" + name);
                LocalDateTime value = (LocalDateTime) m.invoke(model);
                if (value != null) {
                    stringBuffer.append(value.toString());
                }
            }
        }
        return stringBuffer.toString();
    }


    public static boolean judgeSha(Object objectA, Object objectB) {
        String objectASha = getShaByObject(objectA);
        String objectBSha = getShaByObject(objectB);
        return objectASha.equals(objectBSha);
    }

}
