package org.coinor.opents;


/**
 * This is the class to extend when creating your own solution definitions.
 * <p>
 * <em>It is essential that you still implement your own {@link #clone clone()}
 * method</em> and clone whatever custom properties you have in your solution definition.
 * </p>
 * <P>
 * For an excellent discussion of cloning techniques, see the
 * Java Developer Connection Tech Tip
 * <a href="http://developer.java.sun.com/developer/JDCTechTips/2001/tt0306.html">
 * http://developer.java.sun.com/developer/JDCTechTips/2001/tt0306.html</a>.
 * </P>
 * 
 * <p>Here is an example of how to clone your solution.
 * Notice that it properly calls the <code>super.clone()</code>
 * method so that the {@link SolutionAdapter}'s
 * {@link SolutionAdapter#clone clone()} method is also called.
 * Then an <tt>int</tt> array is cloned and a {@link java.util.HashMap} 
 * is cloned.
 * <pre><code>
 *     ...
 *     public Object clone()
 *     {
 *         MySolution sol = (MySolution) super.clone();
 *         sol.myIntArray = (int[])      this.myIntArray.clone();
 *         sol.myMap      = (HashMap)    this.myMap.clone();
 *     }   // end clone
 *     ...
 * </code></pre>
 * </p>
 *
 *
 * <p><em>This code is licensed for public use under the Common Public License version 0.5.</em><br/>
 * The Common Public License, developed by IBM and modeled after their industry-friendly IBM Public License,
 * differs from other common open source licenses in several important ways:
 * <ul>
 *  <li>You may include this software with other software that uses a different (even non-open source) license.</li>
 *  <li>You may use this software to make for-profit software.</li>
 *  <li>Your patent rights, should you generate patents, are protected.</li>
 * </ul>
 * </p>
 * <p><em>Copyright � 2001 Robert Harder</em></p>
 *
 *
 * @author Robert Harder
 * @author rharder@usa.net
 * @version 1.0b
 * @since 1.0b
 */
public class SolutionAdapter 
implements Solution
{

    /** Objective function value. */
    private double[] objectiveValue;
    

    /**
     * If the value has been set for this solution, then the value will
     * be returned. Be careful if this returns null since this may
     * indicate that the {@link TabuSearch} has not yet
     * set the solution's value.
     * 
     * @return The value of the solution
     * @since 1.0
     */
    public final double[] getObjectiveValue()
    {   return this.objectiveValue;
    }   // end getValue



    /**
     * Generally used by the {@link TabuSearch} to set the value of the
     * objective function
     * and set <tt>objectiveValid</tt> to <tt>true</tt>.
     * 
     * @param objValue The objective function value
     * @since 1.0
     */
    
    public final void setObjectiveValue( double[] objValue )
    {   this.objectiveValue = objValue;
    }   // end setObjectiveValue


    
    /**
     * An essential Java method that returns of copy of the object.
     * Specifically the <tt>double</tt> array that holds the
     * objective value is properly cloned.
     * 
     * @return A copy of <tt>this</tt>.
     * @see java.lang.Cloneable
     * @since 1.0
     */
    public Object clone()
    {   try
        {
            Solution sol = (Solution)super.clone();     // Java's default cloning
            
            double[] copyThisObjVal =                   // Get our objective value
                getObjectiveValue();
            
            if( copyThisObjVal != null )                // Make sure the array isn't null
            {
                this.objectiveValue =                   // Clone the array using the built-in clone method
                    (double[])copyThisObjVal.clone();

             /*                                         // The primitive boolean field objectiveValid 
                nothing to do here                      // is automatically cloned by the 
             */                                         // java.lang.Object's clone method.
            }   // end if: not null

            return sol;
        }   // end try
        catch( java.lang.CloneNotSupportedException e ) // Catch exception from java.lang.Object
        {   throw new InternalError( e.toString() );    // Throw a runtime error
        }   // end catch
    }   // end clone
    
        
}   // end SolutionBase class

