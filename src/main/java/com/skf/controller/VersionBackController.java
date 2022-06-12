package com.skf.controller;

import com.skf.dao.po.ChannelRootRulesPO;
import com.skf.service.ChannelRootRulesPOService;
import com.skf.vo.ChannelRootRulesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/06/11
 */
@RequestMapping("/v1")
@RestController
public class VersionBackController {

    @Autowired
    private ChannelRootRulesPOService channelRootRulesPOService;


    @GetMapping("/query/rules")
    public List<ChannelRootRulesPO> queryChannelRootRulesPO() {

        return channelRootRulesPOService.queryChannelRootRulesPO();
    }


    @PostMapping("/add/rules")
    public void addChannelRootRulesPO(@RequestBody ChannelRootRulesVo channelRootRulesVo) {
        channelRootRulesPOService.addChannelRootRulesPO(channelRootRulesVo);
    }


    @PostMapping("/update/rules")
    public void updateChannelRootRulesPO(@RequestBody List<ChannelRootRulesPO> channelRootRulesVoList) {

        channelRootRulesPOService.updateChannelRootRulesPO(channelRootRulesVoList);
    }

}
