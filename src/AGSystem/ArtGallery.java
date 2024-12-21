package AGSystem;

import java.util.ArrayList;

public class ArtGallery {
    private String Name = new String();
    ArrayList<Artwork> artworks = new ArrayList<Artwork>();

    public ArtGallery(){

    }

    public ArtGallery(String Name) {
        this.Name = Name;
    }


    public void addArtwork(Artwork artwork){
        artworks.add(artwork);
        artwork.setGallery(this);
    }

    public void getArtworks() {
        for(int i = 0; i < artworks.size(); i++){
            if(i != artworks.size()-1)
                System.out.print((artworks.get(i)).getName() + ", ");
            else
                System.out.print((artworks.get(i)).getName());
        }
        System.out.print('\n');
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
}
