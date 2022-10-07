package edu.info.aen.first_test.books;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.appbar.MaterialToolbar;

import edu.info.aen.first_test.R;
import edu.info.aen.first_test.books.adapter.BookAdapter;
import edu.info.aen.first_test.books.viewmodel.BookViewModel;
import edu.info.aen.first_test.databinding.ActivityBookRecyclerBinding;

public class BookRecyclerActivity extends AppCompatActivity {

    ActivityBookRecyclerBinding binding;
    BookViewModel bookViewModel;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        this.updateLastModifiedBookViewFromVM();
        MaterialToolbar ViewToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(ViewToolbar);
        ActionBar toolbar = getSupportActionBar();
        if (toolbar != null) {
            toolbar.setDisplayHomeAsUpEnabled(true);
            toolbar.setTitle("Settings");
        }
        this.adapter = new BookAdapter(this, this.bookViewModel.getBooks());
        this.adapter.setListener(this::onClickSetRating);
        binding.bookActivityRv.setAdapter(adapter);
        binding.bookActivityRv.setLayoutManager(new LinearLayoutManager(this));
        binding.bookActivityBtnAdd.setOnClickListener(this::onClickAddBook);
    }

    /**
     * Called by the adapter
     * @param rating the rating to set
     * @param modBookPosition the position of the book in the list
     */
    private void onClickSetRating(float rating, int modBookPosition) {
        Book modifiedBook = this.bookViewModel.getBook(modBookPosition);
        modifiedBook.setNote(rating);
        binding.bookActivityRv.post(() -> adapter.notifyItemChanged(modBookPosition));
        this.bookViewModel.updateModifiedBook(modifiedBook);
        this.updateLastModifiedBookViewFromVM();
    }

    private void onClickAddBook(View v) {
        Book book = new Book(binding.bookActivityEtTitle.getText().toString(), binding.bookActivityEtAuthor.getText().toString(), 0);
        int newBookPosition = this.bookViewModel.addBook(book);
        this.adapter.notifyItemInserted(newBookPosition);
        binding.bookActivityEtAuthor.setText("");
        binding.bookActivityEtTitle.setText("");
        hideKeyboard(this);
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

    public void updateLastModifiedBookViewFromVM() {
        this.binding.activityBookTvLastModified.setText(
                bookViewModel.getModifiedBook() != null ?
                        getString(R.string.book_activity_last_modified_book, this.bookViewModel.getModifiedBook().getTitle(), this.bookViewModel.getModifiedBook().getNote())
                        : getString(R.string.book_activity_last_modified_book_default));
    }
}
