package com.example.cookieclicker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class CookieController {
    @FXML
    private Label numCookiesLabel;
    @FXML
    private Label cookiesPerSecLabel;
//    @FXML
//    private Button buyClickRateButton;
    @FXML
    private Button autoClickButton;

    private double numCookies = 0;
    private double CPS = 0;
    private double clickRate = 1;
    //private int buyClickRateCost = 20;

    private double autoClickCost = 20;

    private double autoClickDelta = 1.2;
    private double autoClickCPS = 0.1;

    @FXML
    protected void cookieButtonClick() {
        numCookies += clickRate;
        numCookiesLabel.setText(Double.toString(numCookies));

        setUpgradeAvailability();
    }

    @FXML
    protected void buyAutoClickButton() {

        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(autoClickCost, autoClickButton, autoClickCPS) ) {
            //change autoClickCost
            autoClickCost *= autoClickDelta;

            //set autoClickButton to reflect new cost
            autoClickButton.setText(Double.toString(autoClickCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    /**
     *
     * @param upgradeCost
     * @param upgradeButton
     * @param CPSBoost
     * @return returns true if there were sufficient funds to proceed with the purchase and returns false otherwise
     */
    private boolean buyUpgrade(double upgradeCost, Button upgradeButton, double CPSBoost) {
        //if we can afford the upgrade
        if(numCookies >= upgradeCost) {
            //subtract upgradeCost from total cookies
            numCookies -= upgradeCost;

            //set numCookiesLabel to new numCookies amount
            numCookiesLabel.setText(Double.toString(numCookies));

            //increase CPS by CPSBoost
            CPS += CPSBoost;

            //change CPS label
            cookiesPerSecLabel.setText(Double.toString(CPS));
            return true;
        }
        return false;
    }

    /**
     * sets the color of all upgrade buttons to signify if they can be purchased
     */
    private void setUpgradeAvailability() {
        if(numCookies >= autoClickCost)
            autoClickButton.setTextFill(Color.GREEN);
        else
            autoClickButton.setTextFill(Color.RED);
    }


    protected void setNumCookiesLabel()
//
//    @FXML
//    protected void buyClickRateButtonClick() {
//        //if there is enough cookies to buy the stat increase
//        if(numCookies >= buyClickRateCost) {
//
//            //subtract the number of cookies from the total
//            numCookies -= buyClickRateCost;
//
//            //increase the click rate
//            clickRate *= 2;
//
//            //increase the cost of the click rate boost for next purchase
//            buyClickRateCost *= 2;
//
//            //set the text of the buy click rate button to the new cost
//            buyClickRateButton.setText(Integer.toString(buyClickRateCost));
//
//            //set the new text for the number of cookies
//
//
//            //if the current amount of cookies is greater than the current cost of the stat boost then set the text
//            //color to green to reflect that it can be purchased
//            if(numCookies >= buyClickRateCost)
//                buyClickRateButton.setTextFill(Color.GREEN);
//            else //otherwise there isn't enough cookies to buy the boost so set the text fill to red
//                buyClickRateButton.setTextFill(Color.GREEN);
//        }
//    }

}