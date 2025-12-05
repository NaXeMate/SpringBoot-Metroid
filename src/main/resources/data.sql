-- ===================================
-- POWER SUIT
-- ===================================
INSERT INTO power_suit (name, installation_date, energy_tanks, reserve_tanks, current_energy, max_energy, heat_resistance, radiation_resistance) VALUES 
('Varia Suit', '2025-11-15', 3, 1, 297, 297, TRUE, FALSE);


-- ===================================
-- UPGRADES - Without requirements
-- ===================================
INSERT INTO upgrades (name, upgrade_class, description, energy_type, tech_origin, required_upgrade_id, power_suit_id) VALUES
('Morph Ball', 'MORPH_BALL', 'Allows Samus to compress herself into a small ball form to navigate tight spaces.', 'NONE', 'CHOZO', NULL, 1),
('Scan Pulse', 'MISC', 'Emits a pulse that reveals hidden objects and enemies in the surroundings.', 'AEION', 'CHOZO', NULL, 1),
('Missile Launcher', 'MISC', 'Enables Samus to fire missiles as a secondary weapon for increased damage against enemies and obstacles.', 'POWER', 'UNKNOWN', NULL, 1),
('Charge Beam', 'BEAM', 'Allows Samus to charge her beam for a more powerful shot. It can combine it with missiles for creating Recharge Combos.', 'POWER', 'CHOZO', NULL, 1),
('Phantom Cloak', 'SUIT', 'Enables Samus to momentarily become invisible, allowing her to evade enemy detection and bypass security systems.', 'AEION', 'CHOZO', NULL, 1),
('Ice Beam', 'BEAM', 'Fires freezing projectiles that can immobilize enemies freeze some surfaces.', 'ICE', 'CHOZO', NULL, 1),
('Lighting Armor', 'SUIT', 'Provides an enhanced protection against biological threats and electrical hazards.', 'AEION', 'CHOZO', NULL, 1),
('High Jump Boots', 'SUIT', 'Increases the height that Samus can reach while jumping.', 'NONE', 'CHOZO', NULL, 1),
('Varia Suit', 'SUIT', 'Provides protection against extreme heat and reduces damage from enemies.', 'NONE', 'CHOZO', NULL, 1),
('Dark Visor', 'VISOR', 'Enables Samus to see objects and life forms in Dark Aether, revealing hidden enemies and transdimensional objects.', 'DARK', 'LUMINOTH', NULL, 1),
('Wave Beam', 'BEAM', 'Fires projectiles that can pass through walls and obstacles and paralyze enemies. It can also activate electric mecanisms', 'ELECTRIC', 'CHOZO', NULL, 1),
('Beam Burst', 'BEAM', 'It gives the equipped beam a surplus of power to shoot it with maximum cadence and firepower for a short period of time.', 'AEION', 'CHOZO', NULL, 1),
('Grapple Beam', 'MISC', 'Use a very specific electric frequency to fire a beam with adherent properties that allows Samus to latch onto specific points and swing across gaps or pull objects.', 'ELECTRIC', 'CHOZO', NULL, 1),
('Light Beam', 'BEAM', 'Fires concentrated light energy that can blind enemies and illuminate dark areas.', 'LIGHT', 'LUMINOTH', NULL, NULL),
('Flash Shift', 'MISC', 'Enables Samus to teleport a short distance in the direction she is moving, allowing her to evade attacks and reach otherwise inaccessible areas.', 'AEION', 'CHOZO', NULL, NULL),
('Spazer Beam', 'BEAM', 'Fires three separate beams simultaneously, increasing the chances of hitting targets and dealing more damage.', 'POWER', 'CHOZO', NULL, 1),
('Thermal Visor', 'VISOR', 'Allows Samus to see heat signatures, revealing hidden enemies and objects in the environment.', 'THERMAL', 'SPACE_PIRATES', NULL, NULL),
('Speed Booster', 'MISC', 'Grants Samus the ability to run at incredible speeds, allowing her to break through certain barriers and enemies. She also can perform a technique called "Shinespark" to traverse large distances quickly.', 'NONE', 'CHOZO', NULL, NULL),
('Plasma Beam', 'BEAM', 'A powerful beam that deals significant damage and can penetrate most enemy shields and traverse through multiple enemies with only one shot.', 'THERMAL', 'CHOZO', NULL, NULL),
('X Ray Visor', 'VISOR', 'Enables Samus to see through walls and other solid objects, revealing hidden passages and enemies.', 'NONE', 'CHOZO', NULL, NULL),
('Eco Visor', 'VISOR', 'Allows Samus to detect life forms through the sounds they make in the environment', 'NONE', 'LUMINOTH', NULL, NULL);


