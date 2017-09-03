package tw.com.frankchang.houli.classno_02_order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etTbaleNumber;
    RadioButton rbCustomer, rbVIP, rbCoffee, rbBlackTea;
    CheckBox cb_A, cb_B, cb_C, cb_D;
    Button btnOrder;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewer();

        //設定背景淡化
        View v = findViewById(R.id.Content01);
        v.getBackground().setAlpha(30);
    }

    void findviewer(){
        etTbaleNumber=(EditText) findViewById(R.id.editText);

        rbCustomer = (RadioButton) findViewById(R.id.radioButton);
        rbVIP = (RadioButton) findViewById(R.id.radioButton2);

        rbCoffee = (RadioButton) findViewById(R.id.radioButton3);
        rbBlackTea = (RadioButton) findViewById(R.id.radioButton4);

        cb_A = (CheckBox) findViewById(R.id.checkBox);
        cb_B = (CheckBox) findViewById(R.id.checkBox2);
        cb_C = (CheckBox) findViewById(R.id.checkBox3);
        cb_D = (CheckBox) findViewById(R.id.checkBox4);

        btnOrder = (Button) findViewById(R.id.button);
        btnOrder.setOnClickListener(btnOrder_Clicker);

        tvShow = (TextView) findViewById(R.id.textView4);
    }

    View.OnClickListener btnOrder_Clicker = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            double d_Money = 0.0;

            StringBuilder sb = new StringBuilder();
            //桌號
            sb.append(getResources().getText(R.string.TableNumber));
            sb.append(etTbaleNumber.getText().toString()).append("\n");
            //客戶類型
            sb.append(getResources().getText(R.string.client));
            if (rbCustomer.isChecked()){
                sb.append(rbCustomer.getText());
            }
            else{
                sb.append(rbVIP.getText());
            }
            sb.append("\n--------------------\n");
            //主餐
            sb.append(getResources().getText(R.string.Main_meal)).append("：\n\t");
            if (cb_A.isChecked()) {
                sb.append(cb_A.getText()).append("　");
                d_Money += 100.0;
            }
            if (cb_B.isChecked()) {
                sb.append(cb_B.getText()).append("　");
                d_Money += 150.0;
            }
            if (cb_C.isChecked()) {
                sb.append(cb_C.getText()).append("　");
                d_Money += 200.0;
            }
            if (cb_D.isChecked()) {
                sb.append(cb_D.getText()).append("　");
                d_Money += 250.0;
            }
            sb.append("\n--------------------\n");
            //附餐飲料
            sb.append(getResources().getText(R.string.Beverage)).append("：\n\t");
            if (rbCoffee.isChecked()){
                sb.append(rbCoffee.getText());
            }
            else{
                sb.append(rbBlackTea.getText());
            }

            sb.append("\n--------------------\n");

            //金額
            sb.append(getResources().getText(R.string.totle));
            if (rbVIP.isChecked()){
                sb.append(d_Money * 0.9);
            }
            else {
                sb.append(d_Money);
            }
            sb.append(getResources().getText(R.string.dollar));

            tvShow.setText(sb);
        }
    };
}
