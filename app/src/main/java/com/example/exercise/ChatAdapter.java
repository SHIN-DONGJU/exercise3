package com.example.exercise;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private List<ChatData> mDataset;
    private String myNickName;
    public String mType;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_nickname;
        public TextView TextView_msg;
        public View rootView;
        public ImageView ImageView_left;
        public ImageView ImageView_right;

        public MyViewHolder(View v) {
            super(v);
            TextView_nickname = v.findViewById(R.id.TextView_nickname);
            TextView_msg = v.findViewById(R.id.TextView_msg);
            rootView = v;
            ImageView_left=v.findViewById(R.id.logo_left);
            ImageView_right=v.findViewById(R.id.logo_right);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChatAdapter(List<ChatData> myDataset, Context context, String myNickName, String type) {
        //{"1","2"}
        mDataset = myDataset;
        this.myNickName = myNickName;
        this.mType = type;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ChatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {

            // create a new view
            LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_chat_right, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ChatData chat = mDataset.get(position);

        holder.TextView_nickname.setText(chat.getNickname());
        holder.TextView_msg.setText(chat.getMsg());

        if(mType.equals("Customer") ) { //손님로그인
            if(chat.getNickname().equals(this.myNickName)) { //손님 chat
                holder.ImageView_left.setVisibility(View.INVISIBLE);
                holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                holder.TextView_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                holder.ImageView_right.setImageResource(R.drawable.ml_logo_gray);
            }
            else {//기사 chat
                holder.ImageView_right.setVisibility(View.INVISIBLE);
                holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                holder.TextView_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            }

        }
        else {//기사 로그인
            if(chat.getNickname().equals(this.myNickName)) {//손님 chat
                holder.ImageView_right.setVisibility(View.INVISIBLE);
                holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                holder.TextView_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                holder.ImageView_left.setImageResource(R.drawable.logo_brown);

            }
            else {//기사 chat
                holder.ImageView_left.setVisibility(View.INVISIBLE);
                holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                holder.TextView_nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            }
        }






    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        //삼항 연산자
        return mDataset == null ? 0 :  mDataset.size();
    }
    public ChatData getChat(int position) {
        return mDataset != null ? mDataset.get(position) : null;
    }

    public void addChat(ChatData chat) {
        mDataset.add(chat);
        notifyItemInserted(mDataset.size()-1); //갱신
    }
}