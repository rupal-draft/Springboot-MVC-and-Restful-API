package com.springboot.springmvc.Spring.MVC.and.Rest.Api.repositories;


import com.springboot.springmvc.Spring.MVC.and.Rest.Api.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
