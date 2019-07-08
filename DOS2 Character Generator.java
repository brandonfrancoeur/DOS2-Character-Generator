import java.util.Scanner;

public class charGen {
    public class Data {
        //races
        Array origins = {"The Red Prince", "Sebille", "Ifan", "Lohse", 
        "Beast", "Fane", "Dwarf", "Human", 
        "Elf", "Lizard", "Undead Dwarf", "Undead Human", 
        "Undead Elf", "Undead Lizard"};
        
        Array preset_classes = {"Battlemage", "Cleric", "Conjurer", "Enchanter", "Fighter",
        "Inquisitor", "Knight", "Metamorph", "Ranger", "Rogue", 
        "Shadowblade", "Wayfarer", "Witch", "Wizard" };
        
        Array talents = {"Ambidextrous", "Arrow Recovery", "Comeback Kid", "Demon", "Duck Duck Goose", "Elemental Affinity", "Elemental Ranger", 
        "Escapist", "Executioner", "Far Out Man", "Five-Star Diner", "Glass Cannon", "Guerilla", 
        "Hothead", "Ice King", "Leech", "Living Armour", "Lone Wolf", "Mnemonic", "Morning Person",
        "Opportunist", "Parry Master", "Pet Pal", "Picture of Health", "Savage Sortilege", 
        "Slingshot", "Stench", "The Pawn", "Torturer", "Unstable", "Walk it Off", "What a Rush"};

        //Store the list of possible skills for each Combat Ability
        Array warfare_skills = {"Bouncing Shield", "Battle Stomp", "Battering Ram", "Crippling Blow"};
        Array huntsman_skills = {"Elemental Arrowheads", "Pin Down", "Richochet", "First Aid"};
        Array scoundrel_skills = {"Chloroform", "Throwing Knife", "Backlash", "Adrenaline"};
        Array pyrokinetic_skills = {"Ignition", "Peace of Mind", "Searing Daggers", "Haste"};
        Array hydro_skills = {"Amour of Frost", "Hail Strike", "Restoration", "Rain"};
        Array aero_skils = {"Blinding Radiance", "Electric Discharge", "Favourable Wind", "Shocking Touch"};
        Array geo_skills = {"Contamination", "Fortify", "Fossil Strike", "Poison Dart"};
        Array necro_skills = {"Raise Bloated Corpse", "Blood Sucker", "Mosquito Swarm", "Decaying Touch"};
        Array summ_skills = {"Elemental Totem", "Summon Incarnate", "Dimensional Bolt", "Farsight Infusion"};
        Array poly_skills = {"Chicken Claw", "Tentacle Lash", "Chameleon Cloak", "Bull Horns"};

        Array attributes = {"Strength", "Finesse", "Intelligence", "Constitution", "Memory", "Wits"};
        
        Array combat_abilities = {"Warfare", "Huntsman", "Scoundrel", "Pyrokinetic",
        "Hydrosophist", "Aerothurge", "Geomancer", "Necromancer", "Summoning", "Polymorph"};

        Array civil_abilities = {"Bartering", "Lucky Charm", "Persuasion", "Loremaster", "Telekinesis", "Sneaking", "Thievery"};
        
        Array tags = {"Barbarian", "Jester", "Mystic", "Noble", "Outlaw", "Scholar", "Soldier", "No Tag"};

        Array instruments = {"Bansuri", "Tambura", "Oud", "Cello"};

        //store the talents
        String talent1;
        String talent2;
        String talent3;
        
        String att1;
        String att2;
        String att3;
        
        //store the skills
        String skill1;
        String skill2;
        String skill3;

        String tag1;
        String tag2;
        
        //store the preset class if necessary
        String preset;
        
        
        //store the character's attributes
        int strength = 10;
        int finesse = 10;
        int intelligence = 10;
        int constitution = 10;
        int memory = 10;
        int wits = 10;
        
