package com.imooc.wechatdemo.service;

import com.imooc.wechatdemo.pojo.Area;

import java.util.List;

public interface AreaService {
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
    boolean insertArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return
     */
    boolean updateArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
