/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.charles7c.cnadmin.common.util.helper;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.extra.servlet.ServletUtil;

import top.charles7c.cnadmin.common.consts.CacheConstants;
import top.charles7c.cnadmin.common.model.dto.LogContext;
import top.charles7c.cnadmin.common.model.dto.LoginUser;
import top.charles7c.cnadmin.common.util.ExceptionUtils;
import top.charles7c.cnadmin.common.util.IpUtils;
import top.charles7c.cnadmin.common.util.ServletUtils;
import top.charles7c.cnadmin.common.util.holder.LogContextHolder;

/**
 * 登录助手
 *
 * @author Charles7c
 * @since 2022/12/24 12:58
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginHelper {

    /**
     * 用户登录并缓存用户信息
     *
     * @param loginUser
     *            登录用户信息
     */
    public static void login(LoginUser loginUser) {
        if (loginUser == null) {
            return;
        }

        // 记录登录信息
        HttpServletRequest request = ServletUtils.getRequest();
        loginUser.setClientIp(ServletUtil.getClientIP(request));
        loginUser.setLocation(IpUtils.getCityInfo(loginUser.getClientIp()));
        loginUser.setBrowser(ServletUtils.getBrowser(request));
        LogContext logContext = LogContextHolder.get();
        loginUser.setLoginTime(logContext != null ? logContext.getCreateTime() : LocalDateTime.now());

        // 登录保存用户信息
        StpUtil.login(loginUser.getUserId());
        loginUser.setToken(StpUtil.getTokenValue());
        SaHolder.getStorage().set(CacheConstants.LOGIN_USER_CACHE_KEY, loginUser);
        StpUtil.getTokenSession().set(CacheConstants.LOGIN_USER_CACHE_KEY, loginUser);
    }

    /**
     * 获取登录用户信息
     *
     * @return /
     */
    public static LoginUser getLoginUser() {
        LoginUser loginUser = (LoginUser)SaHolder.getStorage().get(CacheConstants.LOGIN_USER_CACHE_KEY);
        if (loginUser != null) {
            return loginUser;
        }
        try {
            loginUser = (LoginUser)StpUtil.getTokenSession().get(CacheConstants.LOGIN_USER_CACHE_KEY);
            SaHolder.getStorage().set(CacheConstants.LOGIN_USER_CACHE_KEY, loginUser);
        } catch (Exception ignored) {
        }
        return loginUser;
    }

    /**
     * 更新登录用户信息
     *
     * @param loginUser
     *            登录用户信息
     */
    public static void updateLoginUser(LoginUser loginUser) {
        SaHolder.getStorage().set(CacheConstants.LOGIN_USER_CACHE_KEY, loginUser);
        StpUtil.getTokenSession().set(CacheConstants.LOGIN_USER_CACHE_KEY, loginUser);
    }

    /**
     * 获取登录用户 ID
     *
     * @return /
     */
    public static Long getUserId() {
        return ExceptionUtils.exToNull(() -> getLoginUser().getUserId());
    }

    /**
     * 获取登录用户名
     *
     * @return /
     */
    public static String getUsername() {
        return ExceptionUtils.exToNull(() -> getLoginUser().getUsername());
    }

    /**
     * 获取登录用户昵称
     *
     * @return /
     */
    public static String getNickname() {
        return ExceptionUtils.exToNull(() -> getLoginUser().getNickname());
    }
}
