package com.skf.service;

import com.skf.dao.po.ChannelRootRulesPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/06/11
 */
@Service
public class BackupService {
    public static final String versionFlag = "V";

    @Autowired
    private ChannelRootRulesPOService channelRootRulesPOService;

    public String backupAdd(String currentVersion) {
        if (currentVersion == null) {
            currentVersion = "V0";
        }
        String nextVersion = versionFlag + (Integer.parseInt(currentVersion.substring(1)) + 1);
        List<ChannelRootRulesPO> list =
                channelRootRulesPOService.queryChannelRootRulesPO();

        channelRootRulesPOService.backupOldVersion(list, nextVersion);
        return nextVersion;
    }


    public String backupUpdate(String currentVersion,List<ChannelRootRulesPO> needUpdateChannelRootRulesPoList) {
        if (currentVersion == null) {
            currentVersion = "V0";
        }
        String nextVersion = versionFlag + (Integer.parseInt(currentVersion.substring(1)) + 1);
        List<ChannelRootRulesPO> rawChannelRootRulesPoList =
                channelRootRulesPOService.queryChannelRootRulesPO();

        for (int i = 0; i < rawChannelRootRulesPoList.size(); i++) {
            for (ChannelRootRulesPO channelRootRulesPO : needUpdateChannelRootRulesPoList) {
                if (Objects.equals(rawChannelRootRulesPoList.get(i).getTid(), channelRootRulesPO.getTid())) {
                    rawChannelRootRulesPoList.set(i, channelRootRulesPO);
                }
            }
        }
        channelRootRulesPOService.backupOldVersion(rawChannelRootRulesPoList, nextVersion);
        return nextVersion;
    }
}
