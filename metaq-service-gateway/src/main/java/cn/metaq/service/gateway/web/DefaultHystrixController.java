package cn.metaq.service.gateway.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认降级处理
 */
@RestController
public class DefaultHystrixController {

    private static final Logger logger = LogManager.getLogger(DefaultHystrixController.class);

    @GetMapping("/default/fallback")
    public Map<String, Object> defaultFallback() {
        logger.info("降级操作...");
        Map<String, Object> map = new HashMap<>();
        map.put("statusCode", 500);
        map.put("message", "服务异常,触发熔断");

        return map;
    }
}