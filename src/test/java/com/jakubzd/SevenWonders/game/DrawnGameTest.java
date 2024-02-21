package com.jakubzd.SevenWonders.game;

import com.jakubzd.SevenWonders.entity.Expansion;
import com.jakubzd.SevenWonders.entity.Player;
import com.jakubzd.SevenWonders.entity.Wonder;
import com.jakubzd.SevenWonders.repository.WonderRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DrawnGameTest {

	@Mock
	private static WonderRepository wonderRepository;
	private DrawnGame game;
	private static List<Player> players;
	private static List<Expansion> expansions;
	private static List<Wonder> defaultWonders;
    private static List<Wonder> allWonders;
	@BeforeEach
	void init() {
		game = new DrawnGame(wonderRepository);
		Mockito.lenient().when(wonderRepository.findByExpansion(null)).thenReturn(defaultWonders);
	}

	@BeforeAll
    static void setup() {
		players = Arrays.asList(new Player(1L, "Joe", "Doe", "JDo"),
				new Player(2L, "Sarah", "Doe", "Sahara"),
				new Player(3L, "Emma", "Doe", "Emma Sdoe"));
		final Expansion leaders = new Expansion();
		defaultWonders = Arrays.asList(new Wonder(1L, "Giza", null),
				new Wonder(2L, "Alexandria", null),
				new Wonder(3L, "Olympia", null));
        List<Wonder> expansionWonders = Arrays.asList(new Wonder(4L, "Abu Simbel", leaders),
                new Wonder(5L, "Rome", leaders));
		allWonders = new ArrayList<>(defaultWonders);
		allWonders.addAll(expansionWonders);

		leaders.setId(1L);
		leaders.setName("Leaders");
		leaders.setWonders(new HashSet<>(expansionWonders));
		expansions = List.of(leaders);
	}

	@Test
	void givenNoExpansion_whenGettingAllWonders_thenReturnsDefaultWonders() {
		List<Wonder> wondersInPlay = game.getAllWonders(null);
		verify(wonderRepository, times(1)).findByExpansion(null);
		assertEquals(wondersInPlay, defaultWonders);
	}

	@Test
	void givenAListOfExpansions_whenGettingAllWonders_thenReturnsDefaultAndExpansionWonders() {
		List<Wonder> wondersInPlay = game.getAllWonders(expansions);
		verify(wonderRepository, times(1)).findByExpansion(null);
		assertEquals(wondersInPlay, allWonders);
	}

	@Test
	void givenAListOfPlayersAndWonders_whenDrawingWonders_thenGeneratesAPlayersSizedMap() {
		Map<Player, Wonder> drawMap = game.drawWonders(players, allWonders);
		assertEquals(players.size(), drawMap.size());
	}

	@Test
	void givenAListOfPlayersAndWonders_whenDrawingWonders_thenGeneratesAMapWithAllPlayers() {
		Map<Player, Wonder> drawMap = game.drawWonders(players, allWonders);
		assertEquals(drawMap.keySet(), new LinkedHashSet<>(players));
	}
	@Test
	void givenAListOfPlayersAndWonders_whenDrawingWondersMultipleTimes_thenGeneratesRandomMaps() {
		Map<Player, Wonder> firstDrawMap = game.drawWonders(players, allWonders);
		Map<Player, Wonder> secondDrawMap = game.drawWonders(players, allWonders);
		Map<Player, Wonder> thirdDrawMap = game.drawWonders(players, allWonders);

		assertNotEquals(firstDrawMap, secondDrawMap);
		assertNotEquals(firstDrawMap, thirdDrawMap);
		assertNotEquals(secondDrawMap, thirdDrawMap);
	}

	@Test
	void givenAListOfPlayersAndExpansions_whenDrawingGame_thenGenerateARandomMapOfCombinations() {
		game.draw(players, expansions);
		assertEquals(game.getPlayerWonderMap().size(), players.size());
	}
}
