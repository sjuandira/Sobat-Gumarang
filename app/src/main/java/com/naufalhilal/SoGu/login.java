package com.naufalhilal.SoGu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.naufalhilal.SoGu.Utilities.Constants;
import com.naufalhilal.SoGu.Utilities.PreferenceManager;
import com.naufalhilal.SoGu.databinding.ActivityLoginBinding;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;

public class login extends AppCompatActivity {

    private EditText userEdt, pasEdt;
    private Button buttonLgn;
    private ActivityLoginBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceManager=new PreferenceManager(getApplicationContext());
//        if (preferenceManager.getBoolean(Constants.KEY_IS_SIGNED_IN)){
//            Intent intent=new Intent(getApplicationContext(),searchTiket.class);
//            startActivity(intent);
//            finish();
//        }
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().hide();

//        initView();
//        setVariable();
        setListeners();
    }
//    private void setVariable(){
//        buttonLgn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(userEdt.getText().toString().isEmpty() || pasEdt.getText().toString().isEmpty()){
//                    Toast.makeText(login.this, "Please fill the form", Toast.LENGTH_SHORT).show();
//                }else{
//                    startActivity(new Intent(login.this, searchTiket.class));
//                    finish();
//                }
//            }
//        });
//
//    }
//
//    private void initView(){
//        userEdt = findViewById(R.id.editTextTextPersonName);
//        pasEdt = findViewById(R.id.editTextTextPassword);
//        buttonLgn = findViewById(R.id.buttonlg);
//    }

    private void setListeners(){
        binding.signUp.setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(),sign_up.class)));
        binding.buttonlg.setOnClickListener(view -> {
            if (isValidSignInDetails()){
                signIn();
            }
        });
    }

    private void signIn() {
        loading(true);
        FirebaseFirestore database=FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_COLLECTION_USERS)
                .whereEqualTo(Constants.KEY_EMAIL,binding.editTextTextPersonName.getText().toString())
                .whereEqualTo(Constants.KEY_PASSWORD,binding.editTextTextPassword.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()&&task.getResult()!=null&&task.getResult().getDocuments().size()>0){
                        DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                        preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN,true);
                        preferenceManager.putString(Constants.KEY_USER_ID,documentSnapshot.getId());
                        preferenceManager.putString(Constants.KEY_NAME,documentSnapshot.getString(Constants.KEY_NAME));
                        preferenceManager.putString(Constants.KEY_IMAGE,documentSnapshot.getString(Constants.KEY_IMAGE));
                        Intent intent = new Intent(getApplicationContext(),searchTiket.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }else {
                        loading(false);
                        showToast("gagal melakukan login");
                    }
                });
    }

    private void loading(boolean isLoading){
        if(isLoading){
            binding.buttonlg.setVisibility(View.INVISIBLE);
            binding.progressbar.setVisibility(View.VISIBLE);
        }else{
            binding.buttonlg.setVisibility(View.VISIBLE);
            binding.progressbar.setVisibility(View.INVISIBLE);
        }
    }

    private void showToast(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }
    private boolean isValidSignInDetails(){
        if (binding.editTextTextPersonName.getText().toString().trim().isEmpty()){
            showToast("masukan email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.editTextTextPersonName.getText().toString()).matches()) {
            showToast("masukan email yang valid");
            return false;
        } else if (binding.editTextTextPassword.getText().toString().trim().isEmpty()) {
            showToast("masukan password");
            return false;
        }else{
            return true;
        }
    }
}