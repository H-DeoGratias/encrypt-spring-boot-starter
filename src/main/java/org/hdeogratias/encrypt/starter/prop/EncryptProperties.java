package org.hdeogratias.encrypt.starter.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author H-DeoGratias
 * @create 2021-06-05 16:50
 * @Gitee https://gitee.com/H-DeoGratias
 */
@ConfigurationProperties(prefix = "spring.encrypt")
public class EncryptProperties {
    private final static String DEFAULT_KEY = "H-DeoGratias";
    private String key = DEFAULT_KEY;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
