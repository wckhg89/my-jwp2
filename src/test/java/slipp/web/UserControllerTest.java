package slipp.web;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class UserControllerTest {

	@Test
	public void findFirst() {
		List<String> values = Arrays.asList("j", "a", "b");
		Optional<String> value = values.stream().filter(v -> v.equals("c")).findFirst();
		if (value.isPresent()) {
			System.out.println("value : " + value.get());
		} else {
			System.out.println("empty");
		}
	}

}
