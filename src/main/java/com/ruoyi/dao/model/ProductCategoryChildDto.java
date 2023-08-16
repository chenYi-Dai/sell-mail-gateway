package com.ruoyi.dao.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "商品品类dto",description = "${ProductCategoryChildDto}")
public class ProductCategoryChildDto /*extends ProductCategoryDto*/{

    private List<ProductCategoryDto> children;


}
