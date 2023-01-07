package aj.springbootreview.one.services;

import aj.springbootreview.one.entities.Team;
import aj.springbootreview.one.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeamService {
//    private final TeamRepository teamRepository;
//    public TeamService(TeamRepository teamRepository) {
//        this.teamRepository = teamRepository;
//    }

    @Autowired
    private TeamRepository teamRepository;

    public void save(Team team) {
        teamRepository.save(team);
    }

    public String getTeamInfo(String id) {
          return teamRepository.findById(id).orElseThrow().toString();
    }
    public String getTeamByName(String name) throws Exception {
        return teamRepository.findByName(name).orElseThrow().toString();
    }

    public String getAllTeams() {
        List<Team> allTeams = new ArrayList<>();
        teamRepository.findAll().forEach(allTeams::add);
        return allTeams.stream().map(Objects::toString).collect(Collectors.joining(","));
    }
}
