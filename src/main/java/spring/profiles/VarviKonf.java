package spring.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class VarviKonf {
	
	public static final String PUNANE = "punane";
	public static final String ROHELINE = "roheline";
	
	@Bean
	@Profile({"default", PUNANE})
	Varv getPunane() {
		return new Varv(PUNANE);
	}
	
	@Bean
	@Profile("roheline")
	Varv getRoheline() {
		return new Varv(ROHELINE);
	}
	
}
