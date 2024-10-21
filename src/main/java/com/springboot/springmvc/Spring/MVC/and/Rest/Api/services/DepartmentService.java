package com.springboot.springmvc.Spring.MVC.and.Rest.Api.services;


import com.springboot.springmvc.Spring.MVC.and.Rest.Api.dto.DepartmentDto;
import com.springboot.springmvc.Spring.MVC.and.Rest.Api.entities.DepartmentEntity;
import com.springboot.springmvc.Spring.MVC.and.Rest.Api.exceptions.ResourceNotFound;
import com.springboot.springmvc.Spring.MVC.and.Rest.Api.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;
    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public void isExist(Long departmentId){
        boolean exists = departmentRepository.existsById(departmentId);
        if(!exists) throw new ResourceNotFound("Department not found!!");
    }

    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentEntity> departmentEntities= departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentDto.class))
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDto> getDepartmentbyId(Long id) {
        Optional<DepartmentEntity> departmentEntity= departmentRepository.findById(id);
        return departmentEntity
                .map(departmentEntity1 -> modelMapper
                        .map(departmentEntity1,DepartmentDto.class));
    }

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        DepartmentEntity toSaveEntity = modelMapper.map(departmentDto,DepartmentEntity.class);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartmentEntity,DepartmentDto.class);
    }

    public DepartmentDto updateDepartment(DepartmentDto departmentDto, Long departmentId) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto,DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity savedDepartmentEntity=departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity,DepartmentDto.class);
    }

    public boolean deleteDepartment(Long departmentId) {
        isExist(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public DepartmentDto updatePartialDepartment(Long departmentId, Map<String, Object> updates) {
        isExist(departmentId);
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        updates.forEach((key,value)->{
            Field updateDepartmentEntity=ReflectionUtils.findField(DepartmentEntity.class,key);
            updateDepartmentEntity.setAccessible(true);
            ReflectionUtils.setField(updateDepartmentEntity,departmentEntity,value);
        });
        return modelMapper.map(departmentRepository.save(departmentEntity),DepartmentDto.class);
    }
}
