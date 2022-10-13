package sadowski.wojciech.akaenv.quote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
    private QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping("/quote")
    public Quote getNew() {
        return service.get();
    }

}
