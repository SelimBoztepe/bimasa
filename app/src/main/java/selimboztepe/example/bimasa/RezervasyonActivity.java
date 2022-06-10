package selimboztepe.example.bimasa;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RezervasyonActivity extends AppCompatActivity {

    ArrayList listKisi,listSaat;
    ArrayAdapter adapterKisi,adapterSaat;
    Spinner spnrKisi;
    Spinner spnrSaat;
    DatePicker datePicker;
    String secilenTarih;
    int secilenSaat =1;
    int secilenKisi =1;



    //Masalar Tablosu
    Button masa1,masa2,masa3,masa4,masa5,masa6,masa7,masa8,masa9,masa10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_restoran);


        spnrKisi=findViewById(R.id.spnrKisi);
        spnrSaat=findViewById(R.id.spnrSaat);
        datePicker = (DatePicker) findViewById(R.id.date_picker);


        //Bugünden önceki günlerin seçilmesini engelle
        Calendar today = Calendar.getInstance();
        long now = today.getTimeInMillis();
        datePicker.setMinDate(now);




        // SPINNER
            initKisi();
            initSaat();

        //spinnerkisi
        spnrKisi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedID = (int) spnrKisi.getSelectedItemId();
               secilenKisi = selectedID;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                secilenKisi=1;
            }
        });

        //spinnersaat
        spnrSaat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedID = (int) spnrSaat.getSelectedItemId();
                secilenSaat = selectedID;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                secilenSaat=1;
            }
        });

        masa1 = (Button) findViewById(R.id.button1);
        masa2 = (Button) findViewById(R.id.button2);
        masa3 = (Button) findViewById(R.id.button3);
        masa4 = (Button) findViewById(R.id.button4);
        masa5 = (Button) findViewById(R.id.button5);
        masa6 = (Button) findViewById(R.id.button6);
        masa7 = (Button) findViewById(R.id.button7);
        masa8 = (Button) findViewById(R.id.button8);
        masa9 = (Button) findViewById(R.id.button9);
        masa10 = (Button) findViewById(R.id.button10);

        masa1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view){
                        tarihiGuncelle();
                        Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                        gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                        gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                        gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                        gonderilenbilgi.putExtra("secilen masa", 1);
                        startActivity(gonderilenbilgi);
                    }
            });

        masa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tarihiGuncelle();
                    Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                    gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                    gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                    gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                    gonderilenbilgi.putExtra("secilen masa", 2);
                    startActivity(gonderilenbilgi);
                }
        });

        masa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tarihiGuncelle();
                    Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                    gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                    gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                    gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                    gonderilenbilgi.putExtra("secilen masa", 3);
                    startActivity(gonderilenbilgi);
                }
        });

        masa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tarihiGuncelle();
                    Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                    gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                    gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                    gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                    gonderilenbilgi.putExtra("secilen masa", 4);
                    startActivity(gonderilenbilgi);
                }
        });

        masa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tarihiGuncelle();
                    Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                    gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                    gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                    gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                    gonderilenbilgi.putExtra("secilen masa", 5);
                    startActivity(gonderilenbilgi);
                }
        });

        masa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tarihiGuncelle();
                    Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                    gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                    gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                    gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                    gonderilenbilgi.putExtra("secilen masa", 6);
                    startActivity(gonderilenbilgi);
                }
        });

        masa7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tarihiGuncelle();
                    Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                    gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                    gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                    gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                    gonderilenbilgi.putExtra("secilen masa", 7);
                    startActivity(gonderilenbilgi);
                }
        });

        masa8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    tarihiGuncelle();
                    Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                    gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                    gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                    gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                    gonderilenbilgi.putExtra("secilen masa", 8);
                    startActivity(gonderilenbilgi);
                }
        });

        masa9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tarihiGuncelle();
                    Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                    gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                    gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                    gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                    gonderilenbilgi.putExtra("secilen masa", 9);
                    startActivity(gonderilenbilgi);
                }
        });

        masa10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tarihiGuncelle();
                    Intent gonderilenbilgi = new Intent(RezervasyonActivity.this, BilgiActivity.class);
                    gonderilenbilgi.putExtra("gonderilen tarih", secilenTarih);
                    gonderilenbilgi.putExtra("gonderilen kisi", secilenKisi + 1);
                    gonderilenbilgi.putExtra("gonderilen saat", secilenSaat + 1);
                    gonderilenbilgi.putExtra("secilen masa", 10);
                    startActivity(gonderilenbilgi);
                }
        });


    }
    public void initKisi(){
        listKisi = new ArrayList<>();
        listKisi.add(1);
        listKisi.add(2);
        listKisi.add(3);
        listKisi.add(4);
        listKisi.add(5);
        listKisi.add(6);

        adapterKisi = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_single_choice,  listKisi);
        spnrKisi.setAdapter(adapterKisi);
    }

    public void initSaat(){
        listSaat = new ArrayList<>();
        listSaat.add(1);
        listSaat.add(2);
        listSaat.add(3);
        listSaat.add(4);
        listSaat.add(5);
        listSaat.add(6);
        listSaat.add(7);
        listSaat.add(8);
        listSaat.add(9);
        listSaat.add(10);

        adapterSaat = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_single_choice,listSaat);
        spnrSaat.setAdapter(adapterSaat);
    }

    public void tarihiGuncelle(){
        secilenTarih = (datePicker.getMonth()+1) + "/" + datePicker.getDayOfMonth() + "/" + datePicker.getYear();
    }
}