        //combat abilities
        int dual_wielding = 0;
        int ranged = 0;
        int single_handed = 0;
        int two_handed = 0;
        int leadership = 0;
        int perseverance = 0;
        int retribution = 0;

        int warfare = 0;
        int huntsman = 0;
        int scoundrel = 0;
        int pyrokinetic = 0;
        int hydrosophist = 0;
        int aerothurge = 0;
        int geomancer = 0;
        int necromancer = 0;
        int summoning = 0;
        int polymorph = 0;

        //civil abilities
        int bartering = 0;
        int lucky_charm = 0;
        int persuasion = 0;
        int loremaster = 0;
        int telekinesis = 0;
        int sneaking = 0;
        int thievery = 0;
    }

    public void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Data charData = new Data();
        boolean cont = false;

        System.out.println("Welcome to my Divinity: Original Sin 2 Character generator");
        
        while(cont == false){
            System.out.println("Would you like to use the preset classes? Type Y for Yes and N for No");
            String ans = user.nextLine();
            if(ans == "Y" || ans == "N"){
                cont = true;
            }
        }

        String instrument = getRand(charData.Instruments);

        //get random Origin
        String ori = getRand(charData.origins);
        switch(ori){
            case "The Red Prince":
                charData.Talent1 = "Spellsong";
                charData.Talent2 = "Sophisticated";
                charData.Talent3 = "Spellsong";
                
                //Make sure that the third Talent doesn't equal either of the others
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
                    
            case "Sebille":
                charData.Talent1 = "Corpse Eater";
                charData.Talent2 = "Ancestral Knowledge";
                charData.Talent3 = "Corpse Eater";
                
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
                    
            case "Ifan":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Thrifty";
                charData.Talent3 = "Ingenious";
                
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
                    
            case "Lohse":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Thrifty";
                charData.Talent3 = "Ingenious";
                
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
            case "Beast":
                charData.Talent1 = "Sturdy";
                charData.Talent2 = "Dwarven Guile";
                charData.Talent3 = "Sturdy";
                
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
            case "Fane":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Undead";
                charData.Talent3 = "Undead";
                
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
                
            case "Dwarf":
                charData.Talent1 = "Sturdy";
                charData.Talent2 = "Dwarven Guile";
                charData.Talent3 = "Sturdy";
                
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
            case "Human":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Thrifty";
                charData.Talent3 = "Ingenious";
                
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
            case "Elf":
                charData.Talent1 = "Corpse Eater";
                charData.Talent2 = "Ancestral Knowledge";
                charData.Talent3 = "Corpse Eater";
                    
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
            case "Lizard":
                charData.Talent1 = "Spellsong";
                charData.Talent2 = "Sophisticated";
                charData.Talent3 = "Spellsong";
                    
                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
            case "Undead Dwarf":
                charData.Talent1 = "Sturdy";
                charData.Talent2 = "Undead";
                charData.Talent3 = "Undead";

                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
        
            case "Undead Human":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Undead";
                charData.Talent3 = "Undead";

                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
        
            case "Undead Elf":
                charData.Talent1 = "Corpse Eater";
                charData.Talent2 = "Undead";
                charData.Talent3 = "Undead";

                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
        
            case "Undead Lizard":
                charData.Talent1 = "Sophisticated";
                charData.Talent2 = "Undead";
                charData.Talent3 = "Undead";

                while (charData.Talent3 == charData.Talent1 || charData.Talent3 == charData.Talent2){
                    charData.Talent3 = getRand(charData.talents);
                }
        
        }
    
