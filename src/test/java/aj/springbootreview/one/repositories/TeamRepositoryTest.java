package aj.springbootreview.one.repositories;

import aj.springbootreview.one.entities.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TeamRepositoryTest {
    @Autowired
    TeamRepository teamRepository;

    @Test
    public void testRepo() {
        teamRepository.save(Team.builder().name("fff").shortName("f").build());
        teamRepository.save(Team.builder().name("ccc").shortName("c").build());

        assertThat(teamRepository.findAll(), contains(
                hasProperty("name", is("fff")),
                hasProperty("name", is("ccc"))
        ));

        Team t1 = teamRepository.findByName("fff").get();
        assertEquals("fff", teamRepository.findById(t1.getId()).get().getName());
        assertEquals("f", teamRepository.findById(t1.getId()).get().getShortName());

        Team t2 = teamRepository.findByName("ccc").get();
        assertEquals("ccc", teamRepository.findById(t2.getId()).get().getName());
        assertEquals("c", teamRepository.findById(t2.getId()).get().getShortName());

        assertTrue(teamRepository.findByName("not there").isEmpty());
    }
}
