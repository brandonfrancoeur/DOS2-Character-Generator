import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;
import java.io.*;
import java.lang.Object;

public class charGen {
    public static class Data {
        //races
        String[] origins = {"The Red Prince", "Sebille", "Ifan", "Lohse", 
        "Beast", "Fane", "Dwarf", "Human", 
        "Elf", "Lizard", "Undead Dwarf", "Undead Human", 
        "Undead Elf", "Undead Lizard"};
        
      	//Prebuilt classes
        String[] preset_classes = {"Battlemage", "Cleric", "Conjurer", "Enchanter", "Fighter",
        "Inquisitor", "Knight", "Metamorph", "Ranger", "Rogue", 
        "Shadowblade", "Wayfarer", "Witch", "Wizard" };
        
        String[] talents = {"Ambidextrous", "Arrow Recovery", "Comeback Kid", "Demon", "Duck Duck Goose", "Elemental Affinity", "Elemental Ranger", 
        "Escapist", "Executioner", "Far Out Man", "Five-Star Diner", "Glass Cannon", "Guerilla", 
        "Hothead", "Ice King", "Leech", "Living Armour", "Lone Wolf", "Mnemonic", "Morning Person",
        "Opportunist", "Parry Master", "Pet Pal", "Picture of Health", "Savage Sortilege", 
        "Slingshot", "Stench", "The Pawn", "Torturer", "Unstable", "Walk it Off", "What a Rush"};

        //Store the list of possible skills for each Combat Ability
        String[] warfare_skills = {"Bouncing Shield", "Battle Stomp", "Battering Ram", "Crippling Blow"};
        String[] huntsman_skills = {"Elemental Arrowheads", "Pin Down", "Richochet", "First Aid"};
        String[] scoundrel_skills = {"Chloroform", "Throwing Knife", "Backlash", "Adrenaline"};
        String[] pyrokinetic_skills = {"Ignition", "Peace of Mind", "Searing Daggers", "Haste"};
        String[] hydro_skills = {"Amour of Frost", "Hail Strike", "Restoration", "Rain"};
        String[] aero_skills = {"Blinding Radiance", "Electric Discharge", "Favourable Wind", "Shocking Touch"};
        String[] geo_skills = {"Contamination", "Fortify", "Fossil Strike", "Poison Dart"};
        String[] necro_skills = {"Raise Bloated Corpse", "Blood Sucker", "Mosquito Swarm", "Decaying Touch"};
        String[] summ_skills = {"Elemental Totem", "Summon Incarnate", "Dimensional Bolt", "Farsight Infusion"};
        String[] poly_skills = {"Chicken Claw", "Tentacle Lash", "Chameleon Cloak", "Bull Horns"};

        String[] attributes = {"Strength", "Finesse", "Intelligence", "Constitution", "Memory", "Wits"};
        
        String[] combat_abilities = {"Warfare", "Huntsman", "Scoundrel", "Pyrokinetic",
        "Hydrosophist", "Aerothurge", "Geomancer", "Necromancer", "Summoning", "Polymorph"};

        String[] civil_abilities = {"Bartering", "Lucky Charm", "Persuasion", "Loremaster", "Telekinesis", "Sneaking", "Thievery"};
        
        String[] tags = {"Barbarian", "Jester", "Mystic", "Noble", "Outlaw", "Scholar", "Soldier", "No Tag"};

        String[] instruments = {"Bansuri", "Tambura", "Oud", "Cello"};
      
      	String instrument;

        //store the talents
        String Talent1;
        String Talent2;
        String Talent3;
        
        //store the skills
        String skill1;
        String skill2;
        String skill3;

        String tag1;
        String tag2;
        
        //store the preset class if necessary
        String preset;
        
        String origin;
        
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
      
        //hold the skills if they choose to randomize their character
      	String[] skills = null;
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        Data charData = new Data();
        
        System.out.println();
        System.out.println("Welcome to my Divinity: Original Sin 2 Character generator");
        System.out.println("Would you like to use the preset classes?");
        System.out.println("Type Y for Yes and N for No");
        //test that the user's input is valid
      	int goodInput = 0;
        boolean presetClass = false;
        String input;
     	while(goodInput == 0){
      		input = user.nextLine();
            switch(input){
                case "Y":
                    presetClass = true;
            	    goodInput = 1; 
                    break;
                case "y":
                    presetClass = true;
            	    goodInput = 1; 
                    break;
                case "N":
                    presetClass = false;
                    goodInput = 1;
                    break;
                case "n":
                    presetClass = false;
                    goodInput = 1;
                    break;
                default:
                    System.out.println("Invalid input, Type Y for Yes or Type N for No");
                    break;
            }
         }

