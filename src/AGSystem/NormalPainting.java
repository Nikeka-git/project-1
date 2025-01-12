package AGSystem;

import java.util.ArrayList;

public class NormalPainting extends Artwork implements Met{
    public NormalPainting(){

    }
    public NormalPainting(String name, Artist artist) {
        super(name, artist);
        addInstance(this);
        artist.addArtwork(this);
    }
    public NormalPainting(String name, Artist artist, int cost){
        super(name, artist, cost);
        artist.changeMoney(0, cost);
    }


    private static ArrayList<NormalPainting> instances = new ArrayList<NormalPainting>();


    private static ArrayList<NormalPainting> getInstances() {
        return instances;
    }
    protected static void addInstance(NormalPainting temp){
        instances.add(temp);
    }
    public static void showInstances(int sort, int CostFilter, String Find) {
        ArrayList<NormalPainting> instances = getInstances();
        ArrayList<String> output = new ArrayList<String>();
        for (NormalPainting temp : instances) {
            if (Find.equals("0")) {
                if (CostFilter == 0) {
                    output.add(temp.toString());
                } else if (CostFilter > 0)
                    if (temp.getCost() >= CostFilter)
                        output.add(temp.toString());
                    else if (temp.getCost() <= CostFilter * -1)
                        output.add(temp.toString());
            } else {
                if (CostFilter == 0) {
                    if (temp.toString().contains(Find)) output.add(temp.toString());
                } else if (CostFilter > 0)
                    if (temp.toString().contains(Find))
                        if (temp.getCost() >= CostFilter)
                            output.add(temp.toString());
                        else if (temp.toString().contains(Find))
                            if (temp.getCost() <= CostFilter * -1)
                                output.add(temp.toString());
            }
            Met.showInstancesPart(sort, output);
        }
    }

}
