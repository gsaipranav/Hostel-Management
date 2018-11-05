package mg.hostel.hostelmanagement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {
    SQLiteOpenHelper open;
    SQLiteDatabase dbb;
    Button add;
    EditText username, gender, room, mess, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        open = new DatabaseHelper(this);
        add = (Button) findViewById(R.id.add);
        username = (EditText) findViewById(R.id.username);
        gender = (EditText) findViewById(R.id.gender);
        room = (EditText) findViewById(R.id.room);
        mess = (EditText) findViewById(R.id.mess);
        mobile = (EditText) findViewById(R.id.mobile);

    }

    public void adding(View view) {
        dbb = open.getWritableDatabase();
        String user = username.getText().toString();
        String gen = gender.getText().toString();
        String rooms = room.getText().toString();
        String mes = mess.getText().toString();
        String mobo = mobile.getText().toString();
        insert(user, gen, rooms, mes, mobo);
        Toast.makeText(getApplicationContext(), "ROOM IS BOOKED FOR YOU", Toast.LENGTH_LONG).show();
    }

    public void insert(String user, String gen, String rooms, String mes, String mobo)
    {
        ContentValues contentValues= new ContentValues();
        contentValues.put(MyDBHandler.COLUMN_USERNAME, user);
        contentValues.put(MyDBHandler.COLUMN_GENDER, gen);
        contentValues.put(MyDBHandler.COLUMN_ROOM, rooms);
        contentValues.put(MyDBHandler.COLUMN_MESS, mes);
        contentValues.put(MyDBHandler.COLUMN_MOBILE, mobo);
        long id= dbb.insert(MyDBHandler.TABLE_BOOKING, null, contentValues);
    }

}
