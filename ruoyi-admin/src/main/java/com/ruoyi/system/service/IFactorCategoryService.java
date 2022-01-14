package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.Factor;
import com.ruoyi.system.domain.FactorCategory;

/**
 * 因子类别Service接口
 *
 * @author shang
 * @date 2022-01-12
 */
public interface IFactorCategoryService
{
    /**
     * 查询因子类别
     *
     * @param factorCategoryId 因子类别主键
     * @return 因子类别
     */
    public FactorCategory selectFactorCategoryByFactorCategoryId(String factorCategoryId);

    /**
     * 查询因子类别列表
     *
     * @param factorCategory 因子类别
     * @return 因子类别集合
     */
    public List<FactorCategory> selectFactorCategoryList(FactorCategory factorCategory);

    /**
     * 查询因子列表
     *
     * @param factorCategory 因子类别id
     * @return 因子集合
     */
    public List<Factor> selectFactorList(FactorCategory factorCategory);

    /**
     * 新增因子类别
     *
     * @param factorCategory 因子类别
     * @return 结果
     */
    public int insertFactorCategory(FactorCategory factorCategory);

    /**
     * 修改因子类别
     *
     * @param factorCategory 因子类别
     * @return 结果
     */
    public int updateFactorCategory(FactorCategory factorCategory);

    /**
     * 批量删除因子类别
     *
     * @param factorCategoryIds 需要删除的因子类别主键集合
     * @return 结果
     */
    public int deleteFactorCategoryByFactorCategoryIds(String[] factorCategoryIds);

    /**
     * 删除因子类别信息
     *
     * @param factorCategoryId 因子类别主键
     * @return 结果
     */
    public int deleteFactorCategoryByFactorCategoryId(String factorCategoryId);
}
