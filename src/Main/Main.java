package Main;

import AGSystem.*;

public class Main {
    public static void main(String[] args) {
        ArtGallery gallery1 = new GoodGallery("Louvre");
        ArtGallery gallery2 = new BadGallery("New-York Museum");
        ArtGallery gallery3 = new BadGallery("Kostanayskaya Vystavka Kartin");
        Artist artist1 = new Artist("Da Vinci");
        Artist artist2 = new Artist("Van Gogh");
        Artist artist3 = new Artist("Malevich");
        Artwork painting1 = new AbstractPainting("Mona Lisa", artist1, 2);
        Artwork painting2 = new NormalPainting("Ultima Cena", artist1, 3);
        Artwork painting3 = new NormalPainting("Sternennacht", artist2, 5);
        Artwork painting4 = new NormalPainting("la Belle Ferroniere", artist1, 8);
        Artwork painting5 = new AbstractPainting("Malevich's Square", artist3, 1);

        


        /*if(artist1.getMoney() > artist2.getMoney()){
            System.out.println(artist1.getName() + " have more money than " + artist2.getName());
        }
        else if(artist2.getMoney() > artist1.getMoney()){
            System.out.println(artist2.getName() + " have more money than " + artist1.getName());
        }
        else{
            System.out.println(artist1.getName() + " and " + artist2.getName() + " have the same amount of money");
        }*/

        painting1.setGallery(gallery2);
        painting2.setGallery(gallery1);
        painting3.setGallery(gallery1);
        painting4.setGallery(gallery2);
        painting5.setGallery(gallery3);

        //System.out.println(gallery1.equals(gallery2));

        //System.out.println((painting3.getArtist()).getName());

        //ArtGallery.showInstances(2);
        //ArtGallery.showInstances(0, 0);
        //Artist.showInstances();
        //Artwork.showInstances();


        //Parameters: 1. sort: 0 - no order, 1 - small - big, 2 - big to small
        // 2. filter: rating > x for Artist and Gallery, Cost > x or Cost < -x if x < 0
        // 3. Find Strings with this work in Pool
        Artwork.showInstances(0, 0, "0");
        System.out.println(painting1.hashCode());

        painting1.reaction();
        artist1.reaction();
        gallery1.reaction();

        gallery1.inspection();
        System.out.println(gallery2.getArtworks());

        /*
        Artist testart1 = new Artist("first");
        Artist testart2 = new Artist("first");
        Artwork paint1 = new NormalPainting("lolo", testart1, 2);
        Artwork paint2 = new NormalPainting("lolo", testart2, 2);
        System.out.println(testart1.equals(testart2));
        System.out.println(testart1.hashCode());
        System.out.println(testart2.hashCode());
        */
    }
}
