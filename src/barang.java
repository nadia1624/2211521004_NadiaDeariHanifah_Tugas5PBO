public class barang implements HitungTotalBayar { //interface
    
    private String namaBarang;
    private double hargaBarang;
    private int jumlahBeli;

    public barang(String namaBarang, double hargaBarang,int jumlahBeli){
        
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;

    }

    public double hitungTotalBayar(){// interface dari hitungTotalBayar
        return hargaBarang*jumlahBeli;
    }

    @Override
    public String toString(){
        return "Nama Barang\t: " + namaBarang + 
        "\nHarga Barang\t: " + hargaBarang +
         "\nJumlah Beli\t: " + jumlahBeli ;
    }


    
}
