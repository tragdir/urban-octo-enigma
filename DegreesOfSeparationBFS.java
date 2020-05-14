import edu.princeton.cs.algs4.SymbolGraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BreadthFirstPaths;

public class DegreesOfSeparationBFS {

    public static void main(String[] args) {
	if (args.length != 4) {
	    System.err.println("Incorrect number of arguments: 4 needed");
	    return;
	}
	
	String filename  = args[0];
	String delimiter = args[1];
	String source    = args[2];
	String sink      = args[3];

	SymbolGraph sg = new SymbolGraph(filename, delimiter);
	Graph g = sg.graph();
	
	if (!sg.contains(source)) {
	    StdOut.println(source + " not in database");
	    return;
	}
	
	if (!sg.contains(sink)) {
	    StdOut.println(sink + " not in database");
	    return;
	}
	//StdOut.println("Done reading " + filename);
	
	int sourceIndex = sg.indexOf(source);
	int sinkIndex   = sg.indexOf(sink);
	
	BreadthFirstPaths bfp = new BreadthFirstPaths(g, sourceIndex);
	
	if (bfp.hasPathTo(sinkIndex)) {
	    int N = bfp.distTo(sinkIndex) / 2;
	    StdOut.println(sink + " has a bacon number of " + N + ".");
	    String[] movies = new String[N];
	    String[] actors = new String[N + 1];
	    int i = 0, j = 0, k = 0;
	    for (int v : bfp.pathTo(sinkIndex)) {
		if (k % 2 == 0 && i < actors.length) {
		    actors[i] = sg.nameOf(v);
		    i++;
		    k++;
		}
		else if (k % 2 == 1 && j < movies.length) {
		    movies[j] = sg.nameOf(v);
		    j++;
		    k++;
		}
	    }
	    for (i = actors.length - 1, j = movies.length - 1; i >= 1 && j >= 0; i--, j--) {
		    StdOut.println(actors[i] + " was in the movie " + movies[j] + " with "
				   + actors[i - 1]);
	    } 
	}
	else {
	    StdOut.println(sink + " has no bacon number.");
	}
    }
}

