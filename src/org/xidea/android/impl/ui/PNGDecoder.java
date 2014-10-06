package org.xidea.android.impl.ui;

import java.io.IOException;
import java.io.InputStream;

import org.xidea.android.impl.io.IOUtil;

public class PNGDecoder {
	private static final byte[] SIGNATURE= { (byte)137, 'P','N','G' ,13 ,10 ,26, 10};
	private static final byte[] IHDR = {'I','H','D','R'};
	private int width; // full image width
	private int height; // full image height

	public PNGDecoder(InputStream in) throws IOException{
		if(IOUtil.startsWith(in, SIGNATURE)){
			if(IOUtil.startsWith(in, IHDR)){
				this.width = IOUtil.readInt(in);
				this.height = IOUtil.readInt(in);
			}
		}
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
