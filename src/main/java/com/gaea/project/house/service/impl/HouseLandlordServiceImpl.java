package com.gaea.project.house.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaea.project.house.mapper.HouseLandlordMapper;
import com.gaea.project.house.domain.HouseLandlord;
import com.gaea.project.house.service.IHouseLandlordService;

/**
 * 房东信息Service业务层处理
 * 
 * @author gaea
 * @date 2020-09-12
 */
@Service
public class HouseLandlordServiceImpl implements IHouseLandlordService 
{
    @Autowired
    private HouseLandlordMapper houseLandlordMapper;

    /**
     * 查询房东信息
     * 
     * @param id 房东信息ID
     * @return 房东信息
     */
    @Override
    public HouseLandlord selectHouseLandlordById(Long id)
    {
        return houseLandlordMapper.selectHouseLandlordById(id);
    }

    /**
     * 查询房东信息列表
     * 
     * @param houseLandlord 房东信息
     * @return 房东信息
     */
    @Override
    public List<HouseLandlord> selectHouseLandlordList(HouseLandlord houseLandlord)
    {
        return houseLandlordMapper.selectHouseLandlordList(houseLandlord);
    }

    /**
     * 新增房东信息
     * 
     * @param houseLandlord 房东信息
     * @return 结果
     */
    @Override
    public int insertHouseLandlord(HouseLandlord houseLandlord)
    {
        houseLandlord.setCreatTime(new Date());
        houseLandlord.setModifiedTime(new Date());
        return houseLandlordMapper.insertHouseLandlord(houseLandlord);
    }

    /**
     * 修改房东信息
     * 
     * @param houseLandlord 房东信息
     * @return 结果
     */
    @Override
    public int updateHouseLandlord(HouseLandlord houseLandlord)
    {
        houseLandlord.setModifiedTime(new Date());
        return houseLandlordMapper.updateHouseLandlord(houseLandlord);
    }

    /**
     * 批量删除房东信息
     * 
     * @param ids 需要删除的房东信息ID
     * @return 结果
     */
    @Override
    public int deleteHouseLandlordByIds(Long[] ids)
    {
        return houseLandlordMapper.deleteHouseLandlordByIds(ids);
    }

    /**
     * 删除房东信息信息
     * 
     * @param id 房东信息ID
     * @return 结果
     */
    @Override
    public int deleteHouseLandlordById(Long id)
    {
        return houseLandlordMapper.deleteHouseLandlordById(id);
    }
}
