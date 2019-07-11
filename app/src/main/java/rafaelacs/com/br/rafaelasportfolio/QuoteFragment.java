package rafaelacs.com.br.rafaelasportfolio;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);

        TextView quoteText = quoteView.findViewById(R.id.quoteText);
        TextView byAuthor = quoteView.findViewById(R.id.byAuthor);
        CardView cardView = quoteView.findViewById(R.id.cardView);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        int colors[] = new int[] {R.color.cardview_dark_background, R.color.cardview_light_background,
        R.color.cardview_shadow_end_color, R.color.cardview_shadow_start_color, R.color.secondaryColor,
        R.color.secondaryDarkColor, R.color.secondaryLightColor, R.color.secondaryTextColor};

        quoteText.setText(quote);
        byAuthor.setText("-" + author);

        cardView.setBackgroundResource(getRandomQuote(colors));

        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author){
        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author", author);
        fragment.setArguments(bundle);

        return fragment;
    }

    int getRandomQuote(int[] colorArray){
        int color;
        int quotesArrayLen = colorArray.length;

        int randomNumber = ThreadLocalRandom.current().nextInt(quotesArrayLen);

        color = colorArray[randomNumber];

        return color;
    }

}
