package spring.ioc.methodinjection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

class CommonStuff implements ApplicationContextAware {
	
	private ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
	
	protected CommandManager getCommandManager() {
		return ctx.getBean(CommandManager.class);
	}
	
	protected void test() {
		Command cmd1 = getCommandManager().process();
		Command cmd2 = getCommandManager().process();
		assertNotEquals(cmd1, cmd2);
		
		Command cmd3 = getCommandManager().process();
		assertEquals(cmd2, cmd3);
	}
	
}
