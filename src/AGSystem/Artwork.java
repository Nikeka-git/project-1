package AGSystem;

public class Artwork {
    private String name = new String();
    private Artist artist = new Artist();
    private ArtGallery gallery = new ArtGallery();
    private int cost = 0;

    public Artwork(){

    }

    public Artwork(String name, Artist artist) {
        this.name = name;
        this.artist = artist;

        artist.addArtwork(this);
    }
    public Artwork(String name, Artist artist, int cost){
        this(name, artist);
        this.cost = cost;
        artist.changeMoney(0, cost);
    }

    public void setGallery(ArtGallery gallery){
        this.gallery = gallery;
    }
    public ArtGallery getGallery(){
        return this.gallery;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        artist.changeMoney(this.cost, cost);
        this.cost = cost;
    }

    public Artist getArtist(){
        return artist;
    }
    public void setArtist(Artist artist){
        this.artist = artist;
    }

}
