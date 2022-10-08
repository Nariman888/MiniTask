package com.task1foralabs.Task1ForAlabs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "questionnaire")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire extends BaseEntity {
    private String userName;
    private String userSurname;
    private Date userDate;
    private String skill;
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;
    @ManyToOne(fetch = FetchType.EAGER)
    private Specialty specialty;
    @ManyToOne(fetch = FetchType.EAGER)
    private Users user;//Если допустим пользователь может работать в нескольких компаниях
}
