package p11_OnlineRadioDatabase;

import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Playlist {
    private List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public int getSongsCount() {
        return this.songs.size();
    }

    public String getTotalPlayListLength() {
        int minutes = 0;
        int seconds = 0;
        for (Song song : songs) {
            minutes += song.getMinutes();
            seconds += song.getSeconds();
        }
        int totalLength = (minutes * 60) + seconds;
        int hour = totalLength / 60 / 60;
        int totalMinutes = (totalLength / 60) - (hour * 60);
        int totalSeconds = totalLength % 60;

        return String.format("Playlist length: %dh %dm %ds", hour, totalMinutes, totalSeconds);
    }
}
