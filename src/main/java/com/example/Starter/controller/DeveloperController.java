package com.example.Starter.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Starter.model.Developer;



@RestController 
@RequestMapping("/api/v1/developers")
public class DeveloperController {
    private  final Map<Long, Developer> developerStore = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(1);


    @GetMapping("/ap/vv1/developers")
    public Developer getDevelopers(){
        return new ArrayList<>(developerStore.values());
    }

    @GetMapping("/api/v1/developers/search")
    public List<Developer> getDeveloperBySkill(
        @RequestParam (required = false) String skill,
        @RequestParam (defaultValue = "10") int count) {
            
        List<Developer> dev = new ArrayList<>();
        for (Developer developer : developerStore.values()){
            if(developer.getSkills() != null && developer.getSkills().contains(skill)){
                dev.add(developer);
            }
        }
        return  dev;
    }

    @PostMapping ("/api/v1/developers")
    public Developer createDeveloper(@RequestBody Developer developer){
        developer.setId(counter.getAndIncrement());
        if (developer.getId() > 3){
            developer.addSkill("React");
            developer.addSkill("Java");
        }

        developer.addSkill("React");
        developer.addSkill("Java");
        developer.addSkill("JavaScript");
        developer.addSkill("Python");
        developer.addSkill("Numpy");

        developerStore.put(developer.getId(), developer);

        return  developer;
        
    }
}
