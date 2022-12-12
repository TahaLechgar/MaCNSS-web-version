package com.macnss.controller;


import com.macnss.model.*;
import com.macnss.modelAttributes.PatientFileForm;
import com.macnss.service.*;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class AgentController {

    PatientService patientService;
    RelativeService relativeService;
    PrescriptionService prescriptionService;
    ConsultationService consultationService;
    MedicationService medicationService;

    PatientFileService patientFileService;

    @Autowired
    public AgentController(
            PatientService patientService,
            RelativeService relativeService,
            PrescriptionService prescriptionService,
            ConsultationService consultationService,
            MedicationService medicationService,
            PatientFileService patientFileService)
    {
        this.patientService = patientService;
        this.relativeService = relativeService;
        this.prescriptionService = prescriptionService;
        this.consultationService = consultationService;
        this.medicationService = medicationService;
        this.patientFileService = patientFileService;
    }

    @GetMapping("/file/add")
    public String addFile(Model model){
        model.addAttribute("consultations", consultationService.getAllConsultations());
        model.addAttribute("relatives", relativeService.getAllRelatives());
        return "file";
    }

    @PostMapping("/file/add")
    public String addFilePost(@ModelAttribute PatientFileForm patientFileForm, BindingResult bindingResult, HttpSession session, Model model){
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("msg", "something went wrong");
//            return "file";
//        }
        int matriculate = Integer.parseInt(patientFileForm.getPatientMatriculate());
        Patient patient = patientService.getPatientByMatriculate(matriculate);

        if (patient == null) {
            model.addAttribute("msg", "Patient not found");
            return "file";
        }

        Relative relative;

        switch(patientFileForm.getRelative()){
            case "me" :
                relative = null;
                break;
            case "relative" :
                int relativeId = Integer.parseInt(patientFileForm.getRelativeId());
                relative = relativeService.getRelativeById(relativeId);
                break;
        }

        int consultationId = Integer.parseInt(patientFileForm.getConsultation());
        Consultation consultation = consultationService.getConsultationById(consultationId);

        if(consultation == null){
            model.addAttribute("msg", "Consultation not found");
            return "file";
        }

        String medicamentJSON = patientFileForm.getMedicaments();
        JSONArray medicamentsArray = new JSONArray(medicamentJSON);

        ArrayList<Medication> medications = new ArrayList<>();

        for( int i = 0; i < medicamentsArray.length(); i++){
            medications.add(medicationService.getMedicationByCodeBarre(medicamentsArray.getInt(i)));
        }

        PatientFile patientFile = new PatientFile();
        patientFile.setPatient(patient);
        patientFile.setConsultationType(consultation);
        patientFile.setMedications((ArrayList) medications);
        patientFile.setState("pending");

        patientFileService.savePatientFile(patientFile);
        prescriptionService.savePrescriptions(medications, patientFile);

        return "file";
    }

}
