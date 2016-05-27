package spring.ioc.methodinjection;

// NOTE We cannot make this @Component - since it-s abstract!
// NOTE XML conf. reflection is in MethodInjectionConfiguration.java
public abstract class CommandManager {
	
	private Command command;
	private int i = 0;
	
	/**
	 * Process a {@link Command} - first two will be the same.
	 * @return {@link Command} used.
	 */
	public Command process() {
        
		if (i++ < 2) {
	        command = createCommand();
		}
        
        return command;
        
    } // -process

    // okay... but where is the implementation of this method?
	// NOTE can-t hide this from Spring with private
    protected abstract Command createCommand();
	
}
