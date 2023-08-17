package com.momen.yana.city;


import com.momen.yana.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CityDTO extends BaseDTO {

    @ApiModelProperty(required = true)
    private String name;

}
