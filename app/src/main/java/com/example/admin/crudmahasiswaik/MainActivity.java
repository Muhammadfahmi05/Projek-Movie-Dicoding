package com.example.admin.crudmahasiswaik;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.crudmahasiswaik.adapter.MahasiswaAdapter;
import com.example.admin.crudmahasiswaik.model.Mahasiswa;
import com.example.admin.crudmahasiswaik.model.MahasiswaResult;
import com.example.admin.crudmahasiswaik.network.ApiClient;
import com.example.admin.crudmahasiswaik.network.MahasiswaService;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        ImageView ivCobaGambar = (ImageView) findViewById(R.id.iv_coba_gambar);

//        //muat gambar
//        int SDK_INT = Build.VERSION.SDK_INT;
//        if (SDK_INT > 8){
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
//                    .permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }
//
//        try {
//            URL url = new URL("https://picsum.photos/200/300");
//            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            ivCobaGambar.setImageBitmap(bmp);
//        } catch (MalformedURLException e){
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

//    Picasso.get()
//                .load ("https://picsum.photos/200/300").into(ivCobaGambar);

        //1. menyiapkan sumber data
        //1.a array string 1 dimensi
        //    String[] user = new String[]{"fahmi", "thio", "musa", "dian"};
//        ArrayList<String> user = new ArrayList<>();
//        user.add("User 1 ");
//        user.add("User 2 ");
//        user.add("User 3 ");
//        user.add("User 4 ");
        //    ArrayAdapter<String> userAdapter = new ArrayAdapter<>( this,
           //         android.R.layout.simple_list_item_1, user);
       // MahasiswaAdapter userAdapter = new MahasiswaAdapter(this,0, user)
         // lvUser.setAdapter(userAdapter);

        //1.b POJO(plan old java object)(lebih dari 1 dimensi)
//        Mahasiswa mahasiswa1 = new Mahasiswa();
//        mahasiswa1.setNama("Fahmi");
//        mahasiswa1.setNim("10.11.12.13.14");
//        mahasiswa1.setEmail("lahgo13@gmail.com");
//        mahasiswa1.setFoto("https://picsum.photos/200/300");
//
//        Mahasiswa mahasiswa2 = new Mahasiswa(
//                "tatak",
//                "10.12.13.15.16",
//                "tatak@tak.com",
//                "https://picsum.photos/200/300"
//        );
//        ArrayList<Mahasiswa> user = new ArrayList<>();
//        user.add(mahasiswa1);
//        user.add(mahasiswa2);

        //1.3 sumber data dari API / JSON Object dari internet
        MahasiswaService mService = ApiClient.getRetrofit()
                                                    .create(MahasiswaService.class);
        Call<MahasiswaResult> mahasiswas = mService.getMahasiswas();
        mahasiswas.enqueue(new Callback<MahasiswaResult>() {
            @Override
            public void onResponse(Call<MahasiswaResult> call, Response<MahasiswaResult> response) {
                List<Mahasiswa> mahasiswas = response.body().getMahasiswas();
                //2,menyiapkan adapter
                MahasiswaAdapter userAdapter = new MahasiswaAdapter(getApplicationContext(),0, mahasiswas);
                //3. tampilan aplikasi
                ListView lvUser = (ListView) findViewById(R.id.lv_user);
                lvUser.setAdapter(userAdapter);

                Toast.makeText(getApplicationContext(),
                        "Jumlah mahasiswa: " + response.body().getMahasiswas().size(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MahasiswaResult> call, Throwable t) {

            }
        });











    }
}
