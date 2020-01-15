package br.com.neiberth.autohome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText emailIdET, passwordET;
    Button signInBtn;
    FirebaseAuth nFirebaseAuth;

    private FirebaseAuth.AuthStateListener nAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nFirebaseAuth = FirebaseAuth.getInstance();
        emailIdET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        signInBtn = findViewById(R.id.signInBt);

        nAuthStateListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser nFirebaseUser = nFirebaseAuth.getCurrentUser();
                if(nFirebaseUser != null){
                    Toast.makeText(MainActivity.this, "Você esta logado", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Login",Toast.LENGTH_SHORT).show();
                }
            }
        };

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailIdET.getText().toString();
                String password = passwordET.getText().toString();

                if(email.isEmpty()){
                    emailIdET.setError("Digite o seu E-mail");
                    emailIdET.requestFocus();
                }
                else if (password.isEmpty()){
                    passwordET.setError("Digite sua senha");
                    passwordET.requestFocus();
                }
                else if(!(email.isEmpty() && password.isEmpty())){
                    nFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Erro no Login, Faça o Login novamente", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intentHome = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intentHome);
                            }
                        }
                    });

                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        nFirebaseAuth.addAuthStateListener(nAuthStateListener);
    }
}