-- ===================================
-- UPGRADES - With requirements
-- ===================================
INSERT INTO upgrades (name, upgrade_class, description, energy_type, tech_origin, required_upgrade_id, power_suit_id) VALUES
('Bomb', 'MORPH_BALL', 'Allows Samus to drop bombs while she is in Morph Ball form to damage enemies and destroy certain obstacles.', 'POWER', 'CHOZO', 1, 1),
('Spider Ball', 'MORPH_BALL', 'Grants Samus the ability to cling to and climb through magnetic surfaces.', 'NONE', 'CHOZO', 1, 1),
('Spring Ball', 'MORPH_BALL', 'Allows Samus to jump while she is in Morph Ball form.', 'NONE', 'CHOZO', 1, 1),
('PDP Suit', 'SUIT', 'Provides Samus the ability to enter in Hiper-Mode, injecting Phazon into an energy tank to obtain highly increased offensive capabilities.', 'PHAZON', 'GALACTIC_FEDERATION', 9, 1),
('Diffusion Beam', 'BEAM', 'Fires a wide spread of energy projectiles, increasing the area of effect and making it easier to hit multiple targets.', 'NONE', 'CHOZO', 4, 1),
('Ice Missile', 'MISC', 'An upgraded version of the standard missile that freezes enemies upon impact, making them easier to defeat.', 'ICE', 'CHOZO', 3, 1),
('Dark Beam', 'BEAM', 'Fires projectiles infused with Ing energy that can weaken enemy defenses and freeze them.', 'DARK', 'LUMINOTH', 6, 1),
('Super Missile', 'MISC', 'An upgraded version of the standard missile that deals more damage to enemies and obstacles.', 'POWER', 'UNKNOWN', 3, 1),
('Hiper-Ball', 'MORPH_BALL', 'An enhanced-with-Phazon version of the Morph Ball that allows Samus to expel Phazon rays and damage enemies around him.', 'PHAZON', 'UNKNOWN', 1, NULL),
('Space Jump Boots', 'SUIT', 'Allows Samus to perform multiple mid-air jumps, so she could reach higher platforms and navigate through vertical areas.', 'NONE', 'CHOZO', 8, 1),
('Gravity Suit', 'SUIT', 'Provides enhanced mobility and protection in underwater environments, reducing damage from enemies and allowing Samus to move freely in a liquid-type ambience.', 'NONE', 'CHOZO', 9, 1),
('Light Suit', 'SUIT', 'A lightweight suit that provides Samus with the ability to travel across Light Aether temples.', 'LIGHT', 'LUMINOTH', 7, NULL),
('Nova Beam', 'BEAM', 'Fires a concentrated beam of energy that can penetrate phazite and other defenses.', 'THERMAL', 'CHOZO', 19, NULL);


-- ===================================
-- UPGRADES - With advanced requirements
-- ===================================
INSERT INTO upgrades (name, upgrade_class, description, energy_type, tech_origin, required_upgrade_id, power_suit_id) VALUES
('Seeker Missile', 'MISC', 'An advanced missile that homes in on targets, making it easier to hit moving enemies.', 'POWER', 'CHOZO', 28, NULL),
('Phase Drift', 'MISC', 'Enables Samus to briefly shift into an alternate dimension, allowing her to pass through certain obstacles and avoid enemy attacks.', 'AEION', 'CHOZO', 18, NULL),
('Screw Attack', 'MISC', 'An advanced ability that allows Samus to perform a spinning attack while jumping, damaging enemies on contact and breaking certain obstacles.', 'POWER', 'CHOZO', 30, NULL),
('Power Bomb', 'MORPH_BALL', 'A very powerful bomb that creates a large explosion, damaging all enemies and obstacles within its radius.', 'POWER', 'CHOZO', 22, NULL),
('Hiper-Missile', 'MISC', 'An upgraded version of the Super Missile that deals massive damage to enemies and obstacles.', 'PHAZON', 'UNKNOWN', 25, NULL),
('Phazon Suit', 'SUIT', 'Provides Samus with enhanced protection against blue Phazon contamination and increases her overall durability.', 'PHAZON', 'SPACE_PIRATES', 31, NULL);


