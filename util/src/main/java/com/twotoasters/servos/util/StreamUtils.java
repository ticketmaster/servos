package com.twotoasters.servos.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtils {

    private static final int BUFFER_SIZE = 0x1000;

    private StreamUtils() { }

    /**
     * Creates a {@code byte[]} from reading the entirety of an {@link java.io.InputStream}. May return an
     * empty array but never {@code null}.
     * <p>
     * Copied from Guava's {@code ByteStreams} class.
     */
    public static byte[] streamToBytes(InputStream stream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (stream != null) {
            byte[] buf = new byte[BUFFER_SIZE];
            int r;
            while ((r = stream.read(buf)) != -1) {
                baos.write(buf, 0, r);
            }
        }
        return baos.toByteArray();
    }
}
