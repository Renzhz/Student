package cloud.entities;

import cloud.constant.ReturnCode;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 统一处理后的结果数据
 *
 * @since 2024/8/21
 */
@Data
@Accessors(chain = true)
public class ResultDate<T> {
    /**
     * 结果码
     * <p>
     * 具体参见枚举类 {@link  ReturnCode}
     */
    private String code;

    /**
     * 错误码相关信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 时间戳
     */
    private long timestamp;

    public ResultDate() {
        timestamp = System.currentTimeMillis();
    }

    public static <T> ResultDate<T> success(T data) {
        ResultDate<T> resultDate = new ResultDate<>();
        resultDate.setCode(ReturnCode.SUCCESS.getCode());
        resultDate.setMessage(ReturnCode.SUCCESS.getMessage());
        resultDate.setData(data);
        return resultDate;
    }

    public static <T> ResultDate<T> fail(String code, String message) {
        ResultDate<T> resultDate = new ResultDate<>();
        resultDate.setCode(code);
        resultDate.setMessage(message);
        return resultDate;
    }
}
