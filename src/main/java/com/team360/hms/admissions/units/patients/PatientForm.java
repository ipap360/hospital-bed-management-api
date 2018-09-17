package com.team360.hms.admissions.units.patients;

import com.team360.hms.admissions.common.exceptions.FormValidationException;
import lombok.Data;

import java.util.HashMap;

@Data
public class PatientForm {

    private String name;

    private String code;

    private String notes;

    private Integer birthYear;

    private Gender gender;

    PatientForm validate(int id) {
        HashMap<String, String> errors = new HashMap();
        if (getName() == null) {
            errors.put("name", "Please fill the name");
        }
        if (!errors.isEmpty()) {
            throw new FormValidationException(errors);
        }
        return this;
    }

    PatientForm load(Patient patient) {

        setName(patient.getName());
        setCode(patient.getCode());
        setNotes(patient.getNotes());
        setGender(patient.getGender());
        setBirthYear(patient.getBirthYear());

        return this;
    }

}