package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.Factor;
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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.FactorCategory;
import com.ruoyi.system.service.IFactorCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 因子类别Controller
 *
 * @author shang
 * @date 2022-01-12
 */
@RestController
@RequestMapping("/system/category")
public class FactorCategoryController extends BaseController
{
    @Autowired
    private IFactorCategoryService factorCategoryService;

    /**
     * 查询因子类别列表
     */
    @PreAuthorize("@ss.hasPermi('system:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(FactorCategory factorCategory)
    {
        startPage();
        List<FactorCategory> list = factorCategoryService.selectFactorCategoryList(factorCategory);
        return getDataTable(list);
    }

    /**
     * 查询因子列表
     */
//    @PreAuthorize("@ss.hasPermi('system:category:list')")
    @GetMapping("/listFactor")
    public TableDataInfo listFactor(FactorCategory factorCategory)
    {
        List<Factor> list = factorCategoryService.selectFactorList(factorCategory);
        return getDataTable(list);
    }

    /**
     * 导出因子类别列表
     */
    @PreAuthorize("@ss.hasPermi('system:category:export')")
    @Log(title = "因子类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FactorCategory factorCategory)
    {
        List<FactorCategory> list = factorCategoryService.selectFactorCategoryList(factorCategory);
        ExcelUtil<FactorCategory> util = new ExcelUtil<FactorCategory>(FactorCategory.class);
        util.exportExcel(response, list, "因子类别数据");
    }

    /**
     * 获取因子类别详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:category:query')")
    @GetMapping(value = "/{factorCategoryId}")
    public AjaxResult getInfo(@PathVariable("factorCategoryId") String factorCategoryId)
    {
        return AjaxResult.success(factorCategoryService.selectFactorCategoryByFactorCategoryId(factorCategoryId));
    }

    /**
     * 新增因子类别
     */
    @PreAuthorize("@ss.hasPermi('system:category:add')")
    @Log(title = "因子类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FactorCategory factorCategory)
    {
        return toAjax(factorCategoryService.insertFactorCategory(factorCategory));
    }

    /**
     * 修改因子类别
     */
    @PreAuthorize("@ss.hasPermi('system:category:edit')")
    @Log(title = "因子类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FactorCategory factorCategory)
    {
        return toAjax(factorCategoryService.updateFactorCategory(factorCategory));
    }

    /**
     * 删除因子类别
     */
    @PreAuthorize("@ss.hasPermi('system:category:remove')")
    @Log(title = "因子类别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{factorCategoryIds}")
    public AjaxResult remove(@PathVariable String[] factorCategoryIds)
    {
        return toAjax(factorCategoryService.deleteFactorCategoryByFactorCategoryIds(factorCategoryIds));
    }
}
