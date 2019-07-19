package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
public class TestController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TestRepository testRepository;

//    @RequestMapping("/")
//    public String index(Model model)
//    {
//        model.addAttribute("testlist", testlist.findAll());
//        model.addAttribute("studentrepository", studentrepository.findAll());
//        return "list";
//    }

    @RequestMapping("/")
    public String listTests(Model model){
        model.addAttribute("tests", testRepository.findAll());
        model.addAttribute("students", studentRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String testForm(Model model){
        model.addAttribute("test", new Test());
        model.addAttribute("students", studentRepository.findAll());
        return "testform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Test test, BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("subjects", studentRepository.findAll());
            return "courseform";
        }
        testRepository.save(test);
        return "redirect:/";
    }


    @GetMapping("/addstudent")
    public String subjectForm(Model model){
        model.addAttribute("student", new Student());
        return "student";
    }

    @PostMapping("/processstudent")
    public String processStudent(@Valid Student student, BindingResult result,
                                 Model model){
        if(result.hasErrors()){
            return "student";
        
        }
        studentRepository.save(student);
        return "redirect:/";
    }


//    @RequestMapping("/addtest")
//    public String addTest(Model model)
//    {
//        model.addAttribute("atest", new Test());
//        model.addAttribute("studentrepository", studentrepository.findAll());
//        return "test";
//    }
//
//    @RequestMapping("/savetest")
//    public String saveTest(@ModelAttribute("aTest")Test test, Model model)
//    {
//        testlist.save(test);
//        return "redirect:/";
//    }
//
//
//
//    //filters out above on reload
//    @PostConstruct
//    public void fillTables()
//    {
//        Student a = new Student();
//        a.setFirstName("Joe");
//        a.setLastName("Jackson");
//        studentrepository.save(a);
//
//        Student b = new Student();
//        b.setFirstName("Joe");
//        b.setLastName("Pesci");
//        studentrepository.save(b);
//    }
}
