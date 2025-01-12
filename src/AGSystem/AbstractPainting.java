package AGSystem;

import java.util.ArrayList;

public class AbstractPainting extends Artwork implements Met{
    public AbstractPainting(){

    }
    public AbstractPainting(String name, Artist artist) {
        super(name, artist);
        addInstance(this);
        artist.addArtwork(this);
    }
    public AbstractPainting(String name, Artist artist, int cost){
        super(name, artist, cost);
        artist.changeMoney(0, cost);
    }

    private static ArrayList<AbstractPainting> instances = new ArrayList<AbstractPainting>();

    private static ArrayList<AbstractPainting> getInstances() {
        return instances;
    }
    protected static void addInstance(AbstractPainting temp){
        instances.add(temp);
    }
    public static void showInstances(int sort, int CostFilter, String Find){
        ArrayList<AbstractPainting> instances = getInstances();
        ArrayList<String> output = new ArrayList<String>();
        for(AbstractPainting temp : instances){
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

    @Override
    public void setGallery(ArtGallery gallery){
        if(gallery instanceof BadGallery) {
            if (super.getGallery() != null)
                (super.getGallery()).delArtwork(this);

            //setGallery(gallery);
            gallery.addArtwork(this);
        }
        else{
            System.out.println("Gallery has not accepted this painting.");
        }
    }


}
