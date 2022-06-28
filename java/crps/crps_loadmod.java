package crps;

import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.ObjectRegistry;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.engine.registries.TileRegistry;
import necesse.inventory.item.toolItem.ToolType;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necesse.level.gameObject.WallObject;
import necesse.level.gameObject.furniture.*;
import necesse.level.gameTile.SimpleFloorTile;

import java.awt.*;



@ModEntry
public class crps_loadmod {
    public void init() {
        System.out.println("Carpenter's Salvation Loaded!");
		System.out.println("Why don't you register some maidens!?");

        //willow the wisp. Furniture items that took forever to sprite!
        Color dungeonMapColor = new Color(59, 51, 38);

        ObjectRegistry.registerObject("willowchest", new StorageBoxInventoryObject("willowchest", 40, dungeonMapColor), 10.0F, true);
        DinnerTableObject.registerDinnerTable("willowdinnertable", "willowdinnertable", dungeonMapColor, 20.0F);
        ObjectRegistry.registerObject("willowdesk", new DeskObject("willowdesk", dungeonMapColor), 10.0F, true);
        ObjectRegistry.registerObject("willowmodulartable", new ModularTableObject("willowmodulartable", dungeonMapColor), 10.0F, true);
        ObjectRegistry.registerObject("willowchair", new ChairObject("willowchair", dungeonMapColor), 5.0F, true);
        BenchObject.registerBench("willowbench", "willowbench", dungeonMapColor, 10.0F);
        ObjectRegistry.registerObject("willowbookshelf", new BookshelfObject("willowbookshelf", dungeonMapColor), 10.0F, true);
        ObjectRegistry.registerObject("willowcabinet", new CabinetObject("willowcabinet", dungeonMapColor), 10.0F, true);
        BedObject.registerBed("willowbed", "willowbed", dungeonMapColor, 100.0F);
        ObjectRegistry.registerObject("willowdresser", new DresserObject("willowdresser", dungeonMapColor), 10.0F, true);
        ObjectRegistry.registerObject("willowclock", new ClockObject("willowclock", dungeonMapColor), 10.0F, true);
        ObjectRegistry.registerObject("willowcandelabra", new CandelabraObject("willowcandelabra", dungeonMapColor, 50.0F, 0.1F), 10.0F, true);
        ObjectRegistry.registerObject("willowdisplay", new DisplayStandObject("willowdisplay", dungeonMapColor, 20), 10.0F, true);
        BathtubObject.registerBathtub("willowbathtub", "willowbathtub", dungeonMapColor, 10.0F);
        ObjectRegistry.registerObject("willowtoilet", new ToiletObject("willowtoilet", dungeonMapColor), 5.0F, true);



        //The extra, or I guess "no longer missing" walls for oak, willow, spruce.
        //What are the normal "wood" walls made of? Well, any of them!
        WallObject.registerWallObjects("willow","willowwall", 0,new Color(46, 40, 30), ToolType.ALL,2.0f,6.0f);
        TileRegistry.registerTile("willowfloor", new SimpleFloorTile("willowfloor", new Color(46, 40, 30)),2.0f,true);

        WallObject.registerWallObjects("oak","oakwall", 0,new Color(124, 104, 80), ToolType.ALL,2.0f,6.0f);
        TileRegistry.registerTile("oakfloor", new SimpleFloorTile("oakfloor", new Color(124, 104, 80)),2.0f,true);

        WallObject.registerWallObjects("spruce","sprucewall", 0,new Color(105, 72, 47), ToolType.ALL,2.0f,6.0f);
        TileRegistry.registerTile("sprucefloor", new SimpleFloorTile("sprucefloor", new Color(105, 72, 47)),2.0f,true);


        //here we go with adding lanterns and it's derivatives to the game! I am considering adding lanterns made of different metals but that will come later, probably.
        ObjectRegistry.registerObject("crps_lantern", new crps_lantern_object("crps_lantern"), 2.0F,true);
        //ObjectRegistry.registerObject("crps_lantern_copper", new crps_lantern_object("crps_lantern_copper"), 10.0F,true);
        ObjectRegistry.registerObject("crps_lantern_wall", new crps_lantern_wall_object("crps_lantern_wall"), 3.0F,true);

        //It's just a candelabra object, for now.
        ObjectRegistry.registerObject("crps_streetlight_single", new crps_streetlight_single_object("crps_streetlight_single", new Color(68, 68, 68), 50.0F, 0.1F), 10.0F, true);
        ObjectRegistry.registerObject("crps_streetlight_double", new crps_streetlight_single_object("crps_streetlight_double", new Color(68, 68, 68), 50.0F, 0.1F), 10.0F, true);
        ObjectRegistry.registerObject("crps_streetlight_quad", new crps_streetlight_single_object("crps_streetlight_quad", new Color(68, 68, 68), 50.0F, 0.1F), 10.0F, true);



    }

