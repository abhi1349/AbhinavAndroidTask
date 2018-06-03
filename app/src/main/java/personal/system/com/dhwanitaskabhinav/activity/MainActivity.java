package personal.system.com.dhwanitaskabhinav.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import personal.system.com.dhwanitaskabhinav.R;
import personal.system.com.dhwanitaskabhinav.adapter.StateAdapter;
import personal.system.com.dhwanitaskabhinav.app.Prefs;
import personal.system.com.dhwanitaskabhinav.model.BaseApiResponseModel;
import personal.system.com.dhwanitaskabhinav.model.Example1;
import personal.system.com.dhwanitaskabhinav.rest.ApiClient;
import personal.system.com.dhwanitaskabhinav.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import personal.system.com.dhwanitaskabhinav.R;


public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Spinner state, district;
    Button create, save;
    StateAdapter adapter;
    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    ArrayList<Example1.State> stateArrayList=new ArrayList<>();
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = findViewById(R.id.drawer);
        mNavigationView = findViewById(R.id.design_navigation_view);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.logout)
                {
                    Toast.makeText(MainActivity.this, "logout", Toast.LENGTH_SHORT).show();
                    Call<Example1> call = apiService.doLogout(Prefs.getToken());
                    call.enqueue(new Callback<Example1>() {
                        @Override
                        public void onResponse(Call<Example1>call, Response<Example1> response) {
                Toast.makeText(MainActivity.this, "aaa"+response.body().getMessage()+response.body(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                        }

                        @Override
                        public void onFailure(Call<Example1>call, Throwable t) {
                            Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }
                return false;
            }
        });


        state = findViewById(R.id.state);
        editText2 = findViewById(R.id.editText_state);
        create = findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Integer> map=new HashMap<>();
                map.put("state_id",stateArrayList.get(state.getSelectedItemPosition()).getId());
                HashMap<String,String> map2=new HashMap<>();
                map2.put("district_name",editText2.getText().toString());
                Call<BaseApiResponseModel> call = apiService.createDistrict(Prefs.getToken(),map2,map);
                call.enqueue(new Callback<BaseApiResponseModel>() {
                    @Override
                    public void onResponse(Call<BaseApiResponseModel>call, Response<BaseApiResponseModel> response) {
                        Toast.makeText(MainActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<BaseApiResponseModel>call, Throwable t) {
                        Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


        adapter=new StateAdapter(this,stateArrayList);
        state.setAdapter(adapter);
//use this code  for logout button.
        Call<Example1> call = apiService.getStateResult(Prefs.getToken());
        call.enqueue(new Callback<Example1>() {
            @Override
            public void onResponse(Call<Example1>call, Response<Example1> response) {
//                Toast.makeText(MainActivity.this, ""+response.body().getMessage()+response.body().getState(), Toast.LENGTH_SHORT).show();
                stateArrayList.clear();
                for (Example1.State statemodel:response.body().getState())
                    stateArrayList.add(statemodel);
                adapter.notifyDataSetChanged();
                //update list
                // notifydatasetChange();
            }

            @Override
            public void onFailure(Call<Example1>call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, ""+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
