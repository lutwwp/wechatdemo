package com.imooc.wechatdemo.dao;

import com.imooc.wechatdemo.pojo.Area;

import java.util.List;
/**
 * author wwp
 * date 2018/2/13 16:51
 */
public interface AreaDao {
    /**
     * 区域列表
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据id查询区域
     * @param AreaId
     * @return
     */
    Area queryAreaById(int AreaId);

    /**
     * 插入区域信息
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);

}
