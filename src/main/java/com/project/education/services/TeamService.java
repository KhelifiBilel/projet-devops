package com.project.education.services;

import com.project.education.entities.Team;
import com.project.education.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAll() {
        return this.teamRepository.findAll();
    }

    @Override
    public void addTeam(Team team) {
        this.teamRepository.save(team);
    }

    @Override
    public void updateTeam(Team team) {
        this.teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Integer id) {
        this.teamRepository.deleteById(id);
    }

    @Override
    public Optional<Team> getTeamById(Integer id) {
        return this.teamRepository.findById(id);
        
    }
}
