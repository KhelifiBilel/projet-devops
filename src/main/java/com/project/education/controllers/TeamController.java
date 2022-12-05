package com.project.education.controllers;

import com.project.education.entities.Team;
import com.project.education.services.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private ITeamService teamService;
    @GetMapping
    public List<Team> getAllTeams() {
        return this.teamService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Team> getTeamById(@PathVariable(value ="id") Integer id) {
        return this.teamService.getTeamById(id);
    }
    @PostMapping
    public void addTeam(@RequestBody Team team) {
        this.teamService.addTeam(team);
    }

    @PutMapping
    public void updateTeam(@RequestBody Team team)
    {
        this.teamService.updateTeam(team);
    }
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable(value="id") Integer id){
        this.teamService.deleteTeam(id);
    }
}
