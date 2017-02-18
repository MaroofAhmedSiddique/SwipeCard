package com.swipecard.maroof;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

public class MainActivity extends AppCompatActivity {

    private CardContainer mCardContainer;
    private SimpleCardStackAdapter adapter = null;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardContainer = (CardContainer) findViewById(R.id.card_view);
        count = 11;

        Resources r = getResources();

        adapter = new SimpleCardStackAdapter(this);

        adapter.add(new CardModel("Nougat", "Version -> 7.0–7.1.1", r.getDrawable(R.drawable.nougat)));
        adapter.add(new CardModel("Marshmallow", "Version -> 6.0–6.0.1", r.getDrawable(R.drawable.marshmallow)));
        adapter.add(new CardModel("Lollipop", "Version -> 5.0–5.1.1", r.getDrawable(R.drawable.lollipop)));
        adapter.add(new CardModel("KitKat", "Version -> 4.4–4.4.4", r.getDrawable(R.drawable.kitkat)));
        adapter.add(new CardModel("Jelly Bean", "Version -> 4.1–4.3.1", r.getDrawable(R.drawable.jellybean)));
        adapter.add(new CardModel("Ice Cream Sandwich", "Version -> 4.0–4.0.4", r.getDrawable(R.drawable.icecreamsandwich)));
        adapter.add(new CardModel("Gingerbread", "Version -> 2.3–2.3.7", r.getDrawable(R.drawable.gingerbread)));
        adapter.add(new CardModel("Froyo", "Version -> 2.2-2.2.3", r.getDrawable(R.drawable.froyo)));
        adapter.add(new CardModel("Eclair", "Version -> 2.0-2.1", r.getDrawable(R.drawable.eclair)));
        adapter.add(new CardModel("Donut", "Version -> 1.6", r.getDrawable(R.drawable.donut)));
        CardModel cardModel = new CardModel("Cupcake", "Version -> 1.5", r.getDrawable(R.drawable.cupcake));

        cardModel.setOnClickListener(new CardModel.OnClickListener() {
            @Override
            public void OnClickListener() {
                Log.i("Swipeable Cards", "I am pressing the card");
            }
        });

        cardModel.setOnCardDismissedListener(new CardModel.OnCardDismissedListener() {
            @Override
            public void onLike() {
                count--;
                if (count == 0) {
                    count = 11;
                    mCardContainer = null;
                    mCardContainer = (CardContainer) findViewById(R.id.card_view);
                    mCardContainer.setAdapter(adapter);
                }
                Log.i("Swipeable Cards", "I like the card");
            }


            @Override
            public void onDislike() {
                Log.i("Swipeable Cards", "I dislike the card");
                count--;
                if (count == 0) {
                    count = 11;
                    mCardContainer = null;
                    mCardContainer = (CardContainer) findViewById(R.id.card_view);
                    mCardContainer.setAdapter(adapter);
                }
            }
        });

        adapter.add(cardModel);

        mCardContainer.setAdapter(adapter);
    }
}
