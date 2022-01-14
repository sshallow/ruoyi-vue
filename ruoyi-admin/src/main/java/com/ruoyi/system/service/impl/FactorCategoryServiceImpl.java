package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Factor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FactorCategoryMapper;
import com.ruoyi.system.domain.FactorCategory;
import com.ruoyi.system.domain.Factor;
import com.ruoyi.system.service.IFactorCategoryService;

/**
 * 因子类别Service业务层处理
 *
 * @author shang
 * @date 2022-01-12
 */
@Service
public class FactorCategoryServiceImpl implements IFactorCategoryService
{
    @Autowired
    private FactorCategoryMapper factorCategoryMapper;

    /**
     * 查询因子类别
     *
     * @param factorCategoryId 因子类别主键
     * @return 因子类别
     */
    @Override
    public FactorCategory selectFactorCategoryByFactorCategoryId(String factorCategoryId)
    {
        return factorCategoryMapper.selectFactorCategoryByFactorCategoryId(factorCategoryId);
    }

    /**
     * 查询因子类别列表
     *
     * @param factorCategory 因子类别
     * @return 因子
     */
    @Override
    public List<FactorCategory> selectFactorCategoryList(FactorCategory factorCategory)
    {
        return factorCategoryMapper.selectFactorCategoryList(factorCategory);
    }

    /**
     * 查询因子列表
     *
     * @param factorCategory 因子
     * @return 因子集合
     */
    @Override
    public List<Factor> selectFactorList(FactorCategory factorCategory) {
        return factorCategoryMapper.selectFactorList(factorCategory);
    }

    /**
     * 新增因子类别
     *
     * @param factorCategory 因子类别
     * @return 结果
     */
    @Override
    public int insertFactorCategory(FactorCategory factorCategory)
    {
        return factorCategoryMapper.insertFactorCategory(factorCategory);
    }

    /**
     * 修改因子类别
     *
     * @param factorCategory 因子类别
     * @return 结果
     */
    @Override
    public int updateFactorCategory(FactorCategory factorCategory)
    {
        return factorCategoryMapper.updateFactorCategory(factorCategory);
    }

    /**
     * 批量删除因子类别
     *
     * @param factorCategoryIds 需要删除的因子类别主键
     * @return 结果
     */
    @Override
    public int deleteFactorCategoryByFactorCategoryIds(String[] factorCategoryIds)
    {
        return factorCategoryMapper.deleteFactorCategoryByFactorCategoryIds(factorCategoryIds);
    }

    /**
     * 删除因子类别信息
     *
     * @param factorCategoryId 因子类别主键
     * @return 结果
     */
    @Override
    public int deleteFactorCategoryByFactorCategoryId(String factorCategoryId)
    {
        return factorCategoryMapper.deleteFactorCategoryByFactorCategoryId(factorCategoryId);
    }
}
