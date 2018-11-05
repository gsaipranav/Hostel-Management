package mg.hostel.hostelmanagement;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button reg, login1;
    EditText fname, lname, password, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        openHelper =new DatabaseHelper(this);
        reg =(Button) findViewById(R.id.reg);
        login1 =(Button) findViewById(R.id.login1);
        fname =(EditText) findViewById(R.id.fname);
        lname =(EditText) findViewById(R.id.lname);
        password =(EditText) findViewById(R.id.password);
        email =(EditText) findViewById(R.id.email);
        phone =(EditText) findViewById(R.id.phone);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper.getWritableDatabase();
                String firstname=fname.getText().toString();
                String lastname=lname.getText().toString();
                String pass=password.getText().toString();
                String emailname=email.getText().toString();
                String phoneno=phone.getText().toString();
                insertdata(firstname, lastname, pass, emailname, phoneno );
                Toast.makeText(getApplicationContext(),"Registered successfully", Toast.LENGTH_LONG).show();



            }
        });
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
    public void insertdata(String firstname, String lastname, String pass, String emailname, String phoneno) {
        ContentValues contentValues =new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, firstname);
        contentValues.put(DatabaseHelper.COL_3, lastname);
        contentValues.put(DatabaseHelper.COL_4, pass);
        contentValues.put(DatabaseHelper.COL_5, emailname);
        contentValues.put(DatabaseHelper.COL_6, phoneno);
        long id= db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);


    }
}
