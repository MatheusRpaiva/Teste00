package com.example.aula09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private ViewGroup mensagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mensagens = findViewById(R.id.container);
        Retrofit instanciaRetrofit = new Retrofit.Builder()
                .baseUrl("https://oficinacordova.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterfaceApi apiProduto =
                instanciaRetrofit.create(InterfaceApi.class);

        Call<List<Modelo_Produto>> buscar = apiProduto.getProduto();

        final Callback<List<Modelo_Produto>> callback = new Callback<List<Modelo_Produto>>() {
            @Override
            public void onResponse(Call<List<Modelo_Produto>> call, Response<List<Modelo_Produto>> response) {

                List<Modelo_Produto> produtos = response.body();

             for (Modelo_Produto produto:produtos){

                 addItem(produto.getNomeProduto(), produto.getPrecProduto(), produto.getIdProduto());

             }

            }

            @Override
            public void onFailure(Call<List<Modelo_Produto>> call, Throwable t) {

            }
        };
        buscar.enqueue(callback);


    }


    private void addItem(String nomeProduto, Double precoProduto, int idProduto) {

        CardView cardView = (CardView) LayoutInflater.from(this)
                .inflate(R.layout.modelo_card_view, mensagens, false);
        TextView titulo = (TextView) cardView.findViewById(R.id.titulo);
        TextView mensagem = (TextView) cardView.findViewById(R.id.mensagem);
        TextView desc = (TextView) cardView.findViewById(R.id.descricaoP);
        titulo.setText(nomeProduto);
        mensagem.setText("Preço " + precoProduto.toString());

        mensagens.addView(cardView);

        ImageView imagem = (ImageView) cardView.findViewById(R.id.imageView);
        String url =
                "https://oficinacordova.azurewebsites.net/android/rest/produto/image/"+idProduto;
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        imageLoader.displayImage(url, imagem);

    }

}