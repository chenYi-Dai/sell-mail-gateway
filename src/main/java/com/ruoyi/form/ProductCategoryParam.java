package com.ruoyi.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : ex_yi.chen
 * @ClassName : UpdateSpaceForm
 * @Description : 修改空间集信息入参
 * @Date: 2022-07-14 15:22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ProductCategoryParam", description = "新增商品品类入参")
public class ProductCategoryParam {

    @ApiModelProperty(value = "品类上级id")
    private Long parentId;

    @ApiModelProperty(value = "品类名称")
    private String name;

    @ApiModelProperty(value = "分类级别：0->1级；1->2级")
    private Integer level;

    @ApiModelProperty(value = "数量")
    private Integer productCount;

    @ApiModelProperty(value = "数量单位")
    private String productUnit;

    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;

    @ApiModelProperty(value = "")
    private Integer sort;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "关键词")
    private String keywords;

    @ApiModelProperty(value = "描述")
    private String description;

}
