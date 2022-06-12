package com.skf.controller;

import com.skf.dao.po.ChannelRootRulesPO;
import com.skf.service.ChannelRootRulesPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/06/11
 */
@RestController
@RequestMapping("/v1")
public class RoleBackController {

    @Autowired
    private ChannelRootRulesPOService channelRootRulesPOService;

    @GetMapping("/query/version")
    public List<String> queryVersion() {

        return channelRootRulesPOService.queryVersion();
    }


    @GetMapping("/backup/version")
    public List<ChannelRootRulesPO> rollBackVersion(@RequestParam(name = "version", required = false) String version) {
        return channelRootRulesPOService.rollBackVersion(version);
    }



}
