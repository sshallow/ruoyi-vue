package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 因子类别对象 factor_category
 *
 * @author shang
 * @date 2022-01-12
 */
public class Factor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 因子类别id */
    private String factorCategoryId;

    /** 因子类别标题 */
    @Excel(name = "因子类别标题")
    private String factorCategoryTitle;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

     /** 是否删除 */
    @Excel(name = "是否删除")
    private String isdelete;

    /** 是否多选 */
    @Excel(name = "是否多选")
    private String isdouble;

    /** 因子列表 */
    @Excel(name = "因子列表")
    private String childFactorList;

    /** 因子 id */
    @Excel(name = "因子id")
    private String factorItemId;

    /** 因子标题 */
    @Excel(name = "因子标题")
    private String factorItemTitle;

    /** 因子类别id */
    @Excel(name = "因子类别id")
    private String parentCategoryId;


    public void setFactorCategoryId(String factorCategoryId)
    {
        this.factorCategoryId = factorCategoryId;
    }

    public String getFactorCategoryId()
    {
        return factorCategoryId;
    }
    public void setFactorCategoryTitle(String factorCategoryTitle)
    {
        this.factorCategoryTitle = factorCategoryTitle;
    }

    public String getFactorCategoryTitle()
    {
        return factorCategoryTitle;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setIsdelete(String isdelete)
    {
        this.isdelete = isdelete;
    }

    public String getIsdelete()
    {
        return isdelete;
    }
    public void setIsdouble(String isdouble)
    {
        this.isdouble = isdouble;
    }

    public String getIsdouble()
    {
        return isdouble;
    }

    public void setfactorItemId(String factorItemId)
    {
        this.factorItemId = factorItemId;
    }
    public String getfactorItemId() {
        return factorItemId;
    }

    public void setFactorItemTitle(String factorItemTitle) {
        this.factorItemTitle = factorItemTitle;
    }
    public String getFactorItemTitle() {
        return factorItemTitle;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("factorCategoryId", getFactorCategoryId())
                .append("factorCategoryTitle", getFactorCategoryTitle())
                .append("sort", getSort())
                .append("isdelete", getIsdelete())
                .append("isdouble", getIsdouble())
                .append("factorItemId",getfactorItemId())
                .append("factorItemTitle",getFactorItemTitle())
                .append("parentCategoryId",getParentCategoryId())
                .toString();
    }
}