        //choose a random instrument
        String inst = getRand(charData.instruments);
		charData.instrument = inst;
      
        //get random Origin
        getOrigin(charData);
      
      	//User wants to use a preset class
        if(presetClass){
            //Select a random preset class
            presetClass(charData);
          	generateTags(charData);
        }

      	//User wants to randomize the character
        else if(!presetClass){
            distributeAtts(charData);
            generateCivils(charData);
			generateTags(charData);
          	generateTalent(charData);
            generateSkills(charData);
        }
	
        //print out the results
        System.out.println();
        System.out.println("Here is your randomized character:");
        System.out.println();
        System.out.println("Origin: " + charData.origin);
        
        if(presetClass){
            System.out.println();
            System.out.println("Class: " + charData.preset);
        }
        System.out.println();   
        System.out.println("Talents: " + charData.Talent1 + ", " + charData.Talent2 + ", " + charData.Talent3 );
        System.out.println();
        System.out.println("Tags " + charData.tag1 + ", " + charData.tag2 );
        System.out.println();
        System.out.println("Stats:");
        System.out.println();
       	System.out.println("Strength: " + charData.strength);
        System.out.println("Finesse: " + charData.finesse);
        System.out.println("Intelligence: " + charData.intelligence);
        System.out.println("Constitution: " + charData.constitution);
        System.out.println("Memory: " + charData.memory);
        System.out.println("Wits: " + charData.wits);
        System.out.println();
        System.out.println("Warfare: " + charData.warfare);
        System.out.println("Huntsman: " + charData.huntsman);
        System.out.println("Scoundrel: " + charData.scoundrel);
        System.out.println("Pyrokinetic: " + charData.pyrokinetic);
        System.out.println("Hydrosophist: " + charData.hydrosophist);
        System.out.println("Aerothurge: " + charData.aerothurge);
        System.out.println("Geomancer: " + charData.geomancer);
        System.out.println("Necromancer " + charData.necromancer);
        System.out.println("Summoning: " + charData.summoning);
        System.out.println("Polymorph " + charData.polymorph);      
        System.out.println();  
       	System.out.println("Dual Wielding: " + charData.dual_wielding);
        System.out.println("Ranged: " + charData.ranged);
        System.out.println("Single Handed: " + charData.single_handed);
      	System.out.println("Two Handed: " + charData.two_handed);
        System.out.println("Leadership: " + charData.leadership);
        System.out.println("Perseverance: " + charData.perseverance);
        System.out.println("Retribution: " + charData.retribution);
     	System.out.println();
      	System.out.println("Bartering: " + charData.bartering);
        System.out.println("Lucky Charm: " + charData.lucky_charm);
        System.out.println("Persuasion: " + charData.persuasion);
      	System.out.println("Loremaster: " + charData.loremaster);
        System.out.println("Telekinesis: " + charData.telekinesis);
        System.out.println("Sneaking: " + charData.sneaking);
        System.out.println("Thievery: " + charData.thievery);
     
      	System.out.println();
      	System.out.print("Skills: ");
      
      	if(presetClass){
          System.out.print(charData.skill1 + ", " + charData.skill2 + ", " + charData.skill3);
          System.out.println();
        }
      	else if(!presetClass){
      		System.out.println(Arrays.toString(charData.skills));
        }
        System.out.println();
      	System.out.println("Instrument: " + charData.instrument);
        System.out.println();
    }

    //select a random element from one of the arrays
    public static String getRand(String[] myArray){
       int rand = ThreadLocalRandom.current().nextInt(0, myArray.length);
       return myArray[rand];
    }
    
  	//merge two arrays if required
    public static String[] arrayMerge(String[] array1, String[] array2){
      	int size = array1.length + array2.length;
       	String[] result = new String[size];
      
      	for(int i = 0; i < array1.length; i++){
      		result[i] = array1[i];
        }
      
        for(int i = 0, k = array1.length;k < size && i < array2.length; i++, k++){
        	result[k] = array2[i];  
        }
        return result;
    }
  
