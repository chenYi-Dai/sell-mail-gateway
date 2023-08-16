package com.ruoyi.dao.mapper;

import com.ruoyi.dao.model.ProductCategoryDto;
import com.ruoyi.form.PageParam;
import com.ruoyi.form.ProductCategoryListParam;
import com.ruoyi.form.ProductCategoryParam;
import com.ruoyi.form.UpdateProductCategoryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProductCategoryMapper {

    /**
     * 分页获取所有品类
     * @param param 分页入参对象
     * @return 分页品类列表信息
     */
    List<ProductCategoryDto> productCategoryList(@Param("param") PageParam<ProductCategoryListParam> param);

    /**
     * 分页获取所有品类
     * @param param 分页入参对象
     * @return 分页品类列表信息
     */
    int productCategoryCount(@Param("param") PageParam<ProductCategoryListParam> param);

    /**
     * 查询品类详情
     * @param id 品类id
     * @return 品类对象
     */
    ProductCategoryDto detail(Long id);

    /**
     * 修改品类信息
     * @param param 修改的入参
     */
    void update(UpdateProductCategoryParam param);

    /**
     * 新增品类信息
     * @param param 品类信息
     */
    void add(ProductCategoryParam param);

    /**
     * 新增品类的图片
     * @param dto 图片信息
     * @return 品类的id
     */
    void addCategoryIcon(ProductCategoryDto dto);
}
