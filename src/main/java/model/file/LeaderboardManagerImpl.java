package model.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.chrono.MinguoChronology;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Rappresent the manager class of the LeaderBoard
 */
public class LeaderboardManagerImpl implements LeaderboardManager{

    private Leaderboard leaderBoard;
    private Gson gson;
    final String SEP = File.separator ;
    final String FILE_NAME = System.getProperty("user.home") + 
            SEP + "game.json";
  
    /**
     * Create a new LeaderBoard Manager
     */
    public LeaderboardManagerImpl() {
        this.leaderBoard = new Leaderboard();       
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void read() {   
        File f = new File(FILE_NAME);
        if (f.exists()) {
            try (Reader reader = new FileReader(FILE_NAME)) {
                // Convert JSON File to Java Object
                this.leaderBoard = gson.fromJson(reader, Leaderboard.class);                  
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void write() {
        try (final FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(leaderBoard, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addNewGamer(Gamer gamer) {
        if (checkTop10(gamer.getScore())) {          
            this.leaderBoard.addGamer(gamer);         
        }
    }
     
    private boolean checkTop10(String score) {
        if (leaderBoard.getLeaderBoard().size()<10) {
            return true;
        }
        
        return Integer.parseInt(score) > leaderBoard.getLeaderBoard().stream()
                .map( i -> Integer.parseInt(i.getScore()))
                .sorted().collect(Collectors.toList()).get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Gamer> getLeaderboard() {
        return this.leaderBoard.getLeaderBoard();
    }

}
