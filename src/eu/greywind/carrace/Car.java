package eu.greywind.carrace;

import java.util.Random;

class Car extends Vehicle {
    private int normalSpeed, actualSpeed;

    Car() {
        this.name = generateName() + " " + generateName();
        this.type = "Car";
        this.distanceTraveled = 0;
        this.normalSpeed = generateSpeed();
        this.actualSpeed = normalSpeed;
    }

    private int generateSpeed() {
        Random rnd = new Random();
        return rnd.nextInt(31) + 80;
    }

    private String generateName() {
        Random rnd = new Random();
        String[] carNames = {"Blast","Hollow","Wolf","Fang","Eagle","Blade","Adventure","Aeon","Alabaster","Albatross",
                             "Apex","Astral","Augury","Aura","Aurora","Avalanche","Baron","Barrage","Basilisk",
                             "Behemoth","Blaze","Blend","Bliss","Blitz","Blizzard","Bolt","Buffalo","Bullet","Capital",
                             "Catalyst","Celestial","Centaur","Centurion","Charm","Chase","Climax","Cobra","Conqueror",
                             "Corsair","Cosmos","Crest","Crown","Crusader","Crux","Curiosity","Dawn","Daydream",
                             "Deputy","Desire","Dominion","Dragon","Dusk","Dynamics","Dynamo","Elysium","Eminence",
                             "Empire","Empyrean","Encounter","Enigma","Eon","Eos","Epiphany","Epitome","Escape",
                             "Essence","Eternity","Ethereal","Evolution","Excursion","Expedition","Falcon","Ferocity",
                             "Fire","Flow","Flux","Formula","Fragment","Freedom","Gallop","Grit","Guardian","Guerrilla",
                             "Harmony","Heirloom","Hero","Hydra","Icon","Inception","Inferno","Inquiry","Instinct",
                             "Intro","Ivory","Jazz","Legacy","Legend","Liberty","Lightning","Lioness","Magic","Majesty",
                             "Mammoth","Marvel","Mastery","Meridian","Method","Might","Millennium","Mirage","Momentum",
                             "Moonlight","Morale","Motion","Motive","Mystery","Mythic","Nebula","Nimbus","Obsidian",
                             "Olympian","Onyx","Oracle","Orbit","Origin","Paladin","Paradox","Paragon","Parallel",
                             "Passion","Patron","Phantom","Phenomenon","Pinnacle","Portrait","Presence","Prestige",
                             "Prime","Prodigy","Prophecy","Prospect","Pulse","Purity","Pyre","Quest","Quicksilver",
                             "Radiance","Ranger","Raven","Reach","Realm","Reflect","Renegade","Resolve","Revelation",
                             "Roamer","Rune","Sanctuary","Scorpion","Scout","Serpent","Shadow","Silver","Sliver",
                             "Specter","Spire","Spirit","Spotlight","Sprite","Stardust","Starlight","Storm","Striker",
                             "Supremacy","Surge","Symbol","Tarragon","Temper","Temperament","Tempest","Thriller",
                             "Thunder","Tigress","Titan","Tracer","Tradition","Trailblazer","Treasure","Triumph",
                             "Twister","Umbra","Union","Universe","Utopia","Vagabond","Vanish","Vertex","Vigor",
                             "Vindicator","Viper","Virtue","Vision","Vortex","Voyage","Vulture","Warrior","Whim",
                             "Whirlpool","Wish","Zeal"};
        return carNames[rnd.nextInt(carNames.length)];
    }

    void moveForAnHour() {
        distanceTraveled += actualSpeed;
    }

    void limitSpeed() {
        actualSpeed = 70;
    }

    void setNormalSpeed() {
        actualSpeed = normalSpeed;
    }
}
