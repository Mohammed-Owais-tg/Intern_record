package com.example.Internship.intern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class InternController {


    @Autowired
    private InternService service;


    @GetMapping("interns/")
    public List<InternData> getInterns(){
        return service.getIntern();
    }

    @PostMapping("interns/")
    public void addIntern(@RequestBody InternData intern){
        service.addIntern(intern);
    }

    @PatchMapping("interns/{id}")
    public void updateDepartment(@PathVariable String id , @RequestBody Map<String,Object> field){
        service.updateDepartment(field,id);
    }
}
