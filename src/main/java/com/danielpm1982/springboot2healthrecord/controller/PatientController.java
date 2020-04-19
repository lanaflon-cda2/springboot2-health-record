package com.danielpm1982.springboot2healthrecord.controller;
import com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad.ConsultationLoad;
import com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad.PatientLoad;
import com.danielpm1982.springboot2healthrecord.service.PatientServiceInterface;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;

@Controller
public class PatientController {
    private PatientServiceInterface patientServiceInterface;
    private PatientLoad patientLoad;
    private ConsultationLoad consultationLoad;
    public PatientController(PatientServiceInterface patientServiceInterface, PatientLoad patientLoad, ConsultationLoad consultationLoad) {
        this.patientServiceInterface = patientServiceInterface;
        this.patientLoad = patientLoad;
        this.consultationLoad = consultationLoad;
    }
    @PostConstruct
    public void addPatientBootstrapDataLoad(){
        System.out.println("Bootstraping data: adding patients...");
        patientLoad.getPatientList().forEach(x->patientServiceInterface.addPatient(x));
        System.out.println("Patients added successfully !");
    }
    @PostConstruct
    public void addConsultationBootstrapDataLoad(){
        System.out.println("Bootstraping data: adding consultations...");
        consultationLoad.getConsultationMap().forEach((x,y)->patientServiceInterface.addPatientRecordConsultation(x,y));
        System.out.println("Consultations added successfully !");
    }
    public void showPatient(Long id){
        System.out.println("Showing patient id = "+id+":");
        System.out.println(patientServiceInterface.getPatient(id));
    }
    public void showAllPatients(){
        System.out.println("Showing all patients:");
        patientServiceInterface.getAllPatients().forEach(System.out::println);
    }
}
