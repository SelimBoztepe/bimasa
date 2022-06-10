package selimboztepe.example.bimasa;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VTBaglanti extends SQLiteOpenHelper {
    private static final String VT="musteriler";
    public VTBaglanti( Context context) {
        super(context, VT,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE musteri(id INTEGER primary key AUTOINCREMENT, musteriBilgisi TEXT,telefonNo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS musteri");

    }
}
