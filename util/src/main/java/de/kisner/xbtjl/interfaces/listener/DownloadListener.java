package de.kisner.xbtjl.interfaces.listener;

import java.util.EventListener;

import de.kisner.xbtjl.model.xml.peer.Peer;

public interface DownloadListener extends EventListener
{
	public void updatePieceRequestStatus(int pieceNumber, boolean requested);
    public void fragmentRequestFromPeer(Peer remotePeer, int piece, int begin, int length);
}
