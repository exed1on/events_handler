package com.exed1on.events_handler.service;

import com.exed1on.events_handler.entity.CompetitorEntity;
import com.exed1on.events_handler.repository.CompetitorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {
    @Mock
    private CompetitorRepository competitorRepository;
    @InjectMocks
    private TeamService teamService;
    private CompetitorEntity competitor1;
            @BeforeEach
            public void setup(){
                competitor1=CompetitorEntity.builder()
                        .id(1L)
                        .homeTeamName("Legia Warsaw")
                        .homeTeamCountry("Poland")
                        .awayTeamName("FC Dynamo Kyiv")
                        .awayTeamCountry("Ukraine")
                        .build();
            }

    @Test
    public void givenDifferentCompetitorEntitiesList_whenGetUniqueSortedNames_thenReturnUniqueTeamsNames() {
        CompetitorEntity competitor2 = CompetitorEntity.builder()
                .id(2L)
                .homeTeamName("Real Madrid CF")
                .homeTeamCountry("Spain")
                .awayTeamName("Paris Saint-Germain F.C.")
                .awayTeamCountry("France")
                .build();
        given(competitorRepository.findAll()).willReturn(List.of(competitor1, competitor2));

        TreeSet<String> teams = teamService.getUniqueSortedTeams();
        TreeSet<String> preparedTeams = new TreeSet<>();
        preparedTeams.add("Legia Warsaw");
        preparedTeams.add("FC Dynamo Kyiv");
        preparedTeams.add("Real Madrid CF");
        preparedTeams.add("Paris Saint-Germain F.C.");
        System.out.println(preparedTeams);

        assertThat(teams).isNotNull();
        assertThat(teams.size()).isEqualTo(4);
        assertThat(teams).isEqualTo(preparedTeams);
    }

    @Test
    public void givenSameCompetitorEntitiesList_whenGetUniqueSortedNames_thenReturnUniqueTeamsNames() {
        CompetitorEntity competitor2 = CompetitorEntity.builder()
                .id(2L)
                .homeTeamName("FC Dynamo Kyiv")
                .homeTeamCountry("Ukraine")
                .awayTeamName("Legia Warsaw")
                .awayTeamCountry("Poland")
                .build();
        given(competitorRepository.findAll()).willReturn(List.of(competitor1, competitor2));

        TreeSet<String> teams = teamService.getUniqueSortedTeams();
        TreeSet<String> preparedTeams = new TreeSet<>();
        preparedTeams.add("Legia Warsaw");
        preparedTeams.add("FC Dynamo Kyiv");
        System.out.println(preparedTeams);

        assertThat(teams).isNotNull();
        assertThat(teams.size()).isEqualTo(2);
        assertThat(teams).isEqualTo(preparedTeams);
    }
    @Test
    public void givenCompetitorEntityList_whenGetStringTeams_thenReturnStringOfTeams(){
        CompetitorEntity competitor2 = CompetitorEntity.builder()
                .id(2L)
                .homeTeamName("Real Madrid CF")
                .homeTeamCountry("Spain")
                .awayTeamName("Paris Saint-Germain F.C.")
                .awayTeamCountry("France")
                .build();
        given(competitorRepository.findAll()).willReturn(List.of(competitor1,competitor2));

        String teamsString=teamService.getStringTeams();
        String preparedTeamsString="FC Dynamo Kyiv"+"\n"
                +"Legia Warsaw"+"\n"
                +"Paris Saint-Germain F.C."+"\n"
                +"Real Madrid CF";

        assertThat(teamsString).isNotNull();
        assertThat(teamsString).isEqualTo(preparedTeamsString);
    }
}