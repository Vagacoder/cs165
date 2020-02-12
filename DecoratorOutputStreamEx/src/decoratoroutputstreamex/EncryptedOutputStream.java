package decoratoroutputstreamex;

import static java.lang.System.*;
import static java.lang.Character.*;

import java.io.*;

public class EncryptedOutputStream extends OutputStream {

	protected OutputStream out;

	public EncryptedOutputStream(OutputStream outputStream) {
		this.out = outputStream;
	}


	@Override
	public void write(int b) throws IOException {
		out.write(b);
	}


	@Override
	public void write(byte[] bytes) throws IOException {
		out.write(encrypt(bytes, 1));
	}


	@Override
	public void close() throws IOException {
		super.close();
		out.close();
	}


	// Encrypts text using a shift of s
	public byte[] encrypt(byte[] bytes, int s) {

		for (int i = 0; i < bytes.length; i++)
			if (isUpperCase(bytes[i]))
				bytes[i] = (byte) ((bytes[i] + s - 65) % 26 + 65);
			else if (isLowerCase(bytes[i]))
				bytes[i] = (byte) ((bytes[i] + s - 97) % 26 + 97);

		return bytes;
	}

}
