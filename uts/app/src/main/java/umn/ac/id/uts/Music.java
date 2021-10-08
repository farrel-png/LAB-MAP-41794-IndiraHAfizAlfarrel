package umn.ac.id.uts;

public class Music {
    private String judul;
    private String kategori;
    private int lagu;



    public Music(String judul, String kategori, int lagu) {
        this.judul = judul;
        this.kategori = kategori;
        this.lagu = lagu;
    }

    public int getLagu() {
        return lagu;
    }

    public void setLagu(int lagu) {
        this.lagu = lagu;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori(){
        return kategori;
    }
    public void setKategori(String kategiri){
        this.kategori = kategori;
    }


}
