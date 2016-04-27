import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    //Note:
    //Alright so below I started off with a boolean that is tells me if
    //the players turn is true.So IF it is is true is will be equal to  X and if its
    //false then it will be equal to Zero.
    boolean turn = true;
    int turn_count = 0;
    //Note:
    //Then I set a button with an Array and if you look it is the Button  with a row of arrays so the Arrays
    //are set in a list Array 1,2,3 ..Button 1,2,3 ...and click 1,2,3
    Button[] bArray = null;
    Button a1, a2, a3, b1, b2, b3, c1, c2, c3;


}

Se