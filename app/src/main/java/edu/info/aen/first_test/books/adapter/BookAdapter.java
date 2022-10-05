package edu.info.aen.first_test.books.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.info.aen.first_test.books.Book;
import edu.info.aen.first_test.databinding.RvBookItemBinding;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private final List<Book> books;
    private Context ctx;

    public void setListener(RatingBarClickListener listener) {
        this.listener = listener;
    }

    private RatingBarClickListener listener;

    public BookAdapter(Context ctx, List<Book> books) {
        this.books = books;
        this.ctx = ctx;}

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvBookItemBinding binding = RvBookItemBinding.inflate(LayoutInflater.from(ctx), parent, false);
        return new BookViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.binding.rvItemBookTvAuthor.setText(books.get(position).getAuthor());
        holder.binding.rvItemBookTvTitle.setText(books.get(position).getTitle());
        holder.binding.rvItemBookRatingBar.setRating(books.get(position).getNote());
        holder.binding.rvItemBookRatingBar.setIsIndicator(false);
        Log.d("rv_book_item", "onBindViewHolder: ");
        holder.binding.rvItemBookRatingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            Log.d("rv_book_item", "onBindViewHolder: IN RATING BAR LISTENER");
            int pos = holder.getAdapterPosition();
            if (listener != null) {
                listener.onRatingBarClick(rating, pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        RvBookItemBinding binding;
        public BookViewHolder(RvBookItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface RatingBarClickListener{
        void onRatingBarClick(float rating, int modBookPosition);
    }
}
