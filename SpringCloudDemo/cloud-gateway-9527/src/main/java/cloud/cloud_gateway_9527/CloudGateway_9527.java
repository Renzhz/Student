package cloud.cloud_gateway_9527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * cloud-gateway-9527 模块主启动类
 *
 * @since 2024/8/27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudGateway_9527 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateway_9527.class);
    }
}
