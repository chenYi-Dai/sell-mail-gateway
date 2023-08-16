package com.ruoyi.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.config.SellMailBusinessException;
import com.ruoyi.dao.ProductCategoryDao;
import com.ruoyi.dao.model.ProductCategoryDto;
import com.ruoyi.enums.SellMailBusinessExceptionEnum;
import com.ruoyi.form.PageParam;
import com.ruoyi.form.ProductCategoryListParam;
import com.ruoyi.form.ProductCategoryParam;
import com.ruoyi.form.UpdateProductCategoryParam;
import com.ruoyi.service.ProductCategoryService;
import com.ruoyi.vo.PageResult;
import javafx.fxml.Initializable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Slf4j
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService, InitializingBean {


    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("代码快");
    }
    ProductCategoryServiceImpl() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        ProductCategoryServiceImpl productCategoryService = new ProductCategoryServiceImpl();

    }

    @Resource
    private ProductCategoryDao categoryDao;

    @Override
    @Transactional(rollbackFor = SellMailBusinessException.class)
    //分布式事务 LCN seata(重量级)
    //mybatis 手动事务
    public PageResult<ProductCategoryDto> productCategoryList(PageParam<ProductCategoryListParam> param) {
                PageResult<ProductCategoryDto> pageResult = new PageResult();
        // TODO: 2023/8/15 add del update
        int count = categoryDao.productCategoryCount(param);
        if (count == 0) {
            return pageResult;
        }

        List<ProductCategoryDto> dtos = categoryDao.productCategoryList(param);
        pageResult.setData(dtos);
        pageResult.setTotal(count);

        return pageResult;
    }

    @Override
    public void updateProductCategory(UpdateProductCategoryParam param) {
        log.info("ProductCategoryServiceImpl updateProductCategory param |{}",param);
        ProductCategoryDto dto = categoryDao.detail(param.getId());
        if(ObjectUtil.isEmpty(dto)){
            throw new SellMailBusinessException(SellMailBusinessExceptionEnum.MSG.getMsgDesc());
        }
        categoryDao.update(param);
    }

    @Override
    public void addProductCategory(ProductCategoryParam param) {
        categoryDao.add(param);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
