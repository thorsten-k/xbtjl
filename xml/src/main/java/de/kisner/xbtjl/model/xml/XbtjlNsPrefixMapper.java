package de.kisner.xbtjl.model.xml;

import net.sf.exlp.xml.ns.NsPrefixMapperInterface;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class XbtjlNsPrefixMapper extends NamespacePrefixMapper implements NsPrefixMapperInterface
{
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix)
    {
        if("http://xbtjl.kisner.de".equals(namespaceUri) ){return "xbtjl";}
        if("http://xbtjl.kisner.de/torrent".equals(namespaceUri) ){return "t";}
        if("http://xbtjl.kisner.de/peer".equals(namespaceUri) ){return "p";}
        
       
        return suggestion;
    }

    public String[] getPreDeclaredNamespaceUris()
    {
    	String[] result = new String[3];

    	result = new String[0];
        return result;
    }
}