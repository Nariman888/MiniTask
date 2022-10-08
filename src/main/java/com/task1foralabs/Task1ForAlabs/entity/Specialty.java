package com.task1foralabs.Task1ForAlabs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialty")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Specialty extends BaseEntity {
    private String name;
}
