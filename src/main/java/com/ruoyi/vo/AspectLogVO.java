package com.ruoyi.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AspectLogVO {

    private String method;

    private Object[] param;

    private String cla;

    private Date createTime;
}
