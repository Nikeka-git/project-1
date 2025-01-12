package AGSystem;

import java.util.ArrayList;
import java.util.Comparator;

public class GoodGallery extends ArtGallery implements Met{
    public GoodGallery(){

    }
    public GoodGallery(String name) {

        super(name);
        ArtGallery.addInstance(this);
        addInstance(this);
    }

    private static ArrayList<GoodGallery> instances = new ArrayList<GoodGallery>();


    private static ArrayList<GoodGallery> getInstances() {
        return instances;
    }
    private static void addInstance(GoodGallery gallery){
        instances.add(gallery);
    }
    public static void showInstances(int sort, float rateFilter, String Find){
        ArrayList<GoodGallery> instances = getInstances();
        ArrayList<String> output = new ArrayList<String>();
        for(GoodGallery temp : instances){
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
        System.out.println("Inspection didn't found any problems");
    }

    @Override
    public String toString(){
        return "GoodGallery [name=" + getName() + ", rating=" + getRating() + "]";
    }


}
