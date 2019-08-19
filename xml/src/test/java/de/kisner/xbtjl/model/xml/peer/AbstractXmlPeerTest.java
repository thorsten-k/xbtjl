package de.kisner.xbtjl.model.xml.peer;

import de.kisner.xbtjl.test.AbstractXmlTest;

public abstract class AbstractXmlPeerTest <T extends Object> extends AbstractXmlTest<T>
{
	public AbstractXmlPeerTest(Class<T> cXml)
	{
		super(cXml,"peer");
	}
}