-- ===================================
-- REGIONS
-- ===================================
INSERT INTO regions (name, planet, biome, difficulty_level, climate, exploration_percentage, latitude, altitude, longitude) VALUES
('Brinstar', 'ZEBES', 'FOREST', 3, 'TROPICAL', 75.5, -12.34, 250, 45.67),
('Norfair', 'ZEBES', 'VOLCANIC', 7, 'ARID', 60.2, -25.67, 500, 78.90),
('Crateria', 'ZEBES', 'UNDERGROUND', 4, 'TEMPERATE', 80.1, -5.89, 300, 33.21),
('Chozodia', 'ZEBES', 'RUINS', 6, 'TEMPERATE', 40.0, -22.45, 700, 110.56),
('Lower Brinstar', 'ZEBES', 'FOREST', 5, 'TROPICAL', 65.0, -10.11, 200, 55.43),
('Kraid', 'ZEBES', 'CAVERNS', 6, 'TEMPERATE', 45.8, -18.22, 400, 88.76),
('Ridley', 'ZEBES', 'VOLCANIC', 8, 'ARID', 30.5, -28.33, 600, 99.99),
('Maridia', 'ZEBES', 'CAVERNS', 8, 'CONTINENTAL', 50.0, -30.12, -100, 120.45),
('Wrecked Ship', 'ZEBES', 'RADIOACTIVE', 6, 'TEMPERATE', 40.3, -15.78, 0, 90.12),
('Tourian', 'ZEBES', 'UNDERGROUND', 9, 'TEMPERATE', 70.4, -20.45, 150, 60.78),
('Tallon Surface', 'TALLON_IV', 'FOREST', 4, 'CONTINENTAL', 85.0, 10.34, 100, -45.67),
('Chozo Ruins', 'TALLON_IV', 'RUINS', 6, 'ARID', 55.5, 15.67, 200, -78.90),
('Magmoor Caverns', 'TALLON_IV', 'VOLCANIC', 7, 'ARID', 40.2, 25.89, 300, -33.21),
('Phendrana Drifts', 'TALLON_IV', 'ARTIC', 5, 'POLAR', 65.1, 5.45, 400, -110.56),
('Phazon Mines', 'TALLON_IV', 'RADIOACTIVE', 8, 'CONTINENTAL', 35.0, 18.11, 500, -55.43),
('Impact Crater', 'TALLON_IV', 'RADIOACTIVE', 9, 'ARID', 25.8, 22.22, 600, -88.76),
('Surface', 'SR_388', 'UNDERGROUND', 3, 'CONTINENTAL', 90.5, -35.33, 50, 10.99),
('Sector 1', 'SR_388', 'UNDERGROUND', 4, 'CONTINENTAL', 80.0, -30.12, 100, 20.88),
('Sector 2', 'SR_388', 'CAVERNS', 5, 'TEMPERATE', 70.5, -25.67, 150, 30.77),
('Sector 3', 'SR_388', 'VOLCANIC', 5, 'ARID', 60.2, -20.45, 200, 40.66),
('Sector 4', 'SR_388', 'CAVERNS', 6, 'TEMPERATE', 50.1, -15.78, 250, 50.55),
('Sector 5', 'SR_388', 'FOREST', 7, 'CONTINENTAL', 40.0, -10.11, 300, 60.44),
('Sector 6', 'SR_388', 'ARTIC', 7, 'POLAR', 30.5, -5.89, 350, 70.33),
('Sector 7', 'SR_388', 'RUINS', 8, 'CONTINENTAL', 20.8, -2.34, 400, 80.22),
('Sector 8', 'SR_388', 'CAVERNS', 8, 'ARID', 15.6, 0.00, 450, 90.11);


