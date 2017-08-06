
package welcome.mail;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class readExcell {
   
    public static ArrayList<String[]> read(String locationOfFile ,int sh){
        
        
        ArrayList<String[]> details = new ArrayList<String[]>();
        try{
           
            File file = new File(locationOfFile);
            FileInputStream inputFile = new FileInputStream(file);
            XSSFWorkbook myWorkBook = new XSSFWorkbook (inputFile);
           
            XSSFSheet sheet = myWorkBook.getSheetAt(sh);
            
            int totalRow = sheet.getPhysicalNumberOfRows();
            
            Row row= null;
            Cell codNumberCell=null;
            Cell emailCell = null;
            Cell nameCell = null;
            String codNumber = null;
            String email = null;
            String name = null;
            for(int i=1; i < totalRow ; i++ )
            {
                row = sheet.getRow(i);
                codNumberCell = row.getCell(0);
                emailCell= row.getCell(5);
                nameCell = row.getCell(1);
                codNumber = codNumberCell==null ? "null" : codNumberCell.getStringCellValue();
                email = emailCell==null ? "null" : emailCell.getStringCellValue();
                name = nameCell == null? "null" :nameCell.getStringCellValue();
                if(email == "" || email=="null")
                    continue;
                String[] detail = {codNumber, name , email};
                details.add(detail);
            }
        }catch(Exception ex){
            System.out.println("log: caught at readExcell "+ex); 
        }catch(Throwable tr){
            System.out.println("log: caught throwable at readExcell"+tr);
        }finally{
            
            return details;
            
        }
    }
    
    
}
