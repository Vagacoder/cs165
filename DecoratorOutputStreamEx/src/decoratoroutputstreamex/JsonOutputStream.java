package decoratoroutputstreamex;

import static java.lang.System.*;

import java.io.*;

public class JsonOutputStream extends OutputStream {

	protected OutputStream out;

	public JsonOutputStream(OutputStream outputStream) {
		this.out = outputStream;
	}


	@Override
	public void write(int b) throws IOException {
		out.write(b);
	}


	@Override
	public void write(byte[] bytes) throws IOException {
		var content = new String(bytes);
		content = content.replace(lineSeparator(), "\\n");
		content = "{\t\"data\" : \"" + content + " \"}";

		out.write(content.getBytes());
	}


	@Override
	public void close() throws IOException {
		super.close();
		out.close();
	}
}
