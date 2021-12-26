package com.example.paketproduct.model;

import static android.content.ContentValues.TAG;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.paketproduct.algorithm.fpgrowth.AlgoFPGrowth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BarangCreator {

    public static List<Barang> getListBarang(AlgoFPGrowth fpgrowth){
        ArrayList<Barang> listBarang = new ArrayList<>();
        Map<Integer, String> itemAndInitial = fpgrowth.getInitAndItem();

        for (int i = 0; i < itemAndInitial.size(); i++) {
            Barang barang = new Barang(itemAndInitial.get(i + 1), listDesc[i]);
            listBarang.add(barang);
        }

        Log.d(TAG, "getListBarang: " + listBarang.get(0).getName() + " : " + listBarang.get(0).getDescription());
        return listBarang;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<String> getListBarangAsString(AlgoFPGrowth fpGrowth){
        List<String> listBarang = new ArrayList<>();
        Map<Integer, String> itemAndInitial = fpGrowth.getInitAndItem();
        Set<Integer> keySet = itemAndInitial.keySet();

        keySet.forEach(key -> {
            listBarang.add(itemAndInitial.get(key));
        });

        return listBarang;
    }

    public final static String[] LIST_BARANG = {"Normal Key", "Lever Handle", "Swing Lockcase", "Push & Pull Handle", "Accessories","Handle Set", "Roller Lockcase", "Shelves", "Brackets", "Hinges", "Computer Key", "Cylindrical Handle", "Screws", "Nuts, Bolts & Spacer"};

    private static String[] listDesc = {
            "Accessories adalah barang-barang pelengkap untuk keperluan jendela seperti penyangga jendela, slot pengunci jendela, dan lain-lain",
            "Bolt & Guards adalah barang-barang pelengkap keperluan pintu dan jendela yang berfungsi sebagai pengaman tambahan",
            "Brackets adalah besi berbentuk siku-siku yang berguna sebagai penopang papan hambalan",
            "Casters adalah barang-barang pelengkap untuk kebutuhan rumah seperti aneka roda yang dapat digunakan di lemari, kasur, atau trolley",
            "Computer Key adalah Cylinder dan anak kunci dengan non gerigi. tipe anak kunci seperti banyak ditemukan dan memeliki kelebihan yaitu tidak mudah diduplikasi",
            "Cylindrical Handle adalah gagang pintu berbentuk bulat dengan mekanisme putar. Tipe gagang pintu seperti ini ideal untuk digunakan di pintu kamar mandi",
            "Door Closers adalah barang pelengkap keperluan pintu rumah yang berfungsi untuk menutup pintu secara otomatis",
            "Door Stop adalah barang pelengkap keperluan pintu rumah yang berfungsi sebagai penehan pintu saat posisi terbuka agar tidak langsung berbenturan dengan tembok",
            "Door Threshodls & Sweeps adalah barang pelengkap kebutuhan pintu rumah yang berfungsi sebagai penutup celah atau sering disebut dengan Door Seal",
            "Handle adalah gagang pintu untuk laci dan lemari",
            "Handle Set adalah gagang pintu sistem ayun yang didalam penjualannya sudah termasuk anak kunci dan rumah kuncinya",
            "Hinges adalah engsel berbahan besi atau stainless steel yang berguna untuk menopang daun pintu",
            "Knob Key adalah varian cylinder dengan salah satu sisi berbentuk knob yang ideal digunakan untuk pintu kamar tidur",
            "Lever handle adalah gagang pintu dengan sistem ayun yang dijual terpisah tanpa anak kunci dan rumah kunci. Tipe gagang pintu tipe ini paling banyak digunakan karena bisa dipakai di semua pintu rumah mulai dari pintu utama(satu daun pintu), pintu kamar, hingga pintu kamar mandi",
            "Mailboxes & Signs adalah barang perlengkapan rumah seperti nomor rumah, label keterangan, dll",
            "Normal key adalah Cylinder dan anak kunci dengan tipe gerigi. tipe anak kunci seperti paling banyak ditemukan dan mudah untuk diduplikasi",
            "paku kayu, paku beton, dan tile spacer",
            "Gembok",
            "Tali Rafia",
            "Push & Pull Handle adalah gagang pintu dengan sistem dorong dan tarik. Jenis gagang ini idealnya digunakan di pintu utama dengan dua daun pintu",
            "Rail untuk keperluan pintu geser",
            "Roller Lockcase adalah rumah kunci yang digunakan untuk gagang dengan sistem dorong dan tarik",
            "Sekrup dan fischer",
            "Shelves adalah papan hambalan yang berfungsi untuk tempat penyimpanan barang sekaligus memperindah ruangan",
            "Rumah kunci atau lockcase yang digunakan untuk pintu geser",
            "Swing Lockcase adalah rumah kunci yang ada di dalam badan pintu. Tipe ini digunakan untuk gagang pintu jenis lever handle",
    };

//    private Map<String, String> getDesc(){
//        Map<String, String> listDesc = new HashMap<>();
//
//    }
}
