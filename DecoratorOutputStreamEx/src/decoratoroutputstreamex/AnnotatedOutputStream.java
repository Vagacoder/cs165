package decoratoroutputstreamex;

import static java.lang.System.*;
import static sbcc.Core.*;

import java.io.*;

public class AnnotatedOutputStream extends OutputStream {

	protected OutputStream out;

	public AnnotatedOutputStream(OutputStream outputStream) {
		this.out = outputStream;
	}


	@Override
	public void write(int b) throws IOException {
		out.write(b);
	}


	@Override
	public void write(byte[] bytes) throws IOException {
		println("I'm writing: " + lineSeparator() + new String(bytes));

		out.write(bytes);
	}


	@Override
	public void close() throws IOException {
		super.close();
		out.close();
	}
}
