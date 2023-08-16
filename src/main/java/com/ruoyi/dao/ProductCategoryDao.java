package com.ruoyi.dao;

import com.ruoyi.dao.mapper.ProductCategoryMapper;
import com.ruoyi.dao.model.ProductCategoryDto;
import com.ruoyi.form.PageParam;
import com.ruoyi.form.ProductCategoryListParam;
import com.ruoyi.form.ProductCategoryParam;
import com.ruoyi.form.UpdateProductCategoryParam;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProductCategoryDao {

    @Resource
    private ProductCategoryMapper categoryMapper;

    public List<ProductCategoryDto> productCategoryList(PageParam<ProductCategoryListParam> param){
        return categoryMapper.productCategoryList(param);
    }

    public int productCategoryCount(PageParam<ProductCategoryListParam> param){
        return categoryMapper.productCategoryCount(param);
    }

    public ProductCategoryDto detail(Long id){
        return categoryMapper.detail(id);
    }

    public void update(UpdateProductCategoryParam param) {
        categoryMapper.update(param);
    }

    public void add(ProductCategoryParam param){
        categoryMapper.add(param);
    }
    public void addIcon(ProductCategoryDto dto){
        categoryMapper.addCategoryIcon(dto);
    }
}
