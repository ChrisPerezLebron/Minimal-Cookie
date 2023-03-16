package dev.chrisperezlebron.cookieclicker;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class CookieController implements Initializable {
    @FXML
    private Label numCookiesLabel;
    private Double numCookies = Double.valueOf(0);
    private double clickRate = 1;
    @FXML
    private Label cookiesPerSecLabel;
    private double CPS = 0;
//    @FXML
//    private Button buyClickRateButton;
    @FXML
    private Button autoClickButton;
    private double autoClickCost = 20;
    private double autoClickDelta = 1.01;
    private double autoClickCPS = 0.1;

    @FXML
    private Button grandmaButton;
    private double grandmaCost = 47;
    private double grandmaDelta = 1.01;
    private double grandmaCPS = 0.3;


    @FXML
    private Button mrBakerButton;
    private double mrBakerCost = 132;
    private double mrBakerDelta = 1.01;
    private double mrBakerCPS = 1.1;

    @FXML
    private Button cRobotButton;
    private double cRobotCost = 381;
    private double cRobotDelta = 1.01;
    private double cRobotCPS = 4.0;

    @FXML
    private Button cookieFarmButton;
    private double cookieFarmCost = 879;
    private double cookieFarmDelta = 1.01;
    private double cookieFarmCPS = 10.8;

    @FXML
    private Button cFactoryButton;
    private double cFactoryCost = 2355;
    private double cFactoryDelta = 1.01;
    private double cFactoryCPS = 33;

    @FXML
    private Button sFactoryButton;
    private double sFactoryCost = 5497;
    private double sFactoryDelta = 1.01;
    private double sFactoryCPS = 86;

    @FXML
    private Button xFactoryButton;
    private double xFactoryCost = 16138;
    private double xFactoryDelta = 1.01;
    private double xFactoryCPS = 280;

    @FXML
    private Button cookieClonerButton;
    private double cookieClonerCost = 37001;
    private double cookieClonerDelta = 1.01;
    private double cookieClonerCPS = 720;

    @FXML
    private Button cAcceleratorButton;
    private double cAcceleratorCost = 88087;
    private double cAcceleratorDelta = 1.01;
    private double cAcceleratorCPS = 1900;


    @FXML
    private Button electronCookieButton;
    private double electronCookieCost = 240484;
    private double electronCookieDelta = 1.01;
    private double electronCookieCPS = 5800;

    @FXML
    private Button atomicCButton;
    private double atomicCCost = 709756;
    private double atomicCDelta = 1.01;
    private double atomicCCPS = 19000;

    @FXML
    private Button cookieVolcanoButton;
    private double cookieVolcanoCost = 1432628;
    private double cookieVolcanoDelta = 1.01;
    private double cookieVolcanoCPS = 45000;

    @FXML
    private Button earthquakeCButton;
    private double earthquakeCCost = 3423729;
    private double earthquakeCDelta = 1.01;
    private double earthquakeCCPS = 130000;













    //private int buyClickRateCost = 20;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //use TimeLine to update numCookies every second based on current CPS ammount
        Timeline updateCPS = new Timeline(
                new KeyFrame(Duration.seconds(0.1),
                        new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                addToNumCookiesAndLabel(CPS);
                                System.out.println("updated");
                            }
                        }));
        updateCPS.setCycleCount(Timeline.INDEFINITE);
        updateCPS.play();
    }

    @FXML
    protected void cookieButtonClick() {
        addToNumCookiesAndLabel(clickRate);
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

    @FXML
    protected void buyGrandmaButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(grandmaCost, grandmaButton, grandmaCPS) ) {
            //change autoClickCost
            grandmaCost *= grandmaDelta;

            //set autoClickButton to reflect new cost
            grandmaButton.setText(Double.toString(grandmaCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buyMrBakerButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(mrBakerCost, mrBakerButton, mrBakerCPS) ) {
            //change autoClickCost
            mrBakerCost *= mrBakerDelta;

            //set autoClickButton to reflect new cost
            mrBakerButton.setText(Double.toString(mrBakerCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buyCRobotButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(cRobotCost, cRobotButton, cRobotCPS) ) {
            //change autoClickCost
            cRobotCost *= cRobotDelta;

            //set autoClickButton to reflect new cost
            cRobotButton.setText(Double.toString(cRobotCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buyCookieFarmButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(cookieFarmCost, cookieFarmButton, cookieFarmCPS) ) {
            //change cookieFarmCost
            cookieFarmCost *= cookieFarmDelta;

            //set cookieFarmButton to reflect new cost
            cookieFarmButton.setText(Double.toString(cookieFarmCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }


    @FXML
    protected void buyCFactoryButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(cFactoryCost, cFactoryButton, cFactoryCPS) ) {
            //change cFactoryCost
            cFactoryCost *= cFactoryDelta;

            //set cFactoryButton to reflect new cost
            cFactoryButton.setText(Double.toString(cFactoryCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buySFactoryButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(sFactoryCost, sFactoryButton, sFactoryCPS) ) {
            //change sFactoryCost
            sFactoryCost *= sFactoryDelta;

            //set sFactoryButton to reflect new cost
            sFactoryButton.setText(Double.toString(sFactoryCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buyXFactoryButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(xFactoryCost, xFactoryButton, xFactoryCPS) ) {
            //change xFactoryCost
            xFactoryCost *= xFactoryDelta;

            //set xFactoryButton to reflect new cost
            xFactoryButton.setText(Double.toString(xFactoryCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buyCookieClonerButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(cookieClonerCost, cookieClonerButton, cookieClonerCPS) ) {
            //change cookieClonerCost
            cookieClonerCost *= cookieClonerDelta;

            //set cookieClonerButton to reflect new cost
            cookieClonerButton.setText(Double.toString(cookieClonerCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buyCAcceleratorButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(cAcceleratorCost, cAcceleratorButton, cAcceleratorCPS) ) {
            //change cAcceleratorCost
            cAcceleratorCost *= cAcceleratorDelta;

            //set cAcceleratorButton to reflect new cost
            cAcceleratorButton.setText(Double.toString(cAcceleratorCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }
    @FXML
    protected void buyElectronCookieButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(electronCookieCost, electronCookieButton, electronCookieCPS) ) {
            //change electronCookieCost
            electronCookieCost *= electronCookieDelta;

            //set electronCookieButton to reflect new cost
            electronCookieButton.setText(Double.toString(electronCookieCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buyAtomicCButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(atomicCCost, atomicCButton, atomicCCPS) ) {
            //change atomicCCost
            atomicCCost *= atomicCDelta;

            //set atomicCButton to reflect new cost
            atomicCButton.setText(Double.toString(atomicCCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buyCookieVolcanoButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(cookieVolcanoCost, cookieVolcanoButton, cookieVolcanoCPS) ) {
            //change cookieVolcanoCost
            cookieVolcanoCost *= cookieVolcanoDelta;

            //set atomicCButton to reflect new cost
            cookieVolcanoButton.setText(Double.toString(cookieVolcanoCost));

            //conditionally set the color of all other buttons
            setUpgradeAvailability();
        }
    }

    @FXML
    protected void buyEarthquakeCButton() {
        //call buyUpgrade to do most of the purchasing work. If it returns true, proceed with the rest of the purchase
        //process
        if ( buyUpgrade(earthquakeCCost, earthquakeCButton, earthquakeCCPS) ) {
            //change earthquakeCCost
            earthquakeCCost *= earthquakeCDelta;

            //set earthquakeCButton to reflect new cost
            earthquakeCButton.setText(Double.toString(earthquakeCCost));

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


        if(numCookies >= grandmaCost)
            grandmaButton.setTextFill(Color.GREEN);
        else
            grandmaButton.setTextFill(Color.RED);

        if(numCookies >= mrBakerCost)
            mrBakerButton.setTextFill(Color.GREEN);
        else
            mrBakerButton.setTextFill(Color.RED);


        if(numCookies >= cRobotCost)
            cRobotButton.setTextFill(Color.GREEN);
        else
            cRobotButton.setTextFill(Color.RED);


        if(numCookies >= cookieFarmCost)
            cookieFarmButton.setTextFill(Color.GREEN);
        else
            cookieFarmButton.setTextFill(Color.RED);


        if(numCookies >= cFactoryCost)
            cFactoryButton.setTextFill(Color.GREEN);
        else
            cFactoryButton.setTextFill(Color.RED);


        if(numCookies >= sFactoryCost)
            sFactoryButton.setTextFill(Color.GREEN);
        else
            sFactoryButton.setTextFill(Color.RED);

        if(numCookies >= xFactoryCost)
            xFactoryButton.setTextFill(Color.GREEN);
        else
            xFactoryButton.setTextFill(Color.RED);


        if(numCookies >= cookieClonerCost)
            cookieClonerButton.setTextFill(Color.GREEN);
        else
            cookieClonerButton.setTextFill(Color.RED);


        if(numCookies >= cAcceleratorCost)
            cAcceleratorButton.setTextFill(Color.GREEN);
        else
            cAcceleratorButton.setTextFill(Color.RED);


        if(numCookies >= electronCookieCost)
            electronCookieButton.setTextFill(Color.GREEN);
        else
            electronCookieButton.setTextFill(Color.RED);

        if(numCookies >= atomicCCost)
            atomicCButton.setTextFill(Color.GREEN);
        else
            atomicCButton.setTextFill(Color.RED);

        if(numCookies >= cookieVolcanoCost)
            cookieVolcanoButton.setTextFill(Color.GREEN);
        else
            cookieVolcanoButton.setTextFill(Color.RED);

        if(numCookies >= earthquakeCCost)
            earthquakeCButton.setTextFill(Color.GREEN);
        else
            earthquakeCButton.setTextFill(Color.RED);
    }


    protected void addToNumCookiesAndLabel(double addAmount) {
        //to prevent race condition we only allow one
        synchronized (numCookies) {
            numCookies += addAmount;
        }

        numCookiesLabel.setText(Double.toString(numCookies));

        setUpgradeAvailability();
    }


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