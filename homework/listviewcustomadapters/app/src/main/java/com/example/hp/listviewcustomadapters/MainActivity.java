package com.example.hp.listviewcustomadapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final ArrayList<student> arrayname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayname.add(new student("naman", "it", "9910017741", "delhi"));
        arrayname.add(new student("ram", "it", "9910017742", "new delhi"));
        arrayname.add(new student("sahil", "it", "9910017743", "dwarka"));
        arrayname.add(new student("sunita", "it", "9910017744", "pitampura"));

        ListView ref=findViewById(R.id.list);
        ref.setAdapter(new mycustomadapter());
    }
        class mycustomadapter extends BaseAdapter{


           @Override
           public int getCount() {
               return arrayname.size();
           }

           @Override
           public Object getItem(int i) {
               return null;
           }

           @Override
           public long getItemId(int i) {
               return 0;
           }

           @Override
           public View getView(int i, View view, ViewGroup viewGroup) {

               LayoutInflater li=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
               View rowview;
               if(view==null)
              {
                  rowview = li.inflate(R.layout.layoutforone, viewGroup, false);
                  viewholder vh=new viewholder(rowview);
                  rowview.setTag(vh);
              }
              else
              {
                  rowview=view;

              }
              student curobj=arrayname.get(i);
               viewholder viewhold=(viewholder) rowview.getTag();
               viewhold.name.setText(curobj.getName());
               viewhold.number.setText(curobj.getNumber());
               viewhold.batch.setText(curobj.getBatch());
               viewhold.location.setText(curobj.getLocation());
/*
               student obj=arrayname.get(i);
               TextView studentname=rowview.findViewById(R.id.studentname);
               TextView studentbatch=rowview.findViewById(R.id.studentbatch);
               TextView studentnumber=rowview.findViewById(R.id.studentnumber);
               TextView studentlocation=rowview.findViewById(R.id.studentlocation);
               Button refbutton=rowview.findViewById(R.id.button);


               studentname.setText(obj.getName());
               studentbatch.setText(obj.getBatch());
               studentnumber.setText(obj.getNumber());
               studentlocation.setText(obj.getLocation());
               refbutton.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {

                   }
               });
*/
               return rowview  ;
           }

       }


           class viewholder
           {
               TextView name,number,location,batch;
               Button btn;
               public viewholder(View curview) {

                   name=curview.findViewById(R.id.studentname);
                   number=curview.findViewById(R.id.studentnumber);
                   batch=curview.findViewById(R.id.studentbatch);
                   location=curview.findViewById(R.id.studentlocation);
               }

               public TextView getName() {
                   return name;
               }

               public void setName(TextView name) {
                   this.name = name;
               }

               public TextView getBatch() {
                   return batch;
               }

               public void setBatch(TextView batch) {
                   this.batch = batch;
               }

               public TextView getNumber() {
                   return number;
               }

               public void setNumber(TextView number) {
                   this.number = number;
               }

               public TextView getLocation() {
                   return location;
               }

               public void setLocation(TextView location) {
                   this.location = location;
               }

               public Button getBtn() {
                   return btn;
               }

               public void setBtn(Button btn) {
                   this.btn = btn;
               }
           }

}

