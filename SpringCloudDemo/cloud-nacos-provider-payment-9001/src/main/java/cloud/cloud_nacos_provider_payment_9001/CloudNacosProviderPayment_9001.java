package cloud.cloud_nacos_provider_payment_9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * cloud-nacos-provider-payment-9001 模块主启动类
 *
 * @since 2024/8/23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudNacosProviderPayment_9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudNacosProviderPayment_9001.class);
    }
}
