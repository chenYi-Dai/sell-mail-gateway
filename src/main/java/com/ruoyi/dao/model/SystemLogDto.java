package com.ruoyi.dao.model;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统日志dto对象",description = "{SystemLogDto}")
public class SystemLogDto {

    private Long id;

    private String describe;

    private Long loginId;

    private String loginIp;

    private Date loginTime;

    private String param;

    private String serviceName;

    private String func;

    private String requestUId;
}
