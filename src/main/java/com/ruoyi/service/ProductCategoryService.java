package com.ruoyi.service;

import com.ruoyi.config.SellMailBusinessException;
import com.ruoyi.dao.model.ProductCategoryDto;
import com.ruoyi.form.PageParam;
import com.ruoyi.form.ProductCategoryListParam;
import com.ruoyi.form.ProductCategoryParam;
import com.ruoyi.form.UpdateProductCategoryParam;
import com.ruoyi.vo.PageResult;

import java.util.List;

public interface ProductCategoryService {

    PageResult<ProductCategoryDto> productCategoryList(PageParam<ProductCategoryListParam> param);

    void updateProductCategory(UpdateProductCategoryParam param);

    void addProductCategory(ProductCategoryParam param);
}
