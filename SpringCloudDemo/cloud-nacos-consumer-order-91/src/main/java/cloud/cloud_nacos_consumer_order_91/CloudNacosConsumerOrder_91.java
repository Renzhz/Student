package cloud.cloud_nacos_consumer_order_91;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * cloud-nacos-consumer-order-92 主启动类
 *
 * @since 2024/8/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosConsumerOrder_91 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosConsumerOrder_91.class, args);
    }
}
