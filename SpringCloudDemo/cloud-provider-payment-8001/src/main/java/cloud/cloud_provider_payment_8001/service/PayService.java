package cloud.cloud_provider_payment_8001.service;

import cloud.cloud_provider_payment_8001.entities.Pay;

import java.util.List;

/**
 * 支付交易服务
 * <p>
 *
 * @since 2024/8/21
 */
public interface PayService {
    /**
     * 增加支付交易记录
     *
     * @param pay 一条交易记录
     * @return 1 添加成功，0 添加失败
     */
    int add(Pay pay);

    /**
     * 根据 id 删除交易记录
     *
     * @param id 表主键 id
     * @return 1 删除成功，0 删除失败
     */
    int delete(Integer id);

    /**
     * 更新交易记录
     *
     * @param pay 一条交易记录
     * @return 1 删除成功，0 删除失败
     */
    int update(Pay pay);

    /**
     * 根据 id 获取对应的交易记录
     *
     * @param id 主键 id
     * @return 交易记录信息
     */
    Pay getById(Integer id);

    /**
     * 获取所有的交易记录
     *
     * @return 所有的交易记录信息
     */
    List<Pay> getAll();
}
