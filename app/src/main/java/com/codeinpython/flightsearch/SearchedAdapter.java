package com.codeinpython.flightsearch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SearchedAdapter extends RecyclerView.Adapter<SearchedAdapter.ViewHolder> {
    List<SearchedModelClass> query;

    SearchedAdapter(List<SearchedModelClass> modelClassList)
    {
        this.query = modelClassList;
    }
    //onCreateViewHolder will populate the searched_row.xml that we created as layout of each row in recylcerview
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.searched_row,parent,false);
        return new ViewHolder(v);
    }

    //onBindViewHolder implemented
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.flightName.setText(query.get(position).getFlightName());
        holder.flightImageView.setImageResource(query.get(position).getFlightImage());
        holder.fromCode.setText(query.get(position).getFromCode());
        holder.toCode.setText(query.get(position).getToCode());
        holder.deptTime.setText(query.get(position).getDeptTime());
        holder.arrTime.setText(query.get(position).getArrTime());
        holder.hrs.setText(query.get(position).getHrs());
        holder.price.setText(query.get(position).getPrice());

        //on each item click in recyclerview intent to BookActivity is sent
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),BookActivity.class);
                i.putExtra("fromCode",query.get(holder.getAdapterPosition()).getFromCode());
                i.putExtra("toCode",query.get(holder.getAdapterPosition()).getToCode());
                i.putExtra("deptTime",query.get(holder.getAdapterPosition()).getDeptTime());
                i.putExtra("arrTime",query.get(holder.getAdapterPosition()).getArrTime());
                i.putExtra("image",query.get(holder.getAdapterPosition()).getFlightImage());
                i.putExtra("price",query.get(holder.getAdapterPosition()).getPrice());
                i.putExtra("airline",query.get(holder.getAdapterPosition()).getFlightName());
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return query.size();
    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    //ViewHolder Class defined
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView flightName;
        TextView fromCode;
        TextView toCode;
        TextView deptTime;
        TextView arrTime;
        TextView hrs;
        TextView price;
        ImageView flightImageView;

        ViewHolder(View view)
        {
            super(view);
            flightName = (TextView)view.findViewById(R.id.flight);
            fromCode = (TextView)view.findViewById(R.id.frCode);
            toCode = (TextView)view.findViewById(R.id.tCode);
            deptTime =  (TextView)view.findViewById(R.id.deptTime);
            arrTime =  (TextView)view.findViewById(R.id.arrTime);
            hrs =  (TextView)view.findViewById(R.id.hrs);
            price = (TextView)view.findViewById(R.id.price);
            flightImageView = (ImageView)view.findViewById(R.id.flightImage);

        }


        }
    }

