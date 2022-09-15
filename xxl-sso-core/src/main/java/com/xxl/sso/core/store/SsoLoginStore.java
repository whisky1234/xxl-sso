package com.xxl.sso.core.store;

import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.user.SsoUser;
import com.xxl.sso.core.util.JedisUtil;

/**
 * local login store
 *
 * @author xuxueli 2018-04-02 20:03:11
 */
public class SsoLoginStore {

    private static int redisExpireMinute = 1440;    // 1440 minute, 24 hour

    public static void setRedisExpireMinute(int redisExpireMinute) {
        if (redisExpireMinute < 30) {
            redisExpireMinute = 30;
        }
        SsoLoginStore.redisExpireMinute = redisExpireMinute;
    }

    public static int getRedisExpireMinute() {
        return redisExpireMinute;
    }

    /**
     * get
     *
     * @param storeKey
     * @return
     */
    public static SsoUser get(String storeKey) {

        String redisKey    = redisKey(storeKey);
        Object objectValue = JedisUtil.getObjectValue(redisKey);
        if (objectValue != null) {
            SsoUser xxlUser = (SsoUser) objectValue;
            return xxlUser;
        }
        return null;
    }

    /**
     * remove
     *
     * @param storeKey
     */
    public static void remove(String storeKey) {
        String redisKey = redisKey(storeKey);
        JedisUtil.del(redisKey);
    }

    /**
     * put
     *
     * @param storeKey
     * @param xxlUser
     */
    public static void put(String storeKey, SsoUser xxlUser, Boolean ifRemember) {
        String redisKey = redisKey(storeKey);
        JedisUtil.setObjectValue(redisKey, xxlUser, ifRemember ? redisExpireMinute * 60 : 1440 * 60);  // minute to second
    }

    private static String redisKey(String sessionId) {
        return Conf.SSO_SESSION_ID.concat("#").concat(sessionId);
    }

}
