package sadowski.wojciech.akaenv.quote;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteService {
    private final QuoteRepository repository;
    private final String quoteURL = "https://api.kanye.rest/";
    private final RestTemplate template = new RestTemplate();

    public QuoteService(QuoteRepository repository) {
        this.repository = repository;
    }

    public Quote get() {
        Quote quote = template.getForObject(quoteURL, Quote.class);
        System.out.println(quote);
        while (repository.contains(quote)) quote = template.getForObject(quoteURL, Quote.class);
        if (!repository.contains(quote)) repository.insert(quote);
        return quote;
    }

    public void create(Quote quote) {
        repository.insert(quote);
    }

}
