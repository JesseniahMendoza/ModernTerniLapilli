package jesseniah.modernternilapilli;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

Color;










public class GameActivity extends Activity implements OnClickListener {
    TextView name1;
    boolean turn = true;
    int turn_count = 0;
    Button[] bArray = null;
    Button a1, a2, a3, b1, b2, b3, c1, c2, c3;
    String player1, player2;




 //#1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name1 = (TextView)findViewById(R.id.textView);
        a1 = (Button) findViewById(R.id.A1);
        b1 = (Button) findViewById(R.id.B1);
        c1 = (Button) findViewById(R.id.C1);
                       //
        a2 = (Button) findViewById(R.id.A2);
        b2 = (Button) findViewById(R.id.B2);
        c2 = (Button) findViewById(R.id.C2);
                        //
        a3 = (Button) findViewById(R.id.A3);
        b3 = (Button) findViewById(R.id.B3);
        c3 = (Button) findViewById(R.id.C3);
        bArray = new Button[] { a1, a2, a3, b1, b2, b3, c1, c2, c3 };


        Intent i = getIntent();
        player1 = getIntent().getStringExtra("RealIntent1");
        player2 = i.getStringExtra("RealIntent2");
        name1.setText(player1);


        for (Button b : bArray)
            b.setOnClickListener(this);
        Button bnew = (Button) findViewById(R.id.button1);
        bnew.setOnClickListener(new OnClickListener() {







            //#2
            @Override
            public void onClick(View v) {
                turn = true;
                turn_count = 0;
                enableOrDisable(true);
            }
        });

    }





    //#3
    @Override
    public void onClick(View v) {
        buttonClicked(v);
    }




    private void buttonClicked(View v) {
        Button b = (Button) v;
        if (turn) {
            // X's turn
            b.setText("X");
            name1.setText(player1);

        } else {
            // O's turn
            b.setText("O");
            name1.setText(player2);
        }
        turn_count++;
        b.setClickable(false);
        b.setBackgroundColor(Color.LTGRAY);
        turn = !turn;

        checkForWinner();
    }


    private void checkForWinner() {
        boolean there_is_a_winner = false;
        if (a1.getText() == a2.getText() && a2.getText() == a3.getText()
                && !a1.isClickable())
            there_is_a_winner = true;
        else if (b1.getText() == b2.getText() && b2.getText() == b3.getText()
                && !b1.isClickable())
            there_is_a_winner = true;
        else if (c1.getText() == c2.getText() && c2.getText() == c3.getText()
                && !c1.isClickable())
            there_is_a_winner = true;

        else if (a1.getText() == b1.getText() && b1.getText() == c1.getText()
                && !a1.isClickable())
            there_is_a_winner = true;
        else if (a2.getText() == b2.getText() && b2.getText() == c2.getText()
                && !b2.isClickable())
            there_is_a_winner = true;
        else if (a3.getText() == b3.getText() && b3.getText() == c3.getText()
                && !c3.isClickable())
            there_is_a_winner = true;
        else if (a1.getText() == b2.getText() && b2.getText() == c3.getText()
                && !a1.isClickable())
            there_is_a_winner = true;
        else if (a3.getText() == b2.getText() && b2.getText() == c1.getText()
                && !b2.isClickable())
            there_is_a_winner = true;




        if (there_is_a_winner) {
            if (!turn)
                message(player1 + " Won!");
            else
                message(player2 + " Won!");
            enableOrDisable(false);
        } else if (turn_count == 9)
            message("Oh its a Tie");

    }





    private void message(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
                .show();
    }





    private void enableOrDisable(boolean enable) {
        for (Button b : bArray) {
            b.setText("");
            b.setClickable(enable);
            if (enable) {
                b.setBackgroundColor(Color.parseColor("#33b5e5"));
            } else {
                b.setBackgroundColor(Color.LTGRAY);
            }
        }
    }
}





