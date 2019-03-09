package com.molice.config.druid;

import com.alibaba.druid.util.DruidPasswordCallback;

import java.util.Properties;

/**
 * @ClassName: DBPasswordCallback
 * @Description: TODO
 * @author: molice
 * @date: 2018年9月20日 下午6:05:51
 */
public class DBPasswordCallback extends DruidPasswordCallback {

    /**
     *
     */
    private static final long serialVersionUID = -2034820150051613774L;
    public static final String ENCRYPT_KEY = "THIS SHALL NOT BE SEEN.";
    private static final String PASSWORD = "password";
    private Properties properties;

    /**
     * @param prompt
     * @param echoOn
     */
    public DBPasswordCallback(String prompt, boolean echoOn) {
        super(prompt, echoOn);
    }

    public DBPasswordCallback() {
        this("db pwd", true);
    }

    /**
     * @return the properties
     */
    @Override
    public Properties getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
        String pwd = properties.getProperty(PASSWORD);
        byte[] decryptFrom = EncryptUtil.parseHexStr2Byte(pwd);
        try {
            byte[] decryptResult = EncryptUtil.decrypt(decryptFrom, ENCRYPT_KEY);
            setPassword(new String(decryptResult).toCharArray());
        } catch (Exception e) {
            setPassword(pwd.toCharArray());
        }
    }

}