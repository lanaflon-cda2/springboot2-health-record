package com.danielpm1982.springboot2healthrecord.controller;
import com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad.ProfessionalLoad;
import com.danielpm1982.springboot2healthrecord.service.ProfessionalServiceInterface;
import org.springframework.stereotype.Controller;
import javax.annotation.PostConstruct;

@Controller
public class ProfessionalController {
    private ProfessionalServiceInterface professionalServiceInterface;
    private ProfessionalLoad professionalLoad;
    public ProfessionalController(ProfessionalServiceInterface professionalServiceInterface, ProfessionalLoad professionalLoad) {
        this.professionalServiceInterface = professionalServiceInterface;
        this.professionalLoad = professionalLoad;
    }
    @PostConstruct
    public void addProfessionalBootstrapDataLoad(){
        System.out.println("Bootstraping data: adding professionals...");
        professionalLoad.getProfessionalList().forEach(x->professionalServiceInterface.addProfessional(x));
        System.out.println("Professionals added successfully !");
    }
    public void showAllProfessionals(){
        System.out.println("Showing all professionals:");
        professionalServiceInterface.getAllProfessionals().forEach(System.out::println);
    }
}
