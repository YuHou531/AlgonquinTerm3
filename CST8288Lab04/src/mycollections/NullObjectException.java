package mycollections;

/**
 * NullObjectException
 * 
 * @author    Yu Hou
 * @version   Nov 20 2016
 *
 */
public class NullObjectException extends Exception 
{
	/**
	 * NullObjectException Constructor without detail message.
	 */
    public NullObjectException ()
    {
        super();

    };

	/**
	 * NullObjectException Constructor with detail message.
	 * 
	 * @param message  further information
	 */
    public NullObjectException (String message)
    {
        super(message);
    };
}
