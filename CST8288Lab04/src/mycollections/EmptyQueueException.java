package mycollections;

/**
 * EmptyQueueException
 * 
 * @author    Yu Hou
 * @version   Nov 20 2016
 *
 */
public class EmptyQueueException extends Exception
{
	/**
	 * EmptyQueueException Constructor without detail message.
	 */
    public EmptyQueueException ()
    {
        super();
    };

	/**
	 * EmptyQueueException Constructor with detail message.
	 * 
	 * @param message  further information
	 */
    public EmptyQueueException (String message)
    {
        super(message);
    };
} 
