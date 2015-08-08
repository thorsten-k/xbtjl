package de.kisner.xbtjl.factory.txt;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

import de.kisner.xbtjl.controller.processor.bencode.BenDecoder;

public class TxtBenocdeFactory 
{
	public static void print(File f, File output)
    {
        try
        {
            BenDecoder decoder = new BenDecoder();
            decoder.setRecoveryMode(false);

            PrintWriter pw = new PrintWriter(new FileWriter(output));

            decoder.print(pw,decoder.decodeStream(new BufferedInputStream(new FileInputStream(f))));
            pw.flush();

        }
        catch (Throwable e) {e.printStackTrace();}
    }
	
	public static void print(Map<String,?> map)
    {
        try
        {
            BenDecoder decoder = new BenDecoder();
            decoder.setRecoveryMode(false);

            PrintWriter pw = new PrintWriter(System.out);

            decoder.print(pw,map);
            pw.flush();

        }
        catch (Throwable e) {e.printStackTrace();}
    }
}