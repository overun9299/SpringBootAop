package soap.vo;

import lombok.Data;

@Data
public class Car {

    /** 主键 **/
    private Integer id;

    /** 名称 **/
    private String name;

    /** 价格 **/
    private Float price;

}
