package spring.validation;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

@Validated
public class MethodValidated {
	
	String name;
	
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(@NotEmpty String name) {
		this.name = name;
	}
		
}
