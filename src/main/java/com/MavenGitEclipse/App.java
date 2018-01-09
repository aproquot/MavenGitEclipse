package com.MavenGitEclipse;

import com.MavenGitEclipse.dao.DataQueries;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args!=null && args.length!=0 && args[0]!=null) {
        	try {
        		DataQueries.synchronize((int)Integer.valueOf(args[0]));
        	} catch(NumberFormatException e) {
        		DataQueries.synchronize(10);
        	}
        } else {
        	DataQueries.synchronize(10);
        }
    }
}
