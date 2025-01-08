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
	@Test
	void testGenerateShortUrl2() {
		String originalUrl = "https://en.wikipedia.org/wiki/Car";
		String shortUrl = URLShortenerUtil.generateShortUrl(originalUrl);

		assertThat(shortUrl).isNotNull();
		assertThat(shortUrl.length()).isEqualTo(8);
	}
	@Test
	void testGenerateShortUrl3() {
		String originalUrl = "https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=7929290317241545807&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9301330&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1";
		String shortUrl = URLShortenerUtil.generateShortUrl(originalUrl);

		assertThat(shortUrl).isNotNull();
		assertThat(shortUrl.length()).isEqualTo(8);
	}
	@Test
	void testGenerateShortUrl4() {
		String originalUrl = "https://www.youtube.com/watch?v=ljfdGYlcA_M";
		String shortUrl = URLShortenerUtil.generateShortUrl(originalUrl);

		assertThat(shortUrl).isNotNull();
		assertThat(shortUrl.length()).isEqualTo(8);
	}
	@Test
	void testGenerateShortUrl5() {
		String originalUrl = "https://www.udemy.com/?ranMID=39197&ranEAID=hL6ObH*7r3M&ranSiteID=hL6ObH.7r3M-BWZj0wpR.NgAkdcyB2D0fw&LSNPUBID=hL6ObH*7r3M&utm_source=aff-campaign&utm_medium=udemyads&gad_source=1&gclid=Cj0KCQiAvvO7BhC-ARIsAGFyToUGI7tLDOZi9lGrCSkA9h7cow6R_2YiFTArKJu96DBbytBe4rz-OB0aAkzbEALw_wcB";
		String shortUrl = URLShortenerUtil.generateShortUrl(originalUrl);

		assertThat(shortUrl).isNotNull();
		assertThat(shortUrl.length()).isEqualTo(8);
	}


}
