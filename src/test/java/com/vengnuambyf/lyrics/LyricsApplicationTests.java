package com.vengnuambyf.lyrics;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // This will make Spring use 'application-test.properties' during tests
class LyricsApplicationTests {

	@Test
	void contextLoads() {
		// Your test logic, if necessary.
	}
}