-- ===================================
-- ENEMIES
-- ===================================
INSERT INTO enemies (name, enemy_class, description, health_points, attack_power, speed, danger_level) VALUES
('Zoomer', 'COMMON', 'Small, fast-moving creatures that crawl on walls and ceilings, often found in large numbers.', 20, 5, 15, 1),
('Hornoad', 'COMMON', 'Amphibious enemies that leap out of water to attack Samus with their powerful jaws.', 30, 10, 15, 2),
('Shriekbat', 'COMMON', 'Bat-like creatures that emit loud screeches to disorient Samus and attack in swarms.', 5, 5, 30, 2),
('Ripper', 'COMMON', 'Small, insect-like enemies that swarm Samus and attempt to latch onto her suit to drain energy.', 1, 5, 20, 1),
('Limer', 'COMMON', 'A variant of the Zoomer that has a tougher exoskeleton and deals more damage.', 30, 10, 15, 2),
('Reptilicus', 'COMMON', 'A large, reptilian enemy known for its powerful attacks and resilience.', 40, 40, 20, 4),
('Anficanis', 'COMMON', 'A canine-like creature that hunts in packs and uses coordinated attacks to overwhelm Samus.', 35, 30, 25, 4),
('Space Pirate', 'COMMON', 'One of the standard foot soldiers of the Space Pirate forces, equipped with basic weaponry and armor.', 50, 25, 15, 4),
('Magmoor', 'COMMON', 'Lava-dwelling creatures that can hurl fireballs at Samus and are resistant to heat-based attacks.', 45, 20, 10, 3),
('Metroid', 'COMMON', 'Parasitic organisms that latch onto Samus and drain her energy. They can evolve into more dangerous forms if not dealt with quickly. Very weak to low temperatures.', 60, 15, 10, 6),
('Space Pirate Captain', 'ELITE', 'A higher-ranking Space Pirate with enhanced combat skills and better equipment.', 65, 40, 20, 5),
('Chozo Phantom', 'ELITE', 'A sepectral Chozo warrior contaminated by Phazon, capable of powerful energy attacks and teleportation.', 70, 50, 30, 6),
('Diorimu', 'MINI_BOSS', 'A large, insect-like creature that can burrow underground and launch surprise attacks on Samus.', 80, 40, 40, 6),
('Imago', 'MINI_BOSS', 'A flying creature that attacks Samus with powerful wind gusts and energy projectiles.', 85, 50, 50, 7),
('Serris', 'BOSS', 'A large, serpentine and marine creature that can use a biological version of the Speed Booster to attack its preys', 95, 60, 100, 7),
('Flaahgra', 'BOSS', 'A plant-like creature that uses its tentacles to ensnare Samus and drain her energy while unleashing powerful energy attacks.', 120, 70, 10, 8),
('Kraid', 'BOSS', 'A massive, reptilian creature that lives in the caverns of Zebes. It attacks launching its body parts, which can regenerate over time.', 300, 50, 5, 8),
('Omega Pirate', 'BOSS', 'The most powerful type of Space Pirate, equipped with advanced weaponry and armor, and infused with Phazon. It can activate a camouflage device for stealth and surprise attacks.', 400, 60, 30, 9),
('Dark Samus', 'FINAL_BOSS', 'A formidable foe created from the remains of Samus Aran infused with Phazon, possessing many of her abilities and a relentless drive to destroy her.', 500, 70, 40, 10),
('Ridley', 'FINAL_BOSS', 'The ruthless leader of the Space Pirates, a dragon-like creature known for its cunning and brutality in battle. It is the nemesis of Samus Aran.', 550, 80, 60, 10),
('Meta Ridley', 'FINAL_BOSS', 'A cybernetically enhanced version of Ridley, equipped with advanced weaponry and armor, making it an even more dangerous adversary for Samus.', 600, 90, 50, 10),
('Omega Ridley', 'FINAL_BOSS', 'An even more powerful version of Meta Ridley, further enhanced with Phazon and advanced technology, making it a nearly unstoppable force.', 700, 95, 70, 10),
('Proteus Ridley', 'FINAL_BOSS', 'The ultimate form of Ridley, making it a fusion of organic and cybernetic, equiped with the most advanced weaponry and abilities.', 800, 100, 80, 10);

