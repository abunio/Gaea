package com.gaea.project.house.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gaea.framework.aspectj.lang.annotation.Log;
import com.gaea.framework.aspectj.lang.enums.BusinessType;
import com.gaea.project.house.domain.HouseLandlord;
import com.gaea.project.house.service.IHouseLandlordService;
import com.gaea.framework.web.controller.BaseController;
import com.gaea.framework.web.domain.AjaxResult;
import com.gaea.common.utils.poi.ExcelUtil;
import com.gaea.framework.web.page.TableDataInfo;

/**
 * 房东信息Controller
 * 
 * @author gaea
 * @date 2020-09-12
 */
@RestController
@RequestMapping("/house/landlord")
public class HouseLandlordController extends BaseController
{
    @Autowired
    private IHouseLandlordService houseLandlordService;

    /**
     * 查询房东信息列表
     */
    //@PreAuthorize("@ss.hasPermi('house:landlord:list')")
    @GetMapping("/list")
    public TableDataInfo list(HouseLandlord houseLandlord)
    {
        startPage();
        List<HouseLandlord> list = houseLandlordService.selectHouseLandlordList(houseLandlord);
        return getDataTable(list);
    }

    /**
     * 导出房东信息列表
     */
    @PreAuthorize("@ss.hasPermi('house:landlord:export')")
    @Log(title = "房东信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HouseLandlord houseLandlord)
    {
        List<HouseLandlord> list = houseLandlordService.selectHouseLandlordList(houseLandlord);
        ExcelUtil<HouseLandlord> util = new ExcelUtil<HouseLandlord>(HouseLandlord.class);
        return util.exportExcel(list, "landlord");
    }

    /**
     * 获取房东信息详细信息
     */
    //@PreAuthorize("@ss.hasPermi('house:landlord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(houseLandlordService.selectHouseLandlordById(id));
    }

    /**
     * 新增房东信息
     */
    //@PreAuthorize("@ss.hasPermi('house:landlord:add')")
    @Log(title = "房东信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HouseLandlord houseLandlord)
    {
        return toAjax(houseLandlordService.insertHouseLandlord(houseLandlord));
    }

    /**
     * 修改房东信息
     */
    //@PreAuthorize("@ss.hasPermi('house:landlord:edit')")
    @Log(title = "房东信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HouseLandlord houseLandlord)
    {
        return toAjax(houseLandlordService.updateHouseLandlord(houseLandlord));
    }

    /**
     * 删除房东信息
     */
    @PreAuthorize("@ss.hasPermi('house:landlord:remove')")
    @Log(title = "房东信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(houseLandlordService.deleteHouseLandlordByIds(ids));
    }
}
