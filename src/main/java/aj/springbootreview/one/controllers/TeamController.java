package aj.springbootreview.one.controllers;

import aj.springbootreview.one.entities.Team;
import aj.springbootreview.one.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamController {
//    private final TeamService teamService;
//    public TeamController(TeamService teamService) {
//        this.teamService = teamService;
//    }

    @Autowired
    private TeamService teamService;

    @GetMapping("/team/{name}")
    public @ResponseBody String teamInfo(@PathVariable String name) {
        return teamService.getTeamInfo(name);
    }

    @PostMapping("/team/{name}/{shortName}")
    public @ResponseBody ResponseEntity<HttpStatus> addTeam(@PathVariable String name, @PathVariable String shortName) {
        teamService.save(Team.builder().name(name).shortName(shortName).build());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/teams")
    public @ResponseBody String getAllTeams() {
        return teamService.getAllTeams();
    }
}
