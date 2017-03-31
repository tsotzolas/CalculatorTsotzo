package tsotzolas.ps.com.calculatortsotzo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView helloTextView;
    private Button blueButton;
    TextView strR;
    String str = "";
    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnC;
    Button btnR;
    Button btnDot;

    TextView tvResult;
    TextView textResult;
    TextView tvResultRiza;


    String oper = "";
    //Keep in mind that there is no need to add a reference to a red button!


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        switch (getResources().getConfiguration().orientation) {
//            case Configuration.ORIENTATION_PORTRAIT:
//                setContentView(R.layout.activity_main);
//                break;
//            case Configuration.ORIENTATION_LANDSCAPE:
//                setContentView(R.layout.activity_main);
//                break;
//        }
        setContentView(R.layout.activity_main);

        strR = (TextView) findViewById(R.id.strR);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnR = (Button) findViewById(R.id.btnR);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnC = (Button) findViewById(R.id.btnC);
        btnDot = (Button) findViewById(R.id.btnDot);

        tvResult = (TextView) findViewById(R.id.tvResult);
        textResult = (TextView) findViewById(R.id.textResult);


        // set a listener
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnR.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnDot.setOnClickListener(this);


        System.out.println("Test");
        System.out.println("Test!");


    }


    @Override
    protected void onSaveInstanceState(Bundle SavedInstanceState) {
        super.onSaveInstanceState(SavedInstanceState);
        SavedInstanceState.putString("str", str);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        strR.setText(savedInstanceState.getString("str"));
        str = String.valueOf(strR.getText());
    }


    @Override
    public void onClick(View v) {

        float num0 = 0;
        float num1 = 1;
        float num2 = 2;
        float num3 = 3;
        float num4 = 4;
        float num5 = 5;
        float num6 = 6;
        float num7 = 7;
        float num8 = 8;
        float num9 = 9;

        float result = 0;
        // write operation into oper, we will use it later for output
        if (str.contains("=")) {
            str = "";
        }
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                str = str + oper;
                break;
            case R.id.btnSub:
                oper = "-";
                str = str + oper;
                break;
            case R.id.btnMult:
                oper = "*";
                str = str + oper;
                break;
            case R.id.btnDiv:
                oper = "/";
                str = str + oper;
                break;
            case R.id.btn0:
                str = str + 0;
                break;
            case R.id.btn1:
                str = str + 1;
                break;
            case R.id.btn2:
                str = str + 2;
                break;
            case R.id.btn3:
                str = str + 3;
                break;
            case R.id.btn4:
                str = str + 4;
                break;
            case R.id.btn5:
                str = str + 5;
                break;
            case R.id.btn6:
                str = str + 6;
                break;
            case R.id.btn7:
                str = str + 7;
                break;
            case R.id.btn8:
                str = str + 8;
                break;
            case R.id.btn9:
                str = str + 9;
                break;
            case R.id.btnDot:
                str = str + ".";
                break;
            case R.id.btnC:
                str = "";
                break;
            case R.id.btnR:
                if (str.contains("/0")) {
                    str = "0";
                }
                try {
                    result = (float) calc(str);
                    str = str + "=" + result;
                } catch (Exception e) {
                    Context context = getApplicationContext();
                    CharSequence text = "You make a mistake";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context,text,duration);
                    toast.show();
                    str = "0";
                }


                break;
            default:
                break;
        }

        strR.setText(str);

//        textResult.setText(String.valueOf(result));
    }

    private double calc(String str) {

        Calculable calc = null;
        double result1 = 0;
        try {
            calc = new ExpressionBuilder(str).build();
            result1 = calc.calculate();
        } catch (UnknownFunctionException e) {
            e.printStackTrace();

        } catch (UnparsableExpressionException e) {
            e.printStackTrace();
        }
        return result1;
    }


    /**
     * Makes the text color red.
     */
    public void changeColorToRed(View view) {
        helloTextView.setTextColor(getResources().getColor(R.color.colorUnipiRed));
    }
}
