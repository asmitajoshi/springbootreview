package aj.springbootreview.one.services;

import aj.springbootreview.one.entities.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TeamServiceTest {
    @Autowired
    TeamService teamService;

    @Test
    public void testRepo() throws Exception {
        Team t1 = Team.builder().name("rrr").shortName("r").build();
        Team t2 = Team.builder().name("eee").shortName("e").build();
        teamService.save(t1);
        teamService.save(t2);

        String allTeams = teamService.getAllTeams();
        System.out.println(allTeams);
        assertTrue(allTeams.contains(", name=rrr, shortName=r"));
        assertTrue(allTeams.contains(", name=eee, shortName=e"));

        assertTrue(teamService.getTeamByName("rrr").contains(", name=rrr, shortName=r"));
        assertTrue(teamService.getTeamByName("eee").contains(", name=eee, shortName=e"));
        assertTrue(teamService.getTeamInfo(t1.getId()).contains(", name=rrr, shortName=r"));
        assertTrue(teamService.getTeamInfo(t2.getId()).contains(", name=eee, shortName=e"));
        System.out.println(teamService.getTeamInfo(t2.getId()));
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            teamService.getTeamByName("123");
        });

        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("No value present"));
    }}
