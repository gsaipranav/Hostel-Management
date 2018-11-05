package mg.hostel.hostelmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Closeable;

public class LoginActivity extends AppCompatActivity  {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button logger;
    EditText email2,password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper =new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        logger =(Button) findViewById(R.id.logger);
        email2 =(EditText) findViewById(R.id.email2);
        password2 =(EditText) findViewById(R.id.password2);
        logger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= email2.getText().toString();
                String password=password2.getText().toString();
                Cursor cursor = db.rawQuery("SELECT *FROM "+ DatabaseHelper.TABLE_NAME + " WHERE "+ DatabaseHelper.COL_5 + "=? AND " + DatabaseHelper.COL_4 + "=?", new String[]{email, password});
                if(cursor!=null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(),"Login success", Toast.LENGTH_LONG).show();
                        Intent in=new Intent(LoginActivity.this,RoomActivity.class);
                        startActivity(in);


                    }else{
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
