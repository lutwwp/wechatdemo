package com.imooc.wechatdemo.dao;

import com.imooc.wechatdemo.pojo.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryArea() throws Exception {
        List<Area> areas = areaDao.queryArea();
        assertEquals(2,areas.size());
    }

    @Test
    public void queryAreaById() throws Exception {
        Area area = areaDao.queryAreaById(2);
        assertEquals("北苑",area.getAreaName());
    }

    @Test
    public void insertArea() throws Exception {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int effectNum = areaDao.insertArea(area);
        assertEquals(1,effectNum);
    }

    @Test
    public void updateArea() throws Exception {
        Area area = areaDao.queryAreaById(2);
        area.setAreaName("北苑");
        int effectNum = areaDao.updateArea(area);
        assertEquals(1,effectNum);
    }

    @Test
    public void deleteArea() throws Exception {
        Area area = areaDao.queryAreaById(2);
        int effectNum = areaDao.deleteArea(area.getAreaId());
        assertEquals(1,effectNum);
    }

}