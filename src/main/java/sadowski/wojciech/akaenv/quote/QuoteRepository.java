package sadowski.wojciech.akaenv.quote;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuoteRepository {
    private JdbcTemplate template;

    public QuoteRepository(JdbcTemplate template) {
        this.template = template;
    }

    public Quote get(Quote quote) {
        return template.queryForObject("SELECT * FROM QUOTES WHERE QUOTE = ?", BeanPropertyRowMapper.newInstance(Quote.class), quote.getQuote());
    }

    public List<Quote> getAll() {
        return template.query("SELECT * FROM QUOTES", BeanPropertyRowMapper.newInstance(Quote.class));
    }

    public void insert(Quote quote) {
        template.update("INSERT INTO QUOTES(QUOTE) VALUES (?)", quote.getQuote());
    }

    public boolean contains(Quote quote) {
        return getAll().contains(quote);
    }

}
