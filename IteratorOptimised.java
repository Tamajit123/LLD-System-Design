import java.util.ArrayList;
import java.util.Collections;

interface PlaylistIterator {
    boolean hasNext();
    String next();
}

class SimplePlaylistIterator implements PlaylistIterator {
    private Playlist playlist;
    private int index;

    public SimplePlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSongs().size();
    }

    @Override
    public String next() {
        return playlist.getSongs().get(index++);
    }
}

class ShuffledPlaylistIterator implements PlaylistIterator {
    private Playlist playlist;
    private int index;
    private ArrayList<String> shuffledSongs;

    public ShuffledPlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = 0;
        this.shuffledSongs = new ArrayList<>(playlist.getSongs());
        Collections.shuffle(shuffledSongs);
    }

    @Override
    public boolean hasNext() {
        return index < shuffledSongs.size();
    }

    @Override
    public String next() {
        return shuffledSongs.get(index++);
    }
}

class FavoritesPlaylistIterator implements PlaylistIterator {
    private Playlist playlist;
    private int index;

    public FavoritesPlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        while (index < playlist.getSongs().size()) {
            if (playlist.getSongs().get(index).contains("Fav")) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public String next() {
        return playlist.getSongs().get(index++);
    }
}

class Playlist {
    private ArrayList<String> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public PlaylistIterator iterator(String type) {
        switch (type) {
            case "simple":
                return new SimplePlaylistIterator(this);
            case "shuffled":
                return new ShuffledPlaylistIterator(this);
            case "favorites":
                return new FavoritesPlaylistIterator(this);
            default:
                return null;
        }
    }

    public ArrayList<String> getSongs() {
        return songs;
    }
}

public class IteratorOptimised {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Song 1");
        playlist.addSong("Song 2 Fav");
        playlist.addSong("Song 3");
        playlist.addSong("Song 4 Fav");
        playlist.addSong("Song 5");

        System.out.println("Simple Playlist:");
        PlaylistIterator simpleIterator = playlist.iterator("simple");
        while (simpleIterator.hasNext()) {
            System.out.println("Playing: " + simpleIterator.next());
        }

        System.out.println("\nShuffled Playlist:");
        PlaylistIterator shuffledIterator = playlist.iterator("shuffled");
        while (shuffledIterator.hasNext()) {
            System.out.println("Playing: " + shuffledIterator.next());
        }

        System.out.println("\nFavorites Playlist:");
        PlaylistIterator favoritesIterator = playlist.iterator("favorites");
        while (favoritesIterator.hasNext()) {
            System.out.println("Playing: " + favoritesIterator.next());
        }
    }
}