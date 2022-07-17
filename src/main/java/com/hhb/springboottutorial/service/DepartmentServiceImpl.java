package com.hhb.springboottutorial.service;

import com.hhb.springboottutorial.entity.Department;
import com.hhb.springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRespository;


    @Override
    public Department saveDepartment(Department department) {
        return departmentRespository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRespository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRespository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRespository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRespository.findById(departmentId).get(); // get() is used to throw exception if not found

        if (Objects.nonNull(department.getDepartmentName())
                && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAddress())
                && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRespository.save(depDB);

    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {

        return departmentRespository.findByDepartmentName(departmentName);
    }
}
