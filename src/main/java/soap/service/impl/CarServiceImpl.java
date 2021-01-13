package soap.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import soap.service.CarService;
import soap.vo.Car;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public String addOrUpdateCar(Car car) {
        Map<String , Object> result = new HashMap<>();

        if (car != null) {
            if (car.getId() != null) {
                result.put("success" , true);
                result.put("msg" , "修改成功");
            } else {
                result.put("success" , true);
                result.put("msg" , "新增成功");
            }

        } else {
            result.put("success" , false);
            result.put("msg" , "请输入正确参数");
        }

        System.out.println("方法内打印-"+car.toString());

        return JSONObject.toJSONString(result);
    }
}
