package spring.format;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MyModel {

//	@DateTimeFormat(iso = ISO.DATE)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	Date date;
	
}
