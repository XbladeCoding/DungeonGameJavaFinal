/******************************************************************************
 *  Name: Rohan Balasubramanian
 *
 ******************************************************************************/

Final Project Name: Gridded Dungeoneering

/******************************************************************************
 *  Describe how decided to implement this project. Is it original? or a spin-off
 *  a similar project? If it is the latter, submit a link or documentation to it.

 This is an oroginal idea dreamt up by myself. 
 I as a kid wanted to build a dungeon crawler game.
 So I designed a dungeon crawler-style game that consisted of a player fighting monsters
 and looting dungeons in a n-by-n grid, with a boss fight included in the dungeon as well.
 The game ends either when a player defeats the Garfield enemy, or when they die, or when
 they beat the boss of the dungeon.
 *****************************************************************************/

/******************************************************************************
 *  Describe step by step how to execute your project successfully.
 * If multiple conditions result in different outputs, describe the steps 
* to achieve the different outcomes.
*
This is a game. In order to run the game, run the following commands:
javac Game.java
javac Dungeon.java
javac tester.java
java tester

This compiles all the classes, including the driver, and executes a single line of code
in the tester.java file to start the game.
******************************************************************************/

 

/******************************************************************************
 *  Describe the data types you used to implement your project
 *  
 I used the ArrayList data type in order to have an inventory and to have a better
 way of storing the Monsters in a room, and for loot storage as well.

 I chose to not use arrays at all because they really were not needed, but I did use
 a 2D matrix for the map of the dungeon.
 *****************************************************************************/

 


/******************************************************************************
 *  Describe the methods used in your ADTs

 There are multiple methods across all ADTs. Here is a list of all of them*:

 Player:
 pickUpItem(Item item) - adds an item from the loot on the ground into the player's inventory
 equip(Item item) - adds the stats of an Item in the inventory to the current stats of the player
 heal(Item item) - uses a healing item in the player's inventory to heal some HP for the player
 addPoints(int pts) adds a certain number of points to the player's point count

 Item
 getter and setter methods for HP, dmg, and def.

 Dungeon
 createDungeon() - creates the n-by-n grid with Rooms that the player plays inside of.

 Game
 mainloop() - runs the game
 Battle() - simulates a battle room
 Loot() - simulates a loot room
 Boss() - simulates a boss room
 endGame() - ends the game

 Room
 rollLoot() - returns a loot pool for the loot room based off of the loot table
 rollEnemies() - returns enemies to fight in a battle room

 *NOTE: Each class has its own getter and setter methods. I'm not going to list them all; that would take years.
 *****************************************************************************/

 


/******************************************************************************
 *  Describe the data needed for your project.
 *  Submit data file(s) to run your project. What is the name of the data file(s)?
 *  Describe the purpose of the data.
 *  Describe the multiple testing done to demonstrate a successful implementation.

 No data is required to run this project.
 Each method was tested individually to make sure the entire thing would run properly.
 *****************************************************************************/

 

/******************************************************************************
 *  Known bugs/limitations.

 No bugs have been discovered. If you find one, let me know.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course classmates, and friends)
 *  and attribute them by name.

 No help was recieved. This code is 100% clanker-free.
 *****************************************************************************/


/******************************************************************************
 *  Describe any serious problems you encountered.
 When I was writing code, I would move onto the next step of code, only to discover that I needed more code for the code
 to run (other methods and game mechanics).
 *****************************************************************************/