package com.example.homeworkweek3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nameTextview = (TextView) findViewById(R.id.name);
        TextView phoneTextview = (TextView) findViewById(R.id.phone);
        RadioGroup cheeseRadioGroup = (RadioGroup) findViewById(R.id.cheeseRadioGroup);
        RadioGroup shapeRadioGroup = (RadioGroup) findViewById(R.id.shapeRadioGroup);
        CheckBox pepperoniCheckBox = (CheckBox) findViewById(R.id.pepperoni);
        CheckBox mushroomCheckBox = (CheckBox) findViewById(R.id.mushroom);
        CheckBox veggiesCheckBox = (CheckBox) findViewById(R.id.veggies);
        TextView orderTextview = (TextView) findViewById(R.id.ordering);
        Button exit = (Button) findViewById(R.id.exit);
        Button order = (Button) findViewById(R.id.order);

        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameTextview.getText().toString();
                if (name.equals("")) {
                    Toast.makeText(MainActivity.this, "Name field is missing", Toast.LENGTH_SHORT).show();
                    return;
                }
                String phone = phoneTextview.getText().toString();
                if (phone.equals("")) {
                    Toast.makeText(MainActivity.this, "Phone field is missing", Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectedCheeseIndex = cheeseRadioGroup.getCheckedRadioButtonId();
                if (selectedCheeseIndex == -1) {
                    Toast.makeText(MainActivity.this, "Cheese field can not missing", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton selectedCheeseRadioButton  = (RadioButton) findViewById(selectedCheeseIndex);
                String cheese = selectedCheeseRadioButton.getText().toString();

                int selectedShapeIndex = shapeRadioGroup.getCheckedRadioButtonId();
                if (selectedShapeIndex == -1) {
                    Toast.makeText(MainActivity.this, "Shape field can not missing", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton selectedShapeRadioButton  = (RadioButton) findViewById(selectedShapeIndex);
                String shape = selectedShapeRadioButton.getText().toString();

                List<String> toppings = new ArrayList<>();
                if (pepperoniCheckBox.isChecked()) {
                    toppings.add(pepperoniCheckBox.getText().toString());
                }
                if (mushroomCheckBox.isChecked()) {
                    toppings.add(mushroomCheckBox.getText().toString());
                }
                if (veggiesCheckBox.isChecked()) {
                    toppings.add(veggiesCheckBox.getText().toString());
                }

                orderTextview.setText(formatOrder(name, phone, cheese, shape, toppings));
            }
        });
    }

    public String formatOrder(String name, String phone, String cheese, String shape, List<String> toppings) {
        String res = "";
        res += "Name: ";
        res += name;
        res += "\n";

        res += "Phone: ";
        res += phone;
        res += "\n";

        res += "Cheese: ";
        res += cheese;
        res += "\n";

        res += "Shape: ";
        res += shape;
        res += "\n";

        if (toppings.size() == 0) {
            res += "Topping: None";
        } else {
            res += "Topping: ";
            for (int i = 0; i < toppings.size(); ++ i) {
                res += toppings.get(i);
                if (i != toppings.size() - 1) {
                    res += ", ";
                }
            }
        }
        return res;
    }
}