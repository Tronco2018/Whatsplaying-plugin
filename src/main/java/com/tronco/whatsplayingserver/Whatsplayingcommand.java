package com.tronco.whatsplayingserver;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Whatsplayingcommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        try {
            String artist = execCommand("playerctl metadata artist");
            String title = execCommand("playerctl metadata title");

            String result = "Currently playing: " + ChatColor.BOLD + ChatColor.GREEN + title + " - " + artist;
            commandSender.sendMessage(result);
        } catch (NullPointerException e){
            commandSender.sendMessage(ChatColor.RED + "Failed to retrieve information");
        }
        return true;
    }
    private String execCommand(String command){
        try{
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                output.append(line).append("\n");
            }
            process.waitFor();
            return output.toString().trim();
        } catch (Exception e){
            return null;
        }
    }
}
