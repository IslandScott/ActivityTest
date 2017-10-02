package com.example.activitytest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {
    private int flag = 1;
    private LocalBroadcastManager localBroadcastManger ;
    private List<RecycleList> recycleLists = new ArrayList<>();
//    public static void actionStart(Context context,String data1,String data2){
//        Intent intent = new Intent(context,SecondActivity.class);
//        intent.putExtra("param1",data1);
//        intent.putExtra("param2",data2);
//        context.startActivity(intent);
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main,menu);
//        return true;
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.d("FirstActivity","onRestart");
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch(requestCode){
//            case 1:
//                if(resultCode == RESULT_OK){
//                    String returnData = data.getStringExtra("data_return");
//                    Log.d("FirstActivity",returnData);
//                }
//                break;
//            default:
//
//        }
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch(item.getItemId()){
//            case R.id.add_item:
//                Toast.makeText(this,"You clicked Add", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.remove_item:
//                Toast.makeText(this,"You Clicked Remove",Toast.LENGTH_SHORT).show();
//                break;
//
//        }
//        return true;
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclelist_main);
//        ActionBar actionbar = getSupportActionBar();
//        if(actionbar != null){
//             actionbar.hide();
//        }

        Log.d("FirstActivity",this.toString());
        Log.d("FirstActivity","Task_id is"+getTaskId() );
//        setContentView(R.layout.first_layout);

        initRecyclerList();
        //添加适配器件
        RecycelerAdapter recyclerAdapter = new RecycelerAdapter(FirstActivity.this,R.layout.recyclelist_item
                ,recycleLists);
        ListView listViewb = (ListView) findViewById(R.id.recyclerList_view);
        listViewb.setAdapter(recyclerAdapter);
        listViewb.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RecycleList recycleList = recycleLists.get(position);
                String name = recycleList.getName();
                //刚才所犯的错误是将recycleLists认为里面只有一个类，其实里面有很多个类
                //要先选中其中的一个类才行
                //String name = recycleLists.getClass().getName();
                Intent intent = new Intent();
                Intent intent2 = new Intent();
                if(name.equals("显示TOAST信息")){
                    intent = new Intent(FirstActivity.this,SecondActivity.class);
                    flag =1;
                    Toast.makeText(FirstActivity.this,"attention", Toast.LENGTH_LONG).show();
                }
                if(name.equals("开启另外一个活动")){
                    String data = "Hello SecondActivity";
                        intent = new Intent(FirstActivity.this,SecondActivity.class);
                        intent.putExtra("extra_data",data);
                    flag =1;
                }
                if(name.equals("开启隐藏活动")){
                    intent = new Intent("com.example.activitytest.ACTION_START");
                       intent.addCategory("com.example.activitytest.MY_CATEGORY");
                    flag =1;
                }
                if(name.equals("开启网页")){
                    intent = new Intent(Intent.ACTION_VIEW);
                       intent.setData(Uri.parse("http://www.baidu.com"));
                    flag =1;
                }
                if(name.equals("用另一种方式开启网页")){
                    flag =1;
                    //Intent intent_communication = new Intent("android.intent.action.VIEW");
                }
                if(name.equals("返回数据给上一个结构")){
                    String data = "Hello SecondActivity";
                        intent = new Intent(FirstActivity.this,FifthActivity.class);
                    flag =1;
                }
                if(name.equals("杀死所有进程")){
                    ActivityCollector.finishAll();
                    flag =1;
                }
                if(name.equals("UIWIDGETTEST")){
                    intent = new Intent(FirstActivity.this,SixActivity.class);
                    flag =1;
                }
                if(name.equals("ListView")){
                    intent = new Intent(FirstActivity.this,List_View.class);
                    flag =1;
                }
                if(name.equals("RecyclerView")){
                    intent = new Intent(FirstActivity.this,RecycleActivity.class);
                    flag =1;
                }
                if(name.equals("Dialog")){
                    intent = new Intent(FirstActivity.this,Dialog1.class);
                    flag =1;
                }
                if(name.equals("FragmentTest")){
                    intent = new Intent(FirstActivity.this,Fragment_test.class);
                    flag =1;
                }
                //positon == 12
                if(position == 12){
                    Toast.makeText(FirstActivity.this,"abc",Toast.LENGTH_SHORT);
                    intent = new Intent(FirstActivity.this,ActivityMain.class);
                    flag =1;
                }

                if(name.equals("BroadcastReceiver")){
                    intent = new Intent(FirstActivity.this,BroadcastActivity.class);
                    flag =1;
                }

                if(name.equals("BroadcastTrigger")){
                    //发送有序广播
                    intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
                    sendBroadcast(intent);
                    //发送标准广播
                    intent2 = new Intent("com.example.broadcasttest.ORDERED_BROADCAST");
                    sendOrderedBroadcast(intent2,null);
                    flag =2;
                }

                if(name.equals("LocalBroadcastTrigger")){
                    //发送有序广播
                    intent = new Intent(FirstActivity.this,LocalBroadcastActivity.class);
                    startActivity(intent);
                    //intent2 = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
                    //localBroadcastManger.sendBroadcast(intent2);
                    flag =2;
                }

                if(name.equals("LoginFunction")){
                    intent = new Intent(FirstActivity.this,LoginActivity.class);
                    flag =1;
                }

                if(flag == 1){
                    startActivity(intent);
                }

            }
        });
        //前面要添加（Button） 声明为Button类别
