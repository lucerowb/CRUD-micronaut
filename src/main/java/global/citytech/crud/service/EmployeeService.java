package global.citytech.crud.service;

import global.citytech.crud.controller.payloads.EmployeePayload;
import global.citytech.crud.repository.EmployeeEntity;
import global.citytech.crud.repository.EmployeeEntityBuilder;
import global.citytech.crud.repository.EmployeeRepository;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String save(EmployeePayload employeePayload){
        //https://github.com/Randgalt/record-builder
        EmployeeEntity entity = EmployeeEntityBuilder.builder()
                .name(employeePayload.name())
                .build();
        employeeRepository.save(entity);
        return "SUCCESS";
    }

    public String delete(EmployeePayload employeePayload) throws Exception {
        Optional<EmployeeEntity> maybeEmployeeEntity  = employeeRepository.findById(employeePayload.id());
        if (maybeEmployeeEntity.isEmpty()){
            throw new Exception("No record found");
        }
        employeeRepository.deleteById(employeePayload.id());
        return "DELETE SUCCESS";
    }

    public List<EmployeeEntity> getAll(){
        Iterable<EmployeeEntity> entityIterable = employeeRepository.findAll();
        List<EmployeeEntity> entityList = new ArrayList<>();
        entityIterable.forEach(entityList::add);
        return entityList;
    }

    public EmployeeEntity update(EmployeePayload employeePayload) throws Exception {
        Optional<EmployeeEntity> maybeEmployeeEntity  = employeeRepository.findById(employeePayload.id());
        if (maybeEmployeeEntity.isEmpty()){
            throw new Exception("No record found");
        }

        return employeeRepository.update(EmployeeEntityBuilder.builder()
                .id(maybeEmployeeEntity.get().id())
                .name(employeePayload.name())
                .build());
    }
}
