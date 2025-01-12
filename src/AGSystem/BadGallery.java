package AGSystem;

import java.util.ArrayList;

public class BadGallery extends ArtGallery implements Met{
    public BadGallery(){

    }
    public BadGallery(String name) {
        super(name);
        addInstance(this);
        ArtGallery.addInstance(this);
    }

    private static ArrayList<BadGallery> instances = new ArrayList<BadGallery>();


    private static ArrayList<BadGallery> getInstances() {
        return instances;
    }
    private static void addInstance(BadGallery gallery){
        instances.add(gallery);
    }
    public static void showInstances(int sort, float rateFilter, String Find){
        ArrayList<BadGallery> instances = getInstances();
        ArrayList<String> output = new ArrayList<String>();
        for(BadGallery temp : instances){
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
    public void inspection(){
        System.out.println("Inspection found some problems");
    }

    @Override
    public String toString(){
        return "BadGallery [name=" + getName() + ", rating=" + getRating() + "]";
    }
}
