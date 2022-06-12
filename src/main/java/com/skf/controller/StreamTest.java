package com.skf.controller;

import com.skf.dao.po.ChannelRootRulesPO;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/06/11
 */
public class StreamTest {

    public static void main(String[] args) {

        // raw
        ChannelRootRulesPO channelRootRulesPO1 = new ChannelRootRulesPO();
        channelRootRulesPO1.setTid(1);
        channelRootRulesPO1.setUsername("zs");
        channelRootRulesPO1.setPassword("zs");

        ChannelRootRulesPO channelRootRulesPO2 = new ChannelRootRulesPO();
        channelRootRulesPO2.setTid(2);
        channelRootRulesPO2.setUsername("ls");
        channelRootRulesPO2.setPassword("ls");

        ChannelRootRulesPO channelRootRulesPO3 = new ChannelRootRulesPO();
        channelRootRulesPO3.setTid(3);
        channelRootRulesPO3.setUsername("wh");
        channelRootRulesPO3.setPassword("wh");

        // update
        ChannelRootRulesPO channelRootRulesPO4 = new ChannelRootRulesPO();
        channelRootRulesPO4.setTid(1);
        channelRootRulesPO4.setUsername("zl");
        channelRootRulesPO4.setPassword("zl");

        ChannelRootRulesPO channelRootRulesPO5 = new ChannelRootRulesPO();
        channelRootRulesPO5.setTid(2);
        channelRootRulesPO5.setUsername("tq");
        channelRootRulesPO5.setPassword("tq");

        List<ChannelRootRulesPO> list1 = new ArrayList<>();
        list1.add(channelRootRulesPO1);
        list1.add(channelRootRulesPO2);
        list1.add(channelRootRulesPO3);
        List<ChannelRootRulesPO> list2 = new ArrayList<>();
        list2.add(channelRootRulesPO4);
        list2.add(channelRootRulesPO5);

        for (int i = 0; i < list1.size(); i++) {
            for (ChannelRootRulesPO channelRootRulesPO : list2) {
                if (list1.get(i).getTid().equals(channelRootRulesPO.getTid())) {
                    list1.set(i, channelRootRulesPO);
                }
            }
        }
        for (ChannelRootRulesPO channelRootRulesPO : list1) {
            System.out.println(channelRootRulesPO);
        }
    }
}
