package jesseniah.modernternilapilli;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    //Note:

    //Alright so below I started off with a boolean that is tells me if
    //the players turn is true.So IF it is true it end up being equal to  X and if its
    //false then it will be equal to Zero.

    boolean turn = true;
    int turn_count = 0;
    //Note:
    //Then I set a button w0ith an Array and if you look it is the Button  with a row of arrays so the Arrays
    //are set in a list Array 1,2,3 ..Button 1,2,3 ...and click 1,2,3
    Button[] bArray = null;
    Button a1, a2, a3, b1, b2, b3, c1, c2, c3;
    String player1, player2;


    //Override 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Note: So below you see that I set the onCreate and just like I above like a beat.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        a1 = (Button) findViewById(R.id.A1);
        b1 = (Button) findViewById(R.id.B1);
        c1 = (Button) findViewById(R.id.C1);
        //array,button,click. cha cha cha!
        a2 = (Button) findViewById(R.id.A2);
        b2 = (Button) findViewById(R.id.B2);
        c2 = (Button) findViewById(R.id.C2);
        //array button click. cha cha cha !
        a3 = (Button) findViewById(R.id.A3);
        b3 = (Button) findViewById(R.id.B3);
        c3 = (Button) findViewById(R.id.C3);
        //one more time ..array,button,click.cha cha cha.
        bArray = new Button[] { a1, a2, a3, b1, b2, b3, c1, c2, c3 };
        //ok lastly I set the word NEW since Blaise is all like..,"WHEN I say INSTANTIATE!" you say new.

        for (Button b : bArray)
            b.setOnClickListener(this);
        //ok..so below I set the new button and im calling it with the id\
        //the id I got from the xml activity when I started setting the buttons.
        Button bnew = (Button) findViewById(R.id.button1);
        bnew.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //There are the booleans that I set earlier
                turn = true;
                turn_count = 0;
                enableOrDisable(true);
            }
        });
    }






//Override 2
    @Override
    public void onClick(View v) {
        Intent i = getIntent();
        player1  = i.getStringExtra("RealIntent1");
        player2 = i.getStringExtra("RealIntent2");
        buttonClicked(v);
    }

    private void buttonClicked(View v) {
        Button b = (Button) v;
        if (turn) {
            // X's turn
            b.setText("X");

        } else {
            // O's turn
            b.setText("O");
        }
        turn_count++;
        b.setClickable(false);
        b.setBackgroundColor(Color.LTGRAY);
        turn = !turn;

        checkForWinner();
    }
    //Now we repeat the if and else statements.

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
                message(player1 + "wins");
            else
                message(player2 + "wins");
            enableOrDisable(false);
        } else if (turn_count == 9)
            message("Draw!");

    }

    //Below we are adding the last toast
    private void message(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
                .show();
    }


    private void enableOrDisable(boolean enable) {
        for (Button b : bArray) {
            b.setText("");
            //Setting the click enabler.
            b.setClickable(enable);
            if (enable) {
                b.setBackgroundColor(Color.parseColor("#33b5e5"));
            } else {
                b.setBackgroundColor(Color.LTGRAY);
            }
        }
    }
}

//I found that the functionality was simpler putting when putting everything in one Main Activity
//as well still carries the same end functionality which I found to be quite awesome.




