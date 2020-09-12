package com.gaea.project.house.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gaea.framework.aspectj.lang.annotation.Excel;
import com.gaea.framework.web.domain.BaseEntity;

/**
 * 房东信息对象 house_landlord
 * 
 * @author gaea
 * @date 2020-09-12
 */
public class HouseLandlord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 房东 */
    @Excel(name = "房东")
    private String landlord;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 小区名字 */
    @Excel(name = "小区名字")
    private String community;

    /** 1 租房，2 卖方 */
    @Excel(name = "1 租房，2 卖方")
    private String status;

    /** 删除字段 0 未，1 删除 */
    private String delFlag;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLandlord(String landlord) 
    {
        this.landlord = landlord;
    }

    public String getLandlord() 
    {
        return landlord;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setCommunity(String community) 
    {
        this.community = community;
    }

    public String getCommunity() 
    {
        return community;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }
    public void setModifiedTime(Date modifiedTime) 
    {
        this.modifiedTime = modifiedTime;
    }

    public Date getModifiedTime() 
    {
        return modifiedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("landlord", getLandlord())
            .append("phone", getPhone())
            .append("address", getAddress())
            .append("community", getCommunity())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("creatTime", getCreatTime())
            .append("modifiedTime", getModifiedTime())
            .toString();
    }
}
