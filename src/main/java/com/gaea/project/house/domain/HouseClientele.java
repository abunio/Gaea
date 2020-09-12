package com.gaea.project.house.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gaea.framework.aspectj.lang.annotation.Excel;
import com.gaea.framework.web.domain.BaseEntity;

/**
 * 客户信息对象 house_clientele
 * 
 * @author gaea
 * @date 2020-09-12
 */
public class HouseClientele extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 客户 */
    @Excel(name = "客户")
    private String clientele;

    /** 手机 */
    @Excel(name = "手机")
    private String phone;

    /** 住址 */
    @Excel(name = "住址")
    private String address;

    /** 意向 */
    @Excel(name = "意向")
    private String intention;

    /** 1 租房，2 买房 */
    @Excel(name = "1 租房，2 买房")
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
    public void setClientele(String clientele) 
    {
        this.clientele = clientele;
    }

    public String getClientele() 
    {
        return clientele;
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
    public void setIntention(String intention) 
    {
        this.intention = intention;
    }

    public String getIntention() 
    {
        return intention;
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
            .append("clientele", getClientele())
            .append("phone", getPhone())
            .append("address", getAddress())
            .append("intention", getIntention())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("creatTime", getCreatTime())
            .append("modifiedTime", getModifiedTime())
            .toString();
    }
}
