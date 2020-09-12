package com.gaea.project.house.mapper;

import java.util.List;
import com.gaea.project.house.domain.HouseClientele;

/**
 * 客户信息Mapper接口
 * 
 * @author gaea
 * @date 2020-09-12
 */
public interface HouseClienteleMapper 
{
    /**
     * 查询客户信息
     * 
     * @param id 客户信息ID
     * @return 客户信息
     */
    public HouseClientele selectHouseClienteleById(Long id);

    /**
     * 查询客户信息列表
     * 
     * @param houseClientele 客户信息
     * @return 客户信息集合
     */
    public List<HouseClientele> selectHouseClienteleList(HouseClientele houseClientele);

    /**
     * 新增客户信息
     * 
     * @param houseClientele 客户信息
     * @return 结果
     */
    public int insertHouseClientele(HouseClientele houseClientele);

    /**
     * 修改客户信息
     * 
     * @param houseClientele 客户信息
     * @return 结果
     */
    public int updateHouseClientele(HouseClientele houseClientele);

    /**
     * 删除客户信息
     * 
     * @param id 客户信息ID
     * @return 结果
     */
    public int deleteHouseClienteleById(Long id);

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHouseClienteleByIds(Long[] ids);
}
