package de.kisner.xbtjl.interfaces.protocol;

import java.nio.charset.Charset;

import net.sf.exlp.util.io.ByteUtil;

public class BitTorrentProtocol
{
	public static final String DEFAULT_ENCODING = "UTF8";
    public static final String BYTE_ENCODING = "ISO-8859-1";
    public static Charset BYTE_CHARSET;
    public static Charset DEFAULT_CHARSET;
    
    public static final int BLOCK_SIZE = 16384;
    public static final byte[] BLOCK_SIZE_BYTES = ByteUtil.toByteArray(16384);

    static
    {
        try
        {
            BYTE_CHARSET = Charset.forName(BitTorrentProtocol.BYTE_ENCODING);
            DEFAULT_CHARSET = Charset.forName(BitTorrentProtocol.DEFAULT_ENCODING);
        }
        catch (Throwable e) {e.printStackTrace();}
    }
}
