package AGSystem;

import java.util.ArrayList;
import java.util.Comparator;


public class Artist implements Met{

    public Artist(){

    }

    public Artist(String name){
        this.name = name;
        instances.add(this);
    }



    private static ArrayList<Artist> instances = new ArrayList<Artist>();

    private String name = "";
    ArrayList<Artwork> artworks = new ArrayList<Artwork>();
    private int money = 0;
    private int rating = 0;


    public int getMoney(){
        return money;
    }
    protected void changeMoney(int prev, int cur){
        money = money - prev + cur;
    }

    public ArrayList<Artwork> getArtworks(){
        return artworks;
    }
    protected void addArtwork(Artwork artwork){
        artworks.add(artwork);
        money = money + artwork.getCost();
        if(artwork instanceof NormalPainting){
            rating++;
        }
    }
    protected void delArtwork(Artwork artwork){
        artworks.remove(artwork);
        money = money - artwork.getCost();
        if(artwork instanceof NormalPainting){
            rating--;
        }
    }

    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getRating() {
        if(artworks.isEmpty()){
            return -1;
        }
        else
            return (rating / artworks.size());
    }

    static private ArrayList<Artist> getInstances(){
        return instances;
    }
    protected static void addInstance(Artist arts){
        instances.add(arts);
    }
    public static void showInstances(int sort, float rateFilter, String Find){
        ArrayList<Artist> instances = getInstances();
        ArrayList<String> output = new ArrayList<String>();
        for(Artist temp : instances){
            if(Find.equals("0")){
                if (rateFilter == 0) {
                    output.add(temp.toString());
                }
                else if(rateFilter > 0)
                    if(temp.getRating() >= rateFilter)
                        output.add(temp.toString());
                    else
                    if(temp.getRating() <= rateFilter * -1)
                        output.add(temp.toString());
            }
            else{
                if(rateFilter == 0){
                    if(temp.toString().contains(Find)) output.add(temp.toString());
                }
                else if(rateFilter > 0)
                    if(temp.toString().contains(Find))
                        if(temp.getRating() >= rateFilter)
                            output.add(temp.toString());
                        else
                        if(temp.toString().contains(Find))
                            if(temp.getRating() <= rateFilter)
                                output.add(temp.toString());
            }
        }
        Met.showInstancesPart(sort, output);
    }

    @Override
    public void reaction(){
        if(this.getRating() == -1){
            System.out.println("Gallery isn't opened yet");
        }
        else if(this.getRating() >= 0.75){
            System.out.println("Woah!!");
        }
        else if(this.getRating() <= 0.25){
            System.out.println("Ugh...");
        }
        else{
            System.out.println("That was ok");
        }
    }

    @Override
    public String toString() {
        return "Artist [name=" + getName() + ", rating=" + getRating()*5
                + ", money=" + getMoney() + "]";
    }

    @Override
    public boolean equals(Object artist){
        if(this == artist) return true;
        if(artist == null || getClass() != artist.getClass()) return false;
        Artist artist2 = (Artist) artist;
        if(!getName().equals(artist2.getName()))
            return false;
        if(!getArtworks().equals(artist2.getArtworks()))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        int result = getName().hashCode();
        int rat = (int)(getRating()*5);
        result = 31 * result + rat;
        result = 31 * result + getArtworks().size();
        return result;
    }
}
