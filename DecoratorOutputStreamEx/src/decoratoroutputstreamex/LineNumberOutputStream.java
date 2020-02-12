package decoratoroutputstreamex;

import static java.lang.System.*;

import java.io.*;

public class LineNumberOutputStream extends OutputStream {

	protected OutputStream out;

	public LineNumberOutputStream(OutputStream outputStream) {
		this.out = outputStream;
	}


	@Override
	public void write(int b) throws IOException {
		out.write(b);
	}


	@Override
	public void write(byte[] bytes) throws IOException {
		var lines = new String(bytes).split(lineSeparator());
		int lineNum = 1;
		var sb = new StringBuilder();
		for (var line : lines)
			sb.append(lineNum++).append(" : ").append(line).append(lineSeparator());

		out.write(sb.toString().getBytes());
	}


	@Override
	public void close() throws IOException {
		super.close();
		out.close();
	}

}