    public void postInit() {

        //I copied and pasted the recipes for the oak equivalents of each item, so it was easier to keep track of what the ingredients should be.
        //Of course, these comments are not actually important.
        //{oakchest, 1, carpenter, INGREDIENTS{{oaklog, 8}}, true}
        Recipes.registerModRecipe(new Recipe("willowchest",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",8)},true));
        //{oakdinnertable, 1, carpenter, INGREDIENTS{{oaklog, 16}}, true}
        Recipes.registerModRecipe(new Recipe("willowdinnertable",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",16)},true));
        //{oakdesk, 1, carpenter, INGREDIENTS{{oaklog, 8}}, true}
        Recipes.registerModRecipe(new Recipe("willowdesk",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",8)},true));
        //{oakmodulartable, 1, carpenter, INGREDIENTS{{oaklog, 8}}, true}
        Recipes.registerModRecipe(new Recipe("willowmodulartable",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",8)},true));
        //{oakchair, 1, carpenter, INGREDIENTS{{oaklog, 4}}, true}
        Recipes.registerModRecipe(new Recipe("willowchair",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",4)},true));
        //{oakbench, 1, carpenter, INGREDIENTS{{oaklog, 10}}, true}
        Recipes.registerModRecipe(new Recipe("willowbench",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",10)},true));
        //{oakbookshelf, 1, carpenter, INGREDIENTS{{oaklog, 10}}, true}
        Recipes.registerModRecipe(new Recipe("willowbookshelf",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",10)},true));
        //{oakcabinet, 1, carpenter, INGREDIENTS{{oaklog, 10}}, true}
        Recipes.registerModRecipe(new Recipe("willowcabinet",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",10)},true));
        //{oakbed, 1, carpenter, INGREDIENTS{{oaklog, 10}, {wool, 10}}, true}
        Recipes.registerModRecipe(new Recipe("willowbed",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",10), new Ingredient("wool",10)},true));
        //{oakdresser, 1, carpenter, INGREDIENTS{{oaklog, 8}}, true}
        Recipes.registerModRecipe(new Recipe("willowdresser",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",8)},true));
        //{oakclock, 1, carpenter, INGREDIENTS{{oaklog, 8}, {ironbar, 2}}, true}
        Recipes.registerModRecipe(new Recipe("willowclock",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",8), new Ingredient("ironbar",2)},true));
        //{oakcandelabra, 1, carpenter, INGREDIENTS{{oaklog, 6}, {torch, 3}}, true}
        Recipes.registerModRecipe(new Recipe("willowcandelabra",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",6),new Ingredient("torch", 3)},true));
        //{oakdisplay, 1, carpenter, INGREDIENTS{{oaklog, 10}}, true}
        Recipes.registerModRecipe(new Recipe("willowdisplay",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",10)},true));
        //{oakbathtub, 1, carpenter, INGREDIENTS{{oaklog, 12}}, true}
        Recipes.registerModRecipe(new Recipe("willowbathtub",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",12)},true));
        //{oaktoilet, 1, carpenter, INGREDIENTS{{oaklog, 6}}, true}
        Recipes.registerModRecipe(new Recipe("willowtoilet",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("willowlog",6)},true));


        //These are the extra wooden doors, walls, and floors.
        Recipes.registerModRecipe(new Recipe("willowwall",1,RecipeTechRegistry.WORKSTATION, new Ingredient[] {new Ingredient("willowlog",2)},true));
        Recipes.registerModRecipe(new Recipe("willowdoor",1,RecipeTechRegistry.WORKSTATION, new Ingredient[] {new Ingredient("willowlog",4)},true));
        Recipes.registerModRecipe(new Recipe("willowfloor",1,RecipeTechRegistry.WORKSTATION,new Ingredient[] {new Ingredient("willowlog",1)},true));

        Recipes.registerModRecipe(new Recipe("oakwall",1,RecipeTechRegistry.WORKSTATION, new Ingredient[] {new Ingredient("oaklog",2)},true));
        Recipes.registerModRecipe(new Recipe("oakdoor",1,RecipeTechRegistry.WORKSTATION, new Ingredient[] {new Ingredient("oaklog",4)},true));
        Recipes.registerModRecipe(new Recipe("oakfloor",1,RecipeTechRegistry.WORKSTATION,new Ingredient[] {new Ingredient("oaklog",1)},true));


        Recipes.registerModRecipe(new Recipe("sprucewall",1,RecipeTechRegistry.WORKSTATION, new Ingredient[] {new Ingredient("sprucelog",2)},true));
        Recipes.registerModRecipe(new Recipe("sprucedoor",1,RecipeTechRegistry.WORKSTATION, new Ingredient[] {new Ingredient("sprucelog",4)},true));
        Recipes.registerModRecipe(new Recipe("sprucefloor",1,RecipeTechRegistry.WORKSTATION,new Ingredient[] {new Ingredient("sprucelog",1)},true));


        //lanterns
        Recipes.registerModRecipe(new Recipe("crps_lantern",2,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("torch",2), new Ingredient("ironbar",1)},true));
        Recipes.registerModRecipe(new Recipe("crps_lantern_wall",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("ironbar",1), new Ingredient("crps_lantern",1)},true));
        //streetlights
        Recipes.registerModRecipe(new Recipe("crps_streetlight_single",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("crps_lantern",1), new Ingredient("anylog",6), new Ingredient("anystone",4)},true));
        Recipes.registerModRecipe(new Recipe("crps_streetlight_double",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("crps_lantern",2), new Ingredient("anylog",6), new Ingredient("anystone",4)},true));
        Recipes.registerModRecipe(new Recipe("crps_streetlight_quad",1,RecipeTechRegistry.CARPENTER, new Ingredient[] {new Ingredient("crps_lantern",4), new Ingredient("anylog",6), new Ingredient("anystone",4)},true));

    }
}