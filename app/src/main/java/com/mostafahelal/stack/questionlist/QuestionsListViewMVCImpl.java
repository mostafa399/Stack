package com.mostafahelal.stack.questionlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mostafahelal.stack.R;
import com.mostafahelal.stack.pojo.Item;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListViewMVCImpl extends BaseViewMvc<QuestionsListViewMvc.Listener>implements QuestionsListViewMvc{
    private final RecyclerViewAdapter adapter;

    public QuestionsListViewMVCImpl(LayoutInflater inflater, ViewGroup container) {
       setRootView(inflater.inflate(R.layout.activity_main,container,false));
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new RecyclerViewAdapter(new OnQuestionClickListener() {
            @Override
            public void onQuestionClicked(Item item) {
                for (Listener listener : getListeners()) {
                    listener.onQuestionClicked(item);
                }
            }
        });
        mRecyclerView.setAdapter(adapter);
    }
    @Override
    public void bindQuestions(List<Item> items) {
        adapter.bindData(items);
    }
    public interface OnQuestionClickListener{
        void onQuestionClicked(Item item);

    }


    public static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolde> {
        private final OnQuestionClickListener mOnQuestionClickListener;
        private List<Item> mQuestionList = new ArrayList<>(0);

        public RecyclerViewAdapter(OnQuestionClickListener mOnQuestionClickListener) {
            this.mOnQuestionClickListener = mOnQuestionClickListener;
        }

        @NonNull
        @Override
        public RecyclerViewHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_question_list_item, parent, false);
            return new RecyclerViewHolde(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolde holder, int position) {
            Item item=mQuestionList.get(position);
            // we will solve this after Question Class configuration with retrofit
            holder.mTitle.setText(item.getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnQuestionClickListener.onQuestionClicked(item);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mQuestionList.size();    }

        public static class RecyclerViewHolde extends RecyclerView.ViewHolder {
            public TextView mTitle;
            public RecyclerViewHolde(@NonNull View itemView) {
                super(itemView);
                mTitle = itemView.findViewById(R.id.txt_title);

            }
        }


        public void bindData(List<Item> items){
            mQuestionList = new ArrayList<>(items);
            notifyDataSetChanged();
        }


    }


}