  	//Select Random skills from the given attributes
  	public static String[] selectSkills(String[] skillArray){
      String[] skillSet = new String[3];
      
      for(int i = 0; i < 3; i++){
       String skill = getRand(skillArray);
       skillArray = removeElement(skillArray, skill);
       skillSet[i] = skill;
      }
      
      return skillSet;
  	}
 	
  	//Simple remove function
  	public static String[] removeElement(String[] array, String element){
      String newArr[] = null;
      for(int i = 0; i < array.length; i++){
        if(array[i] == element){
           newArr = new String[array.length-1];
           for(int index = 0; index < i; index++){
           		newArr[index] = array[index];	
           }
           for(int j = i; j < array.length-1; j++){
           		newArr[j] = array[j+1];
           }
           break;
        }
      }
      
  	  return newArr;
    }
  
  	//Build a preset class
 	public static void presetClass(Data charData){
   		String preset = getRand(charData.preset_classes);
        switch(preset){
              	case "battlemage":
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
                    break;
                    
                    
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
                    break;
                    
                case "Conjurer":
                    charData.preset = "Conjurer";
                    charData.Talent3 = "Pet Pal";
                    
                    charData.intelligence++;
                    charData.constitution = charData.constitution+2;
                    charData.summoning++;
                    charData.loremaster++;
                    charData.leadership++;
                    
                    charData.skill1 = "Conjure Incarnate";
                    charData.skill2 = "Dimensional Bolt";
                    charData.skill3 = "Elemental Totem";
                    break;
                    
                    
                case "Enchanter":
                    charData.preset = "Enchanter";
                    charData.Talent3 = "Far Out Man";
                    
                    charData.intelligence = charData.intelligence+2;
                    charData.constitution++;
                    charData.hydrosophist++;
                    charData.aerothurge++;
                    charData.loremaster++;
                
                    charData.skill1 = "Electric Discharge";
                    charData.skill2 = "Hail Strike";
                    charData.skill3 = "Rain";
                    break;
                    
                case "Fighter":
                    charData.preset = "Fighter";
                    charData.Talent3 = "Opportunist";
                    
                    charData.strength++;
                    charData.constitution = charData.constitution+2;
                    charData.warfare++;
                    charData.geomancer++;
                    charData.bartering++;
                    
                    charData.skill1 = "Battle Stomp";
                    charData.skill2 = "Bouncing Shield";
                    charData.skill3 = "Fortify";
                    break;
                    
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
                    break;
                    
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
                    break;
                    
                case "Metamorph":
                    charData.preset = "Metamorph";
                    charData.Talent3 = "Opportunist";

                    charData.strength = charData.strength + 2;
          			charData.finesse = charData.finesse + 2;
                    charData.two_handed++;
                    charData.polymorph++;
                    charData.persuasion++;
                    
                    charData.skill1 = "Tentacle Lash";
                    charData.skill2 = "Chiclen Claw";
                    charData.skill3 = "Bull Horns";
                    break;
                    
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
                    break;

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
                    break;
                    
                case "Shadowblade":
                    charData.preset = "Shadowblade";
                    charData.Talent3 = "Guerilla";

                    charData.finesse = charData.finesse + 2;
                    charData.wits = charData.wits + 2;
                    charData.scoundrel++;
                    charData.polymorph++;
                    charData.thievery++;

                    charData.skill1 = "Chameleon Cloak";
                    charData.skill2 = "Backlash";
                    charData.skill3 = "Chicken Claw";
                    break;
                    
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
                    break;

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
                    break;
                    
                case "Wizard":
                    charData.preset = "Wizard";
                    charData.Talent3 = "Far Out Man";
                    
                    charData.intelligence = charData.intelligence + 2;
                    charData.constitution++;
                    charData.pyrokinetic++;
                    charData.loremaster++;

                    charData.skill1 = "Searing Daggers";
                    charData.skill2 = "Fossil Strike";
                    charData.skill3 = "Ignition";
                    break;
            }
  	}
  
