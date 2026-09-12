import java.util.ArrayList;
import java.util.List;

class PlayList {
    private List<String> songs;

    public PlayList() {
        songs = new ArrayList<>();
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public void playPlayList() {
        for (int i = 0; i < songs.size(); i++) {
            System.out.println("Playing song: " + songs.get(i));
        }
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        PlayList playlist = new PlayList();
        playlist.addSong("Song 1");
        playlist.addSong("Song 2");
        playlist.playPlayList();
    }
}