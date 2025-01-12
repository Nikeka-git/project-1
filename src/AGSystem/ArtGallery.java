package AGSystem;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class ArtGallery implements Met {
    public ArtGallery(){

    }

    public ArtGallery(String name) {
        this.name = name;
    }


    private static ArrayList<ArtGallery> instances = new ArrayList<ArtGallery>();

    private String name = new String();
    private ArrayList<Artwork> artworks = new ArrayList<Artwork>();
    private float rating = 0;

    protected void addArtwork(Artwork artwork){
        artworks.add(artwork);
        if(artwork instanceof NormalPainting){
            rating++;
        }
    }
    protected void delArtwork(Artwork artwork){
        artworks.remove(artwork);
        if(artwork instanceof NormalPainting){
            rating--;
        }
    }
    public ArrayList<Artwork> getArtworks() {
        return artworks;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        if(artworks.isEmpty()){
            return -1;
        }
        else
            return (rating / artworks.size());
    }

    private static ArrayList<ArtGallery> getInstances() {
        return instances;
    }
    protected static void addInstance(ArtGallery gallery){
        instances.add(gallery);
    }
    public static void showInstances(int sort, float rateFilter, String Find){
        ArrayList<ArtGallery> instances = getInstances();
        ArrayList<String> output = new ArrayList<String>();
        for(ArtGallery temp : instances){
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

    public abstract void inspection();


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
        return "ArtGallery [name=" + getName() + ", rating=" + getRating()*5 + "]";
    }

    @Override
    public boolean equals(Object gallery){
        if(this == gallery) return true;
        if(gallery == null || getClass() != gallery.getClass()) return false;
        ArtGallery artGallery = (ArtGallery) gallery;
        if(getName().equals(artGallery.getName())){
            return true;
        }
        else
            return false;
    }

    @Override
    public int hashCode(){
        return getName().hashCode();
    }
}
