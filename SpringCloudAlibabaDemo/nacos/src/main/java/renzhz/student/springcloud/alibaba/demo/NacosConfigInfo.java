package renzhz.student.springcloud.alibaba.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * {Class 描述}
 * <p>
 * 2024/8/20
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.cloud.nacos")
@Component
public class NacosConfigInfo {
    /**
     * Nacos server address.
     */
    private String serverAddr;

    /**
     * Data Id prefix.
     */
    private String prefix;

    /**
     * Nacos group.
     */
    private String group;

    /**
     * Nacos namespace.
     */
    private String namespace;
}
