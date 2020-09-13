package com.gaea.project.house.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaea.project.house.mapper.HouseClienteleMapper;
import com.gaea.project.house.domain.HouseClientele;
import com.gaea.project.house.service.IHouseClienteleService;

/**
 * 客户信息Service业务层处理
 * 
 * @author gaea
 * @date 2020-09-12
 */
@Service
public class HouseClienteleServiceImpl implements IHouseClienteleService 
{
    @Autowired
    private HouseClienteleMapper houseClienteleMapper;

    /**
     * 查询客户信息
     * 
     * @param id 客户信息ID
     * @return 客户信息
     */
    @Override
    public HouseClientele selectHouseClienteleById(Long id)
    {
        return houseClienteleMapper.selectHouseClienteleById(id);
    }

    /**
     * 查询客户信息列表
     * 
     * @param houseClientele 客户信息
     * @return 客户信息
     */
    @Override
    public List<HouseClientele> selectHouseClienteleList(HouseClientele houseClientele)
    {
        return houseClienteleMapper.selectHouseClienteleList(houseClientele);
    }

    /**
     * 新增客户信息
     * 
     * @param houseClientele 客户信息
     * @return 结果
     */
    @Override
    public int insertHouseClientele(HouseClientele houseClientele)
    {
        houseClientele.setCreatTime(new Date());
        houseClientele.setModifiedTime(new Date());
        return houseClienteleMapper.insertHouseClientele(houseClientele);
    }

    /**
     * 修改客户信息
     * 
     * @param houseClientele 客户信息
     * @return 结果
     */
    @Override
    public int updateHouseClientele(HouseClientele houseClientele)
    {
        houseClientele.setModifiedTime(new Date());
        return houseClienteleMapper.updateHouseClientele(houseClientele);
    }

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的客户信息ID
     * @return 结果
     */
    @Override
    public int deleteHouseClienteleByIds(Long[] ids)
    {
        return houseClienteleMapper.deleteHouseClienteleByIds(ids);
    }

    /**
     * 删除客户信息信息
     * 
     * @param id 客户信息ID
     * @return 结果
     */
    @Override
    public int deleteHouseClienteleById(Long id)
    {
        return houseClienteleMapper.deleteHouseClienteleById(id);
    }
}
