package com.example.cookieclicker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class CookieController {
    @FXML
    private Label totalCookiesLabel;
    @FXML
    private Label cookiesPerSecLabel;
    @FXML
    private Button buyClickRateButton;
    @FXML
    private Button buyPassiveButton;

    private int numCookies = 0;
    private int clickRate = 1;
    private int buyClickRateCost = 20;
    private int buyPassiveCost = 20;

    @FXML
    protected void cookieButtonClick() {
        numCookies += clickRate;
        totalCookiesLabel.setText(Integer.toString(numCookies));
        if(numCookies >= buyClickRateCost)
            buyClickRateButton.setTextFill(Color.GREEN);
        if(numCookies >= buyPassiveCost)
            buyPassiveButton.setTextFill(Color.GREEN);
    }

    @FXML
    protected void buyClickRateButtonClick() {
        //if there is enough cookies to buy the stat increase
        if(numCookies >= buyClickRateCost) {

            //subtract the number of cookies from the total
            numCookies -= buyClickRateCost;

            //increase the click rate
            clickRate *= 2;

            //increase the cost of the click rate boost for next purchase
            buyClickRateCost *= 2;

            //set the text of the buy click rate button to the new cost
            buyClickRateButton.setText(Integer.toString(buyClickRateCost));

            //set the new text for the number of cookies


            //if the current amount of cookies is greater than the current cost of the stat boost then set the text
            //color to green to reflect that it can be purchased
            if(numCookies >= buyClickRateCost)
                buyClickRateButton.setTextFill(Color.GREEN);
            else //otherwise there isn't enough cookies to buy the boost so set the text fill to red
                buyClickRateButton.setTextFill(Color.GREEN);
        }
    }

}