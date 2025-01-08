package com.url.shortener.url.shortener;

import com.url.shortener.url.shortener.util.URLShortenerUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UrlShortenerApplicationTests {

	@Test
	void testGenerateShortUrl1() {
		String originalUrl = "https://www.linkedin.com/in/pranav-manapure/";
		String shortUrl = URLShortenerUtil.generateShortUrl(originalUrl);

		assertThat(shortUrl).isNotNull();
		assertThat(shortUrl.length()).isEqualTo(8);
	}

}
