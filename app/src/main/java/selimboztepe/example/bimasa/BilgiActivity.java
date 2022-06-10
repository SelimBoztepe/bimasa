package selimboztepe.example.bimasa;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BilgiActivity extends AppCompatActivity {
    TextView tvTarih;
    TextView tvKisi;
    TextView tvSaat;
    TextView tvListele;
    private VTBaglanti db;
    Button btnTamamla;
    EditText etIsim,etSoyad,etTelefon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_bilgi);
        db=new VTBaglanti(this);
        btnTamamla=(Button) findViewById(R.id.btnTamamla);
        tvTarih = (TextView) findViewById(R.id.tvTarih);
        tvKisi = (TextView) findViewById(R.id.tvKisi);
        tvSaat = (TextView) findViewById(R.id.tvSaat);
        etIsim = (EditText) findViewById(R.id.etIsim);
        etSoyad = (EditText) findViewById(R.id.etSoyad);
        etTelefon = (EditText) findViewById(R.id.etTelefon);
        tvListele = (TextView) findViewById(R.id.tvListele);

        Intent alinanBilgi = getIntent();
        String alinanTarih = alinanBilgi.getStringExtra("gonderilen tarih");
        int alinanKisi = alinanBilgi.getIntExtra("gonderilen kisi",1);
        int alinanSaat = alinanBilgi.getIntExtra("gonderilen saat",1);

        tvTarih.setText(alinanTarih);
        tvKisi.setText(Integer.toString(alinanKisi));
        tvSaat.setText(Integer.toString(alinanSaat));

        btnTamamla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = ""+etIsim.getText()+" "+etSoyad.getText()+" ";
                YeniKayit(output,etTelefon.getText().toString());
                Listele();
            }
        });
    }

    private void YeniKayit(String musteriBilgisi, String telefonNo){
        SQLiteDatabase sldb= db.getReadableDatabase();
        ContentValues must= new ContentValues();
        must.put("musteriBilgisi", musteriBilgisi);
        must.put("telefonNo",telefonNo);
        sldb.insert("musteri",null,must);
    }

    private void Listele(){
        String [] sutunlar={"musteriBilgisi","telefonNo"};
        SQLiteDatabase sldb= db.getReadableDatabase();
        //Veri tabanında imleç oluşturur
        Cursor musteriler= sldb.query("musteri",sutunlar,null,null,null,null,null);
        String tumbilgi="";
        while (musteriler.moveToNext()){
            @SuppressLint("Range") String adbilgisi=musteriler.getString(musteriler.getColumnIndex("musteriBilgisi"));
            @SuppressLint("Range") String nobilgisi=musteriler.getString(musteriler.getColumnIndex("telefonNo"));
            tumbilgi +=adbilgisi+""+nobilgisi+"\n";
        }
        tvListele.setText(tumbilgi);
    }

}















