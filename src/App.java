import java.util.*;
import java.text.*;

public class App {
    // Define a static username and password for login
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean inputValid = false;
        Date hariSekarang = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("E, dd/MM/yyyy");
        SimpleDateFormat waktu = new SimpleDateFormat("hh:mm:ss a zzz");
        String supermarket="budiman supermarket";

        // Add login and captcha logic
        if (login(scanner)) {
            String generatedCaptcha = generateCaptcha();

            do {
                try {
                    System.out.println("Captcha: " + generatedCaptcha);
                    System.out.print("Enter the captcha: ");
                    String enteredCaptcha = scanner.next();

                    if (validateCaptcha(generatedCaptcha, enteredCaptcha)) {
                        // Existing code for invoice input
                        System.out.println("===================================");
                        System.out.print("Masukkan nama pelanggan\t\t: ");
                        String namaPelanggan = scanner.next();

                        System.out.print("Masukkan nomor HP pelanggan\t: ");
                        String nomorHpPelanggan = scanner.next();

                        System.out.print("Masukkan alamat pelanggan\t: ");
                        String alamatPelanggan = scanner.next();

                        System.out.print("Masukkan Kode Barang\t\t: ");
                        String kodeBarang = scanner.next();

                        System.out.print("Masukkan Nama Barang\t\t: ");
                        String namaBarang = scanner.next();

                        System.out.print("Masukkan Harga Barang\t\t: ");
                        double hargaBarang = scanner.nextDouble();

                        System.out.print("Masukkan Jumlah Beli\t\t: ");
                        int jumlahBeli = scanner.nextInt();

                        Faktur faktur = new Faktur(kodeBarang, namaPelanggan, nomorHpPelanggan, alamatPelanggan, namaBarang, hargaBarang, jumlahBeli);

                        System.out.println("==============================================\n");
                        System.out.println("\t"+supermarket.toUpperCase());
                        System.out.println("Tanggal\t\t: " + tanggal.format(hariSekarang));
                        System.out.println("Waktu\t\t: " + waktu.format(hariSekarang));
                        System.out.println("==============================================");
                        System.out.println("DATA PELANGGAN");
                        System.out.println("----------------------------------------------");
                        System.out.println(faktur);
                        System.out.println("TOTAL BAYAR\t: " + faktur.hitungTotalBayar());
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("Kasir : NADIA");

                        inputValid = true; // If no exception occurs, exit the loop
                    } else {
                        System.out.println("Captcha is incorrect. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Input error \n");
                    System.out.println("========== Retry ==========\n");
                    scanner.nextLine(); // Clear input buffer
                }
            } while (!inputValid);
        } else {
            System.out.println("Login failed. Please try again.");
        }

        scanner.close();
    }

    // Method to handle login
    private static boolean login(Scanner scanner) {
        System.out.println("============== LOGIN ==============");
        System.out.print("Enter username: ");
        String enteredUsername = scanner.next();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.next();

        return USERNAME.equals(enteredUsername) && PASSWORD.equals(enteredPassword);
    }

    // Method to generate a random 4-digit captcha
    private static String generateCaptcha() {
        Random random = new Random();
        int captchaNumber = random.nextInt(9000) + 1000;
        return String.valueOf(captchaNumber);
    }

    // Method to validate the entered captcha
    private static boolean validateCaptcha(String generatedCaptcha, String enteredCaptcha) {
        return generatedCaptcha.equals(enteredCaptcha);
    }
}
