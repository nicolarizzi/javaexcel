/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import jxl.Workbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import jxl.Cell;
import jxl.Sheet;
import jxl.read.biff.BiffException;

/**
 *
 * @author DevX64
 */
public class JavaExel {

    
    /**
     * @param args the command line arguments
     */
    
    
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) throws IOException, BiffException, ClassNotFoundException, SQLException {
    
        int i;

    int k;
    for(k = 1; k < 10; k++ )    
    {
        Workbook workbook = Workbook.getWorkbook(new File("D:\\WebApplications\\LingueOne\\Lingue_Telecloud.xls"));
    Sheet sheet = workbook.getSheet("LINGUE"); 
    int totaleRighe = sheet.getRows();
    System.out.println("Sono presenti   " + totaleRighe  + "Righe");
    /*
    String [] FileBoundle = {"D:\\WebApplications\\LingueOne\\Bundle_it.properties",  "D:\\WebApplications\\LingueOne\\Bundle_en.properties", "D:\\WebApplications\\LingueOne\\Bundle_tr.properties", "D:\\WebApplications\\LingueOne\\Bundle_fr.properties",
                                                        "D:\\WebApplications\\LingueOne\\Bundle_ar.properties", "D:\\WebApplications\\LingueOne\\Bundle_ir.properties", "D:\\WebApplications\\LingueOne\\Bundle_pl.properties", "D:\\WebApplications\\LingueOne\\Bundle_et.properties", 
                                                        "D:\\WebApplications\\LingueOne\\Bundle_ro.properties", "D:\\WebApplications\\LingueOne\\Bundle_pt.properties" };
    */
    String [] FileBoundle = {"D:\\WebApplications\\LingueOne\\Bundle_it_IT.properties",  "D:\\WebApplications\\LingueOne\\Bundle_en_GB.properties", "D:\\WebApplications\\LingueOne\\Bundle_tr_TR.properties", "D:\\WebApplications\\LingueOne\\Bundle_fr_FR.properties",
                                                        "D:\\WebApplications\\LingueOne\\Bundle_ar_SA.properties", "D:\\WebApplications\\LingueOne\\Bundle_fa_IR.properties", "D:\\WebApplications\\LingueOne\\Bundle_pl_PL.properties", "D:\\WebApplications\\LingueOne\\Bundle_et_EE.properties", 
                                                        "D:\\WebApplications\\LingueOne\\Bundle_ro_RO.properties", "D:\\WebApplications\\LingueOne\\Bundle_pt_PT.properties" }; 

    FileReader f;
    f=new FileReader("D:\\WebApplications\\Winwatch2.0\\TeleCloudONE\\src\\java\\resources\\Bundle_it_IT.properties");
    BufferedReader b;    
    b=new BufferedReader(f);        
    FileWriter w;
    w=new FileWriter(FileBoundle[k]);
    BufferedWriter bufferedWriter = new BufferedWriter(w);
    
    String s;
    String LeftS;
    String RightS;
    int count = 0;
    int substrFirst;
    int posLingua = k;                  // 4 = Colonna Arabo
     boolean found = false;
    while(true)
    {
      s=b.readLine();
      if(s==null)
        break;
      count++;
      substrFirst = s.indexOf("=");
      
      LeftS =  s.substring(0, substrFirst+1);     
      RightS =  s.substring( substrFirst+1);
     if(substrFirst < 2)
     {
         System.out.println("TROVATO RIGA VUOTA ");
         continue;
     }
      
      
      String stringa1= "";
       for(i = 0; i < totaleRighe; i++)
        {
            Cell a = (Cell) sheet.getCell(0,i);     // legge i campi della prima colonna Italiano
            stringa1 = a.getContents();    
            
            if(RightS.compareToIgnoreCase(stringa1) == 0)
            {                
                           
                Cell tr = (Cell) sheet.getCell(posLingua,i);
                String stringa2 = tr.getContents();          
                
                //String Result = LeftS+stringa2 +"\n";
                //w.write(Result);
                //System.out.println("TRADUZIONE    "+LeftS + "   " + Result);
           
                boolean sostituisci = false;
                //if(k == 3)
                {   
                    if((stringa2.contains("\\u00f1")) || (stringa2.contains("\\u00F1")))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f1", "\\u00f1");
                        stringa2.replaceAll("\u00F1", "\\u00f1");
                    }
                    if((stringa2.contains("\\u00fa")) || (stringa2.contains("\\u00FA")))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00fa", "\\u00fa");
                        stringa2.replaceAll("\u00FA", "\\u00fa");
                    }
                    if((stringa2.contains("\\u00ee")) || (stringa2.contains("\\u00EE")))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ee", "\\u00ee");
                        stringa2.replaceAll("\u00EE", "\\u00ee");
                    }
                    if((stringa2.contains("\\u00c3")) || (stringa2.contains("\\u00C3")))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c3", "\\u00c3");
                        stringa2.replaceAll("\u00C3", "\\u00c3");
                    } 
                    if((stringa2.contains("\\u015e")) || (stringa2.contains("\\u015E")))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015e", "\\u015e");
                        stringa2.replaceAll("\u015E", "\\u015e");
                    }                    
                    if(stringa2.contains("\\u0130"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0130", "\\u0130");
                    }
                    if(stringa2.contains("\\u0163"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0163", "\\u0163");
                    }
                    if(stringa2.contains("\\u0131"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0131", "\\u0131");
                    }
                    if(stringa2.contains("\\u0104"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0104", "\\u0104");
                    }
                    if(stringa2.contains("\\u0027"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0027", "\\u0027");
                    }
                    if(stringa2.contains("\\u00c9"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c9", "\\u00c9");
                    }
                    if(stringa2.contains("\\u00c8"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c8", "\\u00c8");
                    }
                    if(stringa2.contains("\\u0102"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0102", "\\u0102");
                    }
                    if(stringa2.contains("\\u00c7"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c7", "\\u00c7");
                    }
                    if(stringa2.contains("\\u00d5"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00d5", "\\u00d5");
                    }                    
                    if(stringa2.contains("\\u00dc"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00dc", "\\u00dc");
                    }
                    if(stringa2.contains("\\u015a"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015a", "\\u015a");
                    }                    
                    if(stringa2.contains("\\u00e2"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e2", "\\u00e2");
                    }
                    if(stringa2.contains("\\u0103"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0103", "\\u0103");
                    }
                    if(stringa2.contains("\\u00da"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00da", "\\u00da");
                    }
                    if(stringa2.contains("\\u00ce"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ce", "\\u00ce");
                    }  
                    if(stringa2.contains("\\u00fb"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00fb", "\\u00fb");                        
                    }  
                    if(stringa2.contains("\\u015f"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015f", "\\u015f");                        
                    }  
                    if(stringa2.contains("\\u011f"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u011f", "\\u011f");                        
                    }  
                    if(stringa2.contains("\\u00e8"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e8", "\\u00e8");       
                    }  
                    if(stringa2.contains("\\u00e9"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e9", "\\u00e9"); 
                    }
                    if(stringa2.contains("\\u00e7"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e7", "\\u00e7"); 
                    }
                    if(stringa2.contains("\\u00ea"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ea", "\\u00ea"); 
                    }
                    if(stringa2.contains("\\u00fc"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00fc", "\\u00fc"); 
                    }
                    if(stringa2.contains("\\u00f6"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f6", "\\u00f6"); 
                    }
                    if(stringa2.contains("\\u00ea"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ea", "\\u00ea"); 
                    }
                    if(stringa2.contains("\\u00e0"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e0", "\\u00e0"); 
                    }
                    if(stringa2.contains("\\u00f3"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f3", "\\u00f3"); 
                    }
                    if(stringa2.contains("\\u00e4"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e4", "\\u00e4"); 
                    }
                    if(stringa2.contains("\\u00f5"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f5", "\\u00f5"); 
                    }
                    if(stringa2.contains("\\u00e3"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e3", "\\u00e3"); 
                    }
                    if(stringa2.contains("\\u00ed"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ed", "\\u00ed"); 
                    }
                    if(stringa2.contains("\\u00e1"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e1", "\\u00e1"); 
                    }
                    if(stringa2.contains("\\u00f4"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f4", "\\u00f4"); 
                    }                    
                    if(stringa2.contains("\\u0144"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0144", "\\u0144"); 
                    }
                    if(stringa2.contains("\\u015b"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015b", "\\u015b"); 
                    }
                    if(stringa2.contains("\\u0107"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0107", "\\u0107"); 
                    }
                    if(stringa2.contains("\\u0119"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0119", "\\u0119"); 
                    }
                    if(stringa2.contains("\\u0142"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0142", "\\u0142"); 
                    }
                    if(stringa2.contains("\\u017c"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u017c", "\\u017c"); 
                    }
                    if(stringa2.contains("\\u0105"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0105", "\\u0105"); 
                    }
                    if(stringa2.contains("\\u017a"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u017a", "\\u017a"); 
                    }
                    
                    if(sostituisci == true)
                    {
                        String Result = LeftS+stringa2 +"\n";
                        w.write(Result);
                        System.out.println("TRADUZIONE    "+LeftS + "   " + Result);
                    }                    
                }                    
                if(sostituisci == false)
                {
                int j;
                char ch;
                String StringUnic = "";
                for(j = 0; j < stringa2.length(); j++)      
                {                    
                    ch = stringa2.charAt(j);
                    if (ch < 0x10) {
                        StringUnic +=  "\\u000" + Integer.toHexString(ch);
                    } else if (ch < 0x100) {
                        StringUnic +=  "\\u00" + Integer.toHexString(ch);
                    } else if (ch < 0x1000) {
                        StringUnic +=  "\\u0" + Integer.toHexString(ch);
                    }
                    else
                        StringUnic +=  "\\u" + Integer.toHexString(ch);
                    
                }       
                System.out.println("CHAR .. " + StringUnic);                        
                String Result = LeftS+StringUnic +"\n";
                w.write(Result);                
                }
                sostituisci = false;       

                
                found = true;
                break;                
            }
            else 
            {
                String StrOrigine = RightS + " ";                
                if(StrOrigine.compareToIgnoreCase(stringa1) == 0)
                {
                    Cell tr = (Cell) sheet.getCell(posLingua,i);
                    String stringa2 = tr.getContents();          // Letto stringa in Inglese                    
                   //String Result = LeftS+stringa2+"\n";                    
                   //w.write(Result);
                   boolean sostituisci = false;
                   {
                    if((stringa2.contains("\\u00f1")) || (stringa2.contains("\\u00F1")))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f1", "\\u00f1");
                        stringa2.replaceAll("\u00F1", "\\u00f1");
                    }
                    if((stringa2.contains("\\u015e")) || (stringa2.contains("\\u015E")))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015e", "\\u015e");
                        stringa2.replaceAll("\u015E", "\\u015e");
                    }
                    if(stringa2.contains("\\u00fa"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00fa", "\\u00fa");
                    }
                    if(stringa2.contains("\\u00ee"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ee", "\\u00ee");                        
                    }
                    if(stringa2.contains("\\u0130"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0130", "\\u0130");
                    }
                    if(stringa2.contains("\\u0131"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0131", "\\u0131");
                    }
                    if(stringa2.contains("\\u0027"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0027", "\\u0027");
                    }
                    if(stringa2.contains("\\u00c3"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c3", "\\u00c3");
                    }
                    if(stringa2.contains("\\u0163"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0163", "\\u0163");
                    }
                    if(stringa2.contains("\\u00c9"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c9", "\\u00c9");
                    }
                    if(stringa2.contains("\\u0104"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0104", "\\u0104");
                    }
                    if(stringa2.contains("\\u00c8"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c8", "\\u00c8");
                    }
                    if(stringa2.contains("\\u0102"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0102", "\\u0102");
                    }
                    if(stringa2.contains("\\u00c7"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c7", "\\u00c7");
                    }
                    if(stringa2.contains("\\u00d5"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00d5", "\\u00d5");
                    }
                    if(stringa2.contains("\\u00dc"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00dc", "\\u00dc");
                    }
                    if(stringa2.contains("\\u015a"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015a", "\\u015a");
                    }                    
                    if(stringa2.contains("\\u00e2"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e2", "\\u00e2");
                    }
                    if(stringa2.contains("\\u0103"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0103", "\\u0103");
                    }
                    if(stringa2.contains("\\u00da"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00da", "\\u00da");
                    }
                    if(stringa2.contains("\\u00ce"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ce", "\\u00ce");
                    }  
                    if(stringa2.contains("\\u00fb"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00fb", "\\u00fb");                        
                    }  
                    if(stringa2.contains("\\u015f"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015f", "\\u015f");                        
                    }  
                    if(stringa2.contains("\\u011f"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u011f", "\\u011f");                        
                    }  
                    if(stringa2.contains("\\u00e8"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e8", "\\u00e8");                        
                    }  
                    if(stringa2.contains("\\u00e9"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e9", "\\u00e9"); 
                    } 
                    if(stringa2.contains("\\u00e7"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e7", "\\u00e7"); 
                    }  
                    if(stringa2.contains("\\u00ea"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ea", "\\u00ea"); 
                    }
                    if(stringa2.contains("\\u00fc"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00fc", "\\u00fc"); 
                    }
                    if(stringa2.contains("\\u00f6"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f6", "\\u00f6"); 
                    }
                    if(stringa2.contains("\\u00ea"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ea", "\\u00ea"); 
                    }
                    if(stringa2.contains("\\u00e0"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e0", "\\u00e0"); 
                    }
                    if(stringa2.contains("\\u00f3"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f3", "\\u00f3"); 
                    }
                    if(stringa2.contains("\\u00e4"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e4", "\\u00e4"); 
                    }
                    if(stringa2.contains("\\u00f5"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f5", "\\u00f5"); 
                    }
                    if(stringa2.contains("\\u00e3"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e3", "\\u00e3"); 
                    }
                    if(stringa2.contains("\\u00ed"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ed", "\\u00ed"); 
                    }
                    if(stringa2.contains("\\u00e1"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e1", "\\u00e1"); 
                    }
                    if(stringa2.contains("\\u00f4"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f4", "\\u00f4"); 
                    }
                    if(stringa2.contains("\\u0144"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0144", "\\u0144"); 
                    }
                    if(stringa2.contains("\\u015b"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015b", "\\u015b"); 
                    }
                    if(stringa2.contains("\\u0107"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0107", "\\u0107"); 
                    }
                    if(stringa2.contains("\\u0119"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0119", "\\u0119"); 
                    }
                    if(stringa2.contains("\\u0142"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0142", "\\u0142"); 
                    }
                    if(stringa2.contains("\\u017c"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u017c", "\\u017c"); 
                    }
                    if(stringa2.contains("\\u0105"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0105", "\\u0105"); 
                    }
                    if(stringa2.contains("\\u017a"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u017a", "\\u017a"); 
                    }
                    
                    if(sostituisci == true)
                    {
                        String Result = LeftS+stringa2 +"\n";
                        w.write(Result);
                        System.out.println("TRADUZIONE    "+LeftS + "   " + Result);
                    }                    
                }                    
                if(sostituisci == false)
                {
                    int j;
                    char ch;
                    String StringUnic = "";
                    for(j = 0; j < stringa2.length(); j++)      
                    {                    
                        ch = stringa2.charAt(j);
                        if (ch < 0x10) {
                            StringUnic +=  "\\u000" + Integer.toHexString(ch);
                        } else if (ch < 0x100) {
                            StringUnic +=  "\\u00" + Integer.toHexString(ch);
                        } else if (ch < 0x1000) {
                            StringUnic +=  "\\u0" + Integer.toHexString(ch);
                        }
                        else 
                            StringUnic +=  "\\u" + Integer.toHexString(ch);

                    }       
                    System.out.println("CHAR .. " + StringUnic);                        
                    String Result = LeftS+StringUnic +"\n";
                    w.write(Result);
                 }
                 sostituisci = false  ;
                       
                    found = true;
                    break;
                }
                else
                {                    
                    String StrOrigine2 = RightS + "  ";                    
                    //if(RightS.compareTo(stringa1) == 0)
                    if(StrOrigine2.compareToIgnoreCase(stringa1) == 0)
                    {
                        Cell tr = (Cell) sheet.getCell(posLingua,i);
                        String stringa2 = tr.getContents();          // Letto stringa in Inglese                        
                       // String Result = LeftS+stringa2+"\n";                        
                        //w.write(Result);
                        
                        
                        
                   boolean sostituisci = false;
                   {
                    if((stringa2.contains("\\u00f1")) || (stringa2.contains("\\u00F1")))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f1", "\\u00f1");
                        stringa2.replaceAll("\u00F1", "\\u00f1");
                    }
                    if((stringa2.contains("\\u015e")) || (stringa2.contains("\\u015E")))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015e", "\\u015e");
                        stringa2.replaceAll("\u015E", "\\u015e");
                    }
                    if(stringa2.contains("\\u00fa"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00fa", "\\u00fa");
                    }
                    if(stringa2.contains("\\u0027"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0027", "\\u0027");
                    }
                    if(stringa2.contains("\\u00ee"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ee", "\\u00ee");                        
                    }
                    if(stringa2.contains("\\u00c3"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c3", "\\u00c3");
                    }
                    if(stringa2.contains("\\u0130"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0130", "\\u0130");
                    }
                    if(stringa2.contains("\\u0131"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0131", "\\u0131");
                    }
                    if(stringa2.contains("\\u0163"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0163", "\\u0163");
                    }
                    if(stringa2.contains("\\u00c9"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c9", "\\u00c9");
                    }
                    if(stringa2.contains("\\u0104"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0104", "\\u0104");
                    }
                    if(stringa2.contains("\\u00c8"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c8", "\\u00c8");
                    }
                    if(stringa2.contains("\\u0102"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0102", "\\u0102");
                    }
                    if(stringa2.contains("\\u00c7"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00c7", "\\u00c7");
                    }
                    if(stringa2.contains("\\u00d5"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00d5", "\\u00d5");
                    }
                    if(stringa2.contains("\\u00dc"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00dc", "\\u00dc");
                    }
                    if(stringa2.contains("\\u015a"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015a", "\\u015a");
                    } 
                    if(stringa2.contains("\\u00e2"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e2", "\\u00e2");
                    }
                    if(stringa2.contains("\\u0103"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0103", "\\u0103");
                    }
                    if(stringa2.contains("\\u00da"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00da", "\\u00da");
                    }
                    if(stringa2.contains("\\u00ce"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ce", "\\u00ce");
                    }                         
                    if(stringa2.contains("\\u00fb"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00fb", "\\u00fb");                        
                    }  
                    if(stringa2.contains("\\u015f"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015f", "\\u015f");                        
                    }  
                    if(stringa2.contains("\\u011f"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u011f", "\\u011f");                        
                    }  
                    if(stringa2.contains("\\u00e8"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e8", "\\u00e8");                        
                    }  
                    if(stringa2.contains("\\u00e9"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e9", "\\u00e9"); 
                    } 
                    if(stringa2.contains("\\u00e7"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e7", "\\u00e7"); 
                    } 
                    if(stringa2.contains("\\u00ea"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ea", "\\u00ea"); 
                    }
                    if(stringa2.contains("\\u00fc"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00fc", "\\u00fc"); 
                    }
                    if(stringa2.contains("\\u00f6"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f6", "\\u00f6"); 
                    }
                    if(stringa2.contains("\\u00ea"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ea", "\\u00ea"); 
                    }
                    if(stringa2.contains("\\u00e0"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e0", "\\u00e0"); 
                    }
                    if(stringa2.contains("\\u00f3"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f3", "\\u00f3"); 
                    }
                    if(stringa2.contains("\\u00e4"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e4", "\\u00e4"); 
                    }
                    if(stringa2.contains("\\u00f5"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f5", "\\u00f5"); 
                    }
                    if(stringa2.contains("\\u00e3"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e3", "\\u00e3"); 
                    }
                    if(stringa2.contains("\\u00ed"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00ed", "\\u00ed"); 
                    }
                    if(stringa2.contains("\\u00e1"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00e1", "\\u00e1"); 
                    }
                    if(stringa2.contains("\\u00f4"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u00f4", "\\u00f4"); 
                    }
                    if(stringa2.contains("\\u0144"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0144", "\\u0144"); 
                    }
                    if(stringa2.contains("\\u015b"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u015b", "\\u015b"); 
                    }                    
                    if(stringa2.contains("\\u0107"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0107", "\\u0107"); 
                    }
                    if(stringa2.contains("\\u0119"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0119", "\\u0119"); 
                    }
                    if(stringa2.contains("\\u0142"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0142", "\\u0142"); 
                    }
                    if(stringa2.contains("\\u017c"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u017c", "\\u017c"); 
                    }
                    if(stringa2.contains("\\u0105"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u0105", "\\u0105"); 
                    }
                    if(stringa2.contains("\\u017a"))
                    {
                        sostituisci = true;
                        stringa2.replaceAll("\u017a", "\\u017a"); 
                    }
                    
                    if(sostituisci == true)
                    {
                        String Result = LeftS+stringa2 +"\n";
                        w.write(Result);
                        System.out.println("TRADUZIONE    "+LeftS + "   " + Result);
                    }                    
                }                    
                if(sostituisci == false)
                {
                       int j;
                        char ch;
                        String StringUnic = "";
                        for(j = 0; j < stringa2.length(); j++)      
                        {   
                            ch = stringa2.charAt(j);
                            if (ch < 0x10) {
                                StringUnic +=  "\\u000" + Integer.toHexString(ch);
                            } else if (ch < 0x100) {
                                StringUnic +=  "\\u00" + Integer.toHexString(ch);
                            } else if (ch < 0x1000) {
                                StringUnic +=  "\\u0" + Integer.toHexString(ch);
                            }
                            else
                                StringUnic +=  "\\u" + Integer.toHexString(ch);

                        }       
                        System.out.println("CHAR .. " + StringUnic);                        
                        String Result = LeftS+StringUnic +"\n";
                        w.write(Result);
                        
                    }
                     sostituisci = false;   
                        
                        
                        found = true;
                        break;
                    }                    
                }
            }   
        } 
       if(found == false)
       {
          // System.out.println("TRADUZIONE    "+LeftS + "   " + "VUOTA");
           //String Result = LeftS+stringa1+"\n";
           String Result = LeftS+"Empty"+"\n";
           w.write(Result);
       }      
       w.flush();
       found = false;
    }
    System.out.println("TOTALE Righe Lette   "+ count);
    
    w.close();
    b.close();
    

    
    
/*
    for(i = 0; i < totaleRighe; i++)
    {
        Cell a = (Cell) sheet.getCell(0,i);
        String stringa1 = a.getContents();
        System.out.println("Letto    ( "+i+" )" + stringa1);        
        
        
        byte[] arr = stringa1.getBytes("ISO-8859-1");
         String str2 = new String(arr);
         System.out.println("new string = " + str2);
        
    }
*/    
    workbook.close();
    f.close();
    }// end for
    
    
/// SOLO PER creare il Bundle.properties    
    for(k = 1; k < 2; k++ )    
    {
        Workbook workbook = Workbook.getWorkbook(new File("D:\\WebApplications\\LingueOne\\Lingue_Telecloud.xls"));
    Sheet sheet = workbook.getSheet("LINGUE");    
    int totaleRighe = sheet.getRows();
    System.out.println("Sono presenti   " + totaleRighe  + "Righe");
    String [] FileBoundle = {"D:\\WebApplications\\LingueOne\\Bundle_it_IT.properties",  "D:\\WebApplications\\LingueOne\\Bundle.properties"};

    FileReader f;
    f=new FileReader("D:\\WebApplications\\Winwatch2.0\\TeleCloudONE\\src\\java\\resources\\Bundle_it_IT.properties");
    BufferedReader b;    
    b=new BufferedReader(f);        
    FileWriter w;
    
    w=new FileWriter(FileBoundle[k]);
    BufferedWriter bufferedWriter = new BufferedWriter(w);
    
    String s;
    String LeftS;
    String RightS;
    int count = 0;
    int substrFirst;
    int posLingua = k;                  // 4 = Colonna Arabo
     boolean found = false;
    while(true)
    {
      s=b.readLine();
      if(s==null)
        break;
      count++;
      substrFirst = s.indexOf("=");
      
      LeftS =  s.substring(0, substrFirst+1);     
      RightS =  s.substring( substrFirst+1);
     if(substrFirst < 2)
     {
         System.out.println("TROVATO RIGA VUOTA ");
         continue;
     }
      
      
      String stringa1= "";
       for(i = 0; i < totaleRighe; i++)
        {
            Cell a = (Cell) sheet.getCell(0,i);     // legge i campi della prima colonna Italiano
            stringa1 = a.getContents();    
            
            //System.out.println("TRADUZIONE    "+RightS + "   " + stringa1);
            
            
            if(RightS.compareToIgnoreCase(stringa1) == 0)
            {                
                           
                Cell tr = (Cell) sheet.getCell(posLingua,i);
                String stringa2 = tr.getContents();          
                
                String Result = LeftS+stringa2 +"\n";
                w.write(Result);
                System.out.println("TRADUZIONE    "+LeftS + "   " + Result);
           
                
                   /*
                    {
                    int j;
                    char ch;
                    String StringUnic = "";
                    for(j = 0; j < stringa2.length(); j++)      
                    {                    
                        ch = stringa2.charAt(j);
                        if (ch < 0x10) {
                            StringUnic +=  "\\u000" + Integer.toHexString(ch);
                        } else if (ch < 0x100) {
                            StringUnic +=  "\\u00" + Integer.toHexString(ch);
                        } else if (ch < 0x1000) {
                            StringUnic +=  "\\u0" + Integer.toHexString(ch);
                        }
                        else
                            StringUnic +=  "\\u" + Integer.toHexString(ch);

                    }       
                    System.out.println("CHAR .. " + StringUnic);                        
                    String Result = LeftS+StringUnic +"\n";
                    w.write(Result);                
                    }
                   */      

                
                found = true;
                break;                
            }
            else 
            {
                String StrOrigine = RightS + " ";                
                if(StrOrigine.compareToIgnoreCase(stringa1) == 0)
                {
                    Cell tr = (Cell) sheet.getCell(posLingua,i);
                    String stringa2 = tr.getContents();          // Letto stringa in Inglese                    
                   String Result = LeftS+stringa2+"\n";                    
                   w.write(Result);
                    
                    /*
                   int j;
                    char ch;
                    String StringUnic = "";
                    for(j = 0; j < stringa2.length(); j++)      
                    {                    
                        ch = stringa2.charAt(j);
                        if (ch < 0x10) {
                            StringUnic +=  "\\u000" + Integer.toHexString(ch);
                        } else if (ch < 0x100) {
                            StringUnic +=  "\\u00" + Integer.toHexString(ch);
                        } else if (ch < 0x1000) {
                            StringUnic +=  "\\u0" + Integer.toHexString(ch);
                        }
                        else 
                            StringUnic +=  "\\u" + Integer.toHexString(ch);

                    }       
                    System.out.println("CHAR .. " + StringUnic);                        
                    String Result = LeftS+StringUnic +"\n";
                    w.write(Result);
                   */
                    
                       
                    found = true;
                    break;
                }
                else
                {                    
                    String StrOrigine2 = RightS + "  ";                                        
                    if(StrOrigine2.compareToIgnoreCase(stringa1) == 0)
                    {
                        Cell tr = (Cell) sheet.getCell(posLingua,i);
                        String stringa2 = tr.getContents();          // Letto stringa in Inglese                        
                        String Result = LeftS+stringa2+"\n";                        
                        w.write(Result);
                        
                        /*
                        int j;
                        char ch;
                        String StringUnic = "";
                        for(j = 0; j < stringa2.length(); j++)      
                        {   
                            ch = stringa2.charAt(j);
                            if (ch < 0x10) {
                                StringUnic +=  "\\u000" + Integer.toHexString(ch);
                            } else if (ch < 0x100) {
                                StringUnic +=  "\\u00" + Integer.toHexString(ch);
                            } else if (ch < 0x1000) {
                                StringUnic +=  "\\u0" + Integer.toHexString(ch);
                            }
                            else
                                StringUnic +=  "\\u" + Integer.toHexString(ch);

                        }       
                        System.out.println("CHAR .. " + StringUnic);                        
                        String Result = LeftS+StringUnic +"\n";
                        w.write(Result);
                        */
                        
                        found = true;
                        break;
                    }                    
                }
            }   
        } 
       if(found == false)
       {
          // System.out.println("TRADUZIONE    "+LeftS + "   " + "VUOTA");
           //String Result = LeftS+stringa1+"\n";
           String Result = LeftS+"Empty"+"\n";
           w.write(Result);
       }      
       w.flush();
       found = false;
    }
    System.out.println("TOTALE Righe Lette   "+ count);
    
    w.close();
    b.close();   
    workbook.close();
    f.close();
    }// end for  II    
    }    
}
