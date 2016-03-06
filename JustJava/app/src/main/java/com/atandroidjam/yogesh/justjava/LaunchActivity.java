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

/*        Button orderButton = (Button) findViewById(R.id.OrderButton);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(1);
            }
        });
*/

    }

    /**
     * This method is called when the order button is clicked
     */
    public void submitOrder(View view)
    {
        String priceMessage = "";
        if(numberOfCoffeesOrdered > 0)
            priceMessage = "Total: $"+ numberOfCoffeesOrdered*5+"\nThank you!";
        else
            priceMessage = " Total: $0";
        displayMessage(priceMessage);
        displayQuantity(numberOfCoffeesOrdered);
        //displayPrice(numberOfCoffeesOrdered * pricePerCoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

        if(number == 0)
        {
            Toast.makeText(getApplicationContext(),"You can't buy happiness", Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "But you can buy COFFEE", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Enjoy your coffee, Thank you !!!", Toast.LENGTH_SHORT).show();

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
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