        if(ans = "Y"){
        
            //Select a random preset class
            String preset = getRand(charData.presetClasses);
            switch(preset){
                case "Battlemage":
                    charData.preset = "Battlemage";
                    charData.Talent3 = "Comeback Kid";
                
                    charData.strength++;
                    charData.intelligence++;
                    charData.constitution++;
                    charData.aerothurge++;
                    charData.warfare++;
                    charData.persuasion++;
                
                    charData.skill1 = "Blinding Radiance";
                    charData.skill2 = "Shocking Touch";
                    charData.skill3 = "Battering Ram";

                    
                    
                case "Cleric":
                    charData.preset = "Cleric";
                    charData.Talent3 = "Hothead";
                    
                    charData.strength++;
                    charData.intelligence++;
                    charData.constitution++;
                    charData.hydrosophist++;
                    charData.necromancer++;
                    charData.bartering++;
                    
                    charData.skill1 = "Decaying Touch";
                    charData.skill2 = "Restoration";
                    charData.skill3 = "Blood Sucker";
                    
                case "Conjurer":
                    charData.preset = "Conjurer";
                    charData.Talent3 = "Pet Pal";
                    
                    charData.intelligence++;
                    chardata.constitution = charData.constitution+2;
                    charData.summoning++;
                    charData.loremaster++;
                    charData.leadership++;
                    
                    charData.skill1 = "Conjure Incarnate";
                    charData.skill2 = "Dimensional Bolt";
                    charData.skill3 = "Elemental Totem";
                    
                    
                case "Enchanter":
                    charData.preset = "Enchanter";
                    charData.Talent3 = "Far Out Man";
                    
                    charData.intelligence = chardata.intelligence+2;
                    charData.constitution++;
                    charData.hydrosophist++;
                    charData.aerothurge++;
                    charData.loremaster++;
                
                    charData.skill1 = "Electric Discharge";
                    charData.skill2 = "Hail Strike";
                    charData.skill3 = "Rain";
                    
                case "Fighter":
                    charData.preset = "Fighter";
                    charData.Talent3 = "Opportunist";
                    
                    charData.strength++;
                    charData.constitution = chardata.constitution+2;
                    charData.warfare++;
                    charData.geomancer++;
                    charData.bartering++;
                    
                    charData.skill1 = "Battle Stomp";
                    charData.skill2 = "Bouncing Shield";
                    charData.skill3 = "Fortify";
                    
                case "Inquisitor":
                    charData.preset = "Inquisitor";
                    charData.Talent3 = "Executioner";

                    charData.strength++;
                    charData.intelligence++;
                    charData.constitution++;
                    charData.warfare++;
                    charData.necromancer++;
                    charData.telekinesis++;
                    
                    charData.skill1 = "Blood Sucker";
                    charData.skill2 = "Battering Ram";
                    charData.skill3 = "Mosquito Swarm";    
                    
                case "Knight":
                    charData.preset = "Knight";
                    charData.Talent3 = "Opportunist";

                    charData.strength = charData.strength + 2;
                    charData.constitution++;
                    charData.warfare++;
                    charData.two_handed++;
                    charData.bartering++;

                    charData.skill1 = "Battering Ram";
                    charData.skill2 = "Crippling Blow";
                    charData.skill3 = "Battle Stomp";
                    
                case "Metamorph":
                    charData.preset = "Metamorph";
                    charData.Talent3 = "Opportunist";

                    charData.strength = charData.strength + 2;
                    charData.two_handed++;
                    charData.polymorph++;
                    charData.persuasion++;
                    
                    charData.skill1 = "Tentacle Lash";
                    charData.skill2 = "Chiclen Claw";
                    charData.skill3 = "Bull Horns";
                case "Ranger":
                    charData.preset = "Ranger";
                    charData.Talent3 = "Arrow Recovery";

                    charData.finesse = charData.finesse + 2;
                    charData.wits++;
                    charData.huntsman++;
                    charData.pyrokinetic++;
                    charData.lucky_charm++;

                    charData.skill1 = "Richochet";
                    charData.skill2 = "Peace of Mind";
                    charData.skill3 = "Elemental Arrowheads";

                case "Rogue":
                    charData.preset = "Rogue";
                    charData.Talent3 = "The Pawn";

                    charData.finesse = charData.finesse + 2;
                    charData.constitution++;
                    charData.scoundrel++;
                    charData.sneaking++;
                    charData.dual_wielding++;

                    charData.skill1 = "Throwing Knife";
                    charData.skill2 = "Backlash";
                    charData.skill3 = "Adrenaline";
                    
                case "Shadowblade":
                    charData.preset = "Shadowblade";
                    charData.Talent3 = "Guerilla";

                    charData.finesse = charData.finesse + 2;
                    charData.wits = charData.wis + 2;
                    charData.scoundrel++;
                    charData.Polymorph++;
                    charData.thievery++;

                    charData.skill1 = "Chameleon Cloak";
                    charData.skill2 = "Backlash";
                    charData.skill3 = "Chicken Claw";
                    
                case "Wayfarer":
                    charData.preset = "Wayfarer";
                    charData.Talent3 = "Pet Pal";
                    
                    charData.finesse = charData.finesse + 2;
                    charData.intelligence++;
                    charData.huntsman++;
                    charData.geomancer++;
                    charData.bartering++;

                    charData.skill1 = "Pin Down";
                    charData.skill2 = "Fossil Strike";
                    charData.skill3 = "Elemental Arrowheads";

                case "Witch":
                    charData.preset = "Witch";
                    charData.Talent3 = "Leech";
                    
                    charData.finesse++;
                    charData.intelligence++;
                    charData.constitution++;
                    charData.scoundrel++;
                    charData.necromancer++;
                    charData.persuasion++;

                    charData.skill1 = "Raise Bloated Corpse";
                    charData.skill2 = "Chloroform";
                    charData.skill3 = "Mosquito Swarm";
                    
                case "Wizard":
                    charData.preset = "Wizard";
                    charData.Talent3 = "Far Out Man";
                    
                    charData.intelligence = chardata.intelligence + 2;
                    charData.constitution++;
                    charData.pyrokinetic++;
                    charData.loremaster++;

                    charData.skill1 = "Searing Daggers";
                    charData.skill2 = "Fossil Strike";
                    charData.skill3 = "Ignition";
            }

        }

