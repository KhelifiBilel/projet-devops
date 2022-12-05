package com.project.education.services;

import com.project.education.entities.TeamDetails;
import com.project.education.repositories.TeamDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamDetailsService implements ITeamDetailsService {
    @Autowired
    private TeamDetailsRepository teamDetailsRepository;

    @Override
    public List<TeamDetails> getAll() {
        return this.teamDetailsRepository.findAll();
    }

    @Override
    public void addTeamDetails(TeamDetails teamDetails) {
        this.teamDetailsRepository.save(teamDetails);
    }

    @Override
    public void updateTeamDetails(TeamDetails teamDetails) {
        this.teamDetailsRepository.save(teamDetails);
    }

    @Override
    public void deleteTeamDetails(Integer id) {
        this.teamDetailsRepository.deleteById(id);
    }

    @Override
    public Optional<TeamDetails> getTeamDetailsById(Integer id) {
        return this.teamDetailsRepository.findById(id);
    }
}
