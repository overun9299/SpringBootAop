package soap.service;


import soap.vo.Car;

public interface CarService {

    /**
     * 新增或修改car
     * @param car
     * @return
     */
    String addOrUpdateCar(Car car);
}
