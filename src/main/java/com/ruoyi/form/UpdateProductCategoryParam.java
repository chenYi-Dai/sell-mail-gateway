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
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "UpdateProductCategoryParam", description = "修改商品品类入参")
public class UpdateProductCategoryParam extends ProductCategoryParam{

    @ApiModelProperty(value = "品类id")
    private Long Id;

}
