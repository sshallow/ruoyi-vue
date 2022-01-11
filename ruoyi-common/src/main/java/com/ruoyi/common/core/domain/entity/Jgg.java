package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class Jgg extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 纬度id */
    private String dimensionCd;

    /** 纬度名称 */
    @Excel(name = "纬度名称")
    private String dimensionNm;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private String isdelete;

    /** 是否多选 */
    private String isdouble;

    /** 自选股指标定义测试信息 */
//    private List<TbBaseCustomIndexDef> tbBaseCustomIndexDefList;

    public void setDimensionCd(String dimensionCd)
    {
        this.dimensionCd = dimensionCd;
    }

    public String getDimensionCd()
    {
        return dimensionCd;
    }
    public void setDimensionNm(String dimensionNm)
    {
        this.dimensionNm = dimensionNm;
    }

    public String getDimensionNm()
    {
        return dimensionNm;
    }
    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public Integer getSort()
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

//    public List<TbBaseCustomIndexDef> getTbBaseCustomIndexDefList()
//    {
//        return tbBaseCustomIndexDefList;
//    }
//
//    public void setTbBaseCustomIndexDefList(List<TbBaseCustomIndexDef> tbBaseCustomIndexDefList)
//    {
//        this.tbBaseCustomIndexDefList = tbBaseCustomIndexDefList;
//    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("dimensionCd", getDimensionCd())
                .append("dimensionNm", getDimensionNm())
                .append("sort", getSort())
                .append("isdelete", getIsdelete())
                .append("isdouble", getIsdouble())
//                .append("tbBaseCustomIndexDefList", getTbBaseCustomIndexDefList())
                .toString();
    }
}
