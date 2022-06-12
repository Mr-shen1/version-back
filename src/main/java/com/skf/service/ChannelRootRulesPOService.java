package com.skf.service;

import com.skf.dao.mapper.ChannelRootRulesPOMapper;
import com.skf.dao.po.ChannelRootRulesPO;
import com.skf.vo.ChannelRootRulesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/06/11
 */
@Service
public class ChannelRootRulesPOService {

    @Autowired
    private BackupService backupService;

    @Autowired
    private ChannelRootRulesPOMapper channelRootRulesPOMapper;


    public List<ChannelRootRulesPO> queryChannelRootRulesPO() {
        // 查出最新的版本
        String version = queryLastVersion();
        //if (version == null) {
        return channelRootRulesPOMapper.queryChannelRootRulesPO(version);
        //} else {
        //    return channelRootRulesPOMapper.queryLastVersionChannelRootRulesPO(version);
        //}

    }

    public void addChannelRootRulesPO(ChannelRootRulesVo channelRootRulesVo) {
        String currentVersion = queryLastVersion();
        String nextVersion = backupService.backupAdd(currentVersion);
        channelRootRulesPOMapper.addNextVersionChannelRootRulesPO(channelRootRulesVo, nextVersion);

    }

    public void updateChannelRootRulesPO(List<ChannelRootRulesPO> channelRootRulesPoList) {
        String version = queryLastVersion();
        backupService.backupUpdate(version, channelRootRulesPoList);
        //for (ChannelRootRulesPO channelRootRulesPo : channelRootRulesPoList) {
        //    channelRootRulesPOMapper.updateChannelRootRulesPO(channelRootRulesPo);
        //}
    }
    public String queryLastVersion() {
        return channelRootRulesPOMapper.queryLastVersion();
    }

    public void backupOldVersion(List<ChannelRootRulesPO> list, String version) {
        channelRootRulesPOMapper.addChannelRootRulesPos(list, version);
    }

    public List<String> queryVersion() {
        return channelRootRulesPOMapper.queryVersion();
    }

    public List<ChannelRootRulesPO> rollBackVersion(String version) {

        return channelRootRulesPOMapper.rollBackVersion(version);
    }
}
