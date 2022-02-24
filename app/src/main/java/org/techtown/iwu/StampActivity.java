package org.techtown.iwu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.OnClick;

// 메인화면에서 stamp 버튼 클릭 시 나타나는 Activity

public class StampActivity extends AppCompatActivity {
    Button Mapstamp;
    int userBuilding;
    TextView u_mid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stamp);
        ButterKnife.bind(this); // ButterKnife 라이브러리 사용 (gradle에 따로 선언 해야 함)

        Intent intent = getIntent();
        userBuilding = intent.getIntExtra("u_Building", 15); // 앞의 MainActivity에서 majorcode 받음

        u_mid = (TextView) findViewById(R.id.stamp12txt); // 12번째 스탬프 textview 주소 받아서
        u_mid.setText(userBuilding + "호관"); // 위의 mapselect 삽입

        MarkStamp(); //[ay.han] 스탬프찍음여부에 따라 아이콘 변경

        Mapstamp = (Button) findViewById(R.id.MapStamp); // stamp내의 2D MAP으로 스탬프현황 보기
        Mapstamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapInStampActivity.class); // MapInStampActivity 실행
                intent.putExtra("u_Building", userBuilding);
                startActivity(intent); // MapInStampActivity 수행
            }
        });
    }


    // 각 건물의 stamp 영역을 누르면 나타나는 WhereActivity 설정
    @OnClick(R.id.stamp1) void where1(){
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 1);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp2) void where2() {
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 2);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp3) void where3() {
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 6);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp4) void where4() {
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 11);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp5) void where5(){
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 12);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp6) void where6(){
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 17);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp7) void where7(){
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 18);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp8) void where8(){
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 24);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp9) void where9() {
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 30);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp10) void where10() {
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 31); //미유카페
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp11) void where11() {
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", 32); //솔찬공원
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }

    @OnClick(R.id.stamp12) void where12() {
        Intent intent = new Intent(StampActivity.this, WhereStampActivity.class);
        intent.putExtra("where", userBuilding);
        intent.putExtra("u_Building", userBuilding);
        startActivity(intent);
    }
    public void MarkStamp(){
        Intent intent = getIntent();
        String u_id = intent.getStringExtra("u_id"); // [ay.han]MainActivity에서 u_id 받기

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JO = new JSONObject(response);
                    boolean success = JO.getBoolean("success");

                    if (success) {
                        int b1_stamp = JO.getInt("b1_stamp");
                        int b2_stamp = JO.getInt("b2_stamp");
                        int b6_stamp = JO.getInt("b6_stamp");
                        int b11_stamp = JO.getInt("b11_stamp");
                        int b12_stamp = JO.getInt("b12_stamp");
                        int b17_stamp = JO.getInt("b17_stamp");
                        int b18_stamp = JO.getInt("b18_stamp");
                        int b24_stamp = JO.getInt("b24_stamp");
                        int b30_stamp = JO.getInt("b30_stamp");
                        int b31_stamp = JO.getInt("b31_stamp");
                        int b32_stamp = JO.getInt("b32_stamp");
                        int b0_stamp = JO.getInt("b0_stamp");

                        if (b1_stamp == 1) {
                            ImageButton btn1 = (ImageButton) findViewById(R.id.stamp1);
                            btn1.setImageResource(R.drawable.stamp);
                        }if(b2_stamp == 1){
                            ImageButton btn2 = (ImageButton) findViewById(R.id.stamp2);
                            btn2.setImageResource(R.drawable.stamp);
                        }if(b6_stamp == 1){
                            ImageButton btn3 = (ImageButton) findViewById(R.id.stamp3);
                            btn3.setImageResource(R.drawable.stamp);
                        }if(b11_stamp == 1){
                            ImageButton btn4 = (ImageButton) findViewById(R.id.stamp4);
                            btn4.setImageResource(R.drawable.stamp);
                        }if(b12_stamp == 1){
                            ImageButton btn5 = (ImageButton) findViewById(R.id.stamp5);
                            btn5.setImageResource(R.drawable.stamp);
                        }if(b17_stamp == 1){
                            ImageButton btn6 = (ImageButton) findViewById(R.id.stamp6);
                            btn6.setImageResource(R.drawable.stamp);
                        }if(b18_stamp == 1){
                            ImageButton btn7 = (ImageButton) findViewById(R.id.stamp7);
                            btn7.setImageResource(R.drawable.stamp);
                        }if(b24_stamp == 1){
                            ImageButton btn8 = (ImageButton) findViewById(R.id.stamp8);
                            btn8.setImageResource(R.drawable.stamp);
                        }if(b30_stamp == 1){
                            ImageButton btn9 = (ImageButton) findViewById(R.id.stamp9);
                            btn9.setImageResource(R.drawable.stamp);
                        }if(b31_stamp == 1){
                            ImageButton btn10 = (ImageButton) findViewById(R.id.stamp10);
                            btn10.setImageResource(R.drawable.stamp);
                        }if(b32_stamp == 1){
                            ImageButton btn11 = (ImageButton) findViewById(R.id.stamp11);
                            btn11.setImageResource(R.drawable.stamp);
                        }if(b0_stamp == 1){
                            ImageButton btn12 = (ImageButton) findViewById(R.id.stamp12);
                            btn12.setImageResource(R.drawable.stamp);
                        } else {
                            Toast.makeText(getApplicationContext(), "가져오기 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        //[ay.han]DB연결 위한 StampRequest 실행
        StampRequest Request = new StampRequest(u_id, responseListener);
        RequestQueue queue = Volley.newRequestQueue(StampActivity.this);
        queue.add(Request);

    }
}