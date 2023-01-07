package aj.springbootreview.one.controllers;

import aj.springbootreview.one.OneApplication;
import aj.springbootreview.one.entities.Team;
import aj.springbootreview.one.repositories.TeamRepository;
import aj.springbootreview.one.services.TeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamController.class)
public class TeamControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @Test
    public void getTeams() throws Exception {
        String allTeams =
                "Team(id=f04c82ea-f6b9-4f44-8b7c-e567f441c62c, name=rrr, shortName=r)," +
                "Team(id=4caf811c-9951-4782-a051-0de6cb2abc91, name=eee, shortName=e)\n";
        when(teamService.getAllTeams()).thenReturn(allTeams);

        String t2 = "Team(id=1594f8d9-b883-4353-9d5a-e20f3b6364e5, name=eee, shortName=e)";
        when(teamService.getTeamInfo(anyString())).thenReturn(t2);
        mockMvc.perform(get("/teams"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(allTeams));

        mockMvc.perform(get("/team/fff"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(t2));

        mockMvc.perform(post("/team/zzz/z"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
