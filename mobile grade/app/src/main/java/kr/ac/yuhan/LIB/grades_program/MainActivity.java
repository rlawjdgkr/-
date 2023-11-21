package kr.ac.yuhan.LIB.grades_program;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText[] mobile = new EditText[3];
    Integer[] mobile_id = {R.id.mobile_Midterm,R.id.mobile_Final,R.id.mobile_Project};

    EditText[] java = new EditText[3];
    Integer[] java_id = {R.id.java_Midterm,R.id.java_Final,R.id.java_Project};

    EditText[] db = new EditText[3];
    Integer[] db_id = {R.id.db_Midterm,R.id.db_Final,R.id.db_Project};

    TextView[] result_t = new TextView[3];
    Integer[] result_id = {R.id.db_result, R.id.mobile_result, R.id.java_result};

    EditText[] check = new EditText[3];
    Integer[] check_id = {R.id.db_check, R.id.mobile_check, R.id.java_check};

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 3; i++) {
            db[i] = (EditText) findViewById(db_id[i]);
            mobile[i] = (EditText) findViewById(mobile_id[i]);
            java[i] = (EditText) findViewById(java_id[i]);
        }
        for (int i = 0; i < 3; i++) {
            check[i] = (EditText) findViewById(check_id[i]);
            result_t[i] = (TextView) findViewById(result_id[i]);
        }

        btn = findViewById(R.id.result_button);
        btn.setOnClickListener(btnL);

    };

    View.OnClickListener btnL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int result[] = {0,0,0};
            int minus[] = {0,0,0};
            for (int i = 0; i < 3; i++) {
                result[0] = result[0] + Integer.parseInt(db[i].getText().toString());
                result[1] = result[1] + Integer.parseInt(mobile[i].getText().toString());
                result[2] = result[2] + Integer.parseInt(java[i].getText().toString());
            }


            for (int i = 0; i < 3; i++) {
                minus[i] = Integer.parseInt(check[i].getText().toString());

                if(minus[i]>=12){
                    result[i] = 0;
                }
                else{
                    result[i] = result[i] - minus[i]/3;
                }
            }

            for (int i = 0; i < 3; i++) {
                switch (result[i]/5){
                    case 20:
                    case 19:
                        result_t[i].setText("A+");
                        break;
                    case 18:
                        result_t[i].setText("A");
                        break;
                    case 17:
                        result_t[i].setText("B+");
                        break;
                    case 16:
                        result_t[i].setText("B");
                        break;
                    case 15:
                        result_t[i].setText("C+");
                        break;
                    case 14:
                        result_t[i].setText("C");
                        break;
                    case 13:
                        result_t[i].setText("D+");
                        break;
                    case 12:
                        result_t[i].setText("D");
                        break;
                    default:
                        result_t[i].setText("F");
                        break;

                }
            }





        }
    };
}