package AGSystem;

import java.util.ArrayList;
import java.util.Comparator;

public interface Met {
    void reaction();

    static void showInstancesPart(int sort, ArrayList<String> output) {
        if(sort == 0){
            for(String s : output){
                System.out.println(s);
            }
        }
        else if(sort == 1){
            output.sort(Comparator.naturalOrder());
            for(String s : output){
                System.out.println(s);
            }
        }
        else if(sort == 2){
            output.sort(Comparator.reverseOrder());
            for(String s : output){
                System.out.println(s);
            }
        }
    }
}
