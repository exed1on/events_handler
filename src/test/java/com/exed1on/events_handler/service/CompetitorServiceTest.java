package com.exed1on.events_handler.service;

import com.exed1on.events_handler.entity.CompetitorEntity;
import com.exed1on.events_handler.repository.CompetitorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CompetitorServiceTest {
    @Mock
    private CompetitorRepository competitorRepository;
    @InjectMocks
    private CompetitorService competitorService;

    @Test
    public void givenEventEntitiesList_whenGetEvents_thenReturnEventEntityList() {
        CompetitorEntity competitor1 = CompetitorEntity.builder()
                .id(1L)
                .homeTeamName("Legia Warsaw")
                .homeTeamCountry("Poland")
                .awayTeamName("FC Dynamo Kyiv")
                .awayTeamCountry("Ukraine")
                .build();
        CompetitorEntity competitor2 = CompetitorEntity.builder()
                .id(2L)
                .homeTeamName("Real Madrid CF")
                .homeTeamCountry("Spain")
                .awayTeamName("Paris Saint-Germain F.C.")
                .awayTeamCountry("France")
                .build();
        given(competitorRepository.findAll()).willReturn(List.of(competitor1, competitor2));

        List<CompetitorEntity> competitors = competitorService.getCompetitors(2);

        assertThat(competitors).isNotNull();
        assertThat(competitors.size()).isEqualTo(2);
    }
}