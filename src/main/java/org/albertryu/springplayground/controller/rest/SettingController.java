package org.albertryu.springplayground.controller.rest;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.albertryu.springplayground.common.util.LogUtils;
import org.albertryu.springplayground.common.vo.HttpResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/setting")
public class SettingController {

    @GetMapping("/priority")
    public HttpResult getPriorityMap() {
        System.out.println(System.getProperty("prop1"));

        HttpResult<Map<String, String[]>> rs = new HttpResult<>(null);
        log.info(LogUtils.buildClassTag(this) + "getPriorityMap rs={}", rs);
        return rs;
    }

    @PostMapping("/priority")
    public HttpResult updatePriorityMap(@RequestBody Map<String, String[]> priorityMap) {
        HttpResult<Map<String, String[]>> rs = new HttpResult<>(priorityMap);
        log.info(LogUtils.buildClassTag(this) + "getPriorityMap priorityMap={}, rs={}", priorityMap, rs);
        return rs;
    }

}
