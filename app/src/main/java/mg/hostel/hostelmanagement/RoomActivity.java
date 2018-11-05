package mg.hostel.hostelmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
    }
    public void book (View view)
    {
        Intent intent= new Intent(RoomActivity.this,BookActivity.class);
        startActivity(intent);
    }
}
