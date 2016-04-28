package jesseniah.modernternilapilli;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class GameStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        EditText et1 = (EditText)findViewById(R.id.player_one_name);
        EditText et2 = (EditText)findViewById(R.id.player_two_name);

        String player1 = et1.getText().toString();
        String player2 = et2.getText().toString();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.trueId);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent mainIntent = new Intent(
                        GameStartActivity.this, MainActivity.class);
                mainIntent.putExtra("RealIntent1" , "player1");
                mainIntent.putExtra("RealIntent2", "player2");
                startActivity(mainIntent);
            }
        });
    }

}
