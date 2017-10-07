package com.algonquincollege.pada0008.hilogame;

import java.util.Random;

/**
 *  Purpose HiLo Game for assignment.
 *  @author Janki Padaliya (pada0008)
 *  date : 2017-10-06
 */

public class hilogame {
    private static final short GUESS_RANGE = 10;
    private short theNumber, userGuess, userGuessCount;
    private String msg;


    public hilogame() {
        setUserGuessCount((short) 0);
        setTheNumber();
        setMsg("");
    }

    //Random Number Generate function
    public void setTheNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(1001);
        this.theNumber = (short) randomNumber;
    }

    public void setUserGuess(short userGuess) {
        userCountIncrement();
        this.userGuess = userGuess;
    }

    public void setUserGuessCount(short userGuessCount) {
        this.userGuessCount = userGuessCount;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void userCountIncrement() {
        this.userGuessCount = (short) (this.userGuessCount + 1);
    }

    //
    public static short getGuessRange() {
        return GUESS_RANGE;
    }

    public short getTheNumber() {
        return theNumber;
    }

    public short getUserGuess() {
        return userGuess;
    }

    public short getUserGuessCount() {
        if (this.userGuessCount > 10) {
            return (short) 10;
        }
        return userGuessCount;
    }

    public String getMsg() {
        return msg;
    }

    // Player input and game play
    public boolean GuessGame(short userGuess) {
        setUserGuess(userGuess);
        short ug = getUserGuess();
        short ugc = getUserGuessCount();
        short rnd = getTheNumber();

        if (userGuessCount <= 10) {
            if (rnd == ug) {
                if (ugc <= (5)) {
                    setMsg("Congrats ! Superior win !");
                } else {
                    setMsg("Congrats ! Excellent win !");
                }
                return true;
            } else {
                if (ug < rnd) {
                    setMsg("Too Low! Try Again..");
                    return false;
                }
                if (ug > rnd) {
                    setMsg("Too high! Try Again..");
                    return false;
                }
            }
        } else {
            setMsg("No more moves.. Please Reset!");
            return false;
        }
        setMsg("err");
        return false;
    }


    // game reset function
    public void game_reset() {
        setUserGuessCount((short) 0);
        setTheNumber();
        setMsg("");
    }

    // count user's remaining plays
    public short getuserGuessRemain() {
        short count = (short) (10 - getUserGuessCount());
        if (count < 0)
            count = 0;
        return count;
    }

}
