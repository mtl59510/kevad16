package spring.ioc.customscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwinClient {
	
	Twin twin;
	
	public Twin getTwin() {
		return twin;
	}
	
	@Autowired
	public void setTwin(Twin twin) {
		this.twin = twin;
	}
	
}
