package com.imooc.wechatdemo.service.impl;

import com.imooc.wechatdemo.dao.AreaDao;
import com.imooc.wechatdemo.pojo.Area;
import com.imooc.wechatdemo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**      
 * author wwp  
 * date 2018/2/14 16:58
 */ 

@Service
public class AreaServiceImpl implements AreaService {
    
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int AreaId) {
        return areaDao.queryAreaById(AreaId);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
        //出现异常会回滚事务
        if (area.getAreaName() != null && "".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectNum = areaDao.insertArea(area);
                if (effectNum>0){
                    return true;
                }else {
                    throw new RuntimeException("插入信息失败");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("插入信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Transactional
    @Override
    public boolean updateArea(Area area) {
        //出现异常会回滚事务
        if (area.getAreaId() != null && area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try {
                int effectNum = areaDao.updateArea(area);
                if (effectNum>0){
                    return true;
                }else {
                    throw new RuntimeException("更新信息失败");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("更新信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Transactional
    @Override
    public boolean deleteArea(int areaId) {
        //出现异常会回滚事务
        if (areaId>0){
            try {
                int effectNum = areaDao.deleteArea(areaId);
                if (effectNum>0){
                    return true;
                }else {
                    throw new RuntimeException("删除信息失败");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("删除信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }
}
