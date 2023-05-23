package org.illusion.examlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Exam> exams;

    ExamAdapter(Context context, List<Exam> exams) {
        this.exams = exams;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public ExamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExamAdapter.ViewHolder holder, int position) {
        Exam exam = exams.get(position);
        holder.nameView.setText(exam.getTitle());
        holder.descriptionView.setText(exam.getDescription());
    }

    @Override
    public int getItemCount() {
        return exams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, descriptionView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.name);
            descriptionView = view.findViewById(R.id.description);
        }
    }
}