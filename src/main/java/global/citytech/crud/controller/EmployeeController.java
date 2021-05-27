package global.citytech.crud.controller;

import global.citytech.crud.controller.payloads.EmployeePayload;
import global.citytech.crud.repository.EmployeeEntity;
import global.citytech.crud.service.EmployeeService;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller("/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @Inject
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Get
    public List<EmployeeEntity> getAll() {
        return employeeService.getAll();
    }

    @Post
    public String save(EmployeePayload payload) {
        return employeeService.save(payload);
    }

    @Delete
    public String delete(EmployeePayload payload) throws Exception {
        return employeeService.delete(payload);
    }

    @Put
    public EmployeeEntity update(EmployeePayload payload) throws Exception {

        return employeeService.update(payload);
    }


}
