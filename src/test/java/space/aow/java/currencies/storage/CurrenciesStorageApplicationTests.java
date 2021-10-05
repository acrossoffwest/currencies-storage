package space.aow.java.currencies.storage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class CurrenciesStorageApplicationTests {

	@Autowired
	private CurrenciesStorageApplication app;

	@Test
	void contextLoads() {
		assertThat(app).isNotNull();
	}
}
