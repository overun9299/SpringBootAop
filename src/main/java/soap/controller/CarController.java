package soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import soap.aspect.MethodLogAnnotation;
import soap.service.CarService;
import soap.vo.Car;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 新增或修改car
     * @param car
     * @return
     */
    @MethodLogAnnotation(value = "cscs")
    @RequestMapping(value = "/addOrUpdateCar" , method = RequestMethod.POST)
    public String addOrUpdateCar(Car car) {

        return carService.addOrUpdateCar(car);
    }
}
