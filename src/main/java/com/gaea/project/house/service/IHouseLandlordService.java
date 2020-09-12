package com.gaea.project.house.service;

import java.util.List;
import com.gaea.project.house.domain.HouseLandlord;

/**
 * 房东信息Service接口
 * 
 * @author gaea
 * @date 2020-09-12
 */
public interface IHouseLandlordService 
{
    /**
     * 查询房东信息
     * 
     * @param id 房东信息ID
     * @return 房东信息
     */
    public HouseLandlord selectHouseLandlordById(Long id);

    /**
     * 查询房东信息列表
     * 
     * @param houseLandlord 房东信息
     * @return 房东信息集合
     */
    public List<HouseLandlord> selectHouseLandlordList(HouseLandlord houseLandlord);

    /**
     * 新增房东信息
     * 
     * @param houseLandlord 房东信息
     * @return 结果
     */
    public int insertHouseLandlord(HouseLandlord houseLandlord);

    /**
     * 修改房东信息
     * 
     * @param houseLandlord 房东信息
     * @return 结果
     */
    public int updateHouseLandlord(HouseLandlord houseLandlord);

    /**
     * 批量删除房东信息
     * 
     * @param ids 需要删除的房东信息ID
     * @return 结果
     */
    public int deleteHouseLandlordByIds(Long[] ids);

    /**
     * 删除房东信息信息
     * 
     * @param id 房东信息ID
     * @return 结果
     */
    public int deleteHouseLandlordById(Long id);
}
