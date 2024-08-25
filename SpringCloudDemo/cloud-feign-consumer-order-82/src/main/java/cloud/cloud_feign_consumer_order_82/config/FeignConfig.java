package cloud.cloud_feign_consumer_order_82.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenFeign 配置
 *
 * @since 2024/8/25
 */
@Configuration
public class FeignConfig {
    /**
     * 设置重试策略
     *
     * @return 重试策略
     */
    @Bean
    public Retryer customRetryer() {
        return Retryer.NEVER_RETRY; // Feign 默认配置不使用重试策略
//        return new Retryer.Default(100, 1, 3); // 初始间隔时间为 100 ms，重试间最大间隔时间为 1 s，最大请求次数为 3 = 1 (default) + 2
    }

    /**
     * 设置 OpenFeign 日志级别
     * @return OpenFeign 日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
