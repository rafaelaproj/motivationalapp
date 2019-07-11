package rafaelacs.com.br.rafaelasportfolio.data;

import java.util.ArrayList;

import rafaelacs.com.br.rafaelasportfolio.model.Quote;

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
