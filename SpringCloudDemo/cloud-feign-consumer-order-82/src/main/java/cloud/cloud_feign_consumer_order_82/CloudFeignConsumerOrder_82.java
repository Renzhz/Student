package cloud.cloud_feign_consumer_order_82;

import cloud.cloud_common.apis.NacosFeignApi;
import cloud.cloud_common.apis.PayFeignApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * cloud-feign-consumer-order-82 模块主启动类
 *
 * @since 2024/8/24
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = {NacosFeignApi.class, PayFeignApi.class})
// 启用 feign 客户端,定义服务+绑定接口，以声明式的方法优雅而简单的实现服务调用
public class CloudFeignConsumerOrder_82 {
    public static void main(String[] args) {
        SpringApplication.run(CloudFeignConsumerOrder_82.class);
    }
}
