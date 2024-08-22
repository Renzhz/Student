package cloud.cloud_common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 支付交易表 可对外暴露的字段
 * <p>
 * @since 2024/8/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO implements Serializable {
    private Integer id;
    /**
     * 支付流水号
     */
    private String payNo;

    /**
     * 订单流水号
     */
    private String orderNo;

    /**
     * 用户账号 ID
     */
    private Integer userId;

    /**
     * 交易金额
     */
    private BigDecimal amount;
}
