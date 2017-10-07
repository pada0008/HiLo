package com.algonquincollege.pada0008.hilogame;




import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 *  Purpose HiLo Game for assignment.
 *  @author Janki Padaliya (pada0008)
 *  date : 2017-10-06
 */

public class MainActivity extends AppCompatActivity {

    private EditText userGuess;
    private Button btnGuess, btnReset;
    private TextView userGuessCount, userGuessCountRemain;
    private hilogame mygame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userGuess = (EditText) findViewById(R.id.editText);
        btnGuess = (Button) findViewById(R.id.button);
        btnReset = (Button) findViewById(R.id.button2);
        userGuessCount = (TextView) findViewById(R.id.gc);
        userGuessCountRemain = (TextView) findViewById(R.id.rgc);
        mygame = new hilogame();
        screenInit();

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (userGuess.getText().toString().length() > 0) {
                    short guess = (short) Integer.parseInt(userGuess.getText().toString());
                    if (guessValidation(guess)) {
                        mygame.GuessGame(guess);
                        userGuessCount.setText(String.valueOf(mygame.getUserGuessCount()));
                        userGuessCountRemain.setText(String.valueOf(mygame.getuserGuessRemain()));
                        Toast.makeText(getApplicationContext()
                                , mygame.getMsg()
                                , Toast.LENGTH_SHORT).show();
                    }
                } else {
                    userGuess.setError("Please Guess required");
                    userGuess.requestFocus();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameReset();
            }
        });

        btnReset.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String answerToast = "theNumber : " + String.valueOf(mygame.getTheNumber());
                Toast.makeText(getApplicationContext()
                        , answerToast
                        , Toast.LENGTH_SHORT).show();
                GameReset();
                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.about_action:
                DialogFragment aboutFragment = new aboutDialog();
                aboutFragment.show(getFragmentManager(), "About");
                break;
        }
        return true;
    }

    public void screenInit() {
        userGuess.setText("");
        userGuessCount.setText("0");
        userGuessCountRemain.setText("0");

    }

    public void GameReset() {
        screenInit();
        mygame.game_reset();
    }

    // user input validation
    private boolean guessValidation(short guess) {
        if (guess > 1000) {
            userGuess.setError(getString(R.string.validationMsg));
            userGuess.requestFocus();
            return false;
        }
        return true;
    }


}
