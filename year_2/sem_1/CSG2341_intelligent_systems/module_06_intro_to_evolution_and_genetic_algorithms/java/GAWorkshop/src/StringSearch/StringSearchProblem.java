package StringSearch;

/**
 * Class to represent a string search problem
 * 
 * @author phi - Intelligent Systems 2015/2
 */
public class StringSearchProblem
{
    // all we need is a string
    private String target;
    
    /**
     * Construct an instance from a target string
     * 
     * @param target - the string to try to find 
     */
    public StringSearchProblem(String target)
    {
        this.target = target;
    }
    
    /**
     * Get the target string
     * 
     * @return the string 
     */
    public String getTarget()
    {
        return target;
    }
}
