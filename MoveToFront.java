import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    public static void encode() {
	char[] arr = new char[256];
	for (int i = 0; i < arr.length; i++)
	    arr[i] = (char) i;

	while (!BinaryStdIn.isEmpty()) {
	    char c = BinaryStdIn.readChar();
	    char in, out;
	    int index;
	    
	    for (index = 0, out = arr[0]; c != arr[index]; index++) {
		in = arr[index];
		arr[index] = out;
		out = in;
	    }
	    arr[index] = out;
	    BinaryStdOut.write((char) index);
	    arr[0] = c;
	}
	BinaryStdIn.close();
	BinaryStdOut.close();
	
    }

    public static void decode() {
	char[] arr = new char[256];
	for (char i = 0; i < 256; i++)
	    arr[i] = i;
	
	while (!BinaryStdIn.isEmpty()) {
	    char c = BinaryStdIn.readChar();
	    BinaryStdOut.write(arr[c], 8);
	    char index = arr[c];
	    while (c > 0)
		arr[c] = arr[--c];
	    arr[0] = index;
	}
	BinaryStdIn.close();
	BinaryStdOut.close();
	    
    }

    public static void main(String[] args) {
	if (args[0].equals("-"))
	    encode();
	else if (args[0].equals("+"))
	    decode();
	System.out.println(args[0]);
    }
}