  	//Select a random origin
  	public static void getOrigin(Data charData){
    	String ori = getRand(charData.origins);

        switch(ori){
            case "The Red Prince":
                charData.Talent1 = "Spellsong";
                charData.Talent2 = "Sophisticated";
                
                charData.origin = "The Red Prince";
                break;

                    
            case "Sebille":
                charData.Talent1 = "Corpse Eater";
                charData.Talent2 = "Ancestral Knowledge";
                charData.origin = "Sebille";
                break;
                    
            case "Ifan":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Thrifty";
                charData.origin = "Ifan";
                break;

            case "Lohse":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Thrifty";
                charData.origin = "Lohse";
                break;
                
            case "Beast":
                charData.Talent1 = "Sturdy";
                charData.Talent2 = "Dwarven Guile";
                charData.origin = "Beast";
                break;

            case "Fane":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Undead";
                charData.origin = "Fane";
                break;

            case "Dwarf":
                charData.Talent1 = "Sturdy";
                charData.Talent2 = "Dwarven Guile";
                charData.origin = "Dwarf";
                break;

            case "Human":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Thrifty";
                charData.origin = "Human";
                break;
                
            case "Elf":
                charData.Talent1 = "Corpse Eater";
                charData.Talent2 = "Ancestral Knowledge";
                charData.origin = "Elf";
                break;
                
            case "Lizard":
                charData.Talent1 = "Spellsong";
                charData.Talent2 = "Sophisticated";
                charData.origin = "Lizard";
                break;

            case "Undead Dwarf":
                charData.Talent1 = "Sturdy";
                charData.Talent2 = "Undead";
                charData.origin = "Undead Dwarf";
                break;

            case "Undead Human":
                charData.Talent1 = "Ingenious";
                charData.Talent2 = "Undead";
                charData.origin = "Undead Human";
                break;

            case "Undead Elf":
                charData.Talent1 = "Corpse Eater";
                charData.Talent2 = "Undead";
                charData.origin = "Undead Elf";
                break;

            case "Undead Lizard":
                charData.Talent1 = "Sophisticated";
                charData.Talent2 = "Undead";
                charData.origin = "Undead Lizard";
                break;

        }
  	}
  
  	//Randomly select attributes to increment
  	public static void distributeAtts(Data charData){
    	for(int i = 0; i < 3; i++){
                String attribute = getRand(charData.attributes);
                switch (attribute){
                        
                    case "Strength": 
                        charData.strength++;
                        break;
                    
                
                    case "Finesse": 
                        charData.finesse++;
                        break;
                
                    case "Intelligence": 
                        charData.intelligence++;
                        break;
                    
                    case "Constitution": 
                        charData.constitution++;
                        break;
                    
                    case "Memory": 
                        charData.memory++;
                        break;
                    
                    case "Wits": 
                        charData.wits++;
                        break;
                    
                }
            }
            
            //select 2 random combat abilities
            for(int i = 0; i < 2; i++){
                String ability = getRand(charData.combat_abilities);
                switch(ability){
                    case "Warfare": 
                        charData.warfare++;
                        break;

                    case "Huntsman": 
                        charData.huntsman++;
                        break;

                    case "Scoundrel": 
                        charData.scoundrel++;
                        break;

                    case "Pyrokinetic": 
                        charData.pyrokinetic++;
                        break;

                    case "Hydrosophist": 
                        charData.hydrosophist++;
                        break;

                    case "Aerothurge": 
                        charData.aerothurge++;
                        break;

                    case "Geomancer": 
                        charData.geomancer++;
                        break;

                    case "Necromancer": 
                        charData.necromancer++;
                        break;

                    case "Summoning": 
                        charData.summoning++;
                        break;

                    case "Polymorph": 
                        charData.polymorph++;
                        break;

                }
            }
  	}
  
  	//Select random a random civil ability to increment
  	public static void generateCivils(Data charData){
    		String civil = getRand(charData.civil_abilities);
         	String output = civil.substring(0,1).toLowerCase() + civil.substring(1);
            
            switch(output){
                case "bartering": 
                    charData.bartering++;
                    break;
                
                case "lucky_charm": 
                    charData.lucky_charm++;
                    break;
                
                case "persuasion": 
                    charData.persuasion++;
                    break;
                
                case "loremaster": 
                    charData.loremaster++;
                    break;
                
                case "telekinesis": 
                    charData.telekinesis++;
                    break;
                
                case "sneaking": 
                    charData.sneaking++;
                    break;
                
                case "thievery": 
                    charData.thievery++;
                    break;
            }
  	}
  
  	//Select 2 random tags
  	public static void generateTags(Data charData){
    		charData.tag1 = getRand(charData.tags);
            charData.tags = removeElement(charData.tags, charData.tag1);
            charData.tag2 = getRand(charData.tags);
  	}
  
