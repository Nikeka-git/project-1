package AGSystem;

import java.util.ArrayList;


public class Artist {
    private String name = new String();
    ArrayList<Artwork> artworks = new ArrayList<Artwork>();
    private int money = 0;

    public Artist(){

    }

    public Artist(String name){
        this.name = name;
    }

    public int getMoney(){
        return money;
    }
    public void changeMoney(int prev, int cur){
        money = money - prev + cur;
    }

    public ArrayList<Artwork> getArtworks(){
        return artworks;
    }
    public void addArtwork(Artwork artwork){
        artworks.add(artwork);
        money = money + artwork.getCost();
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
