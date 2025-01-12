package AGSystem;

import java.util.ArrayList;

public abstract class Artwork implements Met{
    public Artwork(){

    }
    public Artwork(String name, Artist artist) {
        setName(name);
        setArtist(artist);
        instances.add(this);
    }
    public Artwork(String name, Artist artist, int cost){
        this(name, artist);
        setCost(cost);
        artist.changeMoney(0, cost);
        //instances.add(this);
    }


    private static ArrayList<Artwork> instances = new ArrayList<Artwork>();

    private String name;
    private Artist artist;
    private ArtGallery gallery;
    private int cost = -1;

    public void setGallery(ArtGallery gallery){
        if(this.gallery != null)
            (this.gallery).delArtwork(this);

        this.gallery = gallery;
        gallery.addArtwork(this);
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
        if(this.artist != null)
            (this.artist).delArtwork(this);

        this.artist = artist;
        artist.addArtwork(this);
    }

    @Override
    public String toString() {
        return "Artwork [name=" + getName() + ", artist=" + getArtist().getName()
                + ", cost=" + getCost() + "]";
    }

    @Override
    public boolean equals(Object artwork){
        if(this == artwork) return true;
        if(artwork == null || getClass() != artwork.getClass()) return false;
        Artwork artwork2 = (Artwork) artwork;
        if(!getName().equals(artwork2.getName())) {
            return false;
        }
        if(!getArtist().getName().equals(artwork2.getArtist().getName()))
            return false;
        return true;

    }

    @Override
    public int hashCode(){
        int result = getName().hashCode();
        result = 31 * result + getArtist().getName().hashCode();
        return result;
    }

    private static ArrayList<Artwork> getInstances() {
        return instances;
    }
    protected static void addInstance(Artwork temp){
        instances.add(temp);
    }
    public static void showInstances(int sort, int CostFilter, String Find){
        ArrayList<Artwork> instances = getInstances();
        ArrayList<String> output = new ArrayList<String>();
        for(Artwork temp : instances){
            if(Find.equals("0")){
                if (CostFilter == 0) {
                    output.add(temp.toString());
                }
                else if(CostFilter > 0)
                    if(temp.getCost() >= CostFilter)
                        output.add(temp.toString());
                else
                    if(temp.getCost() <= CostFilter * -1)
                        output.add(temp.toString());
            }
            else{
                if(CostFilter == 0){
                    if(temp.toString().contains(Find)) output.add(temp.toString());
                }
                else if(CostFilter > 0)
                    if(temp.toString().contains(Find))
                        if(temp.getCost() >= CostFilter)
                            output.add(temp.toString());
                else
                    if(temp.toString().contains(Find))
                        if(temp.getCost() <= CostFilter * -1)
                            output.add(temp.toString());
            }
        }

        Met.showInstancesPart(sort, output);
    }

    public void reaction(){
        if(this.getCost() >= 5){
            System.out.println("Woah!!");
        }
        else if(this.getCost() <= 2){
            System.out.println("Ugh...");
        }
        else{
            System.out.println("That was ok");
        }
    }
}

