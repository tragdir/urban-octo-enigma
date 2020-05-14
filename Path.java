public class Path {
    private int col, row;
    private int cost;
    private Path next;

    public Path() {
	col = -1;
	row = -1;
	cost = -1;
	next = null;
    }
    
    public Path(int col, int row, int cost, Path next) {
	this.col = col;
	this.row = row;
	this.cost = cost;
	this.next = next;
    }

    public int col() {
	return col;
    }

    public int row() {
	return row;
    }

    public int cost() {
	return cost;
    }

    public Path next() {
	return next;
    }

    public void addNext(Path p) {
	if (p.row() <= -1 || p.col <= -1)
	    throw new NullPointerException();
	
	if (next == null) {
	    next = p;
	    return;
	}
	else
	    next.addNext(p); 
    }

}
