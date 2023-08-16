package com.ruoyi.controller;

import com.ruoyi.dao.model.ProductCategoryDto;
import com.ruoyi.form.PageParam;
import com.ruoyi.form.ProductCategoryListParam;
import com.ruoyi.form.ProductCategoryParam;
import com.ruoyi.form.UpdateProductCategoryParam;
import com.ruoyi.service.ProductCategoryService;
import com.ruoyi.util.RedisUtils;
import com.ruoyi.vo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping(value = "/category")
@Api(value = "ProductCategoryController",tags = "商品品类类型相关接口")
public class ProductCategoryController {

    @Resource
    private RedisUtils redisUtils;
    @Resource
    private ProductCategoryService categoryService;

    @ApiOperation(value = "获取品类列表信息",notes = "productCategoryList")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public PageResult<ProductCategoryDto> productCategoryList(@RequestBody PageParam<ProductCategoryListParam> param){
        log.info("ProductCategoryController productCategoryList param | {}",param);
        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        String requestId =(String) requestAttributes.getRequest().getAttribute("requestId");
        String requestUid = (String) redisUtils.get(requestId);
        log.info("productCategoryList requestId | {}",requestUid);
        PageResult<ProductCategoryDto> pageResult = categoryService.productCategoryList(param);
        return pageResult;
    }

    @ApiOperation(value = "修改品类信息",notes = "updateProductCategory")
    @RequestMapping(value = "/updateById",method = RequestMethod.POST)
    public void updateProductCategory(@RequestBody UpdateProductCategoryParam param){
        log.info("ProductCategoryController updateProductCategory param | {}",param);
        categoryService.updateProductCategory(param);
    }

    @ApiOperation(value = "新增品类信息",notes = "addProductCategory")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addProductCategory(@RequestBody ProductCategoryParam param){
        log.info("ProductCategoryController addProductCategory param | {}",param);
        categoryService.addProductCategory(param);
    }

}
