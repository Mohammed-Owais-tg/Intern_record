package com.example.Internship.intern;


import org.apache.el.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InternService {

    @Autowired
    private InternRepository repo;

    public List<InternData> getIntern(){
        List<InternData> interns = new ArrayList<>();
        repo.findAll().forEach(interns::add);
        return interns;
    }

    public void addIntern(InternData intern){
        repo.save(intern);
    }

    public void updateDepartment(Map<String,Object> field, String id){
        InternData intern = repo.findById(id).get();

        field.forEach((key,values)->{
            Field field1 = ReflectionUtils.findField(InternData.class, key);
            field1.setAccessible(true);
            ReflectionUtils.setField(field1,intern,values);
        });
        repo.save(intern);

    }

}
