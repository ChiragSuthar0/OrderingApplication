package myapp.sgarg.orderingapplication;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Scene;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSignUp;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignUp.setOnClickListener(v -> {
//                btnSignUp.setText("Tapped");
            Toast.makeText(MainActivity.this, "SignUp Button is Pressed", Toast.LENGTH_SHORT).show();
        });
        btnSignIn.setOnClickListener(v -> {
//                btnSignIn.setText("Tapped");
            Toast.makeText(MainActivity.this, "SignIn Button is Pressed", Toast.LENGTH_SHORT).show();

            Intent catFact = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(catFact);
        });
    }
}