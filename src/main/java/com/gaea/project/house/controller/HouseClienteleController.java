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
import com.gaea.project.house.domain.HouseClientele;
import com.gaea.project.house.service.IHouseClienteleService;
import com.gaea.framework.web.controller.BaseController;
import com.gaea.framework.web.domain.AjaxResult;
import com.gaea.common.utils.poi.ExcelUtil;
import com.gaea.framework.web.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author gaea
 * @date 2020-09-12
 */
@RestController
@RequestMapping("/house/clientele")
public class HouseClienteleController extends BaseController
{
    @Autowired
    private IHouseClienteleService houseClienteleService;

    /**
     * 查询客户信息列表
     */
    //@PreAuthorize("@ss.hasPermi('house:clientele:list')")
    @GetMapping("/list")
    public TableDataInfo list(HouseClientele houseClientele)
    {
        startPage();
        List<HouseClientele> list = houseClienteleService.selectHouseClienteleList(houseClientele);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('house:clientele:export')")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HouseClientele houseClientele)
    {
        List<HouseClientele> list = houseClienteleService.selectHouseClienteleList(houseClientele);
        ExcelUtil<HouseClientele> util = new ExcelUtil<HouseClientele>(HouseClientele.class);
        return util.exportExcel(list, "clientele");
    }

    /**
     * 获取客户信息详细信息
     */
    //@PreAuthorize("@ss.hasPermi('house:clientele:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(houseClienteleService.selectHouseClienteleById(id));
    }

    /**
     * 新增客户信息
     */
    //@PreAuthorize("@ss.hasPermi('house:clientele:add')")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HouseClientele houseClientele)
    {
        return toAjax(houseClienteleService.insertHouseClientele(houseClientele));
    }

    /**
     * 修改客户信息
     */
    //@PreAuthorize("@ss.hasPermi('house:clientele:edit')")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HouseClientele houseClientele)
    {
        return toAjax(houseClienteleService.updateHouseClientele(houseClientele));
    }

    /**
     * 删除客户信息
     */
    @PreAuthorize("@ss.hasPermi('house:clientele:remove')")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(houseClienteleService.deleteHouseClienteleByIds(ids));
    }
}
