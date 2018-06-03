package personal.system.com.dhwanitaskabhinav.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

import personal.system.com.dhwanitaskabhinav.R;
import personal.system.com.dhwanitaskabhinav.app.Prefs;
import personal.system.com.dhwanitaskabhinav.model.LoginResponseModel;
import personal.system.com.dhwanitaskabhinav.rest.ApiClient;
import personal.system.com.dhwanitaskabhinav.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText userName,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.login_userName);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String pass = password.getText().toString();
                if(!(user.isEmpty()&&pass.isEmpty()))
                {
                    ApiInterface apiService =
                            ApiClient.getClient().create(ApiInterface.class);
                    HashMap<String,String> map=new HashMap<>();
                    map.put("username",user);
                    map.put("password",pass);
                    Call<LoginResponseModel> call = apiService.getLoginResult(map);
                    call.enqueue(new Callback<LoginResponseModel>() {
                        @Override
                        public void onResponse(Call<LoginResponseModel>call, Response<LoginResponseModel> response) {
                            if(response.isSuccessful()){
                            Prefs.saveToken(response.body().getToken());
                            Prefs.setLoggedIn(true);
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(LoginActivity.this, "UserName or Password incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<LoginResponseModel>call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Login Failed"+t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Please enter username and password first", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
