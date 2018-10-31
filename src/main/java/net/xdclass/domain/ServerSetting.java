package net.xdclass.domain;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by chengjiapeng on 2018/9/9.
 */

@Component
@PropertySource({"classpath:application.properties"})
@ConfigurationProperties(prefix = "test")
public class ServerSetting {

    private String name;

    private String domain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
