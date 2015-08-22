package de.kisner.xbtjl.util.comparator.xml;

import org.apache.commons.codec.binary.Hex;

import de.kisner.xbtjl.model.xml.torrent.Piece;
import net.sf.exlp.util.io.HashUtil;

public class PieceComparator
{
    /**
     * Verifies the downloaded data with the SHA1 has defined in the Piece of the torrent
     */
    public static boolean equals(byte[] bytes, Piece piece)
    {
    	boolean ok = Hex.encodeHexString(HashUtil.sha1Byte(bytes)).matches(piece.getHash().getValue());
        return ok;
    }
}