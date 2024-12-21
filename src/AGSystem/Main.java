package AGSystem;

public class Main {
    public static void main(String[] args) {
        ArtGallery gallery1 = new ArtGallery("Louvre");
        ArtGallery gallery2 = new ArtGallery("New-York Museum");
        Artist artist1 = new Artist("Da Vinci");
        Artist artist2 = new Artist("Van Gogh");
        Artwork painting1 = new Artwork("Mona Lisa", artist1, 2);
        Artwork painting2 = new Artwork("Ultima Cena", artist1, 3);
        Artwork painting3 = new Artwork("Sternennacht", artist2, 5);
        Artwork painting4 = new Artwork("la Belle Ferroniere", artist1, 8);

        if(artist1.getMoney() > artist2.getMoney()){
            System.out.println(artist1.getName() + " have more money than " + artist2.getName());
        }
        else if(artist2.getMoney() > artist1.getMoney()){
            System.out.println(artist2.getName() + " have more money than " + artist1.getName());
        }
        else{
            System.out.println(artist1.getName() + " and " + artist2.getName() + " have the same amount of money");
        }

        gallery1.addArtwork(painting1);
        gallery1.addArtwork(painting2);
        gallery2.addArtwork(painting3);
        gallery2.addArtwork(painting4);

        gallery1.getArtworks();

        System.out.println((painting3.getArtist()).getName());



    }
}
