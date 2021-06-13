package com.example.recyclerviewexample.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewexample.Model.Student;
import com.example.recyclerviewexample.R;

import java.io.PipedOutputStream;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context cntxt;
    private List<Student> studentDetails;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(Context cntxt, List<Student> studentDetails) {
        this.cntxt = cntxt;
        this.studentDetails = studentDetails;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int pos) {
        Student stu = studentDetails.get(pos);
        holder.txtName.setText(stu.getName());
        holder.txtRollNo.setText(stu.getRollNo());
    }

    @Override
    public int getItemCount() {
        return studentDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName, txtRollNo;
        public Button btndel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtRollNo = itemView.findViewById(R.id.txtRollNo);
            btndel = itemView.findViewById(R.id.btndel);
            itemView.setOnClickListener(this);
            btndel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    Toast.makeText(itemView.getContext(),studentDetails.get(pos).getName(),Toast.LENGTH_LONG).show();
                    studentDetails.remove(pos);
                    notifyItemRemoved(pos);
                }
            });
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            Toast.makeText(cntxt, "You have clicked at " + studentDetails.get(pos).getName() + " " + studentDetails.get(pos).getRollNo(), Toast.LENGTH_LONG).show();
        }
    }
}

