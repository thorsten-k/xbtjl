package de.kisner.xbtjl.interfaces.protocol;

import java.nio.charset.Charset;

public class BtProtocol
{
	public static final String DEFAULT_ENCODING = "UTF8";
    public static final String BYTE_ENCODING = "ISO-8859-1";
    public static Charset BYTE_CHARSET;
    public static Charset DEFAULT_CHARSET;

    static
    {
        try
        {
            BYTE_CHARSET = Charset.forName(BtProtocol.BYTE_ENCODING);
            DEFAULT_CHARSET = Charset.forName(BtProtocol.DEFAULT_ENCODING);
        }
        catch (Throwable e) {e.printStackTrace();}
    }
}
