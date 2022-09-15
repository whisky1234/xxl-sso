package com.xxl.sso.core.user;

import java.io.Serializable;
import java.util.Map;

/**
 * xxl sso user
 *
 * @author xuxueli 2018-04-02 19:59:49
 */
public class SsoUser implements Serializable {
    private static final long serialVersionUID = 42L;

    // field
    private String              userId;
    private String              username;
    private Map<String, String> pluginInfo;

    private String version;
    private int    expireMinute;
    private long   expireFreshTime;


    // set get
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<String, String> getPluginInfo() {
        return pluginInfo;
    }

    public void setPluginInfo(Map<String, String> pluginInfo) {
        this.pluginInfo = pluginInfo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getExpireMinute() {
        return expireMinute;
    }

    public void setExpireMinute(int expireMinute) {
        this.expireMinute = expireMinute;
    }

    public long getExpireFreshTime() {
        return expireFreshTime;
    }

    public void setExpireFreshTime(long expireFreshTime) {
        this.expireFreshTime = expireFreshTime;
    }

}
