# BoxHead

Attempt to create a game similar to the famous flashgame BoxHead.
It's written on Java using the graphic library of Java Swing.

# Intro
This game want to be a replication of BoxHead, a lovely game where a player have to survive agaist zombies.
The zombies come for some door opened along the border of the map and when they reach the player they attack it.
The player have to survive shooting on the enemies using some arms that appear randomly on the map, his life can be restored just waiting without be subject to other attack.

The game is not grid based, so each object have an arbitrary dimension, and ,until now, all of them are represented as rectangle.



# Installation
Java is required.
Just execute the "Boxhead.jar" file.
For a better experience is good to install Mysql database where the score is saved, and the rank should be visualized

# Features
It's possible to play a match in single player or coop multiplayer, where the server is the user that create the room.
Before start is possible to create a map, inserting the object on it using "Editor" sub menu.
There are two levels of difficult that increase the power of the enemies.
The Easy mode draw a rectangular range around the zombie , and when the player fall inside, it will be followed to be attacked.
In the Difficult mode the zombie follow the player as soon as possible finding the shortest path to reach it.

# Future implementation
It's easy to transform the movable object in logic circle. 
It's possible to add new enemy also using reflection.
