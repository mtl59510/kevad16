package spring.ioc.customscope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class TwinScope implements Scope {
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(TwinScope.class);
	
	public static final String TWIN_SCOPE = "twin";
	
	private final Map<String, Object> map = Collections.synchronizedMap(new HashMap<String, Object>());
	
	int i = 0;
	
	public TwinScope() {
		LOGGER.debug("Scope constructor here!");
	}
	
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		
		if (i < 2) {
			remove(name);
			i++;
		}
		
		// construct conditionally
		if (!map.containsKey(name)) {
			LOGGER.debug("new");
			map.put(name, objectFactory.getObject());
		}
		
		LOGGER.debug("get");
		
		return map.get(name);
	} // -get

	@Override
	public Object remove(String name) {
		LOGGER.debug("remove");
		return map.remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		// TODO Auto-generated method stub
	}

	@Override
	public Object resolveContextualObject(String key) {
		LOGGER.debug("resolveContextualObject(String) not implemented!");
		return null;
	}

	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}

}
