package renzhz.student.springcloud.alibaba.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * {Class 描述}
 * <p>
 * 2024/8/20
 */
@RestController
@RequestMapping("/nacos/bean")
public class BeanAutoRefreshConfigExample {
    @Autowired
    private NacosConfigInfo nacosConfigInfo;

    @GetMapping
    public Map<String, String> getConfigInfo() {
        HashMap<String, String> result = new HashMap<>();
        result.put("serverAddr", nacosConfigInfo.getServerAddr());
        result.put("prefix", nacosConfigInfo.getPrefix());
        result.put("group", nacosConfigInfo.getGroup());
        result.put("namespace", nacosConfigInfo.getNamespace());
        return result;
    }
}
