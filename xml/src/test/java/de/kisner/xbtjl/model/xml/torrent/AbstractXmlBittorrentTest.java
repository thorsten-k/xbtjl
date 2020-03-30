package de.kisner.xbtjl.model.xml.torrent;

import de.kisner.xbtjl.test.AbstractXmlTest;

public abstract class AbstractXmlBittorrentTest <T extends Object> extends AbstractXmlTest<T>
{
	public AbstractXmlBittorrentTest(Class<T> cXml)
	{
		super(cXml,"torrent");
	}
}