-- ===================================
-- REGION_ENEMY
-- ===================================
INSERT INTO region_enemy (region_id, enemy_id, number_defeated, spawn_frequency) VALUES

(1, 1, 50, 10),  
(1, 4, 45, 9),   
(1, 5, 30, 7),   
(1, 8, 15, 5),   

(2, 9, 40, 8),   
(2, 6, 20, 6),   
(2, 8, 25, 7),   
(2, 11, 10, 4),  

(3, 1, 35, 8),   
(3, 3, 40, 9),   
(3, 8, 20, 6),   

(4, 8, 30, 8),  
(4, 11, 15, 5), 
(4, 12, 5, 3),   

(5, 1, 60, 10), 
(5, 5, 40, 8),  
(5, 13, 3, 2),   

(6, 6, 25, 7),  
(6, 17, 1, 1),   

(7, 9, 35, 8),   
(7, 8, 20, 6),  
(7, 20, 1, 1),   

(8, 2, 30, 8),   
(8, 7, 15, 5),   

(9, 3, 50, 9),   
(9, 4, 40, 8),   
(9, 12, 8, 4),   

(10, 10, 20, 6),
(10, 8, 30, 7),  
(10, 11, 12, 5),

(11, 1, 40, 8),  
(11, 3, 35, 7), 
(11, 7, 10, 4),  

(12, 1, 45, 9),  
(12, 12, 10, 4), 
(12, 8, 25, 6),  
(12, 16, 1, 1),  

(13, 9, 50, 9),  
(13, 6, 20, 6), 
(13, 8, 15, 5), 

(14, 3, 30, 7),  
(14, 8, 20, 6),  
(14, 11, 10, 4), 

(15, 8, 40, 8),  
(15, 11, 25, 7), 
(15, 18, 1, 1),  
(15, 12, 15, 5), 

(16, 10, 15, 5), 
(16, 21, 1, 1),  
(16, 12, 10, 4), 

(17, 2, 40, 8),  
(17, 1, 35, 7),  

(18, 10, 25, 6), 
(18, 2, 30, 7),  
(18, 14, 2, 2),  

(19, 10, 30, 7), 
(19, 4, 25, 6),  

(20, 9, 35, 8),  
(20, 10, 20, 6), 

(21, 10, 35, 8), 
(21, 7, 15, 5),  
(21, 15, 1, 1),  

(22, 10, 40, 8), 
(22, 1, 30, 7),  

(23, 10, 35, 7), 
(23, 3, 25, 6),  

(24, 10, 45, 9), 
(24, 12, 12, 4), 

(25, 10, 50, 10),
(25, 19, 1, 1); 


--- ===================================
-- REGION_UPGRADE
-- ===================================
INSERT INTO region_upgrade (region_id, upgrade_id) VALUES
(1, 1),   
(1, 3),   
(1, 22),  

(2, 9),   
(2, 6),   
(2, 31),  

(3, 22),  
(3, 8),

(4, 25),
(4, 31),

(5, 23),
(5, 27),

(6, 9),

(7, 16),

(8, 31),
(8, 24),

(9, 5),

(10, 37),

(11, 2),
(11, 13),

(12, 1),
(12, 4),
(12, 22),
(12, 30),

(13, 19),
(13, 26),

(14, 17),
(14, 11),
(14, 31),

(15, 25),
(15, 37),
(15, 39),

(16, 39),

(17, 8),

(18, 4),
(18, 27),

(19, 23),

(20, 6),

(21, 18), 
(21, 31), 

(22, 3),
(22, 29),

(23, 14),
(23, 32),

(24, 10),
(24, 28),

(25, 34),
(25, 36);
