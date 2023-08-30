package com.ruoyi.dao;

import com.ruoyi.dao.mapper.ProductCategoryMapper;
import com.ruoyi.dao.model.ProductCategoryDto;
import com.ruoyi.form.PageParam;
import com.ruoyi.form.ProductCategoryListParam;
import com.ruoyi.form.ProductCategoryParam;
import com.ruoyi.form.UpdateProductCategoryParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
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

    public void queryList(){
        List<T> ts = categoryMapper.queryList();
        log.info("category List result | {}",ts);
    }
}
