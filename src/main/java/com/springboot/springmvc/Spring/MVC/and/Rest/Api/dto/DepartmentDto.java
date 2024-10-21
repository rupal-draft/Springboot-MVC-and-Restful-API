package com.springboot.springmvc.Spring.MVC.and.Rest.Api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private long id;
    @NotBlank(message = "Tittle is required")
    @Size(min = 3, max = 10, message = "The number of characters in Tittle should be in range [3,10]")
    private String tittle;
    private LocalDate createdAt;
    @JsonProperty("isActive")
    private boolean isActive;
}
