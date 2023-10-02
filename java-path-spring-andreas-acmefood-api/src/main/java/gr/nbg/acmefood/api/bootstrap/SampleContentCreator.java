package gr.nbg.acmefood.api.bootstrap;

import gr.nbg.acmefood.api.base.BaseComponent;
import gr.nbg.acmefood.api.domain.*;
import gr.nbg.acmefood.api.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Profile("generate-stores-products-accounts")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {

    private final StoreService storeService;
    private final ProductService productService;
    private final AccountService accountService;

    @Override
    public void run(final String... args) throws Exception {

        List<Account> accounts = accountService.createAll(
                Account.builder()
                        .email("c.giannacoulis@codehub.gr")
                        .firstname("Constantinos").lastname("Giannacoulis")
                        .streetAddress("3583 Tennessee Avenue")
                        .phone("2101234567").build(),
                Account.builder()
                        .email("kastrisios.a@nbg.gr")
                        .firstname("Andreas").lastname("Kastrisios")
                        .streetAddress("Downtown 17, California")
                        .phone("2310987654").build(),
                Account.builder()
                        .email("foufotos@nbg.gr")
                        .firstname("Andreas").lastname("Giannacoulis")
                        .streetAddress("3583 Syngrou Ave., California")
                        .phone("9990987654").build());

        logger.info("Accounts created: {}.", accounts);

        Set<Product> grillProducts = new HashSet<Product>(productService.createAll(
                Product.builder()
                        .description("Σουβλάκι")
                        .category(ProductCategory.Food)
                        .price(BigDecimal.valueOf(3.50))
                        .build(),
                Product.builder()
                        .description("Kebab")
                        .category(ProductCategory.Food)
                        .price(BigDecimal.valueOf(6.50))
                        .build()));

        logger.info("Grill products created: {}.", grillProducts);

        Set<Product> asianProducts = new HashSet<Product>(productService.createAll(
                Product.builder()
                        .description("Curry")
                        .category(ProductCategory.Food)
                        .price(BigDecimal.valueOf(11.50))
                        .build(),
                Product.builder()
                        .description("Noodles")
                        .category(ProductCategory.Food)
                        .price(BigDecimal.valueOf(7.50))
                        .build()));

        logger.info("Asian products created: {}.", asianProducts);

        Set<Product> beverageProducts = new HashSet<Product>(productService.createAll(
                Product.builder()
                        .description("Coffee")
                        .category(ProductCategory.Beverage)
                        .price(BigDecimal.valueOf(2.80))
                        .build(),
                Product.builder()
                        .description("Tea")
                        .category(ProductCategory.Beverage)
                        .price(BigDecimal.valueOf(2.20))
                        .build()));

        logger.info("Beverage products created: {}.", beverageProducts);

        List<Store> stores = storeService.createAll(
                Store.builder()
                        .category(StoreCategory.Grill)
                        .name("Ο Πρόεδρος")
                        .build(),
                Store.builder()
                        .category(StoreCategory.Asian)
                        .name("China Wok")
                        .build(),
                Store.builder()
                        .category(StoreCategory.Breakfast)
                        .name("Everest")
                        .build());

        logger.info("Stores created: {}.", stores);
    }
}
