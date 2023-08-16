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
@ApiModel(value = "商品品类dto",description = "${ProductCategoryDto}")
public class ProductCategoryDto {

    @ApiModelProperty(value = "品类id")
    private Long id;

    @ApiModelProperty(value = "品类上级id")
    private Long parentId;

    @ApiModelProperty(value = "品类名称")
    private String name;

    @ApiModelProperty(value = "分类级别：0->1级；1->2级")
    private Integer level;

    @ApiModelProperty(value = "")
    private Integer productCount;

    @ApiModelProperty(value = "")
    private String productUnit;

    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;

    @ApiModelProperty(value = "")
    private Integer sort;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "")
    private String keywords;

    @ApiModelProperty(value = "描述")
    private String description;

    private List<ProductCategoryDto> children;
}
