package com.xxl.sso.sample.controller;

import com.xxl.sso.core.conf.Conf;
import com.xxl.sso.core.entity.ReturnT;
import com.xxl.sso.core.user.SsoUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuxueli 2017-08-01 21:39:47
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public ReturnT<SsoUser> index(HttpServletRequest request) {
        SsoUser xxlUser = (SsoUser) request.getAttribute(Conf.SSO_USER);
        return new ReturnT<SsoUser>(xxlUser);
    }

    @RequestMapping("/open")
    @ResponseBody
    public ReturnT<SsoUser> open(HttpServletRequest request) {
        SsoUser xxlUser = (SsoUser) request.getAttribute(Conf.SSO_USER);
        return new ReturnT<SsoUser>(xxlUser);
    }

    @RequestMapping("/common/1")
    @ResponseBody
    public ReturnT<SsoUser> common(HttpServletRequest request) {
        SsoUser xxlUser = (SsoUser) request.getAttribute(Conf.SSO_USER);
        return new ReturnT<SsoUser>(xxlUser);
    }

}