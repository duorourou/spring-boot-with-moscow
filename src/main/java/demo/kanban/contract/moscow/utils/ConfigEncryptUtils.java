package demo.kanban.contract.moscow.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

/**
 * Created by xchou on 01/11/2016.
 */
public class ConfigEncryptUtils {
    public static void amain(String[] args){
        //加密工具
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        //加密配置
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        //自己在用的时候更改此密码
        config.setPassword("kanban123");
        //应用配置
        encryptor.setConfig(config);
        String plaintext="kanban";
        //加密
        String ciphertext=encryptor.encrypt(plaintext);
        System.out.println(plaintext + " : " + ciphertext);
    }
}