        else if(ans == "N"){
            for(int i = 0; i < 3; i++){
                String attribute = getRand(charData.Attributes);
                switch (attribute){
                        
                    case "strength": charData.strength++;
                
                    case "finesse": charData.finesse++;
                
                    case "intelligence": charData.intelligence++;
                    
                    case "constitution": charData.constitution++;
                    
                    case "memory": charData.memory++;
                    
                    case "wits": charData.wits++;
                    
                }
            }

            for(int i = 0; i < 2; i++){
                String ability = getRand(charData.combat_abilities);
                switch(ability){
                    case "Warfare": charData.warfare++;

                    case "Huntsman": charData.huntsman++;

                    case "Scoundrel": charData.scoundrel++;

                    case "Pyrokinetic": charData.pyrokinetic++;

                    case "Hydrosophist": charData.hydrosophist++;

                    case "Aerothurge": charData.aerothurge++;

                    case "Geomancer": charData.geomancer++;

                    case "Necromancer": charData.necromancer++;

                    case "Summoning": charData.summoning++;

                    case "Polymorph": charData.polymorph++;

                }
            }

            String civil = getRand(charData.civil_abilities);
            String output = civil.substring(0,1).toLowerCase() + civil.substring(1);
            System.out.println(output);

            charData.output++;
            //maybe need switch statement
        
            //might not work right
            charData.tag1 = getRand(charData.tags);
            if(tag1 != "No Tag"){
                charData.tags = ArrayUtils.removeElement(tags, tag1);
            }

            charData.tag2 = getRand(charData.tags);

            //TODO: check that the talents don't conflict

        }
        //TODO: print out the results

    }
    


    public String getRand(String[] array){
        int rand = new Random().nextInt(array.length);
        return array[rnd];
    }

}
