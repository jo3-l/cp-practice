package templates;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// fast output writer using BufferedWriter
public class FastOutputWriter {
    public BufferedWriter wr;

    public FastOutputWriter(OutputStream st) {
        wr = new BufferedWriter(new OutputStreamWriter(st));
    }

    public void println(boolean b) {
        try {
            wr.write(String.valueOf(b));
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println(char c) {
        try {
            wr.write(String.valueOf(c));
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println(int i) {
        try {
            wr.write(String.valueOf(i));
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println(long l) {
        try {
            wr.write(String.valueOf(l));
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println(float f) {
        try {
            wr.write(String.valueOf(f));
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println(double d) {
        try {
            wr.write(String.valueOf(d));
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println(String s) {
        try {
            wr.write(String.valueOf(s));
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println(char[] cs) {
        try {
            wr.write(cs);
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println(Object o) {
        try {
            wr.write(String.valueOf(o));
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void println() {
        try {
            wr.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(boolean b) {
        try {
            wr.write(String.valueOf(b));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(char c) {
        try {
            wr.write(String.valueOf(c));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(int i) {
        try {
            wr.write(String.valueOf(i));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(long l) {
        try {
            wr.write(String.valueOf(l));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(float f) {
        try {
            wr.write(String.valueOf(f));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(double d) {
        try {
            wr.write(String.valueOf(d));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(String s) {
        try {
            wr.write(String.valueOf(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(char[] cs) {
        try {
            wr.write(cs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print(Object o) {
        try {
            wr.write(String.valueOf(o));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void flush() {
        try {
            wr.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            wr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
