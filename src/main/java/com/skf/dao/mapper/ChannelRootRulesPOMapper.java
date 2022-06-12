package com.skf.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.skf.dao.po.ChannelRootRulesPO;
import com.skf.vo.ChannelRootRulesVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author SSS
* @description 针对表【order_info(订单表 订单表)】的数据库操作Mapper
* @createDate 2021-12-24 18:10:34
* @Entity com.atguigu.gmall.order.domain.OrderInfo
*/
@Mapper
public interface ChannelRootRulesPOMapper extends BaseMapper<ChannelRootRulesPO> {



    List<ChannelRootRulesPO> queryChannelRootRulesPO(String version);

    void addChannelRootRulesPO(ChannelRootRulesVo channelRootRulesVo);

    void updateChannelRootRulesPO(ChannelRootRulesPO channelRootRulesPo);

    String queryLastVersion();

    void addChannelRootRulesPos(@Param("list") List<ChannelRootRulesPO> list, @Param("version") String version);

    void addNextVersionChannelRootRulesPO(@Param("channelRootRulesVo") ChannelRootRulesVo channelRootRulesVo, @Param("nextVersion") String nextVersion);

    List<String> queryVersion();

    List<ChannelRootRulesPO> rollBackVersion(String version);


    //List<ChannelRootRulesPO> queryLastVersionChannelRootRulesPO(String version);

}