//        Button newbutton = (Button)findViewById(R.id.button_1);
//        Button start_activity_button = (Button)findViewById(R.id.button_start);
//        Button hidden_activity_button = (Button)findViewById(R.id.button_hidden);
//        Button internet_activity_button = (Button)findViewById(R.id.button_internet);
//        Button open_intenet_by_activity = (Button)findViewById(R.id.button_4);
//        Button backdata = (Button)findViewById(R.id.button_5);
//        Button FinishActivity = (Button)findViewById(R.id.button_6);
//        Button TextView = (Button)findViewById(R.id.button_7);
//        Button List_View = (Button)findViewById(R.id.list_view);
//        Button Recycle_View = (Button)findViewById(R.id.button_20);
//        Button Dialog_button = (Button)findViewById(R.id.button_21);
//        Button Fragment_button = (Button)findViewById(R.id.button_fragment);
//        Button News_test = (Button)findViewById(R.id.news_test);



//        newbutton.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                        startActivity(intent);
//                        //finish();
//                        Toast.makeText(FirstActivity.this,"attention", Toast.LENGTH_LONG).show();
//                    }
//
//                }
//        );
//
//        start_activity_button.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        String data = "Hello SecondActivity";
//                        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                        intent.putExtra("extra_data",data);
//                        startActivity(intent);
//                    }
//
//                }
//        );
//
//        hidden_activity_button.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intent = new Intent("com.example.activitytest.ACTION_START");
//                        intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                        startActivity(intent);
//                    }
//
//                }
//        );
//
//        internet_activity_button.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intent = new Intent(Intent.ACTION_VIEW);
//                        intent.setData(Uri.parse("http://www.baidu.com"));
//                        startActivity(intent);
//                    }
//
//                }
//        );
//
//        open_intenet_by_activity.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        //只要匹配信息就可以启动
//                        Intent intent_communication = new Intent("android.intent.action.VIEW");
//                        startActivity(intent_communication);
//                    }
//
//                }
//        );
//
//        backdata.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        String data = "Hello SecondActivity";
//                        Intent intent = new Intent(FirstActivity.this,FifthActivity.class);
//                        startActivityForResult(intent,1);
//                    }
//
//                }
//        );
//
//        FinishActivity.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                       ActivityCollector.finishAll();
//                    }
//
//                }
//        );
//
//        TextView.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intent = new Intent(FirstActivity.this,SixActivity.class);
//                        startActivity(intent);
//                    }
//
//                }
//        );
//
//        List_View.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intent = new Intent(FirstActivity.this,List_View.class);
//                        startActivity(intent);
//                    }
//
//                }
//        );
//
//        Recycle_View.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intent = new Intent(FirstActivity.this,RecycleActivity.class);
//                        startActivity(intent);
//                    }
//
//                }
//        );
//
//        Dialog_button.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intent = new Intent(FirstActivity.this,Dialog1.class);
//                        startActivity(intent);
//                    }5
//
//                }
//        );
//
//        Fragment_button.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intent = new Intent(FirstActivity.this,Fragment_test.class);
//                        startActivity(intent);
//
//                    }
//
//                }
//        );
//
//        News_test.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intent = new Intent(FirstActivity.this,ActivityMain.class);
//                        startActivity(intent);
//
//                    }
//
//                }
//        );

        }//onCreate
        private void initRecyclerList(){
            RecycleList tost = new RecycleList("显示TOAST信息");
            recycleLists.add(tost);

            RecycleList startAnotherActivity = new RecycleList("开启另外一个活动");
            recycleLists.add(startAnotherActivity);

            RecycleList startHiddenActivity = new RecycleList("开启隐藏活动");
            recycleLists.add(startHiddenActivity);

            RecycleList startNet = new RecycleList("开启网页");
            recycleLists.add(startNet);

            RecycleList startNetByOtherWay = new RecycleList("用另一种方式开启网页");
            recycleLists.add(startNetByOtherWay);

            RecycleList returnData = new RecycleList("返回数据给上一个结构");
            recycleLists.add(returnData);

            RecycleList kilAllProcess = new RecycleList("杀死所有进程");
            recycleLists.add(kilAllProcess);

            RecycleList UIWIDGETTEST = new RecycleList("UIWIDGETTEST");
            recycleLists.add(UIWIDGETTEST);

            RecycleList ListView = new RecycleList("ListView");
            recycleLists.add(ListView);

            RecycleList RecyclerView = new RecycleList("RecyclerView");
            recycleLists.add(RecyclerView);

            RecycleList Dialog = new RecycleList("Dialog");
            recycleLists.add(Dialog);

            RecycleList FragmentTest = new RecycleList("FragmentTest");
            recycleLists.add(FragmentTest);


            RecycleList NewsTest = new RecycleList("NewsTest");
            recycleLists.add(NewsTest);

            RecycleList BroadcastReceverTest = new RecycleList("BroadcastReceiver");
            recycleLists.add(BroadcastReceverTest);

            RecycleList BroadcastTrigger = new RecycleList("BroadcastTrigger");
            recycleLists.add(BroadcastTrigger);

            RecycleList LocalBroadcastTrigger = new RecycleList("LocalBroadcastTrigger");
            recycleLists.add(LocalBroadcastTrigger);

            RecycleList LoginFunction = new RecycleList("LoginFunction");
            recycleLists.add(LoginFunction);
        }

    }

