package com.ratel.modules.tools.domain;

import lombok.Data;
import com.ratel.framework.core.domain.BaseNativeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * 支付宝配置类
 */
@Data
@Entity
@Table(name = "alipay_config")
public class AlipayConfig extends BaseNativeEntity {

    /**
     * 应用ID,APPID，收款账号既是APPID对应支付宝账号
     */
    @NotBlank
    @Column(name = "app_id")
    private String appId;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    @NotBlank
    @Column(name = "private_key", columnDefinition = "TEXT COMMENT '商户私钥'")
    private String privateKey;

    /**
     * 支付宝公钥
     */
    @NotBlank
    @Column(name = "public_key", columnDefinition = "text")
    private String publicKey;

    /**
     * 签名方式，固定格式
     */
    @Column(name = "sign_type")
    private String signType = "RSA2";

    /**
     * 支付宝开放安全地址，一般不会变
     */
    @Column(name = "gateway_url")
    private String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 编码，固定格式
     */
    private String charset = "utf-8";

    /**
     * 异步通知地址
     */
    @NotBlank
    @Column(name = "notify_url")
    private String notifyUrl;

    /**
     * 订单完成后返回的页面
     */
    @NotBlank
    @Column(name = "return_url")
    private String returnUrl;

    /**
     * 类型，固定格式
     */
    private String format = "JSON";

    /**
     * 商户号
     */
    @NotBlank
    @Column(name = "sys_service_provider_id")
    private String sysServiceProviderId;

}
