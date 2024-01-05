package de.kisner.xbtjl.model.xml;

import org.exlp.interfaces.io.NsPrefixMapperInterface;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class XbtjlNsPrefixMapper extends NamespacePrefixMapper implements NsPrefixMapperInterface
{
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix)
    {
        if("http://xbtjl.kisner.de".equals(namespaceUri) ){return "xbtjl";}
        if("http://xbtjl.kisner.de/torrent".equals(namespaceUri) ){return "bt";}
        if("http://xbtjl.kisner.de/peer".equals(namespaceUri) ){return "p";}
        if("http://xbtjl.kisner.de/protocol".equals(namespaceUri) ){return "p2p";}
        if("http://xbtjl.kisner.de/tracker".equals(namespaceUri) ){return "t";}
       
        return suggestion;
    }

    public String[] getPreDeclaredNamespaceUris()
    {
    	String[] result = new String[3];

    	result = new String[0];
        return result;
    }
}