package me.swastik.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Commands extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        /*
        The first if statement defines the name of the command which is to be executed by a player or from a console
        or command block.

        The functioning of the first if statement works as follows:
        - it starts out by not being case-sensitive and checking the input provided by the player/console which is
        usually the name of the command. In very rare instances will it be given a wrong value.
        - it then prints out a message to the console to acknowledge the input and let the admin know the command is
        being executed in the system.
        - the following if else ladder describes the command's logic and checks whether the command is run by a player
        or console or from a command block and the appropriate logic and message is executed.

        Development of this logic was done by @KodySimpson, a youtuber who creates content on Java and Spigot.
         */

        // making a die command
        if (label.equalsIgnoreCase("die")) {

            System.out.println("I have been run by someone.");

            //check to see if a Player ran the command or something else
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.setHealth(0.0);
                p.sendMessage(ChatColor.RED + "You have opted to die.");

            } else if (sender instanceof ConsoleCommandSender) {

                System.out.println("The command was ran in the console.");

            } else if (sender instanceof BlockCommandSender) {

                System.out.println("The command was ran by a command block.");

            }
        }

        //making a feed  command
        if (label.equalsIgnoreCase("feed")) {

            System.out.println("I have been run by someone.");

            //check to see if a Player ran the command or something else
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("Commands.feed")) {
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.RED + "Your appetite was fed.");
                } else {
                    p.sendMessage(ChatColor.RED + "You don't have permission to run this command.");
                }

            } else if (sender instanceof ConsoleCommandSender) {

                System.out.println("The command was ran in the console.");

            } else if (sender instanceof BlockCommandSender) {

                System.out.println("The command was ran by a command block.");

            }

            // making a fly command
            if (label.equalsIgnoreCase("fly")) {

                System.out.println("I have been run by someone or something.");

                //check to see if a Player ran the command or something else
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (p.hasPermission("Commands.fly")) {
                        p.setAllowFlight(true);
                        p.sendMessage(ChatColor.RED + "Your can now fly around.");
                    } else {
                        p.setAllowFlight(false);
                        p.sendMessage(ChatColor.RED + "You don't have permission to run this command.");
                    }

                } else if (sender instanceof ConsoleCommandSender) {

                    System.out.println("The command was ran in the console.");

                } else if (sender instanceof BlockCommandSender) {

                    System.out.println("The command was ran by a command block.");

                }

            }
            //return true if the command was used correctly, but i generally just return true no matter what

        }
        return true;

    }
}

