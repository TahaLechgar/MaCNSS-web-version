package com.macnss.modelAttributes;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientFileForm {

    String patientMatriculate;
    String relative;
    String relativeId;
    String consultation;
    String medicaments;



}
