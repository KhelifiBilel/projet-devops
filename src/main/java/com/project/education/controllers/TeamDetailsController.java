package com.project.education.controllers;

import com.project.education.entities.TeamDetails;
import com.project.education.services.ITeamDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teamdetails")
public class TeamDetailsController {
    @Autowired
    private ITeamDetailsService teamDetailsService;
    @GetMapping
    public List<TeamDetails> getAllTeamDetails() {
        return this.teamDetailsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TeamDetails> getTeamDetailsById(@PathVariable(value ="id") Integer id) {
        return this.teamDetailsService.getTeamDetailsById(id);
    }
    @PostMapping
    public void addTeamDetails(@RequestBody TeamDetails teamDetails) {
        this.teamDetailsService.addTeamDetails(teamDetails);
    }

    @PutMapping
    public void updateTeamDetails(@RequestBody TeamDetails teamDetails)
    {
        this.teamDetailsService.updateTeamDetails(teamDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteTeamDetails(@PathVariable(value="id") Integer id){
        this.teamDetailsService.deleteTeamDetails(id);
    }
}
