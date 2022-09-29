package com.xxl.sso.core.login;

import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.store.SsoLoginStore;
import com.xxl.sso.core.user.SsoUser;
import com.xxl.sso.core.store.SsoSessionIdHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuxueli 2018-11-15 15:54:40
 */
public class SsoTokenLoginHelper {

    /**
     * client login
     *
     * @param sessionId
     * @param xxlUser
     */
    public static void login(String sessionId, SsoUser xxlUser,Boolean ifRemember) {

        String storeKey = SsoSessionIdHelper.parseStoreKey(sessionId);
        if (storeKey == null) {
            throw new RuntimeException("parseStoreKey Fail, sessionId:" + sessionId);
        }

        SsoLoginStore.put(sessionId, xxlUser,ifRemember);
    }

    /**
     * client logout
     *
     * @param sessionId
     */
    public static void logout(String sessionId) {

        String storeKey = SsoSessionIdHelper.parseStoreKey(sessionId);
        if (storeKey == null) {
            return;
        }

        SsoLoginStore.remove(sessionId);
    }
    /**
     * client logout
     *
     * @param request
     */
    public static void logout(HttpServletRequest request) {
        String headerSessionId = request.getHeader(Conf.SSO_SESSION_ID);
        logout(headerSessionId);
    }


    /**
     * login check
     *
     * @param sessionId
     * @return
     */
    public static SsoUser loginCheck(String  sessionId){

        String storeKey = SsoSessionIdHelper.parseStoreKey(sessionId);
        if (storeKey == null) {
            return null;
        }
        //        if (xxlUser != null) {
//            String version = SsoSessionIdHelper.parseVersion(sessionId);
//            if (xxlUser.getVersion().equals(version)) {
//
//                // After the expiration time has passed half, Auto refresh
//                if ((System.currentTimeMillis() - xxlUser.getExpireFreshTime()) > xxlUser.getExpireMinute()/2) {
//                    xxlUser.setExpireFreshTime(System.currentTimeMillis());
//                    SsoLoginStore.put(storeKey, xxlUser);
//                }
//
//                return xxlUser;
//            }
//        }
        return SsoLoginStore.get(sessionId);
    }


    /**
     * login check
     *
     * @param request
     * @return
     */
    public static SsoUser loginCheck(HttpServletRequest request){
        String headerSessionId = request.getHeader(Conf.SSO_SESSION_ID);
        return loginCheck(headerSessionId);
    }


}
