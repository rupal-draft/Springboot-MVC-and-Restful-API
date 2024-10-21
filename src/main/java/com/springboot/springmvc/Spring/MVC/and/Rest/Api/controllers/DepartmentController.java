package com.springboot.springmvc.Spring.MVC.and.Rest.Api.controllers;

import com.springboot.springmvc.Spring.MVC.and.Rest.Api.dto.DepartmentDto;
import com.springboot.springmvc.Spring.MVC.and.Rest.Api.exceptions.ResourceNotFound;
import com.springboot.springmvc.Spring.MVC.and.Rest.Api.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentbyId(@PathVariable(name = "departmentId") Long id){
        Optional<DepartmentDto>departmentDto= departmentService.getDepartmentbyId(id);
        return departmentDto
                .map(departmentDto1 -> ResponseEntity.ok(departmentDto1))
                .orElseThrow(()->new ResourceNotFound("Department not found!!"));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody @Valid DepartmentDto departmentDto){
        DepartmentDto savedDepartmentDto=departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody @Valid DepartmentDto departmentDto, @PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.updateDepartment(departmentDto,departmentId));
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long departmentId){
        boolean isDeleted = departmentService.deleteDepartment(departmentId);
        if(!isDeleted) ResponseEntity.notFound().build();
        return ResponseEntity.ok(isDeleted);
    }

    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> updatePartialDepartment(@PathVariable Long departmentId, Map<String,Object>updates){
        DepartmentDto departmentDto = departmentService.updatePartialDepartment(departmentId,updates);
        return ResponseEntity.ok(departmentDto);
    }
}
