package decoratoroutputstreamex;

import static sbcc.Core.*;

import java.io.*;

public class UppercaseOutputStream extends OutputStream {

	protected OutputStream out;

	public UppercaseOutputStream(OutputStream outputStream) {
		this.out = outputStream;
	}


	@Override
	public void write(int b) throws IOException {
		out.write(b);
	}


	@Override
	public void write(byte[] bytes) throws IOException {
		var content = new String(bytes);
		out.write(content.toUpperCase().getBytes());
	}


	@Override
	public void close() throws IOException {
		super.close();
		out.close();
	}

}
