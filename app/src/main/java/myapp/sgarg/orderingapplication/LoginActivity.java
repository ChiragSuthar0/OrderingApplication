package myapp.sgarg.orderingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private EditText edt_Username;
    private EditText edt_Password;
    private Button btn_SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_Username = findViewById(R.id.txt_UserName);
        edt_Password = findViewById(R.id.txt_Password);
        btn_SignIn = findViewById(R.id.btn_LogIn);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance("https://fir-garg-d89-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = firebaseDatabase.getReference("user");

        btn_SignIn.setOnClickListener(V -> {
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User user = snapshot.child(edt_Username.getText().toString()).getValue(User.class);
                    
                    if (user == null) {
                        Toast.makeText(LoginActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    
                    if (user.getPassword().equals(edt_Password.getText().toString())) {
                        Toast.makeText(LoginActivity.this, "Sign In Successful!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    
                }
            });
        });

    }
}