  	//Make sure that the third talent doesn't conflict with anything
  	public static void generateTalent(Data charData){
    	String cont = "false";
            
        while(cont == "false"){
           	  String talent = getRand(charData.talents);
              if(talent == "Demon"){
                if(charData.pyrokinetic >=1){
                  cont = "true";
                }
              }
              if(talent == "Duck Duck Goose"){
                if(charData.huntsman >=1)
                  cont = "true";
              }
              if(talent == "Elemental Ranger"){
                if(charData.huntsman >=1)
                  cont = "true";
              }
              if(talent == "Executioner"){
                if(charData.warfare >=1)
                  cont = "true";
              }
              if(talent == "Guerilla"){
                if(charData.sneaking >=1)
                  cont = "true";
              }
              if(talent == "Ice King"){
                if(charData.hydrosophist >=1)
                  cont = "true";
              }
              if(talent == "Picture of Health"){
                if(charData.warfare >=1)
                  cont = "true";
              }
              if(talent == "The Pawn"){
                if(charData.scoundrel >=1)
                  cont = "true";
              }
             
              charData.Talent3 = talent;
            }
  	}
  
  	//Select random skills based on the character's combat skills
  	public static void generateSkills(Data charData){
    	 String[] array1 = null;
         String[] array2 = null;
            
          
            
            for(int i = 0; i < 2; i++){
                //each if statement checks which attriutes need to be added to the list of possible skills
                if(charData.warfare > 0){
                    
                    
                    if(array1 == null){
                        array1 = charData.warfare_skills;
                    }
                    //If the attribute is leveled to 2, then only one skill array is needed
                    else if(array2 == null && array1 != null && charData.warfare < 2){
                        array2 = charData.warfare_skills;
                    }
                }
              	if(charData.scoundrel > 0){
                    if(array1 == null){
                        array1 = charData.scoundrel_skills;
                    }
                    else if(array2 == null && array1 != null && charData.scoundrel < 2){
                        array2 = charData.scoundrel_skills;
                    }
                }
                if(charData.huntsman > 0){
                    if(array1 == null){
                        array1 = charData.huntsman_skills;
                    }
                    else if(array2 == null && array1 != null && charData.huntsman < 2){
                        array2 = charData.huntsman_skills;
                    }
                }
                if(charData.pyrokinetic > 0){
                    if(array1 == null){
                        array1 = charData.pyrokinetic_skills;
                    }
                    else if(array2 == null && array1 != null && charData.pyrokinetic < 2){
                        array2 = charData.pyrokinetic_skills;
                    }
                }
                if(charData.hydrosophist > 0){
                    if(array1 == null){
                        array1 = charData.hydro_skills;
                    }
                    else if(array2 == null && array1 !=null && charData.hydrosophist < 2){
                        array2 = charData.hydro_skills;
                    }
                }
                if(charData.aerothurge > 0){
                    if(array1 == null){
                        array1 = charData.aero_skills;
                    }
                    else if(array2 == null && array1 !=null && charData.aerothurge < 2){
                        array2 = charData.aero_skills;
                    }
                }
                if(charData.geomancer > 0){
                    if(array1 == null){
                        array1 = charData.geo_skills;
                    }
                    else if(array2 == null && array1 !=null && charData.geomancer < 2){
                        array2 = charData.geo_skills;
                    }
                }
                if(charData.necromancer > 0){
                    if(array1 == null){
                        array1 = charData.necro_skills;
                    }
                    else if(array2 == null && array1 !=null && charData.necromancer < 2){
                        array2 = charData.necro_skills;
                    }
                }
                if(charData.summoning > 0){
                    if(array1 == null){
                        array1 = charData.summ_skills;
                    }
                    else if(array2 == null && array1 !=null && charData.summoning < 2){
                        array2 = charData.summ_skills;
                    }
                }
                if(charData.polymorph > 0){
                    if(array1 == null){
                        array1 = charData.poly_skills;
                    }
                    else if(array2 == null && array1 !=null && charData.polymorph < 2){
                        array2 = charData.poly_skills;
                    }
                }
            }
          
         	//if more than 1 stat is above 0, an array merge is required
          	if(array1 != null && array2 != null){
        		String[] newArray = arrayMerge(array1, array2);
              	charData.skills = selectSkills(newArray);
        	}
            else if(array1 != null && array2 == null){
          		charData.skills = selectSkills(array1);
            }
  	}
   
}