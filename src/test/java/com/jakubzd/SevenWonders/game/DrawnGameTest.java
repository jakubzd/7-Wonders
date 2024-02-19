package com.jakubzd.SevenWonders.game;

import com.jakubzd.SevenWonders.entity.Expansion;
import com.jakubzd.SevenWonders.entity.Player;
import com.jakubzd.SevenWonders.entity.Wonder;
import com.jakubzd.SevenWonders.repository.WonderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DrawnGameTest {

	@Mock
	private static WonderRepository wonderRepository;
	private DrawnGame game;
	private static List<Player> players;
	private static List<Expansion> expansions;
	private static List<Wonder> defaultWonders;
	private static List<Wonder> expansionWonders;
	private static List<Wonder> allWonders;
	@BeforeEach
	void init() {
		game = new DrawnGame(wonderRepository);
		when(wonderRepository.findByExpansion(null)).thenReturn(defaultWonders);
	}
	@BeforeAll
    static void setup(@Mock WonderRepository wonderRepository) {
		players = Arrays.asList(new Player(1L, "Joe", "Doe", "JDo"),
				new Player(2L, "Sarah", "Doe", "Sahara"),
				new Player(3L, "Emma", "Doe", "Emma Sdoe"));
		final Expansion leaders = new Expansion();
		defaultWonders = Arrays.asList(new Wonder(1L, "Giza", null),
				new Wonder(2L, "Alexandria", null),
				new Wonder(3L, "Olympia", null));

		expansionWonders = Arrays.asList(new Wonder(4L, "Abu Simbel", leaders),
				new Wonder(5L, "Rome", leaders));
		leaders.setId(1L);
		leaders.setName("Leaders");
		leaders.setWonders(new HashSet<>(expansionWonders));
		expansions = List.of(leaders);
	}

	@Test
	void givenNoExpansion_whenGettingAllWonders_thenReturnsDefaultWonders() {
		List<Wonder> allWonders = game.getAllWonders(null);
		verify(wonderRepository, times(1)).findByExpansion(null);
		Assertions.assertEquals(allWonders, defaultWonders);
	}

	@Test
	void givenAListOfExpansions_whenGettingAllWonders_thenReturnsDefaultAndExpansionWonders() {

	}


	@Test
	void givenAListOfPlayersAndExpansions_whenDrawingGame_thenGenerateARandomMapOfCombinations() {
	}
}
