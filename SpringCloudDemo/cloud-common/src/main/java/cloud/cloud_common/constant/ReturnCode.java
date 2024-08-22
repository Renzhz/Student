package cloud.cloud_common.constant;

import lombok.Getter;

import java.util.Arrays;

/**
 * 返回值
 * <p>
 *
 * @since 2024/8/21
 */
@Getter
public enum ReturnCode {
    FAIL("999", "操作 XXX 失败."),
    SUCCESS("200", "Success."),

    RC201("201", "服务开启降级保护."),
    RC202("202", "热点参数限流."),
    RC203("203", "系统规则不满足要求."),
    RC204("204", "授权规则不通过."),

    RC375("375", "数字运算异常."),

    RC401("401", "匿名用户访问无权限资源."),
    RC403("403", "无访问权限."),
    RC404("404", "资源找不到或者不存在."),

    RC500("500", "系统异常，请稍候重试或者联系管理员."),

    CLIENT_AUTHENTICATION_FAILED("1001", "客户端认证失败."),
    USERNAME_OR_PASSWORD_ERROR("1002", "用户名或密码错误."),
    UNSUPPORTED_GRANT_TYPE("1003", "不支持的认证模式."),
    BUSINESS_ERROR("1004", "业务逻辑异常."),
    INVALID_TOKEN("2001", "访问令牌无效."),
    ACCESS_DENIED("2003", "没有权限访问该资源。");

    /**
     * http 状态码
     */
    private final String code;

    /**
     * code 信息
     */
    private final String message;

    ReturnCode(String code, String describe) {
        this.code = code;
        this.message = describe;
    }

    public static ReturnCode getReturnCode(String code) {
        return Arrays.stream(ReturnCode.values()).filter(element -> code.equalsIgnoreCase(element.code)).findFirst().orElse(null);
    }
}