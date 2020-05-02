package com.example.segundoexamenparcial;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.recyclerview.widget.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> book_list;
    private Context context;
    private RecyclerView myrecyclerview;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textview_title;
        public TextView textview_author;
        public TextView textview_price;
        public TextView textview_editorial;
        public ImageView imageview_image;


        public View layout;

        public ViewHolder(View view) {
            super(view);
            layout = view;
            textview_title = (TextView) view.findViewById(R.id.title);
            textview_author = (TextView) view.findViewById(R.id.title);
            textview_editorial = (TextView) view.findViewById(R.id.title);
            textview_price = (TextView) view.findViewById(R.id.title);
            imageview_image = (ImageView) view.findViewById(R.id.image);
        }
    }

    public void add(int position, Book book) {
        book_list.add(position, book);
        notifyItemInserted(position);
    }

    public void remove(int posicion) {
        book_list.remove(posicion);
        notifyItemRemoved(posicion);
    }

    public BookAdapter(List<Book> data, Context context, RecyclerView recyclerView) {
        book_list = data;
        this.context = context;
        myrecyclerview = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View vista =
                inflater.inflate(R.layout.fragment_sports, parent, false);

        ViewHolder view_holder = new ViewHolder(vista);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder manager, final int position) {

        final Book book = book_list.get(position);
        manager.textview_title.setText("Titulo: " + book.getTitle());
        manager.textview_author.setText("Autor: " + book.getAuthor());
        manager.textview_author.setText("Editorial: " + book.getEditorial());
        manager.textview_price.setText("Price: " + book.getPrice());
        Picasso.with(context).load(book.getUrl_image()).placeholder(R.mipmap.ic_launcher_round).into(manager.imageview_image);

        manager.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Description");
                builder.setMessage("La descripcion va aqui jajaj");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return book_list.size();
    }
}