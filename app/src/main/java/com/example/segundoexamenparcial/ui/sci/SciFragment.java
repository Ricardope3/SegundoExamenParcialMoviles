package com.example.segundoexamenparcial.ui.sci;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.segundoexamenparcial.Book;
import com.example.segundoexamenparcial.BookAdapter;
import com.example.segundoexamenparcial.R;
import com.example.segundoexamenparcial.RequestBook;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class SciFragment extends Fragment  implements RequestBook.Callback {

    private SciViewModel sciViewModel;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manejadorLayout;
    BookAdapter adapter;
    private String filtro = "";
    List<Book> book_list;
    private Handler handler = new Handler();
    Context contexto;

    JSONArray json;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sciViewModel =
                ViewModelProviders.of(this).get(SciViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sci, container, false);
        contexto = getActivity().getApplicationContext();

        book_list = new ArrayList<>();
//        recyclerView = (RecyclerView)root.findViewById(R.id.title);
//        recyclerView.setHasFixedSize(true);
//        manejadorLayout = new LinearLayoutManager(contexto);
//        recyclerView.setLayoutManager(manejadorLayout);

        RequestBook.getRequest(getActivity(), this );
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                try {
                    adapter.notifyDataSetChanged();
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }, 3000);

        populateRecyclerView();

        final TextView textView = root.findViewById(R.id.text_sci);
//        sciViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        textView.setText("HOOLA");
        return root;
    }

    private void populateRecyclerView()
    {
        adapter = new BookAdapter(book_list, contexto, recyclerView);
//        recyclerView.setAdapter(adapter);
    }
    private String getResponse(String response)
    {
        return response;
    }
    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void processJSON(String response) {
        try{
            json = new JSONArray(response);
            for(int i = 0; i<json.length();i++)
            {
                JSONArray jsonArray = json.getJSONArray(i);

                Book product = new Book();
                product.setTitle(jsonArray.getJSONObject(0).getString("title"));
                product.setAuthor(jsonArray.getJSONObject(0).getString("author"));
                product.setEditorial(jsonArray.getJSONObject(0).getString("editorial"));
                product.setEditorial(jsonArray.getJSONObject(0).getString("description"));
                product.setPrice(jsonArray.getJSONObject(0).getString("price"));
                product.setUrl_image(jsonArray.getJSONObject(0).getString("url_picture"));

                System.out.println(product);

                book_list.add(product);
            }
        }catch(JSONException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onError()
    {

    }
}