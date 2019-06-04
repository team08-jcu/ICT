package com.example.apple.coursepal;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.os.Bundle;

public class ListViewAdapter extends BaseAdapter{

    //variables
    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<Model> modellist) {
        mContext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainIcon);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getTitle());
        holder.mDescTv.setText(modellist.get(postition).getDesc());
        //set the result in imageview
        holder.mIconIv.setImageResource(modellist.get(postition).getIcon());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                if (modellist.get(postition).getTitle().equals("University of Melbourne - Bachelors of Information Technology")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "University of Melbourne - Bachelors of Information Technology");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.melbourneuni);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "Parkville VIC 3010, Australia");
                    intent.putExtra("contentTutionInfo ", "9,050 AUD (2017), International tuition: 39,168 AUD (2017)");
                    intent.putExtra("contentEnrollmentInfo ", "Total enrollment: 59,129 (31 Mar 2017)");
                    intent.putExtra("contentAddress", "Parkville VIC 3010, Australia");
                    intent.putExtra("contentStarRating", "4");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("The University of Sydney - Bachelor of Games and interactive environments")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "The University of Sydney - Bachelor of Games and interactive environments");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.sydneyuni);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "Camperdown NSW 2006, Australia");
                    intent.putExtra("contentTutionInfo ", "Undergraduate tuition and fees: 9,050 AUD (2017)");
                    intent.putExtra("contentEnrollmentInfo ", "Total enrollment: 59,129 (31 Mar 2017)");
                    intent.putExtra("contentStarRating", "5");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("Monash University, Clayton Campus - Bachelor of Justice")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Monash University, Clayton Campus - Bachelor of Justice");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.monashuni);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "Wellington Rd, Clayton VIC 3800, Australia");
                    intent.putExtra("contentTutionInfo ", "Doctoral students: 4,874 (2017)");
                    intent.putExtra("contentEnrollmentInfo ", "Undergraduate tuition and fees: International tuition: 37,050 AUD (2014)\n");
                    intent.putExtra("contentStarRating", "3");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("The University of Queensland - Bachelors of Information Technology")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "The University of Queensland - Bachelors of Information Technology");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.queenslanduni);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "St Lucia QLD 4072, Australia");
                    intent.putExtra("contentTutionInfo ", "Undergraduate tuition and fees: Domestic tuition: 8,477 AUD (2015), International tuition: 31,920 AUD (2015)");
                    intent.putExtra("contentEnrollmentInfo ", "Subsidiaries: UQ Business School, MORE");
                    intent.putExtra("contentStarRating", "4");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("UNSW Sydney - Bachelor of Games and interactive environments")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "UNSW Sydney - Bachelor of Games and interactive environments");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.unsw);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "Camperdown NSW 2006, Australia");
                    intent.putExtra("contentTutionInfo",
                            "Undergraduate tuition and fees: 16,016 AUD (2013)");
                    intent.putExtra("contentEnrollmentInfo ", "Total enrollment: 53,481 (2015)");
                    intent.putExtra("contentStarRating", "5");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("The University of Adelaide - Bachelor of Justice")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "The University of Adelaide - Bachelor of Justice");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.sydneyuni);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "Camperdown NSW 2006, Australia");
                    intent.putExtra("contentTutionInfo",
                            "Undergraduate tuition and fees: 9,050 AUD (2017)");
                    intent.putExtra("contentEnrollmentInfo ", "Total enrollment: 59,129 (31 Mar 2017)");
                    intent.putExtra("contentStarRating", "3");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("The University of Adelaide - Bachelor of Justice")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "The University of Adelaide - Bachelor of Justice");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.adelaide);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "Adelaide SA 5005, Australia");
                    intent.putExtra("contentTutionInfo",
                            "Undergraduate tuition and fees: 8,768 AUD (2015)");
                    intent.putExtra("contentEnrollmentInfo ", "Products and Services: adelaide.edu.au");
                    intent.putExtra("contentStarRating", "4");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("RMIT University, Melbourne City Campus -  Bachelors of Information Technology ")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "RMIT University, Melbourne City Campus -  Bachelors of Information Technology");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.rmit);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "124 La Trobe St, Melbourne VIC 3000, Australia");
                    intent.putExtra("contentTutionInfo",
                            "Total enrollment: 84,267 (2016)");
                    intent.putExtra("contentEnrollmentInfo ", "Doctoral students: 1,433");
                    intent.putExtra("contentStarRating", "3");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("University of South Australia - Bachelor of Games and interactive environments")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "University of South Australia - Bachelor of Games and interactive environments");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.southaus);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "South Australia");
                    intent.putExtra("contentTutionInfo",
                            "Total enrollment: 84,267 (2016)");
                    intent.putExtra("contentEnrollmentInfo ", "Doctoral students: 1,433");
                    intent.putExtra("contentStarRating", "4");
                    mContext.startActivity(intent);
                }
                if (modellist.get(postition).getTitle().equals("La Trobe University, Melbourne Campus - Bachelor of Justice")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "La Trobe University, Melbourne Campus - Bachelor of Justice");
                    Bundle bundle=new Bundle();
                    bundle.putInt("image",R.drawable.latrobe);
                    intent.putExtras(bundle);
                    intent.putExtra("contentAddress", "Plenty Rd & Kingsbury Dr, Bundoora VIC 3086, Australia");
                    intent.putExtra("contentTutionInfo", "Total enrollment: 36,278 (2014)");
                    intent.putExtra("contentEnrollmentInfo ", "Undergraduate tuition and fees: 8,613 AUD (2014)");
                    intent.putExtra("contentStarRating", "5");
                    mContext.startActivity(intent);
                }
            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (Model model : arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

}
