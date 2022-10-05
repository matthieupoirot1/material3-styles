package edu.info.aen.first_test.books;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

import edu.info.aen.first_test.R;
import edu.info.aen.first_test.books.adapter.BookAdapter;
import edu.info.aen.first_test.databinding.ActivityBookRecyclerBinding;

public class BookRecyclerActivity extends AppCompatActivity {

    ActivityBookRecyclerBinding binding;
    List<Book> books = new ArrayList<>();
    Book lastModifiedBook = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialToolbar ViewToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(ViewToolbar);
        ActionBar toolbar = getSupportActionBar();
        if(toolbar != null){
            toolbar.setDisplayHomeAsUpEnabled(true);
            toolbar.setTitle("Settings");
        }

        this.initBooks();

        BookAdapter adapter = new BookAdapter(this, books);
        adapter.setListener( (rating, modBookPosition) -> {
            books.get(modBookPosition).setNote(rating);
            binding.bookActivityRv.post(() -> adapter.notifyItemChanged(modBookPosition));
            this.lastModifiedBook = books.get(modBookPosition);
            this.binding.activityBookTvLastModified.setText("Last modified book : " + this.lastModifiedBook.getTitle() + " Note : " + this.lastModifiedBook.getNote());
        });
        binding.bookActivityRv.setAdapter(adapter);
        binding.bookActivityRv.setLayoutManager(new LinearLayoutManager(this));

        binding.bookActivityBtnAdd.setOnClickListener(v -> {
            Book book = new Book(binding.bookActivityEtTitle.getText().toString(), binding.bookActivityEtAuthor.getText().toString(), 0);
            books.add(book);
            adapter.notifyItemInserted(books.size() - 1);
            binding.bookActivityEtAuthor.setText("");
            binding.bookActivityEtTitle.setText("");
            hideKeyboard(this);
        });
    }

    private void initBooks(){
        books.add(new Book("The Lord of the Rings", "J.R.R. Tolkien", 2.5F));
        books.add(new Book("Royal Assassin", "Robin HOBB", 5));
        books.add(new Book("Fablehaven", "Brandon Mull", 3.8F));
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
