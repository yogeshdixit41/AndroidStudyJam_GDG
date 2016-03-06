package com.atandroidjam.yogesh.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class LaunchActivity extends AppCompatActivity {

    private int numberOfCoffeesOrdered = 0;
    private final int pricePerCoffee = 5;
    private final int paperCupCharge = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }

    /**
     * This method is called when the order button is clicked
     */
    public void submitOrder(View view)
    {
        String priceMessage = "";
        int finalPrice = calculatePrice(numberOfCoffeesOrdered);

        String finalOrderDescription = createOrderSummary(finalPrice);

        displayMessage(finalOrderDescription);
        displayQuantity(numberOfCoffeesOrdered);
        //displayPrice(numberOfCoffeesOrdered * pricePerCoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantityNumber) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + quantityNumber);
    }


    /**
     * increment coffee cups by 1
     */
    public void increment( View view)
    {
        displayQuantity(++numberOfCoffeesOrdered);
    }

    /**
     * decrement coffee cups by 1
     */
    public void decrement( View view)
    {
        if (numberOfCoffeesOrdered > 0)
            displayQuantity(--numberOfCoffeesOrdered);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity) {
        int price = quantity * pricePerCoffee;
        return price;

    }

    private int calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * pricePerCup;
        return price;
    }

    private String createOrderSummary(int price)
    {
        String orderDescription = "";
        if(price > 0)
            orderDescription = " Name : Yogesh Dixit \n Quantity: " + numberOfCoffeesOrdered + "\n Total: $"+ price+ "\n Thank You !";
        return orderDescription;
    }

}
