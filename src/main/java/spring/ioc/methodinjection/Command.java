package spring.ioc.methodinjection;

// NOTE the conf. is externalized, but w/ JavaConfig!
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Command {
	
	public Object execute() {
		return this.toString();
	}
	
}
