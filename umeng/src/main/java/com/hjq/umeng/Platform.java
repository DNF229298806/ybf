package com.hjq.umeng;

import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/AndroidProject
 *    time   : 2019/04/03
 *    desc   : 友盟平台
 */
public enum Platform {

    // 微信
    WEIXIN(SHARE_MEDIA.WEIXIN, "com.tencent.mm","微信"),
    // 微信朋友圈
    CIRCLE(SHARE_MEDIA.WEIXIN_CIRCLE, "com.tencent.mm","微信朋友圈"),

    // QQ
    QQ(SHARE_MEDIA.QQ, "com.tencent.mobileqq","QQ"),
    // QQ 空间
    QZONE(SHARE_MEDIA.QZONE, "com.tencent.mobileqq","QQ空间"),

    // 新浪
    SINA(SHARE_MEDIA.SINA, "com.sina.weibo","新浪");

    private SHARE_MEDIA mThirdParty; // 第三方平台
    private String mPackageName; // 第三方包名
    private String appName;

    Platform(SHARE_MEDIA thirdParty, String packageName,String appName) {
        mThirdParty = thirdParty;
        mPackageName = packageName;
        this.appName = appName;
    }

    SHARE_MEDIA getThirdParty() {
        return mThirdParty;
    }

    String getPackageName() {
        return mPackageName;
    }

    public String getAppName() {
        return appName;
    }}