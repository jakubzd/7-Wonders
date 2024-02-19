-- Insert Expansions
INSERT INTO expansions (name, description, cards_to_add) VALUES
    ('Leaders', 'Introduces leader cards and new strategies.', '4 leader cards per player, keep the stack of all leaders if Abu Simbel or Rome is in play.'),
    ('Cities', 'Expands the game with new city cards and challenges.', 'City cards equal to the amount of players (ex. in a 5 player game add 5 cards for each age).'),
    ('Armada', 'Introduces naval warfare and exploration.', 'Armada cards equal to the amount of players (ex. in a 5 player game add 5 cards for each age).');
-- Default wonders with no expansions
INSERT INTO wonders (id, name, expansion_id) VALUES
    (1, 'Giza', NULL),
    (2, 'Babylon', NULL),
    (3, 'Ephesos', NULL),
    (4, 'Rhodos', NULL),
    (5, 'Alexandria', NULL),
    (6, 'Olympia', NULL),
    (7, 'Halikarnassos', NULL),
-- Wonders from the Leaders expansion (expansion_id = 1)
    (8, 'Abu Simbel', 1),
    (9, 'Rome', 1),
-- Wonders from the Cities expansion (expansion_id = 2)
    (10, 'Byzantium', 2),
    (11, 'Petra', 2),
-- Wonders from the Armada expansion (expansion_id = 3)
    (12, 'Siracusa', 3);