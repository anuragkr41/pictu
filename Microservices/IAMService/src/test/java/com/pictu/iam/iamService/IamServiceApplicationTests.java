package com.pictu.iam.iamService;

import com.pictu.core.utilities.IdGeneratorString;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IamServiceApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(IdGeneratorString.locationIDGenerator());
	}

}
